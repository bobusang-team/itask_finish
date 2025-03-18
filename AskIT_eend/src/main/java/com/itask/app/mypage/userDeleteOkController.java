package com.itask.app.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.UserDTO;
import com.itask.app.mypage.dao.MypageDAO;

public class userDeleteOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		UserDTO userDTO = new UserDTO();
		
		// 해당 사용자의 세션을 받아올 객체 객체 선언
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		System.out.println("=========userDeleteOk에서의 thisUser 출력");
		System.out.println(thisUser);
		
		//세션통해 해당 유저의 아이디 저장
		String userId = thisUser.getUserId();
		System.out.println(userId);
		
		request.setCharacterEncoding("UTF-8");
		
		//세션끊고
		session.invalidate();
		
		//삭제되었다면
		if(!mypageDAO.delete(userId)) {
			System.out.println("회원 탈퇴 완료!");
			request.setAttribute("msg", "회원탈퇴완료");
			result.setPath(request.getContextPath() + "/main.jsp");
			result.setRedirect(true);
		}else {
			System.out.println("회원 삭제 실패!");
			request.setAttribute("errorMsg", "Password Edit Error!!!");
			result.setPath(request.getContextPath() + "/app/mypage/editInfo.jsp");
			result.setRedirect(true);
		}
		
		return result;
		
	}
	
}
