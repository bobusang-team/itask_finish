package com.itask.app.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.AdminDTO;




public class AdminLoginOkController implements Execute{
	
	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AdminDAO adminDAO = new AdminDAO();
		System.out.println("execute");
		AdminDTO adminDTO = new AdminDTO();
		Result result = new Result();
		
		String adminId = request.getParameter("adminId");
		String adminPw = request.getParameter("adminPw");
		System.out.println("execute1");
		adminDTO = adminDAO.AdminLogin(adminId, adminPw);
		System.out.println("execute2");
		
		if(adminDTO != null) {
			HttpSession session = request.getSession();
			session.setAttribute("adminDTO", adminDTO);
			System.out.println(adminDTO.getAdminNick());
			result.setPath(request.getContextPath() + "/admin/basic/totalMember.ad");
			result.setRedirect(true);
		}
		else {
			result.setPath(request.getContextPath() + "/app/admin/adminLogin.jsp");
			result.setRedirect(true);
		}
		
		
		return result;
	}

}
