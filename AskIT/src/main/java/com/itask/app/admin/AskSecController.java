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

public class AskSecController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 AdminDAO adminDAO = new AdminDAO();
	        
	        // 전체 회원 목록 가져오기
	        List<ArticleDTO> askSec = adminDAO.AskSec();

	        // 회원 목록을 request 객체에 담아 JSP로 전달
	        request.setAttribute("askSec", askSec);

	        // 결과 페이지 설정
	        Result result = new Result();
	        result.setPath("/app/admin/askSec.jsp");
	        return result;
	}



}