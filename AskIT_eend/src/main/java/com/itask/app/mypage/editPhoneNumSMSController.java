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

import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class editPhoneNumSMSController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();
		String line = reader.readLine();
		JsonElement jsonElement = JsonParser.parseString(line);
		JsonObject jsonObject = jsonElement.getAsJsonObject();
		String phoneNumber = jsonObject.get("phoneNumber").getAsString(); // editPhoneNum.js에서 있는 phoneNumber 객체 가져오기
		
		SmsService smsService = new SmsService(); // 만들어야함
		
		try {
			//SMS전송, 인증코드 생성
			String checkNumberCode = smsService.sendVerificationSms(phoneNumber);
			
			//세션에 인증코드 저장
			HttpSession session = request.getSession();
			session.setAttribute("checkNumberCode", checkNumberCode);
		
		} catch (CoolsmsException e) {
			e.printStackTrace();
		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
}
