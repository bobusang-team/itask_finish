package com.itask.app.member;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SMSService {
	private static final String API_KEY = "NCSOGCLXY5PABBSK";
	private static final String API_SECRET = "ACBS4G9TEMOQXTVUYOUAHCC13TWMI4PW";
	private static final String FROM_NUMBER = "01022216710";
	
	public String sendVerificationSms(String to) throws CoolsmsException{
		Message coolsms = new Message(API_KEY, API_SECRET);
		String verificationCode = generateVerificationCode();
		HashMap<String, String>params = new HashMap<>();
		params.put("to", to);
		params.put("from", FROM_NUMBER);
		params.put("type", "SMS");
		params.put("text", "인증번호는 ["+verificationCode+"] 입니다.");
		
		JSONObject obj = (JSONObject) coolsms.send(params); 
		System.out.print("인증번호 전송 완료 :");
		System.out.println(obj.toString());
		
		return verificationCode;
	}
	
	private String generateVerificationCode() {
		Random random = new Random();
		StringBuilder code = new StringBuilder();
		for(int i=0; i<6; i++) {
			code.append(random.nextInt(10));
		}
		return code.toString();
	}
}
