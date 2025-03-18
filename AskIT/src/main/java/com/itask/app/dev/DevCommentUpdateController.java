package com.itask.app.dev;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.CommentDTO;

public class DevCommentUpdateController {
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
	
		
	response.setCharacterEncoding("UTF-8");
	request.setCharacterEncoding("UTF-8");

	DevDAO devDAO = new DevDAO();
	CommentDTO commentDTO = new CommentDTO();
	Result result = new Result();
	
	int commentNum = Integer.parseInt(request.getParameter("commentNum"));
	String commentText = request.getParameter("commentText");
	System.out.println(commentText);
	
	commentDTO.setCommentNum(commentNum);
	commentDTO.setCommentText(commentText);
	 System.out.println("게시글 내용: " + commentText);
	 
	 boolean isUpdated = devDAO.commmentUpdate(commentDTO);
     
     if (isUpdated) {
         result.setPath("/dev/listAsk.dev");
         result.setRedirect(false); // 리다이렉트 처리
     } else {
         request.setAttribute("errorMessage", "댓글 수정에 실패했습니다.");
         result.setPath("/dev/askEdit.jsp");
     }
     return result;
	
	
	
	
	
	}
}
