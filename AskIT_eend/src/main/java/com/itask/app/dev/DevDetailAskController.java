package com.itask.app.dev;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;
//import com.itask.app.dto.CommentDTO;
import com.itask.app.dto.UserDTO;

public class DevDetailAskController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		

		
	      Result result = new Result();
	      
	      //boardNumber가 빈문자열이나 null인 경우
	      String articleNumStr = request.getParameter("articleNum");
	      if(articleNumStr == null || articleNumStr.trim().isEmpty()) {
	         System.out.println("articleNum 값이 없습니다.");
	         
	         result.setPath("/app/article/dev/ask.jsp"); //게시글 목록 페이지로 리다이렉트
	         result.setRedirect(true);
	         return result;
	      }
	      
	      int articleNum = Integer.parseInt(articleNumStr);
	      UserDTO userDTO = new UserDTO();
	      DevDAO devDAO = new DevDAO();
	      ArticleListDTO articleListDTO = devDAO.selectOne(articleNum);
//	      FileDAO fileDAO = new FileDAO();
	      
	      //게시글이 존재하지 않을 경우 처리
	      if(articleListDTO == null) {
	         System.out.println("존재하지 않는 게시글 입니다." + articleNum);
	         result.setPath("/app/board/boardList.jsp");
	         result.setRedirect(true);
	         return result;
	      }
	      
//	      List<FileDTO> files = fileDAO.select(boardNumber);
//	      boardListDTO.setFiles(files);
	      
	      //로그인한 사용자 번호 가져오기
	      Integer loginUserNum = (Integer) request.getSession().getAttribute("userNum");
	      System.out.println("로그인한 멤버 번호 : " + loginUserNum);
	      
	      HttpSession session = request.getSession();
	      session.setAttribute("userNum", loginUserNum);  // loginUserNum은 로그인한 사용자의 번호
	      
	      //현재 게시글의 작성자 번호 가져오기
	      int articleWriterNum = articleListDTO.getUserNum();
	      System.out.println("현재 게시글 작성자 번호 : " + articleWriterNum);
	      
	      //로그인한 사용자가 작성자가 아닐 때만 조회수 증가
	      if(!Objects.equals(loginUserNum, articleWriterNum)) {
	    	  devDAO.increaseView(articleNum);
	      }
	      
	      request.setAttribute("dev", articleListDTO);
	      result.setPath("/app/article/dev/askDetail.jsp");
	      result.setRedirect(false);
	      
	      return result;
	}
}
