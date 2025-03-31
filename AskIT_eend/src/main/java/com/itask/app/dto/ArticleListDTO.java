package com.itask.app.dto;import java.util.List;public class ArticleListDTO {
//   CREATE TABLE TBL_ARTICLE (
//          ARTICLE_NUM NUMBER NOT NULL,
//          USER_NUM NUMBER NOT NULL,
//          ARTICLE_TOPCATE VARCHAR2(100) CHECK (UPPER(ARTICLE_TOPCATE) IN ('개발', '보안', '자격증')),
//          ARTICLE_BOTCATE VARCHAR2(100) CHECK (UPPER(ARTICLE_BOTCATE) IN ('질문', '꿀팁')),
//          ARTICLE_TAGNAME VARCHAR2(100) CHECK (UPPER(ARTICLE_TAGNAME) IN ('JAVA', 'HTML', 'CSS', 'JAVASCRIPT', 'ORACLE', 
//              'NETWORK', 'WEB', 'MOBILE', '포렌식', '악성코드', 
//              '정보보안', '정보처리', '네트워크관리사', '리눅스마스터', 'SQLD')),
//          ARTICLE_TITLE VARCHAR2(100) NOT NULL,
//          ARTICLE_TEXT VARCHAR2(3000) NOT NULL,
//          ARTICLE_DATE DATE NOT NULL,
//          ARTICLE_MODIFY_DATE DATE NULL,
//          ARTICLE_VIEW NUMBER DEFAULT 0 NOT NULL,
//          ARTICLE_MONITER_NUM NUMBER DEFAULT 0 NOT NULL,
//          CONSTRAINT TBL_ARTICLE_PK PRIMARY KEY (ARTICLE_NUM),
//          CONSTRAINT TBL_USER_FK FOREIGN KEY (USER_NUM) REFERENCES TBL_USER (USER_NUM) ON DELETE CASCADE
//      );

	private int articleNum;
	private int userNum;
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
	private int articleMonitorNum;
	private int userMonitor;
	private String userMentoCert;
	private String userNick; // 관리자페이지에서 필요한 DTO
	private String badge;
	private String category; // 검색결과에 필요한 DTO	private List<AttachedFileDTO> files;

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

	public int getArticleMonitorNum() {
		return articleMonitorNum;
	}

	public void setArticleMonitorNum(int articleMonitorNum) {
		this.articleMonitorNum = articleMonitorNum;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;	}	public List<AttachedFileDTO> getFiles() {		return files;	}	public void setFiles(List<AttachedFileDTO> files) {		this.files = files;	}

	@Override
	public String toString() {
		return "ArticleListDTO [articleNum=" + articleNum + ", userNum=" + userNum + ", articleTopcate="
				+ articleTopcate + ", articleBotcate=" + articleBotcate + ", articleTagname=" + articleTagname
				+ ", articleTitle=" + articleTitle + ", articleText=" + articleText + ", articleDate=" + articleDate
				+ ", articleView=" + articleView + ", articleMonitor=" + articleMonitorNum + ", userMonitor="
				+ userMonitor + ", userMentoCert=" + userMentoCert + ", userNick=" + userNick + ", badge=" + badge
				+ ", category=" + category + ", files=" + files + "]";
	}
}
