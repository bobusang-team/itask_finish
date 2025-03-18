package com.itask.app.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;

public class DevUpdateController implements Execute {

	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int articleNum = Integer.valueOf(request.getParameter("articleNum"));
	

		DevDAO devDAO = new DevDAO();
	
		ArticleListDTO dev = devDAO.selectOne(articleNum);
		System.out.println(articleNum);// 특정 게시글 조회
	    request.setAttribute("dev", dev);
		/* request.setAttribute("dev", devDAO.select(articleNum)); */

		Result result = new Result();
		result.setPath("/app/article/dev/askEdit.jsp"); 
		result.setRedirect(false);
		
		return result;
		/*
		 * request.getRequestDispatcher("/app/article/dev/askEdit.jsp").forward(request,
		 * response);
		 */
	
		
	}

}
