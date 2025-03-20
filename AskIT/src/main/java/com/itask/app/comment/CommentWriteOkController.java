package com.itask.app.comment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.comment.dao.CommentDAO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.CommentDTO;

public class CommentWriteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		CommentDTO commentDTO = new CommentDTO();
		CommentDAO commentDAO = new CommentDAO();
		System.out.println("세션에 저장된 멤버" + session.getAttribute("userNum"));
   
		request.setCharacterEncoding("utf-8");
		
		//json 응답
		Gson gson = new Gson();
//		Map<String, Object> responseMap = new HashMap<>(); 
		
		//Json 데이터 읽기
		BufferedReader reader = request.getReader();
		JsonObject jsonObject = JsonParser.parseString(reader.lines().collect(Collectors.joining())).getAsJsonObject();
		
		//필수 파라미터 확인
		if(!jsonObject.has("articleNum") || !jsonObject.has("userNum") || !jsonObject.has("commentText")) {
			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(gson.toJson(Map.of("status", "fail", "message", "필수 데이터가 없습니다")));
			return null;
		}
		
		//DTO 설정
		commentDTO.setArticleNum(jsonObject.get("articleNum").getAsInt());
		System.out.println(jsonObject.get("articleNum").getAsInt());
		commentDTO.setUserNum(jsonObject.get("userNum").getAsInt());
		System.out.println(jsonObject.get("userNum").getAsInt());
		commentDTO.setCommentText(jsonObject.get("commentText").getAsString());
		System.out.println(jsonObject.get("commentText").getAsString());
		
		System.out.println("commentDTO 확인 : " + commentDTO);
		
		//DB 저장
		commentDAO.insert(commentDTO);
		System.out.println("댓글 작성완료: " + commentDTO);
		
		//Json응답
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().write(gson.toJson(Map.of("status", "success", "message", "댓글이 성공적으로 저장되었습니다")));
		
		
		return null;
	}

}
