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

public class mentoCheckOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		MypageMainDTO mypageMainDTO = new MypageMainDTO();
		
		// 해당 사용자의 세션을 통해 정보 받아오기
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		String path = null;
		
		System.out.println("========해당 유저 DTO : " + thisUser); // 확인용
		
		// 로그인 상태가 아니라면
		if(thisUser == null) {
			path = "/app/member/login.jsp";
			result.setPath(path);
			result.setRedirect(true);
		}
			// 로그인 상태의 경우 다음 경로를 mypageMain으로 설정
			path = "/app/mypage/mentoCheck.jsp";
			
			// 사용자의 아이디 값 받아오기
			String userId = thisUser.getUserId();
			System.out.println("================userId확인용" + userId);
			
			//쿼리 실행
			mypageMainDTO = mypageDAO.mainPageSelect(userId);
			System.out.println(mypageMainDTO); // 확인용
			request.setAttribute("mypageMainDTO", mypageMainDTO);
			
			int profileNum = thisUser.getProfileNum();
			String profileFileName = mypageDAO.profileSelect(profileNum);
			
			// contextPath 경로 설정
			String contextPath = request.getContextPath();
			
			//프로필 이미지와 경로 설정
			String profileImgSrc = null;
			String profileAlt = null;
			
			switch(profileNum) {
			case 1:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지1";
			    break;
			case 2:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지2";
			    break;
			case 3:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지3";
			    break;
			case 4:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지4";
			    break;
			case 5:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지5";
			    break;
			case 6:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지6";
			    break;
			case 7:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지7";
			    break;
			case 8:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지8";
			    break;
			case 9:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지9";
			    break;
			case 10:
			    profileImgSrc = contextPath + "/assets/img/" + profileFileName;
			    profileAlt = "프로필이미지10";
			    break;
			}
			
			//요청에 프로필에 대한 값을 설정
			request.setAttribute("profileImgSrc", profileImgSrc);
			request.setAttribute("profileAlt", profileAlt);
			
			result.setPath(path);
			result.setRedirect(false);
			
		return result;
		
	}	
}
