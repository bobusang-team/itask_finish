package com.itask.app.write.dao;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.ArticleDTO;
import com.mybatis.config.MyBatisConfig;

public class WriteDAO {
   
   private SqlSession sqlSession;

    // 기본 생성자
    public WriteDAO() {
        this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true); // 자동 커밋 모드
    }
    
    //글쓰기 버튼 클릭시 회원/비회원 체크
    public String getUserId(int userNum) {
		return sqlSession.selectOne("write.getUserId", userNum);
	}

    // 글쓰기 메소드
    public void insertArticle(ArticleDTO articleDTO) {
    	System.out.println("글쓰기 DAO 실행");
        sqlSession.insert("write.insertArticle", articleDTO);
    }
    



}