package com.itask.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.UserDTO;
import com.itask.app.member.dao.UserDAO;

public class CertInitController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserDAO userDAO = new UserDAO();
		Result result = new Result();
		
		System.out.println("자격증 초기화 섭컨 ");
		
		UserDTO userInfo = (UserDTO) request.getSession().getAttribute("userDTO");
		int userNum = userInfo.getUserNum();
		
		if(userInfo == null) {
			System.out.println("userDTO 세션 받아오기 오류 ");
		}
		
		userDAO.cert(userNum);
		
		result.setRedirect(true);
		result.setPath(request.getContextPath()+"/app/member/joinfinish.jsp");
		
		
		return result;
	}

}
