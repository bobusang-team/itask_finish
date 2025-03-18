package com.itask.app.member;

import java.io.IOException;
import java.sql.Timestamp;

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
		
		
//		userMoniter
		userDTO.setUserMonitor(0);
		String userId = request.getParameter("userId");
		
		String userNick = request.getParameter("userNick");
		String userMail = request.getParameter("userMail");
		
//		String agreeOp = (String) session.getAttribute("agreeOption");
		
		String agreeOp = (String) request.getSession().getAttribute("agreeOption");
		
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
		userDTO.setUserJoinDate(new Timestamp(System.currentTimeMillis()));
		
		userDAO.join(userDTO);
		
		session.setAttribute("userDTO", userDTO);
		
		int test = ((UserDTO) request.getSession().getAttribute("userDTO")).getUserNum();
		
		System.out.println(request.getSession().getAttribute("userDTO"));
		System.out.println("========="+test+"==========");
		
		result.setRedirect(false);
		result.setPath("/app/member/certOk.me");
		
		return result;
	}
	
}
