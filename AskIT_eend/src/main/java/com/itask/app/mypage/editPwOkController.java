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

public class editPwOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		MypageDAO mypageDAO = new MypageDAO();
		Result result = new Result();

		// 해당 사용자의 세션을 받아줄 세션 객체 선언
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		System.out.println("=========editPwOk에서의 thisUser 출력");
		System.out.println(thisUser);

		// 세션통해 해당 유저의 아이디 저장
		String userId = thisUser.getUserId();

		String userNewPw = request.getParameter("userNewPw");
		String userRepeatPw = request.getParameter("userRepeatPw");
		
		System.out.println(thisUser);

		// 새로 입력한 비밀번호와 재확인 비밀번호가 같지 않다면 + ****** 유효성 검사 더욱 필요함
		if (!userNewPw.equals(userRepeatPw)) {
			session.setAttribute("pwMatchError", "비밀번호가 서로 일치하지 않습니다.");
			System.out.println(request.getAttribute("pwMatchError"));
			result.setPath(request.getContextPath() + "/app/mypage/editPw.jsp");
			result.setRedirect(true);
			return result;
		} else {
			// 비밀번호가 같다면
			// userDTO 객체에 유저 id, 비밀번호 저장
			UserDTO userDTO = new UserDTO();
			userDTO.setUserId(userId);
			userDTO.setUserPw(userNewPw);

			// 해당 유저의 비밀번호를 수정
			if (!mypageDAO.pwUpdate(userDTO)) {
				System.out.println("비밀번호 수정 완료!");
				session.setAttribute("editPwSuccessMsg", "비밀번호 수정 완료! \n로그인페이지로 이동합니다.");
				result.setPath(request.getContextPath() + "/app/member/login.jsp");
				result.setRedirect(true);
				session.invalidate();
			} else {
				System.out.println("비밀번호 수정 실패!");
//				request.setAttribute("errorMsg", "Password Edit Error!!!");
				result.setPath(request.getContextPath() + "/app/mypage/editPw.jsp");
				result.setRedirect(true);
			}

		}

		return result;
	}

}
