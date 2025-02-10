package com.itask.app.notice.dao;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.NoticeListDTO;
import com.mybatis.config.MyBatisConfig;

public class NoticeDetailDAO {
	public SqlSession sqlSession;
	
	public NoticeDetailDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//게시글 상세페이지 조회 메소드
	public NoticeListDTO selectDetail(int noticeNum) {
		System.out.println("공지사항 글 상세 보기 메소드");
		return sqlSession.selectOne("notice.selectDetail", noticeNum);
	}
	
	//조회수 증가 메소드
	public void updateReadCount(int noticeNum) {
		System.out.println("조회수 업데이트 실행 : " + noticeNum);
		int result = sqlSession.update("notice.updateReadCount", noticeNum);
		System.out.println("조회수 업데이트 결과 : " + result);
	}
}
