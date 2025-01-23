package com.itask.app.dto;

public class MypageMainDTO {
	// 필드
	private int userNum;
	private String userNick;
	private String userMoniter = "0";
	private String userCareer = "";
	private int articleCount;
	private int commentCount;
	private int badgeCount;
	
	//세터게터
	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public String getUserMoniter() {
		return userMoniter;
	}

	public void setUserMoniter(String userMoniter) {
		this.userMoniter = userMoniter;
	}

	public String getUserCareer() {
		return userCareer;
	}

	public void setUserCareer(String userCareer) {
		this.userCareer = userCareer;
	}

	public int getArticleCount() {
		return articleCount;
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getBadgeCount() {
		return badgeCount;
	}

	public void setBadgeCount(int badgeCount) {
		this.badgeCount = badgeCount;
	}

	@Override
	public String toString() {
		return "MypageMainDTO [userNum=" + userNum + ", userNick=" + userNick + ", userMoniter=" + userMoniter
				+ ", userCareer=" + userCareer + ", articleCount=" + articleCount + ", commentCount=" + commentCount
				+ ", badgeCount=" + badgeCount + "]";
	}

}
