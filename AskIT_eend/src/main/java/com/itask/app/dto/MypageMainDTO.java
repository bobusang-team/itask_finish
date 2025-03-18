package com.itask.app.dto;

public class MypageMainDTO {
	// 필드
	private int userNum;
	private int profileNum;
	private String userNick;
	private int userMonitor = 0;
	private String userMentoCert = "F";
	private String userCareer = "";
	private int articleCount;
	private int commentCount;
	private String certsIPE;
	private String certsIPIE;
	private String certsIPT;
	private String certsISE;
	private String certsISIE;
	private String certsNetManager1;
	private String certsNetManager2;
	private String certsSqld;
	private String certsLinuxMaster1;
	private String certsLinuxMaster2;

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

	public String getUserNick() {
		return userNick;
	}

	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}

	public int getUserMonitor() {
		return userMonitor;
	}

	public void setUserMonitor(int userMonitor) {
		this.userMonitor = userMonitor;
	}

	public String getUserMentoCert() {
		return userMentoCert;
	}

	public void setUserMentoCert(String userMentoCert) {
		this.userMentoCert = userMentoCert;
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

	public String getCertsIPE() {
		return certsIPE;
	}

	public void setCertsIPE(String certsIPE) {
		this.certsIPE = certsIPE;
	}

	public String getCertsIPIE() {
		return certsIPIE;
	}

	public void setCertsIPIE(String certsIPIE) {
		this.certsIPIE = certsIPIE;
	}

	public String getCertsIPT() {
		return certsIPT;
	}

	public void setCertsIPT(String certsIPT) {
		this.certsIPT = certsIPT;
	}

	public String getCertsISE() {
		return certsISE;
	}

	public void setCertsISE(String certsISE) {
		this.certsISE = certsISE;
	}

	public String getCertsISIE() {
		return certsISIE;
	}

	public void setCertsISIE(String certsISIE) {
		this.certsISIE = certsISIE;
	}

	public String getCertsNetManager1() {
		return certsNetManager1;
	}

	public void setCertsNetManager1(String certsNetManager1) {
		this.certsNetManager1 = certsNetManager1;
	}

	public String getCertsNetManager2() {
		return certsNetManager2;
	}

	public void setCertsNetManager2(String certsNetManager2) {
		this.certsNetManager2 = certsNetManager2;
	}

	public String getCertsSqld() {
		return certsSqld;
	}

	public void setCertsSqld(String certsSqld) {
		this.certsSqld = certsSqld;
	}

	public String getCertsLinuxMaster1() {
		return certsLinuxMaster1;
	}

	public void setCertsLinuxMaster1(String certsLinuxMaster1) {
		this.certsLinuxMaster1 = certsLinuxMaster1;
	}

	public String getCertsLinuxMaster2() {
		return certsLinuxMaster2;
	}

	public void setCertsLinuxMaster2(String certsLinuxMaster2) {
		this.certsLinuxMaster2 = certsLinuxMaster2;
	}

	public String getFormattedMonitor() {

		if (userMonitor == 0) {
			return "0inch 0m";
		}
		try {
			int inch = userMonitor / 100;
			int monitor = userMonitor % 100;
			return inch + "inch " + monitor + "m";
		} catch (NumberFormatException e) {
			return "Invalid format";
		}
	}

	@Override
	public String toString() {
		return "MypageMainDTO [userNum=" + userNum + ", profileNum=" + profileNum + ", userNick=" + userNick
				+ ", userMonitor=" + userMonitor + ", userMentoCert=" + userMentoCert + ", userCareer=" + userCareer
				+ ", articleCount=" + articleCount + ", commentCount=" + commentCount + ", certsIPE=" + certsIPE
				+ ", certsIPIE=" + certsIPIE + ", certsIPT=" + certsIPT + ", certsISE=" + certsISE + ", certsISIE="
				+ certsISIE + ", certsNetManager1=" + certsNetManager1 + ", certsNetManager2=" + certsNetManager2
				+ ", certsSqld=" + certsSqld + ", certsLinuxMaster1=" + certsLinuxMaster1 + ", certsLinuxMaster2="
				+ certsLinuxMaster2 + "]";
	}

	// T의 수를 세는 메서드
	public int getBadgeCount() {
		int count = 0;
		if ("T".equals(userMentoCert))
			count++;
		if ("T".equals(certsIPE))
			count++;
		if ("T".equals(certsIPIE))
			count++;
		if ("T".equals(certsIPT))
			count++;
		if ("T".equals(certsISE))
			count++;
		if ("T".equals(certsISIE))
			count++;
		if ("T".equals(certsNetManager1))
			count++;
		if ("T".equals(certsNetManager2))
			count++;
		if ("T".equals(certsSqld))
			count++;
		if ("T".equals(certsLinuxMaster1))
			count++;
		if ("T".equals(certsLinuxMaster2))
			count++;
		return count;
	}

}
