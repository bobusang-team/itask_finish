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

public class PwfindOkController implements Execute{
	
	static int userNumForReset = -1;

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		userDTO = userDAO.pwfind(userId, userName, userPhone);
		System.out.println("start pwfindOkcontroller");
		
		//일치하는 회원을 찾았을 경우 
		if(userDTO != null) {
			userNumForReset = userDTO.getUserNum();
			System.out.println(userNumForReset);
			
			// 비밀번호 변경 페이지로 이동
			result.setPath(request.getContextPath()+"/app/member/pwreset.jsp");
			result.setRedirect(true);
		}else {
			//일치하는 회원을 찾지 못했을 경우
			HttpSession session = request.getSession();
			session.setAttribute("pwfindFail", "해당하는 회원 정보가 없습니다.");
			result.setPath(request.getContextPath()+"/app/member/pwfind.jsp");
			result.setRedirect(true);
		}
		
		return result;
	}
	
}
