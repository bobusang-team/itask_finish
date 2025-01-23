package com.itask.app.dev.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.ArticleDetailDTO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.CommentDTO;
import com.mybatis.config.MyBatisConfig;

public class DevDAO {

	public SqlSession sqlSession;

	public DevDAO() {
		System.out.println("데브다오 실행");
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		System.out.println("데브다오 실행2");
	}
		
    //개발 질문 게시글 가져오기
	public List<ArticleListDTO> selectAllAsk() {
	    System.out.println("DAO selectAllAsk 실행");
//	    System.out.println("pageMap: " + pageMap);
		List<ArticleListDTO> list = sqlSession.selectList("dev.selectAllAsk");
		System.out.println("조회 결과: " + list);
		return list;
	}

	//개발 꾸팁 게시글 가져오기
		public List<ArticleListDTO> selectAllTip() {
		    System.out.println("DAO selectAllTip 실행");
//		    System.out.println("pageMap: " + pageMap);
			List<ArticleListDTO> list = sqlSession.selectList("dev.selectAllTip");
			System.out.println("조회 결과: " + list);
			return list;
		}
		
		public List<CommentDTO> comment(int articleNum) {
		       return sqlSession.selectList("dev.comment", articleNum);
		   }
	
    // 게시글 총 개수 가져오기
	public int getTotal() {
		return sqlSession.selectOne("dev.getTotal");
	}
	
    //조회수 증가
	public void increaseView(int articleNum) {
		sqlSession.update("dev.increaseView", articleNum);
	}
	
	//게시글 삭제
	public void delete(int articleNum) {
		System.out.println("DAO delete 실행");
		sqlSession.delete("dev.delete", articleNum);
	}
	
	//게시글 수정
	public boolean update(ArticleDetailDTO articleDetailDTO) {
		int result = sqlSession.update("dev.update", articleDetailDTO);
		return result>0;
	}

	
	public ArticleListDTO selectOne(int articleNum) {
		System.out.println("상세페이지 정보 불러오기" + articleNum);
		return sqlSession.selectOne("dev.selectOne", articleNum);
	}
	
	
	public ArticleListDTO select(int articleNum) {
		System.out.println("DAO select 실행!");
		return sqlSession.selectOne("dev.select", articleNum);
	}

	//게시글 수정
		public boolean commmentUpdate(CommentDTO commentDTO) {
			int result = sqlSession.update("dev.commmentUpdate", commentDTO);
			return result>0;
		}



    
    
    
}
