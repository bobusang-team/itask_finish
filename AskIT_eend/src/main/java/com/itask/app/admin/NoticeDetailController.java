package com.itask.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.NoticeDTO;

public class NoticeDetailController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		
		System.out.println(request.getParameter("noticeNum") + "=================");
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		NoticeDTO notice = adminDAO.NoticeDetail(noticeNum);
		request.setAttribute("notice", notice);
		result.setPath("/app/admin/noticeDetail.jsp");
		result.setRedirect(false);
		return result;
	}

}
