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

public class editPhoneNumOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		
		// 해당 사용자의 세션을 받아올 객체 객체 선언
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		System.out.println("=========editPhoneNum에서의 thisUser 출력");
		System.out.println(thisUser);
		
		// 해당 사용자의 id 저장
		String userId = thisUser.getUserId();
		System.out.println(userId);
		
		String userPhone = request.getParameter("userPhoneNum");
		System.out.println(userPhone);
		// ********************여기에 jsp단의 유효성검사가 필요함
		//if() 인증번호까지 맞았다면
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(userId);
		userDTO.setUserPhone(userPhone);
		
		if(!mypageDAO.phoneUpdate(userDTO)) {
			System.out.println("핸드폰번호 수정 완료!");
			result.setPath("/app/mypage/editInfo.jsp");
			result.setRedirect(false);
		}else {
			System.out.println("비밀번호 수정 실패!");
			request.setAttribute("errorMsg", "PhoneNum Edit Error!!!");
			result.setPath(request.getContextPath() + "/app/mypage/editPhoneNum.jsp");
			result.setRedirect(true);
		
		}
	//else 인증번호 틀렸다면
		
		
		return result;
	}
	
	
}
