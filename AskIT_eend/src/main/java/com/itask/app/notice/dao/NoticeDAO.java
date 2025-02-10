package com.itask.app.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.NoticeListDTO;
import com.mybatis.config.MyBatisConfig;

public class NoticeDAO {
	
	public SqlSession sqlSession;
	
	public NoticeDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//모든 게시글 가져오기
		public List<NoticeListDTO> selectAll(Map<String, Integer> pageMap){
			System.out.println("모든 게시글 조회하기 - seletAll 메소드 실행" + pageMap); //확인용
			List<NoticeListDTO> list = sqlSession.selectList("notice.selectAll", pageMap);
			System.out.println("조회결과 : " + list);
			return list; //리턴타입이 List<NoticeListDTO> 라서 이렇게 전달해줌
		}
		
		//게시글 총 갯수 가져오기
		public int getTotal() {
			return sqlSession.selectOne("notice.getTotal");
		}		
		
		//게시글 상세페이지 조회 메소드
		public NoticeListDTO select(int noticeNum) {
			System.out.println("공지사항 상세보기 메소드");
			return sqlSession.selectOne("notice.select", noticeNum);
		}
		
		

}
