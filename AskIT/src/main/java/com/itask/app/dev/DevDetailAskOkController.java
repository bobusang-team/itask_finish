package com.itask.app.dev;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;

public class DevDetailAskOkController implements Execute {
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int articleNum = Integer.valueOf(request.getParameter("articleNum"));
		DevDAO devDAO = new DevDAO();
		ArticleListDTO articleListDTO = devDAO.select(articleNum); 
		Result result = new Result();

		 devDAO.increaseView(articleNum);
		 System.out.println("조회수 증가 성공!");// 조회수 증가
		 request.setAttribute("dev", articleListDTO); 

		result.setPath("/app/article/dev/askDetail.jsp");
		result.setRedirect(false);

		return result;
	}

}
