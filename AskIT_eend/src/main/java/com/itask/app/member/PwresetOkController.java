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

public class PwresetOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO();
		Result result = new Result();
		
		String userPw = request.getParameter("userNewPw");
		String newPwCheck = request.getParameter("userNewPwCheck");
		System.out.println("start pwresetOkcontroller" + userPw + newPwCheck);
		
		System.out.println(userPw.equals(newPwCheck)+"");
		
		if(userPw.equals(newPwCheck)) {
			System.out.println("new passwords are equal");
			//새로 입력한 비밀번호와 재입력한 비밀번호가 일치할 때 
			//userPw update
			int userNum = PwfindOkController.userNumForReset;
			if(userNum>=0) {
				userDTO.setUserPw(userPw);
				userDTO.setUserNum(userNum);
				userDAO.reset(userDTO);
				HttpSession session = request.getSession();
				session.setAttribute("pwCheck", "비밀번호가 성공적으로 변경되었습니다!");
			}else {
				HttpSession session = request.getSession();
				session.setAttribute("pwCheck", "비밀번호 변경에 실패했습니다!");
			}
			result.setPath(request.getContextPath()+"/app/member/login.jsp");
		}else {
			//불일치 
			System.out.println("new passwords are not equal");
			HttpSession session = request.getSession();
			session.setAttribute("pwCheck", "입력한 비밀번호가 불일치합니다!");
			result.setPath(request.getContextPath()+"/app/member/pwreset.jsp");
			
		}
		result.setRedirect(true);
		return result;
	}
	

}
