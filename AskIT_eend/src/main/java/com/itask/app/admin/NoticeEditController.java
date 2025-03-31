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
import com.itask.app.dto.NoticeDTO;

public class NoticeEditController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
        NoticeDTO noticeDTO = new NoticeDTO();
        Result result = new Result();
        
        HttpSession session = request.getSession();
        AdminDTO adminDTO = (AdminDTO) session.getAttribute("adminDTO");
        System.out.println("Session adminDTO: " + adminDTO); // 디버깅용

        //확인코드
        System.out.println("noticeNum: " + request.getParameter("noticeNum"));
        System.out.println("noticeCategory: " + request.getParameter("noticeCategory"));
        System.out.println("noticeTitle: " + request.getParameter("noticeTitle"));
        System.out.println("noticeText: " + request.getParameter("noticeText"));
        
        // NoticeDTO 설정
        noticeDTO.setNoticeNum(Integer.valueOf(request.getParameter("noticeNum")));
        noticeDTO.setNoticeCategory(request.getParameter("noticeCategory"));
        noticeDTO.setNoticeTitle(request.getParameter("noticeTitle"));
        noticeDTO.setNoticeText(request.getParameter("noticeText"));
        															
        															
        if (adminDTO != null) {
            noticeDTO.setAdminNum(adminDTO.getAdminNum());
        }
        adminDAO.NoticeUpdate(noticeDTO);
        
        result.setRedirect(true);
        result.setPath("./notice.ad");
        return result;
	}

}
