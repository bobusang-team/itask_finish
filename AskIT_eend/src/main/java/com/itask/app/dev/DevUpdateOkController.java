package com.itask.app.dev;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleDetailDTO;

public class DevUpdateOkController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException { 
			
	
			response.setCharacterEncoding("UTF-8");
    		request.setCharacterEncoding("UTF-8");
    	
		
			DevDAO devDAO = new DevDAO();
			ArticleDetailDTO articleDetailDTO = new ArticleDetailDTO();
			Result result = new Result();
		
		   int articleNum = Integer.parseInt(request.getParameter("articleNum"));
	        String articleTitle = request.getParameter("articleTitle");
	        System.out.println(articleTitle);
	        String articleText = request.getParameter("articleText");

	        
	        System.out.println("업데이트 메소드 실행");
	        devDAO.update(articleDetailDTO);
	        System.out.println("업데이트 메소드 실행완료!");
	        
	        
	        // DevDAO와 ArticleDetailDTO 객체 생성
	        articleDetailDTO.setArticleNum(articleNum); // 유저 설정
	        articleDetailDTO.setArticleTitle(articleTitle); // 수정된 제목 설정
	        articleDetailDTO.setArticleText(articleText); // 수정된 내용 설정
	        System.out.println("게시글 내용: " + articleText);
	        // 게시글 업데이트 수행
	        boolean isUpdated = devDAO.update(articleDetailDTO);
	        
	        if (isUpdated) {
	        	request.setAttribute("message", "게시물이 수정되었습니다.");
	            result.setPath("/dev/listAsk.dev");
	            result.setRedirect(false); // 리다이렉트 처리
	        } else {
	            request.setAttribute("errorMessage", "게시물 수정 실패했습니다.");
	            result.setPath("/dev/askEdit.jsp");
	        }
	        return result;
	
	}

}
