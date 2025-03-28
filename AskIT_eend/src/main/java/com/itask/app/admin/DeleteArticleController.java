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

public class DeleteArticleController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		String topcate = request.getParameter("articleTopcate").trim();
		System.out.println(topcate);
		String botcate = request.getParameter("articleBotcate").trim();
		System.out.println(botcate);
		String[] articleNum = request.getParameter("articleNums").split(",");
		List<String> articleList = Arrays.asList(articleNum);
		adminDAO.DeleteArticle(articleList);
		
		if(topcate.equals("개발") && botcate.equals("질문")) {
			result.setPath("./askDev.ad");			
		}
		else if(topcate.equals("보안") && botcate.equals("질문")) {
			result.setPath("./askSec.ad");
		}
		else if(topcate.equals("자격증") && botcate.equals("질문")) {
			result.setPath("./askQual.ad");
		}
		else if(topcate.equals("개발") && botcate.equals("꿀팁")) {
			result.setPath("./tipDev.ad");
		}
		else if(topcate.equals("보안") && botcate.equals("꿀팁")) {
			result.setPath("./tipSec.ad");
		}
		else if(topcate.equals("자격증") && botcate.equals("꿀팁")) {
			result.setPath("./tipQual.ad");
		}
		result.setRedirect(true);
		return result;
	}

}
