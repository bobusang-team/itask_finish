package com.itask.app.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Result;
import com.itask.app.dto.UserDTO;

/**
 * Servlet implementation class UserFrontController
 */
//@WebServlet("/UserFrontController")
public class MypageFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MypageFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		System.out.println("mypage 서블릿 실행");
		
		
	      // 세션에서 로그인 여부 확인 (세션이 없거나 로그인 정보가 없으면 로그인 페이지로 리다이렉트)
//        HttpSession session = request.getSession(false);
//        if (session == null || session.getAttribute("userDTO") == null) {
//            System.out.println("로그인되지 않음. 로그인 페이지로 이동.");
//            response.sendRedirect(request.getContextPath() + "/app/member/login.jsp");
//            return;
//        }
		
		// 해당 회원의 세션에 접근하여 정보 가져오기
		HttpSession session = request.getSession();
		
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
//		System.out.println(userDTO);
		
		if (userDTO == null) {
            // 세션에 유저 정보가 없는 경우 -> 로그인 페이지
            response.sendRedirect(request.getContextPath() + "/app/member/login.jsp");
            return;
        }
		
		
		//필요한 Path만 남기기
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target + " 경로확인==============!!!");
		Result result = new Result();
//			UserDTO userDTO = new UserDTO();
		
//			Integer userNum = (Integer)request.getSession().getAttribute("userNum");
		
//			HttpSession session = request.getSession();
//			System.out.println(session);
//			String check = (String) session.getAttribute(userDTO.getUserId());
//			session.setAttribute("userDTO", userDTO);
//			System.out.println(" ========== userDTO.getUserId 확인 :" + userDTO.getUserId());
//			System.out.println(" ========== check 확인 :" + check);
//			System.out.println(" ========== userNum 확인 :" + session.getAttribute(userDTO.getUserId()));
		
		// +++++ 0122 오전
		// 마이페이지 메인에 접근시 해당 유저의 뱃지수, 게시글수, 댓글수 뽑아와야함
		switch(target) {
		case "/mypage/mypageMainOk.my":
			System.out.println("mypageMainOk 실행!");
			result = new mypageMainOkController().execute(request, response);
			
			break;
		// +++++
			
		case "/mypage/mentoCheck.my": // 자격/멘토 뱃지 추가하기 클릭시 -> 해당 jsp로 이동
			System.out.println("mentoCheck 실행!");
			result.setPath("/app/mypage/mentoCheck.jsp");
			result.setRedirect(false);
			break;
			
		case "/mypage/pwCheck.my": // 내정보 수정하기 클릭 -> 해당 jsp 이동
			System.out.println("pwCheck 실행!");
			result.setPath("/app/mypage/pwCheck.jsp");
			result.setRedirect(false); //forward 방식
			break;
			
		case "/mypage/pwCheckOk.my": // 내정보 수정하기 클릭 후 비밀번호 입력하고 클릭시
			System.out.println("pwCheckOk 실행!");
			result = new pwCheckOkController().execute(request, response); // 여기 구현해야함 처리할 컨트롤러생성 
			break;
			
		case "/mypage/editInfoOk.my": // 닉네임 변경하기 클릭시 -> 업데이트
			System.out.println("editInfoOk 실행!");
			result = new editInfoOkController().execute(request, response); // 여기 구현해야함 처리할 컨트롤러 생성
			break;
			
		case "/mypage/editPw.my": // 비밀번호 수정하기 클릭시 -> 해당 jsp 이동
			System.out.println("editPw 실행!");
			result.setPath("/app/mypage/editPw.jsp");
			result.setRedirect(false);
			break;
			
		case "/mypage/editPwOk.my":
			System.out.println("editPwOk 실행!"); // 비밀번호 변경하기 클릭시 -> 업데이트
			result = new editPwOkController().execute(request, response);
			break;
			
		case "/mypage/editPhoneNum.my": // 핸드폰 번호 수정하기 클릭시 -> 업데이트
			System.out.println("editPhoneNum 실행!");
			result.setPath("/app/mypage/editPhoneNum.jsp");
			result.setRedirect(false);
			break;
			
		case "/mypage/editPhoneNumOk.my":
			System.out.println("editPhoneNumOk 실행!"); // 핸드폰번호 변경하기 클릭시 -> 업데이트
			result = new editPhoneNumOkController().execute(request, response);
			break;
			
			// 회원탈퇴하기는 고려해봐야한다..
		case "/mypage/userDeleteOk.my":
			System.out.println("userDeleteOk 실행!"); // 회원탈퇴하기 클릭시 -> 삭제
			result = new userDeleteOkController().execute(request, response);
			break;
			
		case "/mypage/checkNickOk.my":
			System.out.println("checkNickOk 실행!"); // 닉네임 중복검사
			result = new CheckNickDuplicateController().execute(request, response);
			break;
		}
	
	// 다음 동작 처리
	if(result != null) {
		if(result.isRedirect()) {
			response.sendRedirect(result.getPath());
			System.out.println(request.getAttribute("userId"));
		}else {
			request.getRequestDispatcher(result.getPath()).forward(request, response);
		}
	}
	
	
	
	}

}
