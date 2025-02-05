package com.itask.app.dto;

public class ArticleDetailDTO {

	private int userNick;
	private int userMonitor;
	private String userMentoCert; 
	private int articleNum;
	private String articleTopcate;
	private String articleBotcate;
	private String articleTagname;
	private String articleTitle;
	private String articleText;
	private String articleDate;
	/*
	 * private String articleModifyDate;
	 */	
	private int articleView;
	private int articleMonitor;
	public int getUserNick() {
		return userNick;
	}
	public void setUserNick(int userNick) {
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
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public String getArticleTopcate() {
		return articleTopcate;
	}
	public void setArticleTopcate(String articleTopcate) {
		this.articleTopcate = articleTopcate;
	}
	public String getArticleBotcate() {
		return articleBotcate;
	}
	public void setArticleBotcate(String articleBotcate) {
		this.articleBotcate = articleBotcate;
	}
	public String getArticleTagname() {
		return articleTagname;
	}
	public void setArticleTagname(String articleTagname) {
		this.articleTagname = articleTagname;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleText() {
		return articleText;
	}
	public void setArticleText(String articleText) {
		this.articleText = articleText;
	}
	public String getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
	}
	public int getArticleView() {
		return articleView;
	}
	public void setArticleView(int articleView) {
		this.articleView = articleView;
	}
	public int getArticleMonitor() {
		return articleMonitor;
	}
	public void setArticleMonitor(int articleMonitor) {
		this.articleMonitor = articleMonitor;
	}
	@Override
	public String toString() {
		return "ArticleDetailDTO [userNick=" + userNick + ", userMonitor=" + userMonitor + ", userMentoCert="
				+ userMentoCert + ", articleNum=" + articleNum + ", articleTopcate=" + articleTopcate
				+ ", articleBotcate=" + articleBotcate + ", articleTagname=" + articleTagname + ", articleTitle="
				+ articleTitle + ", articleText=" + articleText + ", articleDate=" + articleDate + ", articleView="
				+ articleView + ", articleMonitor=" + articleMonitor + "]";
	}
	

	
	
}
