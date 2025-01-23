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
		
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		System.out.println(userDTO);
//		userMoniter
		String userId = request.getParameter("userId");
        String userPw = request.getParameter("userPw");
        String userName = request.getParameter("userName");
        String userNick = request.getParameter("userNick");
        String userPhone = request.getParameter("userPhone");
        String userMail = request.getParameter("userMail");
        String userCareer = request.getParameter("userCareer");
		
		userDTO.setUserId(userId);
        userDTO.setUserPw(userPw);
        userDTO.setUserName(userName);
        userDTO.setUserNick(userNick);
        userDTO.setUserPhone(userPhone);
        userDTO.setUserMail(userMail != null ? userMail : ""); // null일 경우 빈 문자열로 처리
        userDTO.setUserMoniter("0"); // 고정 값
        userDTO.setUserAgree("F"); // 고정 값
        userDTO.setUserCert('F'); // 고정 값
        userDTO.setUserCareer(userCareer != null ? userCareer : ""); // null일 경우 빈 문자열로 처리
		
		
		userDAO.join(userDTO);
		
		HttpSession session = request.getSession();
		session.setAttribute("userDTO", userDTO);
		
		result.setRedirect(true);
		result.setPath(request.getContextPath()+"/app/member/joinfinish.jsp");
		
		return result;
	}
	
}
