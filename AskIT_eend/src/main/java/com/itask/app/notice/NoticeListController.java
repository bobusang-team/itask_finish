package com.itask.app.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;

//공지사항 목록보기
public class NoticeListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Result result = new Result();
		
		//boardNumber가 빈 문자열이나 null인 경우
		String noticeNumStr = request.getParameter("noticeNum");
		if(noticeNumStr == null || noticeNumStr.trim().isEmpty()) {
			System.out.println("noticeNum 값이 없습니다");
			result.setPath("/app/notice/notice.jsp"); //게시글 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}

		return null;
	}
	
	

}
