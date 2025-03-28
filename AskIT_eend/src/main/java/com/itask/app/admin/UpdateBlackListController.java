package com.itask.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;

public class UpdateBlackListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] blackListIds = request.getParameterValues("blackListIds");
		System.out.println(blackListIds);
        int period = Integer.parseInt(request.getParameter("blacklistPeriod"));
        System.out.println(period);

        Map<String, Object> updateMap = new HashMap<>();
        updateMap.put("blackListIds", blackListIds);
        updateMap.put("period", period);
        AdminDAO adminDAO = new AdminDAO();
        adminDAO.UpdateBlackList(updateMap);
        
        Result result = new Result();
        result.setRedirect(true);
		result.setPath("./blackList.ad");
		return result;
	}

}
