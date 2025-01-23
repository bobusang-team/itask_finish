package com.itask.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.UserDTO;

public class TotalMemberController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("TotalMemberController 실행됨");
		AdminDAO adminDAO = new AdminDAO();
		// 전체 회원 목록 가져오기
		List<UserDTO> users = adminDAO.TotalMember();
		for (UserDTO user : users) {
			System.out.println("회원 데이터: " + user);
		}
		// 회원 목록을 request 객체에 담아 JSP로 전달
		request.setAttribute("users", users);

		// 결과 페이지 설정
		Result result = new Result();
		System.out.println(result);
		result.setPath("/app/admin/basic/totalMember.jsp");
		return result;
	}

}
