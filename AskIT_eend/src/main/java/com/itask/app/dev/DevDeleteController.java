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
		devDAO.delete(articleNum);
		result.setPath("./listAsk.dev");
		result.setRedirect(true);
		return result;
	}

}
