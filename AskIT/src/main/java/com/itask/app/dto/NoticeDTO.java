package com.itask.app.dto;

public class NoticeDTO {
//	CREATE TABLE TBL_NOTICE (
//			NOTICE_NUM NUMBER,
//			ADMIN_NUM NUMBER,
//			NOTICE_CATEGORY VARCHAR2(100) NOT NULL CHECK (NOTICE_CATEGORY IN ('전체','개발','보안','자격증')),
//			NOTICE_TITLE VARCHAR2(100) NOT NULL,
//			NOTICE_TEXT VARCHAR2(3000) NOT NULL,
//			NOTICE_VIEW NUMBER DEFAULT 0 NOT NULL,
<<<<<<< HEAD
//			NOTICE_DATE DATE NOT NULL,
//			NOTICE_MODIFY_DATE DATE,
=======
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
//			CONSTRAINT TBL_NOTICE_PK PRIMARY KEY (NOTICE_NUM),
//			CONSTRAINT TBL_ADMIN_FK FOREIGN KEY (ADMIN_NUM) REFERENCES TBL_ADMIN(ADMIN_NUM) ON DELETE CASCADE
//			);
	
<<<<<<< HEAD
	//필드
=======
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
	private int noticeNum;
	private int adminNum;
	private String noticeCategory;
	private String noticeTitle;
	private String noticeText;
<<<<<<< HEAD
	private int noticeView = 0;
	private String noticeDate;
	private String noticeModifyDate;
	
	//세터, 게터
=======
	private int noticeView;
	private String noticeDate;
	private String noticeModifyDate;
	
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeModifyDate() {
		return noticeModifyDate;
	}
	public void setNoticeModifyDate(String noticeModifyDate) {
		this.noticeModifyDate = noticeModifyDate;
	}
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
<<<<<<< HEAD
	public int getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(int adminNum) {
=======
	public int getAdminNUm() {
		return adminNum;
	}
	public void setAdminNUm(int adminNum) {
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
		this.adminNum = adminNum;
	}
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeText() {
		return noticeText;
	}
	public void setNoticeText(String noticeText) {
		this.noticeText = noticeText;
	}
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
<<<<<<< HEAD
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeModifyDate() {
		return noticeModifyDate;
	}
	public void setNoticeModifyDate(String noticeModifyDate) {
		this.noticeModifyDate = noticeModifyDate;
	}
	
	@Override
	public String toString() {
		return "NoticeDTO [noticeNum=" + noticeNum + ", adminNum=" + adminNum + ", noticeCategory=" + noticeCategory
				+ ", noticeTitle=" + noticeTitle + ", noticeText=" + noticeText + ", noticeView=" + noticeView
				+ ", noticeDate=" + noticeDate + ", noticeModifyDate=" + noticeModifyDate + "]";
	}
	
	
=======
	
	
	@Override
	public String toString() {
		return "NoticeDTO [noticeNum=" + noticeNum + ", adminNUm=" + adminNum + ", noticeCategory=" + noticeCategory
				+ ", noticeTitle=" + noticeTitle + ", noticeText=" + noticeText + ", noticeView=" + noticeView + "]";
	}
	
	
	
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
}
