package com.itask.app.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class UserMainDAO {
	private SqlSession sqlSession;

	// 생성자에서 MyBatis 세션 팩토리 설정
	public UserMainDAO() {
		this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	// sql 쿼리 실행

	// 명예의 전당 상위 5명 가져오기 (MyBatis 사용)
	public List<UserDTO> getRankingTop5() {
		System.out.println("명예의 전당 상위 5명 가져오기 ========="); //출력시도
		try {
			return sqlSession.selectList("main.selectRanking"); // 매퍼 호출
		} catch (Exception e) {
			return null;
		} finally {
			sqlSession.close();
		}
	}
}