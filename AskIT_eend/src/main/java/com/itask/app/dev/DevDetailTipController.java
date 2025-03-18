package com.itask.app.dev;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.CommentDTO;

public class DevDetailTipController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		int articleNum = Integer.parseInt(request.getParameter("articleNum"));
		System.out.println("DevDetailTipController 실행");
		DevDAO devDAO = new DevDAO();
		System.out.println("DevDetailTipController DAO객체");
		
		List<CommentDTO> comments = devDAO.comment(articleNum); // 댓글 리스트 가져오기
		 request.setAttribute("comments", comments);
		
	    ArticleListDTO dev = devDAO.selectOne(articleNum); // 특정 게시글 조회
	    request.setAttribute("dev", dev);
		
	    Result result = new Result();
	    result.setPath("/app/article/dev/tipDetail.jsp");
	    result.setRedirect(false);
	    return result;
	}
}
