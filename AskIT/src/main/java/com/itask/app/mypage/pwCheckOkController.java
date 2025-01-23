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

public class pwCheckOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		MypageDAO mypageDAO = new MypageDAO();
		Result result = new Result();
		UserDTO userDTO = new UserDTO();
		
		//해당 회원의 세션정보 받아오기
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		
		if (userDTO == null) {
            // 세션에 유저 정보가 없는 경우 -> 로그인 페이지
            result.setRedirect(true);
            result.setPath(request.getContextPath() + "/app/member/login.jsp");
            return result;
		}
		
//		System.out.println("============세션내 해당 회원의 정보" + thisUser); 확인 완료
//		System.out.println(session);
		
	
//		Integer userNum = (Integer) request.getSession().getAttribute("userNum");
//		System.out.println(" ========== 세션 userNum 확인 :" + userNum);
		
//		session.setAttribute("userDTO", userDTO);
//		System.out.println(" ========== 세션 USERID 확인 :" + userDTO.getUserId());
//		System.out.println(" ========== 세션 USERID 확인 :" + session.getAttribute(userDTO.getUserId()));
		// 로그인한 유저는 session에 유저정보가 저장되어 있으므로 바로 꺼내온다.
//		System.out.println(session.getAttribute("userDTO"));
//		UserDTO thisUser = (UserDTO)session.getAttribute("UserDTO");
//		
//		System.out.println(thisUser.toString());
//		
		//사용자의 아이디와 form에서 입력한 비밀번호를 저장
		String userId = thisUser.getUserId();
//		System.out.println(userId); 확인완료

		String userPw = request.getParameter("userPw");
//		System.out.println(userPw); 확인완료
		
		//회원정보가 있다면 -> infoEdit 페이지 출력
		if(mypageDAO.pwCheck(userId, userPw)) {
//			System.out.println("--------------- pwCheckOk컨트롤러확인 : " + userId);
			result.setPath("/app/mypage/editInfo.jsp");
			result.setRedirect(false); // forward로 보내기
		}else {
//			System.out.println("--------------- pwCheckOk컨트롤러확인 : " + userId);
			//pw 인증 실패시 다시 그 페이지
			session.setAttribute("pwCheckFailMsg", "비밀번호가 일치하지 않습니다.");
			System.out.println(request.getAttribute("pwCheckFailMsg"));
			result.setPath(request.getContextPath() + "/app/mypage/pwCheck.jsp");
			result.setRedirect(true); 
		}
		
		return result;
	}
}
