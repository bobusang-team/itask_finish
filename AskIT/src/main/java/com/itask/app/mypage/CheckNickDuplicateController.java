package com.itask.app.mypage;

import java.io.IOException;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.mypage.dao.MypageDAO;

public class CheckNickDuplicateController implements Execute {
	
	private MypageDAO mypageDAO = new MypageDAO();
	private Gson gson = new Gson();

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userNick = request.getParameter("userNick");
		System.out.println(userNick);
		
		boolean exists = false;
		
		exists = mypageDAO.isNick(userNick); // 닉네임 중복확인
		
		System.out.println(exists);
		String jsonResponse = gson.toJson(new CheckResponse(exists));
		
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(jsonResponse);
		
		return null;
	}
	
	// Json 응답 형식 클래스
	private class CheckResponse {
        private boolean exists; // 불리언 필드 선언

        public CheckResponse(boolean exists) { // 생성자를 통해서 초기화한다.
            this.exists = exists;
        }

		public boolean isExists() { // 메소드 선언 -> 리턴값 불리언
            return exists;
        }
    }
}
