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
   private int ArticleNum;
   private String  AttachedFileName;
public int getAttachedFileNum() {
	return AttachedFileNum;
}
public void setAttachedFileNum(int attachedFileNum) {
	AttachedFileNum = attachedFileNum;
}
public int getArticleNum() {
	return ArticleNum;
}
public void setArticleNum(int articleNum) {
	ArticleNum = articleNum;
}
public String getAttachedFileName() {
	return AttachedFileName;
}
public void setAttachedFileName(String attachedFileName) {
	AttachedFileName = attachedFileName;
}
@Override
public String toString() {
	return "AttachedFileDTO [AttachedFileNum=" + AttachedFileNum + ", ArticleNum=" + ArticleNum + ", AttachedFileName="
			+ AttachedFileName + "]";
}
   
   
}
