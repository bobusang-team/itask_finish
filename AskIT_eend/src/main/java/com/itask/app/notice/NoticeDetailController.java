package com.itask.app.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.NoticeListDTO;
import com.itask.app.notice.dao.NoticeDetailDAO;

//공지사항 글상세보기
public class NoticeDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("== NoticeDetailController == 확인");
		
		NoticeListDTO noticeListDTO = new NoticeListDTO();
		Result result = new Result();
		
		//noticeNum이 빈 문자열이나 null인 경우
		String noticeNumStr = request.getParameter("noticeNum");
		if(noticeNumStr == null || noticeNumStr.trim().isEmpty()) {
			System.out.println("noticeNum 값이 없습니다");
			result.setPath("/app/notice/notice.jsp"); //공지사항 목록 페이지로 리다이렉트
			result.setRedirect(true);
			return result;
		}
		
		int noticeNum = Integer.parseInt(noticeNumStr);
		
		NoticeDetailDAO noticeDetailDAO = new NoticeDetailDAO();
		noticeListDTO = noticeDetailDAO.selectDetail(noticeNum);
		System.out.println(noticeListDTO);
		
		
		//게시글이 존재하지 않을 경우 처리 = 삭제되었을 경우 = 공지사항 목록으로 이동
		if(noticeListDTO == null) {
			System.out.println(noticeNum + "번 게시물은 존재하지 않거나 삭제되었습니다.");
			result.setPath("/app/notice/notice.jsp");
			return result;
		}
		
		//조회수 증가 = 공지사항 관리는 관리자페이지에서 하기 때문에 무조건 조회할 때마다 조회수 1씩 증가한다
		noticeDetailDAO.updateReadCount(noticeNum);
		
		
		request.setAttribute("noticeList", noticeListDTO);
		result.setPath("/app/notice/noticeDetail.jsp");
		result.setRedirect(false);
		
		return result;
	}

}
