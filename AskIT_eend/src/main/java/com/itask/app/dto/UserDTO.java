package com.itask.app.dto;

import java.sql.Timestamp;

public class UserDTO {
//	CREATE TABLE TBL_USER (
//		    USER_NUM NUMBER,
//		    PROFILE_NUM NUMBER DEFAULT '1' NOT NULL,
//		    USER_ID VARCHAR2(15) NOT NULL,
//		    USER_NAME VARCHAR2(100) NOT NULL,
//		    USER_NICK VARCHAR2(100) NOT NULL,
//		    USER_PW VARCHAR2(20) NOT NULL,
//		    USER_PHONE VARCHAR2(11) NOT NULL,
//		    USER_MAIL VARCHAR2(100) NOT NULL,
//		    USER_MENTO_CERT CHAR(1) DEFAULT 'F' CHECK (USER_MENTO_CERT IN ('T', 'F')),
//		    USER_MONITOR NUMBER DEFAULT '0' NOT NULL,
//		    USER_AGREE CHAR(1) DEFAULT 'F' CHECK (USER_AGREE IN ('T', 'F')),
//		    USER_CAREER VARCHAR2(3000),
//		    USER_JOIN_DATE DATE NOT NULL,
//		    CONSTRAINT PK_USER_NUM PRIMARY KEY (USER_NUM),
//		    CONSTRAINT FK_PROFILE_NUM FOREIGN KEY (PROFILE_NUM) REFERENCES TBL_PROFILE (PROFILE_NUM) ON DELETE CASCADE
//		);
	
	// 필드
	private int userNum;
	private int profileNum = 1;
	private String userId;
	private String userName;
	private String userNick;
	private String userPw;
	private String userPhone;
	private String userMail;
	private char userMentoCert = 'F';
	private int userMonitor = 0;
	private char userAgree = 'F';
	private String userCareer;
	private Timestamp userJoinDate;
	
	
	//세터,게터
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public int getProfileNum() {
		return profileNum;
	}
	public void setProfileNum(int profileNum) {
		this.profileNum = profileNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public char getUserMentoCert() {
		return userMentoCert;
	}
	public void setUserMentoCert(char userMentoCert) {
		this.userMentoCert = userMentoCert;
	}
	public int getUserMonitor() {
		return userMonitor;
	}
	public void setUserMonitor(int userMonitor) {
		this.userMonitor = userMonitor;
	}
	public char getUserAgree() {
		return userAgree;
	}
	public void setUserAgree(char userAgree) {
		this.userAgree = userAgree;
	}
	public String getUserCareer() {
		return userCareer;
	}
	public void setUserCareer(String userCareer) {
		this.userCareer = userCareer;
	}
	public Timestamp getUserJoinDate() {
		return userJoinDate;
	}
	public void setUserJoinDate(Timestamp userJoinDate) {
		this.userJoinDate = userJoinDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO [userNum=" + userNum + ", profileNum=" + profileNum + ", userId=" + userId + ", userName="
				+ userName + ", userNick=" + userNick + ", userPw=" + userPw + ", userPhone=" + userPhone
				+ ", userMail=" + userMail + ", userMentoCert=" + userMentoCert + ", userMonitor=" + userMonitor
				+ ", userAgree=" + userAgree + ", userCareer=" + userCareer + ", userJoinDate=" + userJoinDate + "]";
	}
	
	
	
	
	

}
