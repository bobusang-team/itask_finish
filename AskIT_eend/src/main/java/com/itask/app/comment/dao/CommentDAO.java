package com.itask.app.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.CommentDTO;
import com.itask.app.dto.CommentListDTO;
import com.mybatis.config.MyBatisConfig;

public class CommentDAO {
	SqlSession sqlSession;

	public CommentDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
	
	//댓글 작성
	public void insert(CommentDTO commentDTO) {
		System.out.println("댓글작성실행");
		sqlSession.insert("comment.insert", commentDTO);
	}
	
	//댓글 목록
	public List<CommentListDTO> selectAll(int articleNum) {
		return sqlSession.selectList("comment.selectAll", articleNum);
	}
	
	//댓글 추천
		public void incrementCommentMonitor(int coomentNum) {
		   int result = sqlSession.update("comment.incrementMonitorNum", coomentNum);
		}
	//댓글 수 세기
		public int getTotalComment() {
			return sqlSession.selectOne("comment.countComment");
		}
	
	//댓글 삭제
	public void delete(int commentNum) {
		sqlSession.delete("comment.delete", commentNum);
	}
	
	//댓글 수정
	public void update(CommentDTO commentDTO) {
		sqlSession.update("comment.update", commentDTO);
	}
}
