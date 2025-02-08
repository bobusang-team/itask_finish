package com.itask.app.mypage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.MypageMainDTO;
import com.itask.app.dto.UserDTO;
import com.itask.app.mypage.dao.MypageDAO;

public class myProfileImgChangOkController implements Execute {

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

		// 로그인 상태가 아니라면
		if (thisUser == null) {
			path = "/app/member/login.jsp";
			result.setPath(path);
			result.setRedirect(true);
		}

		// 로그인 상태의 경우 다음 경로를 mypageMain으로 설정
//		path = "/mypage/mypageMainOk.my";
		path = "/app/mypage/mypageMain.jsp";

		// 사용자의 아이디 값 받아오기
		String userId = thisUser.getUserId();
		System.out.println("================userId확인용" + userId);
		
		//쿼리 실행
		mypageMainDTO = mypageDAO.mainPageSelect(userId);
		System.out.println(mypageMainDTO); // 확인용

		// 변경완료후 돌아가는 페이지는 메인페이지 이므로, mypageMainDTO에 정보도 필요함
		// 이때 mypageMainDTO에 있는

		// 유저가 선택한 프로필 번호를 받아와서
		// profile 테이블에 해당 번호로 쿼리를 보낸다
		
		int userNum = thisUser.getUserNum();
		int profileNum = Integer.parseInt(request.getParameter("option"));
//		System.out.println("======유저가 선택한 번호 : " + profileNum);
		
		//파일명을 select하는 쿼리문실행
		String profileFileName = mypageDAO.profileSelect(profileNum);
//		System.out.println("======해당하는 프로필 이미지명 : " + profileFileName);
		
		
		Map<String, Integer> map = new HashMap<>();
		map.put("userNum", userNum);
		map.put("profileNum", profileNum);
		
		// UserDTO에 profileNum 업데이트하는 메소드 실행
		int checkUpdate = mypageDAO.UserProfileNumUpdate(map);
		System.out.println("컨트롤러에 넘어온 체크업데이트 : " + checkUpdate);
		
		// UserDTO 조회하는 메소드 실행
		System.out.println("변경전 userDTO : " + thisUser);
		UserDTO changeUser = mypageDAO.selectUser(userNum);
		System.out.println("변경후 userDTO : " + changeUser);
		session.setAttribute("userDTO", changeUser);
		
		mypageMainDTO.setProfileNum(profileNum);
		System.out.println("수정후 mypageMainDTO : " + mypageMainDTO);
//		request.setAttribute(profileFileName, profileFileName);
		
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
//		System.out.println("=====프로필경로 확인 : " + profileImgSrc);
		
		//요청에 프로필에 대한 값을 설정
		request.setAttribute("profileImgSrc", profileImgSrc);
		request.setAttribute("profileAlt", profileAlt);
		

		// 뱃지 이미지와 경로 설정
		List<Map<String, String>> badges = new ArrayList<>();
		badges.add(Map.of(
		    "status", mypageMainDTO.getUserMentoCert(),
		    "name", "멘토",
		    "imgSrc", contextPath + "/assets/img/profile_mento.png",
		    "alt", "멘토뱃지이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsIPE(),
		    "name", "정보처리기사",
		    "imgSrc", contextPath + "/assets/img/cert_ipe.png",
		    "alt", "정보처리기사이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsIPIE(),
		    "name", "정보처리산업기사",
		    "imgSrc", contextPath + "/assets/img/cert_ipie.png",
		    "alt", "정보처리산업기사이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsIPT(),
		    "name", "정보처리기능사",
		    "imgSrc", contextPath + "/assets/img/cert_ipt.png",
		    "alt", "정보처리기능사이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsISE(),
		    "name", "정보보안기사",
		    "imgSrc", contextPath + "/assets/img/cert_ise.png",
		    "alt", "정보보안기사이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsISIE(),
		    "name", "정보보안산업기사",
		    "imgSrc", contextPath + "/assets/img/cert_isie.png",
		    "alt", "정보보안산업기사이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsNetManager1(),
		    "name", "네트워크관리사 1급",
		    "imgSrc", contextPath + "/assets/img/cert_netmanager1.png",
		    "alt", "네관1이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsNetManager2(),
		    "name", "네트워크관리사 2급",
		    "imgSrc", contextPath + "/assets/img/cert_netmanager2.png",
		    "alt", "네관2이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsSqld(),
		    "name", "SQLD",
		    "imgSrc", contextPath + "/assets/img/cert_sqld.png",
		    "alt", "sqld이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsLinuxMaster1(),
		    "name", "리눅스마스터 1급",
		    "imgSrc", contextPath + "/assets/img/cert_linuxmaster1.png",
		    "alt", "리마1이미지"
		));
		badges.add(Map.of(
		    "status", mypageMainDTO.getCertsLinuxMaster2(),
		    "name", "리눅스마스터 2급",
		    "imgSrc", contextPath + "/assets/img/cert_linuxmaster2.png",
		    "alt", "리마2이미지"
		));
	    
		request.setAttribute("mypageMainDTO", mypageMainDTO);
		request.setAttribute("Tcount", mypageMainDTO.getBadgeCount());
		request.setAttribute("badges", badges);
		
		result.setPath(path);
		result.setRedirect(false);
		
		return result;
	}

}
