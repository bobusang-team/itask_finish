package com.itask.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.ArticleDTO;
import com.itask.app.dto.CommentDTO;

public class ArticleDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("articleNum") + "=================");
		int articleNum = Integer.parseInt(request.getParameter("articleNum"));
//        String articleNumber = request.getParameter("articleNum");
		System.out.println(articleNum);

		AdminDAO adminDAO = new AdminDAO();
		System.out.println("게시글 정보받기전");
		ArticleDTO article = adminDAO.ArticleDetail(articleNum); // 게시글 정보 가져오기
		System.out.println("게시글 정보받은 후");
        List<CommentDTO> comments = adminDAO.Comment(articleNum); // 댓글 리스트 가져오기
		request.setAttribute("article", article);
        request.setAttribute("comments", comments); 

		Result result = new Result();
		result.setRedirect(false);
		result.setPath("/app/admin/articleDetail.jsp");
		return result;
	}
}