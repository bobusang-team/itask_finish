package com.itask.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.NoticeDTO;

public class NoticeController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 AdminDAO adminDAO = new AdminDAO();
	        
	        List<NoticeDTO> noticeList = adminDAO.Notice();
	        for (NoticeDTO list : noticeList) {
				System.out.println("공지사항 데이터: " + list);
			}
	        // 회원 목록을 request 객체에 담아 JSP로 전달
	        request.setAttribute("noticeList", noticeList);

	        // 결과 페이지 설정
	        Result result = new Result();
	        result.setPath("/app/admin/notice.jsp");
	        return result;
	}



}
