package com.itask.app.dto;

public class MyTotalCommentDTO {
	private int articleNum;
	private int userNum;
	private String userNick;
	private String badge;
	private String userMentoCert = "F";
	private String articleTopCate;
	private String articleBotCate;
	private String articleTagName;
	private String articleTitle;
	private int commentNum;
	private int commentMonitorNum;
	private String commentText;
	private String commentDate;
	private String commentModifyDate;
	
	
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
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
	public String getBadge() {
		return badge;
	}
	public void setBadge(String badge) {
		this.badge = badge;
	}
	public String getUserMentoCert() {
		return userMentoCert;
	}
	public void setUserMentoCert(String userMentoCert) {
		this.userMentoCert = userMentoCert;
	}
	public String getArticleTopCate() {
		return articleTopCate;
	}
	public void setArticleTopCate(String articleTopCate) {
		this.articleTopCate = articleTopCate;
	}
	public String getArticleBotCate() {
		return articleBotCate;
	}
	public void setArticleBotCate(String articleBotCate) {
		this.articleBotCate = articleBotCate;
	}
	public String getArticleTagName() {
		return articleTagName;
	}
	public void setArticleTagName(String articleTagName) {
		this.articleTagName = articleTagName;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getCommentMonitorNum() {
		return commentMonitorNum;
	}
	public void setCommentMonitorNum(int commentMonitorNum) {
		this.commentMonitorNum = commentMonitorNum;
	}
	public String getCommentText() {
		return commentText;
	}
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentModifyDate() {
		return commentModifyDate;
	}
	public void setCommentModifyDate(String commentModifyDate) {
		this.commentModifyDate = commentModifyDate;
	}
	
	
	@Override
	public String toString() {
		return "MyTotalCommentDTO [articleNum=" + articleNum + ", userNum=" + userNum + ", userNick=" + userNick
				+ ", badge=" + badge + ", userMentoCert=" + userMentoCert + ", articleTopCate=" + articleTopCate
				+ ", articleBotCate=" + articleBotCate + ", articleTagName=" + articleTagName + ", articleTitle="
				+ articleTitle + ", commentNum=" + commentNum + ", commentMonitorNum=" + commentMonitorNum
				+ ", commentText=" + commentText + ", commentDate=" + commentDate + ", commentModifyDate="
				+ commentModifyDate + "]";
	}
	
	
	

}
