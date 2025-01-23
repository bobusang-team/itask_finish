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

public class TipDevController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 AdminDAO adminDAO = new AdminDAO();
	        
	        
	        List<ArticleDTO> tipDev = adminDAO.TipDev();
	        
	        request.setAttribute("tipDev", tipDev);

	        // 결과 페이지 설정
	        Result result = new Result();
	        result.setPath("/app/admin/tipDev.jsp");
	        return result;
	}



}
