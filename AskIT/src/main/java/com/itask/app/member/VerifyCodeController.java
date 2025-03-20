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

public class VerifyCodeController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader(); //getReader() HTTP 요청 본문을 읽을 수 있는 BufferedReader반환
		 String line = reader.readLine(); // JSON 데이터의 첫번째 줄을 읽음
		 JsonElement jsonElement = JsonParser.parseString(line); //문자열 형태의 JSON을 JsonElement로 변환 
		 JsonObject jsonObject = jsonElement.getAsJsonObject(); // JsonObject 형태로 변환하여 key-value 값을 쉽게 추출하도록 
		 String userCode = jsonObject.get("code").getAsString(); //code 필드 값을 string으로 가져
		 System.out.println("code" + userCode); //최종적으로 userCode에는 클라이언트가 보낸 인증번호가 저장됨 
		 HttpSession session = request.getSession();
		  
		  //세션에 저장된 인증번호
		 String sessionCode = (String) session.getAttribute("verificationCode");
		 System.out.println("sessionCode" + sessionCode);
		  
		 //인증번호 일치 여부 검사
		 if(sessionCode != null && sessionCode.equals(userCode)) {
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write("{\"success\" : " + true + "}");
		    System.out.println("인증 성공");
		 }else {
		    response.setContentType("text/plain");
		    response.setCharacterEncoding("UTF-8");
		    response.getWriter().write("{\"success\" : " + false + " } ");
		    System.out.println("인증 실패");
		 }
		 return null;
	}
	
}
