package com.itask.app.dto;

public class ArticleDetailDTO {

	private int userNick;
<<<<<<< HEAD
	private int userMonitor;
	private String userMentoCert; 
=======
	private int userMoniter;
	private String userCert; 
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
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
<<<<<<< HEAD
	private int articleMonitor;

=======
	private int articleMoniter;
	
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
	public int getUserNick() {
		return userNick;
	}
	public void setUserNick(int userNick) {
		this.userNick = userNick;
	}
<<<<<<< HEAD
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

=======
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
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
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
<<<<<<< HEAD
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
	

=======
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
	
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
	
}
