package com.itask.app.dto;

public class ProfileDTO {
//	CREATE TABLE TBL_PROFILE(
//			PROFILE_NUM NUMBER PRIMARY KEY,
//			PROFILE_PHOTO VARCHAR2(100) NOT NULL
//		);
	
	//필드
	private int profileNum;
	private String profilePhoto;
	
	//세터, 게터
	public int getProfileNum() {
		return profileNum;
	}
	public void setProfileNum(int profileNum) {
		this.profileNum = profileNum;
	}
	public String getProfilePhoto() {
		return profilePhoto;
	}
	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}
	
	
	@Override
	public String toString() {
		return "ProfileDTO [profileNum=" + profileNum + ", profilePhoto=" + profilePhoto + "]";
	}
	
	
	
}
