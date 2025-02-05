package com.itask.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.UserDTO;
import com.itask.app.member.dao.UserDAO;

public class JoinOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		System.out.println(userDTO);
//		userMoniter
		userDTO.setUserMonitor(0);
		String userId = request.getParameter("userId");
		
		String userNick = request.getParameter("userNick");
		String userMail = request.getParameter("userMail");
		
		String agreeOp = (String) session.getAttribute("agreeOption");
		
		if(agreeOp == null) {
			System.out.println("선택약관 동의 세션 받아오지 못함");
		}else if(agreeOp.equals("true")) {
			System.out.println("선택약관 동의");
			userDTO.setUserAgree('T');
		}else {
			System.out.println("선택약관 미동의");
			userDTO.setUserAgree('F');
		}
		
		userDTO.setUserId(userId);
		userDTO.setUserPw(request.getParameter("userPw"));
		userDTO.setUserName(request.getParameter("userName"));
		userDTO.setUserNick(userNick);
		userDTO.setUserPhone(request.getParameter("userPhone"));
		userDTO.setUserMail(userMail);
		
		
		userDAO.join(userDTO);
		
		
		session.setAttribute("userDTO", userDTO);
		
		
		result.setRedirect(true);
		result.setPath(request.getContextPath()+"/app/member/joinfinish.jsp");
		
		return result;
	}
	
}
