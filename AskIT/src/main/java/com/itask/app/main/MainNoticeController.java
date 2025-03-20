package com.itask.app.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.NoticeDTO;
import com.itask.app.main.dao.MainNoticeDAO;

public class MainNoticeController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			System.out.println("공지사항 데이터 가져오는 중");
			
			MainNoticeDAO mainNoticeDAO = new MainNoticeDAO();
			List<NoticeDTO> notices = mainNoticeDAO.getRecentNotices();
			System.out.println("공지사항 개수 :" + notices.size());
			
			//Json 변환 및 응답
			Gson gson = new Gson();
			String jsonResponse = gson.toJson(notices);
			System.out.println("공지사항json응답" + jsonResponse);

			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonResponse);

			return null; //json응답 result 불필요
		} catch (Exception e) {
			System.out.println("공지사항 오류발생!!");
			e.printStackTrace();
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"공지사항을 불러오지 못함");
			return null;
		}
		
	}

}
