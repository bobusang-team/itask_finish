package com.itask.app.dto;

public class CertsDTO {
//	CREATE TABLE TBL_CERTS (
//		    USER_NUM NUMBER PRIMARY KEY, 
//		    CERTS_IPE CHAR(1) DEFAULT 'F' CHECK (CERTS_IPE IN ('T', 'F')),
//		    CERTS_IPIE CHAR(1) DEFAULT 'F' CHECK (CERTS_IPIE IN ('T', 'F')),
//		    CERTS_IPT CHAR(1) DEFAULT 'F' CHECK (CERTS_IPT IN ('T', 'F')),
//		    CERTS_ISE CHAR(1) DEFAULT 'F' CHECK (CERTS_ISE IN ('T', 'F')),
//		    CERTS_ISIE CHAR(1) DEFAULT 'F' CHECK (CERTS_ISIE IN ('T', 'F')),
//		    CERTS_NETMANAGER1 CHAR(1) DEFAULT 'F' CHECK (CERTS_NETMANAGER1 IN ('T', 'F')),
//		    CERTS_NETMANAGER2 CHAR(1) DEFAULT 'F' CHECK (CERTS_NETMANAGER2 IN ('T', 'F')),
//		    CERTS_SQLD CHAR(1) DEFAULT 'F' CHECK (CERTS_SQLD IN ('T', 'F')),
//		    CERTS_LINUXMASTER1 CHAR(1) DEFAULT 'F' CHECK (CERTS_LINUXMASTER1 IN ('T', 'F')),
//		    CERTS_LINUXMASTER2 CHAR(1) DEFAULT 'F' CHECK (CERTS_LINUXMASTER2 IN ('T', 'F')),
//		    CONSTRAINT FK_USER_NUM_FK FOREIGN KEY (USER_NUM) REFERENCES TBL_USER (USER_NUM)
//		);
	
	//필드
	private int userNum;
	private char certsIPE = 'F';
	private char certsIPIE = 'F';
	private char certsIPT = 'F';
	private char certsISE = 'F';
	private char certsISIE = 'F';
	private char certsNetManager1 = 'F';
	private char certsNetManager2 = 'F';
	private char certsSqld = 'F';
	private char certsLinuxMaster1 = 'F';
	private char certsLinuxMaster2 = 'F';
	
	//세터, 게터
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public char getCertsIPE() {
		return certsIPE;
	}
	public void setCertsIPE(char certsIPE) {
		this.certsIPE = certsIPE;
	}
	public char getCertsIPIE() {
		return certsIPIE;
	}
	public void setCertsIPIE(char certsIPIE) {
		this.certsIPIE = certsIPIE;
	}
	public char getCertsIPT() {
		return certsIPT;
	}
	public void setCertsIPT(char certsIPT) {
		this.certsIPT = certsIPT;
	}
	public char getCertsISE() {
		return certsISE;
	}
	public void setCertsISE(char certsISE) {
		this.certsISE = certsISE;
	}
	public char getCertsISIE() {
		return certsISIE;
	}
	public void setCertsISIE(char certsISIE) {
		this.certsISIE = certsISIE;
	}
	public char getCertsNetManager1() {
		return certsNetManager1;
	}
	public void setCertsNetManager1(char certsNetManager1) {
		this.certsNetManager1 = certsNetManager1;
	}
	public char getCertsNetManager2() {
		return certsNetManager2;
	}
	public void setCertsNetManager2(char certsNetManager2) {
		this.certsNetManager2 = certsNetManager2;
	}
	public char getCertsSqld() {
		return certsSqld;
	}
	public void setCertsSqld(char certsSqld) {
		this.certsSqld = certsSqld;
	}
	public char getCertsLinuxMaster1() {
		return certsLinuxMaster1;
	}
	public void setCertsLinuxMaster1(char certsLinuxMaster1) {
		this.certsLinuxMaster1 = certsLinuxMaster1;
	}
	public char getCertsLinuxMaster2() {
		return certsLinuxMaster2;
	}
	public void setCertsLinuxMaster2(char certsLinuxMaster2) {
		this.certsLinuxMaster2 = certsLinuxMaster2;
	}
	
	@Override
	public String toString() {
		return "CertsDTO [userNum=" + userNum + ", certsIPE=" + certsIPE + ", certsIPIE=" + certsIPIE + ", certsIPT="
				+ certsIPT + ", certsISE=" + certsISE + ", certsISIE=" + certsISIE + ", certsNetManager1="
				+ certsNetManager1 + ", certsNetManager2=" + certsNetManager2 + ", certsSqld=" + certsSqld
				+ ", certsLinuxMaster1=" + certsLinuxMaster1 + ", certsLinuxMaster2=" + certsLinuxMaster2 + "]";
	}
	
	
	
}
