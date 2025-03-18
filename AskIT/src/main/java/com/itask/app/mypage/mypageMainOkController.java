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
		
<<<<<<< HEAD
		
		
		
=======
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
<<<<<<< HEAD
=======
		
		// 원하는 값을 저장할 DTO를 생성해야함
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
		MypageMainDTO mypageMainDTO = new MypageMainDTO();
		
		// 해당 사용자의 세션을 통해 정보 받아오기
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
<<<<<<< HEAD
		String path = null;
		
		System.out.println("========해당 유저 DTO : " + thisUser); // 확인용
		
		// 로그인 상태가 아니라면
		if(thisUser == null) {
			path = "/app/member/login.jsp";
			result.setPath(path);
			result.setRedirect(true);
		} else {
			path = "/app/mypage/mypageMain.jsp";
			
			// 사용자의 아이디
			String userId = thisUser.getUserId();
			System.out.println("================userId확인용" + userId);
			
			//쿼리 실행
			mypageMainDTO = mypageDAO.mainPage(userId);
			System.out.println(mypageMainDTO); // 확인용
			
			request.setAttribute("MypageMainDTO", mypageMainDTO);
			result.setPath(path);
			result.setRedirect(false);
		}


		

		
		
		
		//생성된다면
//		if(mypageMainDTO != null) {
//			result.setPath("/app/mypage/mypageMain.jsp");
//			result.setRedirect(false);
//		}else {
//			//실패시 메인화면으로
//			result.setPath("/usermain.jsp");
//			result.setRedirect(true);
//		}
=======
		
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
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
		
		return result;
	}
	
}


