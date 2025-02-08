package com.itask.app.dto;

public class ArticleListDTO {
//   CREATE TABLE TBL_ARTICLE (
//          ARTICLE_NUM NUMBER NOT NULL,
//          USER_NUM NUMBER NOT NULL,
//          ARTICLE_TOPCATE VARCHAR2(100) CHECK (UPPER(ARTICLE_TOPCATE) IN ('개발', '보안', '자격증')),
//          ARTICLE_BOTCATE VARCHAR2(100) CHECK (UPPER(ARTICLE_BOTCATE) IN ('질문', '꿀팁')),
//          ARTICLE_TAGNAME VARCHAR2(100) CHECK (UPPER(ARTICLE_TAGNAME) IN ('JAVA', 'HTML', 'CSS', 'JAVASCRIPT', 'ORACLE', 
//              'NETWORK', 'WEB',터
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
   public int getArticleMonitor() {
      return articleMonitorNum;
   }
   public void setArticleMonitor(int articleMonitorNum) {
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
   
   @Override
   public String toString() {
      return "ArticleListDTO [articleNum=" + articleNum + ", userNum=" + userNum + ", articleTopcate="
            + articleTopcate + ", articleBotcate=" + articleBotcate + ", articleTagname=" + articleTagname
            + ", articleTitle=" + articleTitle + ", articleText=" + articleText + ", articleDate=" + articleDate
            + ", articleView=" + articleView + ", articleMonitor=" + articleMonitorNum + ", userMonitor=" + userMonitor
            + ", userMentoCert=" + userMentoCert + ", userNick=" + userNick + ", badge=" + badge + "]";
   }
}
