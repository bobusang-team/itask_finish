package com.itask.app.dto;

public class CommentListDTO {
	private int commentNum;
	private int userNum;
	private int articleNum;
	private int commentMonitorNum;
	private String commentText;
	private String commentDate;
	private String commentModifyDate;
	private String userNick;
	
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
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}
	
	@Override
	public String toString() {
		return "CommentListDTO [commentNum=" + commentNum + ", userNum=" + userNum + ", articleNum=" + articleNum
				+ ", commentMonitorNum=" + commentMonitorNum + ", commentText=" + commentText + ", commentDate="
				+ commentDate + ", commentModifyDate=" + commentModifyDate + ", userNick=" + userNick + "]";
	}
	
	
}
