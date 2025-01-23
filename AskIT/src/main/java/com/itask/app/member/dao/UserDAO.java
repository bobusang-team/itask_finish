package com.itask.app.member.dao;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.UserDTO;
import com.mybatis.config.MyBatisConfig;

public class UserDAO {
   public SqlSession sqlSession;

   public UserDAO() {
      sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
   }
   
   // 회원가입
   public void join(UserDTO userDTO) {
      sqlSession.insert("user.join", userDTO);
   }
   
   // 로그인
   public UserDTO login(String userId, String userPw) {
	   UserDTO userDTO = new UserDTO();
	   userDTO.setUserId(userId);
	   userDTO.setUserPw(userPw);
	   return sqlSession.selectOne("user.login", userDTO);
   }
   
   //비밀번호 찾기 
   public UserDTO pwfind(String userId, String userName, String userPhone) {
	   UserDTO userDTO = new UserDTO();
	   userDTO.setUserId(userId);
	   userDTO.setUserName(userName);
	   userDTO.setUserPhone(userPhone);
	   return sqlSession.selectOne("user.pwfind", userDTO);
   }
   
   //비밀번호 수정
   public void reset(UserDTO userDTO) {
	   sqlSession.update("user.reset", userDTO);
   }
   
   //중복체크
   //아이디
   public boolean isId(String userId) {
	   int cnt = sqlSession.selectOne("user.idCnt", userId);
	   return cnt>0;
   }
   //닉네임
   public boolean isNick(String userNick) {
	   int cnt = sqlSession.selectOne("user.nickCnt", userNick);
	   return cnt>0;
   }
   //이메일
   public boolean isMail(String userMail) {
	   int cnt = sqlSession.selectOne("user.mailCnt", userMail);
	   return cnt>0;
   }
   
}