package com.itask.app.mypage;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.MypageMainDTO;
import com.itask.app.dto.UserDTO;
import com.itask.app.mypage.dao.MypageDAO;

public class userTotalArticleOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		Result result = new Result();
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		String path = null;

		// 로그인 상태가 아니라면
		if (thisUser == null) {
			path = request.getContextPath() + "/app/member/login.jsp";
			result.setPath(path);
			result.setRedirect(true);
			return result;
		}

		// 로그인 상태라면
		path = "/app/mypage/userTotalArticle.jsp";

		// 사용자의 아이디 값 받아오기
		String userNick = request.getParameter("userNick");
		System.out.println("================모든 게시글을 볼 유저의 닉네임 : " + userNick);

		ArticleListDTO articleListDTO = new ArticleListDTO();
		MypageDAO mypageDAO = new MypageDAO();
		MypageMainDTO mypageMainDTO = new MypageMainDTO();

		// 쿼리 실행 여기서의 mypageMainDTO는 게시글에서 클릭한 유저의 DTO임
		mypageMainDTO = mypageDAO.userPageSelect(userNick);
		request.setAttribute("mypageMainDTO", mypageMainDTO);

		int profileNum = mypageMainDTO.getProfileNum();
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
		
		// 닉네임으로부터 유저번호를 알아오는 쿼리문을 작성하자
		int userNum = mypageDAO.getUserNum(userNick);
		System.out.println("==쿼리 이후 컨트롤러에서 출력하는 userNum : " + userNum);

		String temp = request.getParameter("page");
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지번호 기본값 : 1
		int rowCount = 5; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수

		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행
		int endRow = startRow + rowCount - 1;

		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		pageMap.put("userNum", userNum);

		// 게시글의 총 개수를 먼저 알아와야함
		int total = mypageDAO.getTotalArticleNum(userNum);

		// 게시글 목록 조회
		List<ArticleListDTO> myList = mypageDAO.selectAllMyArticle(pageMap);
		request.setAttribute("myArticleList", myList);

		// 올림 함수를 사용해서 페이지네이션 총 수를 구해야함
		int realEndPage = (int) Math.ceil(total / (double) rowCount); // 리얼 마지막 페이지 네이션
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현재 페이지를 기준으로 보여주는 페이지네이션 그룹
		int startPage = endPage - (pageCount - 1); // 현재 페이지 그룹에서의 첫 페이지

		// 음수 페이지가 start 인 것을 방지
		endPage = Math.min(endPage, realEndPage);

		// prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);

		System.out.println("=======페이징 정보확인===========");
		System.out.println("== pageMap : " + pageMap);
		System.out.println("== pageMap : " + pageMap);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
		System.out.println("===============================");

		result.setPath(path);
		result.setRedirect(false);

		return result;
	}
	
}
