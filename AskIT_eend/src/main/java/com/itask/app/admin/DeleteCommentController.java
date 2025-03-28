package com.itask.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;

public class DeleteCommentController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		int commentNum = Integer.valueOf(request.getParameter("commentNum"));
		System.out.println(commentNum);
		adminDAO.DeleteComment(commentNum);
		
		result.setPath("./articleDetail.ad?articleNum=" + request.getParameter("articleNum"));
		result.setRedirect(true);
		return result;
	}

}
