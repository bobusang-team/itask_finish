package com.itask.app.main.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itask.app.dto.NoticeDTO;
import com.mybatis.config.MyBatisConfig;

public class MainNoticeDAO {
    private SqlSession sqlSession;

    public MainNoticeDAO() {
        this.sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
    }

    // 최근 공지사항 조회
    public List<NoticeDTO> getRecentNotices() {
        return sqlSession.selectList("selectRecentNotices");
    }
}
