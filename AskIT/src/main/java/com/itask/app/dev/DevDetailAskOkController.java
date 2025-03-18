package com.itask.app.dev;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;

public class DevDetailAskOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Result result = new Result();
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		
		int articleNum = Integer.valueOf(request.getParameter("articleNum"));
		DevDAO devDAO = new DevDAO();
		ArticleListDTO articleListDTO = devDAO.select(articleNum); 
		
		  //게시글이 존재하지 않을 경우 처리
	      if(articleListDTO == null) {
	         System.out.println("존재하지 않는 게시글 입니다." + articleNum);
	         result.setPath("/app/article/dev/ask.jsp");
	         result.setRedirect(false);
	         return result;
	      }
	      
	      //로그인한 사용자 번호 가져오기
	      Integer loginUserNum = (Integer) request.getSession().getAttribute("userNum");
	      System.out.println("로그인한 멤버 번호 : " + loginUserNum);		

	      //현재 게시글의 작성자 번호 가져오기
	      int articleWriterNum = articleListDTO.getUserNum();
	      System.out.println("현재 게시글 작성자 번호 : " + articleWriterNum);

	    //로그인한 사용자가 작성자가 아닐 때만 조회수 증가
	      if(!Objects.equals(loginUserNum, articleWriterNum)) {
	         devDAO.increaseView(articleNum);
	      }

		result.setPath("/app/article/dev/askDetail.jsp");
		result.setRedirect(false);

		return result;
	}

}
