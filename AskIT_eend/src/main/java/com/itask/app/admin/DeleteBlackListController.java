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

public class DeleteBlackListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		
		String[] blackListNum = request.getParameter("blackListNum").split(",");
		System.out.println(blackListNum);
		List<String> userIdsList = Arrays.asList(blackListNum);
		
		System.out.println(userIdsList);
		adminDAO.DeleteBlackList(userIdsList);
		
		result.setRedirect(true);
		result.setPath("./blackList.ad");
		return result;
	}

}
