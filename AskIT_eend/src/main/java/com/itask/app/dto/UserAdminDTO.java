package com.itask.app.dto;

public class UserAdminDTO {
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
		private String userJoinDate;
		private String grade;
		private String badge;
		
		
		
		public String getBadge() {
			return badge;
		}
		public void setBadge(String badge) {
			this.badge = badge;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
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
		public String getUserJoinDate() {
			return userJoinDate;
		}
		public void setUserJoinDate(String userJoinDate) {
			this.userJoinDate = userJoinDate;
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
			return "UserAdminDTO [userNum=" + userNum + ", profileNum=" + profileNum + ", userId=" + userId
					+ ", userName=" + userName + ", userNick=" + userNick + ", userPw=" + userPw + ", userPhone="
					+ userPhone + ", userMail=" + userMail + ", userMentoCert=" + userMentoCert + ", userMonitor="
					+ userMonitor + ", userAgree=" + userAgree + ", userCareer=" + userCareer + ", userJoinDate="
					+ userJoinDate + "]";
		}
}

