package com.itask.app.mypage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.ArticleDetailDTO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.MypageMainDTO;
import com.itask.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class MypageDAO {
	public SqlSession sqlSession;
	
	// 선언한 참조변수에 DB에 접근할 수 있는 Session을 만든다.
	public MypageDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 마이페이지 진입시 비밀번호 확인
	// 1이면 존재한다는 것임
	public boolean pwCheck(String userId, String inputPw) {
		UserDTO userDTO = new UserDTO();
		
		userDTO.setUserId(userId);
		userDTO.setUserPw(inputPw);
		int result = (Integer)sqlSession.selectOne("mypage.pwCheck", userDTO);
		return result == 1;
	}
	
	// 닉네임 수정시 중복 확인
	// return 결과가 0이면 중복 없는 것 => true
	public boolean nickCheck(String nickName) {
		return (Integer)sqlSession.selectOne("mypage.nickCheck", nickName) == 0; 
	}

	// 닉네임 수정 버튼 클릭시 해당 회원 업데이트
	// return 결과가 0이면 수정 실패한 것
	public boolean nickUpdate(UserDTO userDTO) {
		return (Integer)sqlSession.update("mypage.nickUpdate", userDTO) == 0;
	}
	
	// 비밀번호 수정하기에서 비밀번호 클릭시
	// return 결과가 0이면 수정 실패한 것
	public boolean pwUpdate(UserDTO userDTO) {
		return (Integer)sqlSession.update("mypage.pwUpdate", userDTO) == 0;
	}
	
	// 핸드폰번호 수정하기에서 변경된 정보 저장하기 클릭시
	// return 결과가 0이면 수정 실패한 것
	public boolean phoneUpdate(UserDTO userDTO) {
		return (Integer)sqlSession.update("mypage.phoneUpdate", userDTO) == 0;
	}

	// 회원탈퇴하기 버튼 클릭시
	public boolean delete(String userId) {
		return (Integer)sqlSession.delete("mypage.delete", userId) == 0;
	}
	
	// 마이페이지 메인에 출력해야할 정보를 받아오는 쿼리
	public MypageMainDTO mainPageSelect(String userId) {
		MypageMainDTO mypageMainDTO = new MypageMainDTO();
		
		mypageMainDTO = sqlSession.selectOne("mypage.main", userId);
		
		return mypageMainDTO;
	}
	
	//증복체크
	//닉네임
	   public boolean isNick(String userNick) {
		   int cnt = sqlSession.selectOne("mypage.nickCnt", userNick);
		   return cnt>0;
	   }
	   
	 //해당 유저가 작성한 게시글 모두 가져오기
	 public List<ArticleListDTO> selectAllMy(Map<String, Integer> pageMap){
		 System.out.println("========selectAll : 유저가 작성한 게시글 가져오기");
		 List<ArticleListDTO> myList = sqlSession.selectList("mypage.selectAllMy", pageMap);
		 System.out.println("가져온 목록 : " + myList);
		 return myList;
	 }
	 
	 //해당 유저가 작성한 게시글 총 수
	 public int getTotal(int userNum) {
		 return sqlSession.selectOne("mypage.getTotal", userNum);
	 }
	 
//	 fetch 사용시 주석해제
//	 public List<ArticleListDTO> selectArticlesByCategory(Map myMap){
//		 System.out.println("====selectArticlesByCategory 메소드 실행");
//		 List<ArticleListDTO> myList = sqlSession.selectList("mypage.selectCateList", myMap);
//		 return myList;
//	 }
	 
	 // 유저가 선택한 프로필 번호의 파일명 가져오기
	 public String profileSelect(int profileNum) {
		System.out.println("=====profileSelect 메소드 실행");
		String profileName = sqlSession.selectOne("mypage.profileSelect", profileNum);
		System.out.println("=====profileName 명 " + profileName);
		return profileName;
	 }
	 
	 // 유저 테이블에 프로필 이미지 변경
	 public int UserProfileNumUpdate(Map<String, Integer> map) {
		int checkResult = sqlSession.update("mypage.userProfileUpdate", map);
		System.out.println("checkResult 값 : " + checkResult);
		return checkResult;
	 }
	
	 // 해당 유저 DTO 불러오기
	 public UserDTO selectUser(int userNum) {
		 System.out.println("userDTO 조회 메소드 실행");
		 UserDTO userDTO = sqlSession.selectOne("mypage.userSelect", userNum);
		 return userDTO;
	 }
	 
	 // 내가 작성한 게시글 상세 불러오기
	 public ArticleListDTO selectArticleDetail(int articleNum) {
		 System.out.println("selectArticleDetail 메소드 실행");
		 ArticleListDTO articleListDTO = sqlSession.selectOne("mypage.articleDetail", articleNum);
		 System.out.println("쿼리 실행 후 게시글 상세 정보 : " + articleListDTO);
		 return articleListDTO;
	 }
}

