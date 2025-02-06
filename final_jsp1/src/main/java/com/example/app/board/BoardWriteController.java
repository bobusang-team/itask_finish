package com.example.app.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.member.dao.MemberDAO;

public class BoardWriteController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		MemberDAO memberDAO = new MemberDAO();
		Result result = new Result();
		
		HttpSession session = request.getSession();
		Integer memberNumber = (Integer) session.getAttribute("memberNumber");
		String path = null;
		
		System.out.println("글쓰기 실행!");
		
		// 로그인이 되어있지 않은 상태라면
		if(memberNumber == null) {
			path = "/app/member/login.jsp"; // 글쓰기 페이지로 이동
		} else {
			path = "/app/board/boardWrite.jsp";
			request.setAttribute("memberId", memberDAO.getMemberId(memberNumber));
		}
		result.setPath(path);
		result.setRedirect(false);
		
		
		return result;
	}
	
}
