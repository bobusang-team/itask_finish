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
//	 기존메소드  
//	   public void insert(AttachedFileDTO attachedFileDTO) {
//	      System.out.println("파일 DAO - 파일저장 AttachedFileDTO : " + attachedFileDTO);
//	      
//	      try { //파일업로드가 안될 경우를 위해 try-catch블록으로 잡기
//	         int result = sqlSession.insert("attachedFile.insert", attachedFileDTO);
//	         System.out.println("파일 저장완료 - db저장된 행의 개수 : " + result);
//	         
//	         //db에 파일이 제대로 저장되었는지 확인
//	         List<AttachedFileDTO> uploadFile = select(attachedFileDTO.getArticleNum());
//	         System.out.println("DB에서 가져온 파일 : " + uploadFile);
//	         System.out.println(attachedFileDTO.getAttachedFileNum() + " : 첨부파일 번호확인");
//	      } catch (Exception e) {
//	         // TODO Auto-generated catch block
//	         System.out.println("파일 저장이 실패되었습니다. " + e.getMessage());
//	         e.printStackTrace();
//	      }	      
//	   }   
//	   
//	   새 메소드
	   public int insert(AttachedFileDTO attachedFileDTO) {
		    System.out.println("첨부파일 DAO 실행");

		    // 이전코드
			/*
			 * sqlSession.insert("attachedFile.insert", attachedFileDTO); // MyBatis가 자동으로
			 * attachedFileNum 설정
			 * 
			 * System.out.println("첨부파일 정보: " + attachedFileDTO);
			 * System.out.println("생성된 첨부파일 번호: " + attachedFileDTO.getAttachedFileNum());
			 * 
			 * return attachedFileDTO.getAttachedFileNum(); // 이제 정상적으로 번호가 반환됨
			 */		    //이전 코드 끝
		    
		    try {
		        int result = sqlSession.insert("attachedFile.insert", attachedFileDTO);
		        System.out.println("DB 삽입 결과: " + result);
		        System.out.println("첨부파일 정보: " + attachedFileDTO);
		        System.out.println("생성된 첨부파일 번호: " + attachedFileDTO.getAttachedFileNum());
		        return attachedFileDTO.getAttachedFileNum();
		    } catch (Exception e) {
		        System.out.println("파일 삽입 중 오류 발생: " + e.getMessage());
		        e.printStackTrace();
		        return -1;
		    }
		    
		    
		    
		}
	   
	   
	   public List<AttachedFileDTO> select(int articleNum){
	      return sqlSession.selectList("attachedFile.select", articleNum);
	   }

	   public void delete(int articleNum) {
		   sqlSession.delete("attachedFile.delete", articleNum);
	   }

}
