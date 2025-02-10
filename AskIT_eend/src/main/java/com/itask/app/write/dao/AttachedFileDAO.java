package com.itask.app.write.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.AttachedFileDTO;
import com.mybatis.config.MyBatisConfig;

public class AttachedFileDAO {
	
	SqlSession sqlSession;
	   
	   public AttachedFileDAO() {
	      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	   }
	   
	   public void insert(AttachedFileDTO attachedFileDTO) {
	      System.out.println("파일 DAO - 파일저장 AttachedFileDTO : " + attachedFileDTO);
	      
	      try { //파일업로드가 안될 경우를 위해 try-catch블록으로 잡기
	         int result = sqlSession.insert("AttachedFile.insert", attachedFileDTO);
	         System.out.println("파일 저장완료 - db저장된 행의 개수 : " + result);
	         
	         //db에 파일이 제대로 저장되었는지 확인
	         List<AttachedFileDTO> uploadFile = select(attachedFileDTO.getArticleNum());
	         System.out.println("DB에서 가져온 파일 : " + uploadFile);
	      } catch (Exception e) {
	         // TODO Auto-generated catch block
	         System.out.println("파일 저장이 실패되었습니다. " + e.getMessage());
	         e.printStackTrace();
	      }
	      
	   }
	   
	   public List<AttachedFileDTO> select(int articleNum){
	      return sqlSession.selectList("AttachedFile.select", articleNum);
	   }

	   public void delete(int articleNum) {
		   sqlSession.delete("AttachedFile.delete", articleNum);
	   }

}
