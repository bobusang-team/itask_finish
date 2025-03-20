package com.itask.app.main.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.ArticleListDTO;
import com.mybatis.config.MyBatisConfig;


public class SearchDAO {
	private SqlSession sqlSession;

	public SearchDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//2글자 이상 검색어로 검색 + 페이징
	public List<ArticleListDTO> searchArticles(String query, int startRow, int endRow) {
		List<ArticleListDTO> articles = null;
		
			try {
				articles = sqlSession.selectList("main.searchArticles",
				new SearchParam(query, startRow, endRow));
			} catch (Exception e) {
				System.out.println("searcParam error :" + e.getMessage());
			}
		return articles;
	}
	
	//검색결과 개수 조회
	public int getTotalCount(String query) {
		int total = 0;
		
		try {
			Integer result = sqlSession.selectOne("main.getTotalCount", query);
			if(result != null) {
					total = result; // null방지
			}
			} catch (Exception e) {
				System.out.println("getTotalCount Error:" + e.getMessage());			
		}
			return total;
	}
	
	// 특정 태그가진 게시글 목록 조회
		public List<ArticleListDTO> searchArticlesByTag(String tag) {
			List<ArticleListDTO> articles = null;
			try {
				articles = sqlSession.selectList("main.searchArticlesByTag", tag);			
			} catch (Exception e) {
				System.out.println("searchArticlesByTag 오류:" + e.getMessage());
			}
			return articles;
			
		}
		
		//특정 검색결과 개수 조회
		public int getTotalCountByTag(String query) {
			int total = 0;
			
			try {
				total = sqlSession.selectOne("main.getTotalCountByTag", query);
				} catch (Exception e) {
					System.out.println("getTotalCountByTag Error:" + e.getMessage());			
			}
				return total;
		}
		

}
