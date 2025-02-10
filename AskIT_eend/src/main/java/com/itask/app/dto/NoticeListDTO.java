package com.itask.app.dto;

public class NoticeListDTO {
	
//	공지사항 목록에서 필요한 항목들
	//글번호, 글제목, 카테고리, 관리자 닉네임, 작성일, 수정일, 조회수
	
	private int noticeNum;
	private int adminNum;
	private String noticeTitle;
	private String noticeText;
	private String noticeCategory;
	private String adminNick;
	private String noticeDate;
	private String noticeModifyDate;
	private int noticeView;
	
	public int getNoticeNum() {
		return noticeNum;
	}
	public void setNoticeNum(int noticeNum) {
		this.noticeNum = noticeNum;
	}
	public int getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
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
	public String getNoticeCategory() {
		return noticeCategory;
	}
	public void setNoticeCategory(String noticeCategory) {
		this.noticeCategory = noticeCategory;
	}
	public String getAdminNick() {
		return adminNick;
	}
	public void setAdminNick(String adminNick) {
		this.adminNick = adminNick;
	}
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
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
	
	@Override
	public String toString() {
		return "NoticeListDTO [noticeNum=" + noticeNum + ", adminNum=" + adminNum + ", noticeTitle=" + noticeTitle
				+ ", noticeText=" + noticeText + ", noticeCategory=" + noticeCategory + ", adminNick=" + adminNick
				+ ", noticeDate=" + noticeDate + ", noticeModifyDate=" + noticeModifyDate + ", noticeView=" + noticeView
				+ "]";
	}


	

}
