package com.itask.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.ArticleAdminDTO;

public class UpdateArticleController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		ArticleAdminDTO article = new ArticleAdminDTO();
		Result result = new Result();
		
		
		String topcate = request.getParameter("articleTopcate").trim();
		System.out.println(topcate + "---------");
		String botcate = request.getParameter("articleBotcate").trim();
		System.out.println(botcate + "---------");
		
		System.out.println("값 출력 시작");
		System.out.println(Integer.valueOf(request.getParameter("articleNum")));
		System.out.println("상위카테고리: " + request.getParameter("articleTopcate"));
		System.out.println("하위카테고리: " + request.getParameter("articleBotcate"));
		System.out.println("태그: " + request.getParameter("articleTagName"));
		System.out.println(request.getParameter("articleTitle"));
		System.out.println(request.getParameter("articleText"));
		System.out.println("값 출력 완료");
		
		article.setArticleNum(Integer.valueOf(request.getParameter("articleNum")));
		article.setArticleTopCate(request.getParameter("articleTopcate"));
		article.setArticleBotCate(request.getParameter("articleBotcate"));
		article.setArticleTagName(request.getParameter("articleTagName"));
		article.setArticleTitle(request.getParameter("articleTitle"));
		article.setArticleText(request.getParameter("articleText"));
		
		
		
		adminDAO.UpdateArticle(article);
		
		
		/*
		 * if(topcate.equals("개발") && botcate.equals("질문")) {
		 * result.setPath("./askDev.ad"); } else if(topcate.equals("보안") &&
		 * botcate.equals("질문")) { result.setPath("./askSec.ad"); } else
		 * if(topcate.equals("자격증") && botcate.equals("질문")) {
		 * result.setPath("./askQual.ad"); } else if(topcate.equals("개발") &&
		 * botcate.equals("꿀팁")) { result.setPath("./tipDev.ad"); } else
		 * if(topcate.equals("보안") && botcate.equals("꿀팁")) {
		 * result.setPath("./tipSec.ad"); } else if(topcate.equals("자격증") &&
		 * botcate.equals("꿀팁")) { result.setPath("./tipQual.ad"); }
		 */
		result.setPath("./articleDetail.ad?articleNum=" + request.getParameter("articleNum"));
		result.setRedirect(true);
		return result;
	}

}
