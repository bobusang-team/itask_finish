package com.itask.app.main.dao;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.ArticleDTO;
import com.mybatis.config.MyBatisConfig;

public class ArticleDAO {
	private SqlSession sqlSession;

	// 생성자에서 MyBatis 세션 팩토리 설정
	public ArticleDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	// best 게시글 카테고리별로 가져오기
	public ArticleDTO getBestArticle(String category) {
		ArticleDTO bestArticle = null;
		try {
			bestArticle = sqlSession.selectOne("main.selectBestArticle", category); //네임스페이스
		} catch (Exception e) {
			System.out.println("selectBestArticle 오류:" + e.getMessage());
		}

		return bestArticle;

	}
	
	
	}

