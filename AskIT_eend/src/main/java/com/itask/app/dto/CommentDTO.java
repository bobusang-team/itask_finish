package com.itask.app.dto;

public class CommentDTO {
//	CREATE TABLE TBL_COMMENT (
//		    COMMENT_NUM NUMBER PRIMARY KEY,          
//		    USER_NUM NUMBER NOT NULL,              
//		    ARTICLE_NUM NUMBER NOT NULL,          
//		    COMMENT_MONITOR_NUM NUMBER DEFAULT 0,    
//		    COMMENT_TEXT VARCHAR2(1000) NOT NULL,    
//		    COMMENT_MODIFY CHAR(1) CHECK (COMMENT_MODIFY IN ('T', 'F')), 
//		    COMMENT_DELETE CHAR(1) CHECK (COMMENT_DELETE IN ('T', 'F')), 
//		    COMMENT_DATE DATE NOT NULL,             
//		    COMMENT_MODIFY_DATE DATE,               
//		    CONSTRAINT FK_USER_NUM FOREIGN KEY (USER_NUM) REFERENCES TBL_USER(USER_NUM),
//		    CONSTRAINT FK_ARTICLE_NUM FOREIGN KEY (ARTICLE_NUM) REFERENCES TBL_ARTICLE(ARTICLE_NUM) ON DELETE CASCADE
//		);
	private int commentNum;
	private int userNum;
	private int articleNum;
	private int commentMonitorNum;
	private String commentText;
	private boolean commentModify;
	private boolean commentDelete;
	private String commentDate;
	private String commentModifyDate;
	private String userMoniter; //관리자페이지에서 필요함
	private String commentResultdate;
	private String userNick;
	
	
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
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
	public boolean isCommentModify() {
		return commentModify;
	}
	public void setCommentModify(boolean commentModify) {
		this.commentModify = commentModify;
	}
	public boolean isCommentDelete() {
		return commentDelete;
	}
	public void setCommentDelete(boolean commentDelete) {
		this.commentDelete = commentDelete;
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
	
	public String getUserMoniter() {
		return userMoniter;
	}
	public void setUserMoniter(String userMoniter) {
		this.userMoniter = userMoniter;
	}
	
	public String getCommentResultdate() {
		return commentResultdate;
	}
	public void setCommentResultdate(String commentResultdate) {
		this.commentResultdate = commentResultdate;
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
		return "CommentDTO [commentNum=" + commentNum + ", userNum=" + userNum + ", articleNum=" + articleNum
				+ ", commentMonitorNum=" + commentMonitorNum + ", commentText=" + commentText + ", commentModify="
				+ commentModify + ", commentDelete=" + commentDelete + ", commentDate=" + commentDate
				+ ", commentModifyDate=" + commentModifyDate + "]";
	}
	
	
	
}
