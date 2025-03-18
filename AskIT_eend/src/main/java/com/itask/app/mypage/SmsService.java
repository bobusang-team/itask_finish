package com.itask.app.mypage;

import java.util.HashMap;
import java.util.Random;

import org.json.simple.JSONObject;

import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

public class SmsService {
	// coolsms 내용 전달
	//내 정보
//	private static final String API_KEY = "NCSJYTHWTKKOETDK";
//	private static final String API_SECRET = "J7PO2LCWKHZTAQ3SYC6L5MH9PTC6SUTQ";
//	private static final String FROM_NUMBER = "01083507172";
	//강사님 정보
    private static final String API_KEY = "NCSPNNVBVPVPRTVX";
	private static final String API_SECRET = "LSISNFQLHSZJU90NCZRQ2VA7HBK7ASZN";
	private static final String FROM_NUMBER = "01075812581";
	
	public String sendVerificationSms(String to) throws CoolsmsException {
		System.out.println("smsService ====================" + to);
		Message coolsms = new Message(API_KEY, API_SECRET);
		String checkNumberCode = generateVerificationCode();
		
		HashMap<String, String> params = new HashMap<>();
		params.put("to", to);
		params.put("from", FROM_NUMBER);
		params.put("type", "SMS");
		params.put("text", "인증번호는 [" + checkNumberCode + "] 입니다.");
		
		JSONObject obj = (JSONObject) coolsms.send(params);
		System.out.println("문자발송완료");
		System.out.println(obj.toString());
		return checkNumberCode;	
	
	}
	
	// 이 클래스에서만 사용할 인증번호 생성 함수
		private String generateVerificationCode() {
			Random random = new Random();
			StringBuilder code = new StringBuilder();
			for (int i = 0; i < 6; i++) {
				code.append(random.nextInt(10));
			}
			return code.toString();
		}
}
