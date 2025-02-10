package com.itask.app.mypage;

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

public class VerifyCodeController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// json형태로 요청이 들어오므로 parsing시켜야함
		BufferedReader reader = request.getReader();
		String line = reader.readLine();

		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		String userCode = jsonObject.get("code").getAsString();

		System.out.println("code" + userCode); // 확인용

		HttpSession session = request.getSession();
		// 세션에 저장된 인증번호
		String sessionCode = (String) session.getAttribute("checkNumberCode");
		System.out.println("sessionCode" + sessionCode);

		// 인증번호 일치 여부 검사
		if (sessionCode != null && sessionCode.equals(userCode)) {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"success\" : " + true + "}");
			System.out.println("인증 실패");
		} else {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("{\"success\" : " + false + "}");
			System.out.println("인증 실패");
		}

		return null; //페이지 이동이 없으므로 null
	}

}
