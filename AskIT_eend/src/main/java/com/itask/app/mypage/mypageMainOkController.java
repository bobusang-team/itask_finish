package com.itask.app.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.MypageMainDTO;
import com.itask.app.dto.UserDTO;
import com.itask.app.mypage.dao.MypageDAO;

public class mypageMainOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		
		// 원하는 값을 저장할 DTO를 생성해야함
		MypageMainDTO mypageMainDTO = new MypageMainDTO();
		
		// 해당 사용자의 세션을 통해 정보 받아오기
		HttpSession session = request.getSession();
		
		Integer userNum = (Integer)request.getSession().getAttribute("userNum");
		
//		Integer userNum2 = (Integer)request.getSession().getAttribute("userDTO",getUserNum);
		
		
		System.out.println(userNum);
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		
		System.out.println(thisUser); // 확인용
		
		// 사용자의 아이디
		String userId = thisUser.getUserId();
		System.out.println("userId확인용================" + userId);
		
		
		//쿼리 실행
		mypageMainDTO = mypageDAO.mainPage(userId);
		System.out.println(mypageMainDTO); // 확인용
		
		//사용자의 세션에 저장
		session.setAttribute("MypageMainDTO", mypageMainDTO);
		
		//생성된다면
		if(mypageMainDTO != null) {
			result.setPath("/app/mypage/mypageMain.jsp");
			result.setRedirect(false);
		}else {
			//실패시 메인화면으로
			result.setPath("/usermain.jsp");
			result.setRedirect(true);
		}
		
		return result;
	}
	
}


