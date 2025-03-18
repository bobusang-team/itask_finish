package com.itask.app.dto;

public class CommentDTO {
//   CREATE TABLE TBL_COMMENT (
//          COMMENT_NUM NUMBER NOT NULL,          
//          USER_NUM NUMBER NOT NULL,              
//          ARTICLE_NUM NUMBER NOT NULL,          
//          COMMENT_MONITOR_NUM NUMBER DEFAULT 0,    
//          COMMENT_TEXT VARCHAR2(1000) NOT NULL,    
//          COMMENT_DATE DATE NOT NULL,   
//          COMMENT_MODIFY_DATE DATE,            
//          CONSTRAINT PK_COMMENT_NUM PRIMARY KEY (COMMENT_NUM),
//          CONSTRAINT FK_USER_NUM FOREIGN KEY (USER_NUM) REFERENCES TBL_USER(USER_NUM) ON DELETE CASCADE,
//          CONSTRAINT FK_ARTICLE_NUM FOREIGN KEY (ARTICLE_NUM) REFERENCES TBL_ARTICLE(ARTICLE_NUM) ON DELETE CASCADE
//      );
   private int commentNum;
   private int userNum;
   private int articleNum;
   private int commentMonitorNum;
   private String commentText;
   private String commentDate;
   private String commentModifyDate;
   
   public int getCommentNum() {
      return commentNum;
   }
   public void setCommentNum(int commentNum) {
      this.commentNum = commentNum;
   }
   public int getUserNum() {
      return userNum;
   }
   public void setUserNum(int userNum) {
      this.userNum = userNum;
   }
   public int getArticleNum() {
      return articleNum;
   }
   public void setArticleNum(int articleNum) {
      this.articleNum = articleNum;
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
      return "CommentDTO [commentNum=" + commentNum + ", userNum=" + userNum + ", articleNum=" + articleNum
            + ", commentMonitorNum=" + commentMonitorNum + ", commentText=" + commentText + ", commentDate="
            + commentDate + ", commentModifyDate=" + commentModifyDate + "]";
   }

   
   
}
