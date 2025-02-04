package com.itask.app.admin.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.AdminDTO;
import com.itask.app.dto.ArticleDTO;
import com.itask.app.dto.CommentDTO;
import com.itask.app.dto.NoticeDTO;
import com.itask.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class AdminDAO {
	public SqlSession sqlSession;
	
	public AdminDAO() {
		System.out.println("설정전");
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
		System.out.println("세션설정된");
	}
	
	public AdminDTO AdminLogin(String AdminId, String AdminPw){
			AdminDTO adminDTO = new AdminDTO();
			
			adminDTO.setAdminId(AdminId);
			adminDTO.setAdminPw(AdminPw);
			System.out.println("DTO설정됨");
			return sqlSession.selectOne("admin.adminLogin", adminDTO);
		
	}
	
	public List<UserDTO> TotalMember() {
		return sqlSession.selectList("admin.totalMember");
	}
	
	public List<UserDTO> GeneralMember() {
		return sqlSession.selectList("admin.generalMember");
	}
	
	public List<UserDTO> MentoMember() {
		return sqlSession.selectList("admin.mentoMember");
	}
	
	public List<NoticeDTO> Notice() {
		return sqlSession.selectList("admin.notice");
	}
	
	public List<ArticleDTO> TipDev() {
		return sqlSession.selectList("admin.tipDev");
	}
	
	public List<ArticleDTO> TipSec() {
		return sqlSession.selectList("admin.tipSec");
	}
	
	public List<ArticleDTO> TipQual() {
		return sqlSession.selectList("admin.tipQual");
	}
	
	public List<ArticleDTO> AskDev() {
		return sqlSession.selectList("admin.askDev");
	}
	
	public List<ArticleDTO> AskSec() {
		return sqlSession.selectList("admin.askSec");
	}
	
	public List<ArticleDTO> AskQual() {
		return sqlSession.selectList("admin.askQual");
	}

	public void write(NoticeDTO noticeDTO) {
		sqlSession.insert("admin.write", noticeDTO);
	}
	
	public ArticleDTO ArticleDetail(int articleNum) {
		return sqlSession.selectOne("admin.articleDetail", articleNum);
	}
	
	public List<CommentDTO> Comment(int articleNum) {
	    return sqlSession.selectList("admin.commentArticle", articleNum);
	}
	
	
}
