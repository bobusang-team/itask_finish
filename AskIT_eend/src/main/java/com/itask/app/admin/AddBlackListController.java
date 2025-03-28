package com.itask.app.admin;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.BlackListDTO;

public class AddBlackListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminDAO adminDAO = new AdminDAO();
		Result result = new Result();
		BlackListDTO blackListDTO = new BlackListDTO();
		System.out.println(request.getParameter("day"));
		String[] userIds = request.getParameter("userId").split(",");
		String[] userNames = request.getParameter("userNick").split(",");		
        String reason = request.getParameter("reason");
        int days = Integer.valueOf(request.getParameter("day"));
		System.out.println(userIds);
		System.out.println(userNames);
		System.out.println(reason);
		System.out.println(days);
		
		 // 현재 날짜 구하기 (YYYY-MM-DD 형식)
        LocalDate now = LocalDate.now();
        String today = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // 블랙리스트 해제 날짜 (현재 날짜 + days)
        String releaseDate = now.plusDays(days).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        // DTO에 데이터 담기
        for (int i = 0; i < userIds.length; i++) {
            blackListDTO.setBlackListId(userIds[i]);
            blackListDTO.setBlackListName(userNames[i]);
            blackListDTO.setBlackListComment(reason);
            blackListDTO.setBlackListDate(today);
            blackListDTO.setBlackListReleaseDate(releaseDate);
            
            adminDAO.addBlackList(blackListDTO);
        }
        
        result.setRedirect(true);
        result.setPath("./blackList.ad");
		return result;
	}

}
