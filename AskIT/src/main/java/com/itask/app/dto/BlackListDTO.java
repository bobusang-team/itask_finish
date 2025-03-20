package com.itask.app.dto;

public class BlackListDTO {
//	CREATE TABLE TBL_BLACKLIST(
//			BLACKLIST_NUM NUMBER PRIMARY KEY,
//			BLACKLIST_COMMENT VARCHAR2(100) NOT NULL,
//			BLACKLIST_DATE DATE NOT NULL,
//			BLACKLIST_NAME VARCHAR2(100) NOT NULL,
//			BLACKLIST_ID VARCHAR2(15) NOT NULL,
//			BLACKLIST_RELEASEDATE DATE NOT NULL
//		);
	
	//필드
	private int blackListNum;
	private String blackListComment;
	private String blackListDate;
	private String blackListName;
	private String blackListId;
	private String blackListReleaseDate;
	
	//세터, 게터
	public int getBlackListNum() {
		return blackListNum;
	}
	public void setBlackListNum(int blackListNum) {
		this.blackListNum = blackListNum;
	}
	public String getBlackListComment() {
		return blackListComment;
	}
	public void setBlackListComment(String blackListComment) {
		this.blackListComment = blackListComment;
	}
	public String getBlackListDate() {
		return blackListDate;
	}
	public void setBlackListDate(String blackListDate) {
		this.blackListDate = blackListDate;
	}
	public String getBlackListName() {
		return blackListName;
	}
	public void setBlackListName(String blackListName) {
		this.blackListName = blackListName;
	}
	public String getBlackListId() {
		return blackListId;
	}
	public void setBlackListId(String blackListId) {
		this.blackListId = blackListId;
	}
	public String getBlackListReleaseDate() {
		return blackListReleaseDate;
	}
	public void setBlackListReleaseDate(String blackListReleaseDate) {
		this.blackListReleaseDate = blackListReleaseDate;
	}
	
	
	@Override
	public String toString() {
		return "BlackListDTO [blackListNum=" + blackListNum + ", blackListComment=" + blackListComment
				+ ", blackListDate=" + blackListDate + ", blackListName=" + blackListName + ", blackListId="
				+ blackListId + ", blackListReleaseDate=" + blackListReleaseDate + "]";
	}
	
	
	
	
}
