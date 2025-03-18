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

public class editInfoOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		UserDTO userDTO = new UserDTO();
		
		// 해당 사용자의 세션을 받아올 객체 객체 선언
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		System.out.println("=========editInfoOk에서의 thisUser 출력");
		System.out.println(thisUser);
		
		//세션통해 해당 유저의 아이디 저장
		String userId = thisUser.getUserId();
		System.out.println(userId);
		//사용자가 입력한 닉네임 저장
		String userNick = request.getParameter("userNick");
		System.out.println(userNick);
		
		userDTO.setUserId(userId);
		userDTO.setUserNick(userNick);
		
		request.setCharacterEncoding("UTF-8");
 
		// 쿼리문 실행
		// 중복이 아닐시
		if(mypageDAO.nickCheck(userNick)) {
			// 수정된 행이 1이상 -> 메소드에서 false 반환함
			if(!mypageDAO.nickUpdate(userDTO)) {
				System.out.println("닉네임 수정 성공!");
				//현재페이지 새로고침
				result.setPath("/app/mypage/editInfo.jsp");
				result.setRedirect(false);
			}else {
				System.out.println("닉네임 수정 실패!");
				session.setAttribute("nickDup", "NickName Edit Error!!!");
				result.setPath(request.getContextPath() + "/app/mypage/editInfo.jsp");
				result.setRedirect(true);
			}
		}else {
			//중복이면 중복 상태 설정
			session.setAttribute("DuplicateStatus", "true");
		}
		
		return result;
	}

	
	
	
	
}
