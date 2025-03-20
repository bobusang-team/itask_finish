package com.itask.app.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.UserDTO;
import com.itask.app.main.dao.UserMainDAO;


public class RankingController implements Execute{

	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		Mybaits 가져오기
		UserMainDAO userDAO = new UserMainDAO();

		// 매퍼주소
		List<UserDTO> topUsers = null;
		try {
		    topUsers = userDAO.getRankingTop5();
		    System.out.println("Top Users: " + topUsers);
		} catch (Exception e) {
		    e.printStackTrace();
		    response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "명예의 전당 데이터를 불러올 수 없습니다.");
		    return null;
		}
			
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		System.out.println(topUsers + "==================================!");

		// json으로 변환하고 나서 응답
		String json = new Gson().toJson(topUsers);
		
		try {
			response.getWriter().write(json);
		} finally {
			response.getWriter().close();
		}
		return null;
		// json 때문에 리턴경로 없음
	}

}
