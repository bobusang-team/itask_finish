package com.itask.app.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.comment.dao.CommentDAO;
import com.itask.app.dto.CommentDTO;

public class CommentUpdateOkController implements Execute{
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setCommentNum(Integer.valueOf(request.getParameter("commentNum")));
		commentDTO.setCommentText(request.getParameter("commentText"));
		
		new CommentDAO().update(commentDTO);
		return null;
	}
}
