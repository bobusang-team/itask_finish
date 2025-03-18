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
<<<<<<< HEAD
//		    ARTICLE_TITLE VARCHAR2(1000) NOT NULL,
=======
//		    ARTICLE_TITLE VARCHAR2(100) NOT NULL,
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
//		    ARTICLE_TEXT VARCHAR2(3000) NOT NULL,
//		    ARTICLE_DATE DATE NOT NULL,
//		    ARTICLE_MODIFY_DATE DATE NULL,
//		    ARTICLE_VIEW NUMBER DEFAULT 0 NOT NULL,
<<<<<<< HEAD
//		    ARTICLE_MONITOR_NUM NUMBER DEFAULT 0 NOT NULL,
=======
//		    ARTICLE_MONITER_NUM NUMBER DEFAULT 0 NOT NULL,
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
//		    CONSTRAINT TBL_ARTICLE_PK PRIMARY KEY (ARTICLE_NUM),
//		    CONSTRAINT TBL_USER_FK FOREIGN KEY (USER_NUM) REFERENCES TBL_USER (USER_NUM) ON DELETE CASCADE
//		);
	
<<<<<<< HEAD
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
=======
	private int userNum;
	private int articleNum;
	private String articleTopcate;
	private String articleBotcate;
	private String articleTagname;
	private String articleTitle;
	private String articleText;
	private String articledate;
	private String articleModifyDate;
	private int articleView;
	private int articleMoniter;
	private String userNick; //관리자페이지에서 필요한 DTO
	private String grade;
	private String userMoniter;
	
	
	
	
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
<<<<<<< HEAD
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
=======
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
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
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
<<<<<<< HEAD
	public String getArticleDate() {
		return articleDate;
	}
	public void setArticleDate(String articleDate) {
		this.articleDate = articleDate;
=======
	public String getArticledate() {
		return articledate;
	}
	public void setArticledate(String articledate) {
		this.articledate = articledate;
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
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
<<<<<<< HEAD
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
	
	
	
=======
	public int getArticleMoniter() {
		return articleMoniter;
	}
	public void setArticleMoniter(int articleMoniter) {
		this.articleMoniter = articleMoniter;
	}
		
	public String getUserMoniter() {
		return userMoniter;
	}
	public void setUserMoniter(String userMoniter) {
		this.userMoniter = userMoniter;
	}
	
	public String getFormattedMoniter() {
	    if (userMoniter == null || userMoniter.isEmpty()) {
	        return "0inch 0m";
	    }

	    try {
	        int monitorValue = Integer.parseInt(userMoniter); 
	        int inch = monitorValue / 100; 
	        return inch + "inch ";
	    } catch (NumberFormatException e) {
	        return "Invalid format";
	    }
	}

	
	@Override
	public String toString() {
		return "ArticleDTO [userNum=" + userNum + ", articleNum=" + articleNum + ", articleTopcate="
				+ articleTopcate + ", articleBotcate=" + articleBotcate + ", articleTagname=" + articleTagname
				+ ", articleTitle=" + articleTitle + ", articleText=" + articleText + ", articledate=" + articledate
				+ ", articleModifyDate=" + articleModifyDate + ", articleView=" + articleView + ", articleMoniter="
				+ articleMoniter + "]";
	}

>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
}
