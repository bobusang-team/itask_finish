package com.itask.app.admin;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;

public class DeleteNoticeController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		String[] deleteNoticeNums = request.getParameter("deleteNoticeNums").split(",");
		List<String> NoticeList = Arrays.asList(deleteNoticeNums);
		
		adminDAO.DeleteNotice(NoticeList);

		result.setRedirect(true);
		result.setPath("./notice.ad");
		return result;
	}

}
