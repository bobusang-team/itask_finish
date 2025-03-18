package com.itask.app.dto;

public class AdminDTO {
<<<<<<< HEAD
   
//   CREATE TABLE TBL_ADMIN(
//          ADMIN_NUM NUMBER,
//          ADMIN_NICK VARCHAR2(100) NOT NULL,
//          ADMIN_ID VARCHAR2(100) NOT NULL,
//          ADMIN_PW VARCHAR2(100) NOT NULL,
//          CONSTRAINT PK_ADMIN PRIMARY KEY(ADMIN_NUM)
//      );
   
   //관리자 필드
   private int adminNum;
   private String adminNick;
   private String adminId;
   private String adminPw;
   
   //getter/setter
   public int getAdminNum() {
      return adminNum;
   }
   public void setAdminNum(int adminNum) {
      this.adminNum = adminNum;
   }
   public String getAdminNick() {
      return adminNick;
   }
   public void setAdminNick(String adminNick) {
      this.adminNick = adminNick;
   }
   public String getAdminId() {
      return adminId;
   }
   public void setAdminId(String adminId) {
      this.adminId = adminId;
   }
   public String getAdminPw() {
      return adminPw;
   }
   public void setAdminPw(String adminPw) {
      this.adminPw = adminPw;
   }
   
   
   @Override
   public String toString() {
      return "AdminDTO [adminNum=" + adminNum + ", adminNick=" + adminNick + ", adminId=" + adminId + ", adminPw="
            + adminPw + "]";
   }
   
   

   

}
=======
//	CREATE TABLE TBL_ADMIN(
//		    ADMIN_NUM NUMBER,
//		    ADMIN_NICK VARCHAR2(100) NOT NULL,
//		    ADMIN_ID VARCHAR2(100) NOT NULL,
//		    ADMIN_PW VARCHAR2(100) NOT NULL,
//		    CONSTRAINT PK_ADMIN PRIMARY KEY(ADMIN_NUM)
//		);
	
	private int adminNum;
	private String adminNick;
	private String adminId;
	private String adminPw;
	
	
	public int getAdminNum() {
		return adminNum;
	}
	public void setAdminNum(int adminNum) {
		this.adminNum = adminNum;
	}
	public String getAdminNick() {
		return adminNick;
	}
	public void setAdminNick(String adminNick) {
		this.adminNick = adminNick;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminPw() {
		return adminPw;
	}
	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}
	
	
	@Override
	public String toString() {
		return "AdminDTO [adminNum=" + adminNum + ", adminNick=" + adminNick + ", adminId=" + adminId + ", adminPw="
				+ adminPw + "]";
	}
	
	
	
}

>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
