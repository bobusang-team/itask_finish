package com.itask.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.AdminDTO;
import com.itask.app.dto.CommentDTO;

public class AddCommentController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
        CommentDTO commentDTO = new CommentDTO();
        Result result = new Result();

        HttpSession session = request.getSession();
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("adminDTO");
        System.out.println("Session adminDTO: " + adminDTO); // 디버깅용
        System.out.println(request.getAttribute("commentText"));
        commentDTO.setCommentText(request.getParameter("commentText"));
        
        
        
		return result;
	}
	
}
