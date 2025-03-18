package com.itask.app.dto;

public class AttachedFileDTO {
//   CREATE TABLE TBL_ATTACHEDFILE(
//         ATTACHEDFILE_NUM NUMBER PRIMARY KEY,
//         ARTICLE_NUM NUMBER NOT NULL,
//         ATTACHEDFILE_NAME VARCHAR2(300) NOT NULL,
//         CONSTRAINT FK_ARTICLE FOREIGN KEY (ARTICLE_NUM) REFERENCES TBL_ARTICLE(ARTICLE_NUM) ON DELETE CASCADE
//      );
	
   //필드
   private int AttachedFileNum;
   private int AticleNum;
   private String  AttachedFileName;
   
   //세터,게터
   public int getAttachedFileNum() {
      return AttachedFileNum;
   }
   public void setAttachedFileNum(int attachedFileNum) {
      AttachedFileNum = attachedFileNum;
   }
   public int getAticleNum() {
      return AticleNum;
   }
   public void setAticleNum(int aticleNum) {
      AticleNum = aticleNum;
   }
   public String getAttachedFileName() {
      return AttachedFileName;
   }
   public void setAttachedFileName(String attachedFileName) {
      AttachedFileName = attachedFileName;
   }
   
   
   
}
