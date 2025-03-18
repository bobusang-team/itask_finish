package com.itask.app.main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.ArticleDTO;
import com.itask.app.main.dao.ArticleDAO;

public class BestArticlesController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
    	try {
			ArticleDAO articleDAO = new ArticleDAO();

			//    	질문과 꿀팁 게시글
			ArticleDTO bestMoon = articleDAO.getBestArticle("질문");
			ArticleDTO bestTip = articleDAO.getBestArticle("꿀팁");

			//		데이터 제대로 오는지 디버깅
			System.out.println("bestMoon" + (bestMoon != null ? bestMoon.getArticleTitle() : "NULL"));
			System.out.println("bestTip" + (bestTip != null ? bestMoon.getArticleTitle() : "NULL"));
			
			//    	JSON 변환 및 응답
			Map<String, Object> responseData = new HashMap<>();
			responseData.put("bestMoon", bestMoon != null ? bestMoon : new ArticleDTO());
			responseData.put("bestTip", bestTip != null ? bestTip : new ArticleDTO());

			Gson gson = new Gson();
			String jsonResponse = gson.toJson(responseData);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResponse);

//			Result result = new Result();
//			result.setRedirect(false);
//			return result;
			return null; //main에서 json응답하기 때문에 
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "데이터를 불러오지 못함");
			return null;
		}
		
    	
    }
}
