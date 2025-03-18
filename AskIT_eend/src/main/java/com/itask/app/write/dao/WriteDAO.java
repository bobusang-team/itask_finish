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
    public int insertArticle(ArticleDTO articleDTO) {
    	System.out.println("글쓰기 DAO 실행");
        sqlSession.insert("write.insertArticle", articleDTO);
		System.out.println(articleDTO + "출력 ==");
		System.out.println("게시글제목 : " + articleDTO.getArticleTitle());
		System.out.println("게시글내용 : " + articleDTO.getArticleText());
		
		System.out.println("== 게시글 작성 DAO ==");
		System.out.println("생성된 articleNumber : " + articleDTO.getArticleNum());
		System.out.println("== 게시글 작성 DAO 끝 ==");
		return articleDTO.getArticleNum();
    }
    



}