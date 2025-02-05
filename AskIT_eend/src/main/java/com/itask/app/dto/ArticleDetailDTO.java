package com.itask.app.dto;

public class ArticleDetailDTO {

	private int userNick;
	private int userMoniter;
	private String userCert; 
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
	private int articleMoniter;
	
	public int getUserNick() {
		return userNick;
	}
	public void setUserNick(int userNick) {
		this.userNick = userNick;
	}
	public int getUserMoniter() {
		return userMoniter;
	}
	public void setUserMoniter(int userMoniter) {
		this.userMoniter = userMoniter;
	}
	public String getUserCert() {
		return userCert;
	}
	public void setUserCert(String userCert) {
		this.userCert = userCert;
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
	public int getArticleMoniter() {
		return articleMoniter;
	}
	public void setArticleMoniter(int articleMoniter) {
		this.articleMoniter = articleMoniter;
	}
	@Override
	public String toString() {
		return "ArticleDetailDTO [userNick=" + userNick + ", userMoniter=" + userMoniter + ", userCert=" + userCert
				+ ", articleNum=" + articleNum + ", articleTopcate=" + articleTopcate + ", articleBotcate="
				+ articleBotcate + ", articleTagname=" + articleTagname + ", articleTitle=" + articleTitle
				+ ", articleText=" + articleText + ", articleDate=" + articleDate + ", articleView=" + articleView
				+ ", articleMoniter=" + articleMoniter + "]";
	}
	
	
}
