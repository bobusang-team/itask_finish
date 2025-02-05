package com.itask.app.dto;

public class ArticleDTO {
//	CREATE TABLE TBL_ARTICLE (
//		    ARTICLE_NUM NUMBER NOT NULL,
//		    USER_NUM NUMBER NOT NULL,
//		    ARTICLE_TOPCATE VARCHAR2(100) CHECK (UPPER(ARTICLE_TOPCATE) IN ('개발', '보안', '자격증')),
//		    ARTICLE_BOTCATE VARCHAR2(100) CHECK (UPPER(ARTICLE_BOTCATE) IN ('질문', '꿀팁')),
//		    ARTICLE_TAGNAME VARCHAR2(100) CHECK (UPPER(ARTICLE_TAGNAME) IN ('JAVA', 'HTML', 'CSS', 'JAVASCRIPT', 'ORACLE', 
//		        'NETWORK', 'WEB', 'MOBILE', '포렌식', '악성코드', 
//		        '정보보안', '정보처리', '네트워크관리사', '리눅스마스터', 'SQLD')),
//		    ARTICLE_TITLE VARCHAR2(1000) NOT NULL,
//		    ARTICLE_TEXT VARCHAR2(3000) NOT NULL,
//		    ARTICLE_DATE DATE NOT NULL,
//		    ARTICLE_MODIFY_DATE DATE NULL,
//		    ARTICLE_VIEW NUMBER DEFAULT 0 NOT NULL,
//		    ARTICLE_MONITOR_NUM NUMBER DEFAULT 0 NOT NULL,
//		    CONSTRAINT TBL_ARTICLE_PK PRIMARY KEY (ARTICLE_NUM),
//		    CONSTRAINT TBL_USER_FK FOREIGN KEY (USER_NUM) REFERENCES TBL_USER (USER_NUM) ON DELETE CASCADE
//		);
	
	//필드
	private int articleNum;
	private int userNum;
	private String articleTopCate;
	private String articleBotCate;
	private String articleTagName;
	private String articleTitle;
	private String articleText;
	private String articleDate;
	private String articleModifyDate;
	private int articleView = 0;
	private int articleMonitorNum = 0;
	
	//세터,게터
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
	public String getArticleModifyDate() {
		return articleModifyDate;
	}
	public void setArticleModifyDate(String articleModifyDate) {
		this.articleModifyDate = articleModifyDate;
	}
	public int getArticleView() {
		return articleView;
	}
	public void setArticleView(int articleView) {
		this.articleView = articleView;
	}
	public int getArticleMonitorNum() {
		return articleMonitorNum;
	}
	public void setArticleMonitorNum(int articleMonitorNum) {
		this.articleMonitorNum = articleMonitorNum;
	}
	
	@Override
	public String toString() {
		return "ArticleDTO [articleNum=" + articleNum + ", userNum=" + userNum + ", articleTopCate=" + articleTopCate
				+ ", articleBotCate=" + articleBotCate + ", articleTagName=" + articleTagName + ", articleTitle="
				+ articleTitle + ", articleText=" + articleText + ", articleDate=" + articleDate
				+ ", articleModifyDate=" + articleModifyDate + ", articleView=" + articleView + ", articleMonitorNum="
				+ articleMonitorNum + "]";
	}
	
	
	
}
