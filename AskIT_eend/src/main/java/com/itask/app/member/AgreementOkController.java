package com.itask.app.member;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.itask.app.Execute;
import com.itask.app.Result;

public class AgreementOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("선택약관 동의 섭컨 ");
		
		
		BufferedReader reader = request.getReader(); 
		String line = reader.readLine(); 
		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		String userAgree = jsonObject.get("check").getAsString();
		System.out.println("agreement status : " + userAgree);
		
		HttpSession session = request.getSession();
		session.setAttribute("agreeOption", userAgree);
		
		return null;
	}

}
