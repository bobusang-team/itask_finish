package com.itask.app.member;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.member.dao.UserDAO;

public class CheckMailDuplicateController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UserDAO userDAO = new UserDAO();
		Gson gson = new Gson();
		
//		isMail 얘 유저 다오에 존재함
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		String mail = jsonObject.get("mail").getAsString();
		
		boolean exists = userDAO.isMail(mail);
		
		JsonObject responseJson = new JsonObject();
		responseJson.addProperty("exists", exists);
		//프로퍼티 추가를 안해줘서 exist 값을 잘못받아와서 중복되어서 사용가능하다고
		//떴던거임
		
		response.setContentType("application/json");
		response.getWriter().write(gson.toJson(responseJson));
		
		
		
		return null;
	}

}
