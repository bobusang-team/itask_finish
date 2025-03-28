package com.itask.app.admin.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.AdminDTO;
import com.itask.app.dto.ArticleAdminDTO;
import com.itask.app.dto.BlackListDTO;
import com.itask.app.dto.CommentAdminDTO;
import com.itask.app.dto.MypageMainDTO;
import com.itask.app.dto.NoticeDTO;
import com.itask.app.dto.UserAdminDTO;
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
	
	public int getTotal() {
		return sqlSession.selectOne("admin.getTotal");
	}
	
	public int getSearchTotal(String search) {
		return sqlSession.selectOne("admin.getSearchTotal", search);
	}
	
	public int getGeneralTotal() {
		return sqlSession.selectOne("admin.getGeneralTotal");
	}
	
	public int getMentoTotal() {
		return sqlSession.selectOne("admin.getMentoTotal");
	}
	
	public int getBlackTotal() {
		return sqlSession.selectOne("admin.getBlackTotal");
	}
	
	public List<UserAdminDTO> TotalMember(Map<String, Integer> pageMap) {
		List<UserAdminDTO> list = sqlSession.selectList("admin.totalMember", pageMap);
		return list;
	}
	
	public List<UserAdminDTO> GeneralMember(Map<String, Integer> pageMap) {
		System.out.println("GeneralMember실행");
		List<UserAdminDTO> list = sqlSession.selectList("admin.generalMember", pageMap);
		System.out.println("GeneralMember 실행완료");
		return list;
	}
	
	public List<UserAdminDTO> MentoMember(Map<String, Integer> pageMap) {
		List<UserAdminDTO> list = sqlSession.selectList("admin.mentoMember", pageMap);
		return list;
	}
	
	public List<NoticeDTO> Notice(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.notice", pageMap);
	}
	
	public List<ArticleAdminDTO> TipDev(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.tipDev", pageMap);
	}
	
	public List<ArticleAdminDTO> TipSec(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.tipSec", pageMap);
	}
	
	public List<ArticleAdminDTO> TipQual(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.tipQual", pageMap);
	}
	
	public List<ArticleAdminDTO> AskDev(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.askDev", pageMap);
	}
	
	public List<ArticleAdminDTO> AskSec(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.askSec", pageMap);
	}
	
	public List<ArticleAdminDTO> AskQual(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.askQual", pageMap);
	}

	public void write(NoticeDTO noticeDTO) {
		sqlSession.insert("admin.write", noticeDTO);
	}
	
	public ArticleAdminDTO ArticleDetail(int articleNum) {
		return sqlSession.selectOne("admin.articleDetail", articleNum);
	}
	
	public List<CommentAdminDTO> Comment(int articleNum) {
	    return sqlSession.selectList("admin.commentArticle", articleNum);
	}
	
	public List<BlackListDTO> BlackList(Map<String, Integer> pageMap) {
		return sqlSession.selectList("admin.blackList", pageMap);
	}
	
	public void DeleteMember(List<String> userIds) {
		sqlSession.delete("admin.deleteMember", userIds);
	}

	public void addBlackList(BlackListDTO blackListDTO) {
		sqlSession.insert("admin.addBlackList", blackListDTO);
		
	}
	
	public MypageMainDTO Userpage(String userNick) {
		return sqlSession.selectOne("admin.userPage",userNick);
	}

	public int getAskDevTotal() {
		return sqlSession.selectOne("admin.getAskDevTotal");
	}

	public int getAskQualTotal() {
		return sqlSession.selectOne("admin.getAskQualTotal");
	}

	public int getAskSecTotal() {
		return sqlSession.selectOne("admin.getAskSecTotal");
	}

	public int getNoticeTotal() {
		return sqlSession.selectOne("admin.getNoticeTotal");
	}

	public int getTipDevTotal() {
		return sqlSession.selectOne("admin.getTipDevTotal");
	}

	public int getTipQualTotal() {
		return sqlSession.selectOne("admin.getTipQualTotal");
	}

	public int getTipSecTotal() {
		return sqlSession.selectOne("admin.getTipSecTotal");
	}
	
	public void UpdateCerts(Map<String, Object> certsMap) {
		sqlSession.update("admin.updateCerts", certsMap);
	}
	
	public void UpdateGrade(int userNum) {
		sqlSession.update("admin.updateGrade", userNum);
	}
	
	public void UpdateCareer(Map<String, Object> careerMap) {
		sqlSession.update("admin.updateCareer", careerMap);
	}
	
	public void DeleteBlackList(List<String> userIds) {
		sqlSession.delete("admin.deleteBlackList", userIds);
	}
	
	public void UpdateBlackList(Map<String, Object> updateMap) {
		sqlSession.update("admin.updateBlackList", updateMap);
	}
	
	public void DeleteNotice(List<String> NoticeList) {
		sqlSession.delete("admin.deleteNotice", NoticeList);
	}
	
	public NoticeDTO NoticeDetail(int noticeNum) {
		return sqlSession.selectOne("admin.noticeDetail", noticeNum);
	}
	
	public void NoticeUpdate(NoticeDTO noticeDTO) {
		sqlSession.update("admin.noticeUpdate", noticeDTO);
	}
	public List<UserAdminDTO> SearchMember(Map<String, Object> pageMap) {
	    return sqlSession.selectList("admin.searchMember", pageMap);
	}
	public void DeleteArticle(List<String> ArticleList) {
		sqlSession.delete("admin.deleteArticle", ArticleList);
	}
	public void UpdateArticle(ArticleAdminDTO article) {
		sqlSession.update("admin.updateArticle", article);
	}

	public void DeleteComment(int commentNum) {
		sqlSession.update("admin.deleteComment", commentNum);
	}
}
