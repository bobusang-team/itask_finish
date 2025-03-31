package com.itask.app.dev;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;

public class DevDeleteController {

	public Result execute(HttpServletRequest request, HttpServletResponse response) {
		
		response.setCharacterEncoding("UTF-8");
		
		System.out.println("delete컨트롤러 실행");
		DevDAO devDAO = new DevDAO();
		Result result = new Result();

		int articleNum = Integer.valueOf(request.getParameter("articleNum"));

		   boolean isDeleted = devDAO.delete(articleNum);
	        
	        if (isDeleted) {
	        	request.setAttribute("message", "게시물이 삭제되었습니다.");
	            result.setPath("http://localhost:8889/AskIT_eend/usermain.jsp");
	            result.setRedirect(true); // 리다이렉트 처리
	        } else {
	            request.setAttribute("errorMessage", "게시물 수정에 실패했습니다.");
	            result.setPath("/dev/askEdit.jsp");
	        }
	        return result;
	}
	
	
}
