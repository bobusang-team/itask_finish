package com.itask.app.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.UserDTO;
import com.itask.app.member.dao.UserDAO;

public class LoginOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		userDTO = userDAO.login(userId, userPw);
		
		
		//로그인 성공 시 
		if(userDTO != null) {
			System.out.println(userDTO);
			//세션에 해당 사용자 정보를 저장
			HttpSession session = request.getSession();
			session.setAttribute("userDTO", userDTO);
			
			// 회원 메인 페이지로 이동 
			result.setPath(request.getContextPath()+"/usermain.jsp");
			result.setRedirect(true);
		}else {
			//로그인 실패시 로그인 페이지로 이동
			HttpSession session = request.getSession();
			session.setAttribute("loginFail", "아이디 또는 비밀번호가 일치하지 않습니다.");
			// setPath 수정필요
			result.setPath(request.getContextPath()+"/app/member/login.jsp");
			result.setRedirect(true);
		}
		
		return result;
	}
	
}
