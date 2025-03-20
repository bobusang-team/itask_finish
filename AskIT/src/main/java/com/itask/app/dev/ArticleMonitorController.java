package com.itask.app.dev;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.UserDTO;

public class ArticleMonitorController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Result result = new Result();
        HttpSession session = request.getSession();
        System.out.println("모니터 컨트롤러 실행====");
        
	      //boardNumber가 빈문자열이나 null인 경우
	      String articleNumStr = request.getParameter("articleNum");
	      System.out.println("현재 게시글 번호: " + request.getParameter("articleNum"));
	      if(articleNumStr == null || articleNumStr.trim().isEmpty()) {
	         System.out.println("articleNum 값이 없습니다.");
	         
	         result.setPath("/app/article/dev/ask.jsp"); //게시글 목록 페이지로 리다이렉트
	         result.setRedirect(true);
	         return result;
	      }
	      
	      int articleNum = Integer.parseInt(articleNumStr);
	      UserDTO userDTO = new UserDTO();
	      DevDAO devDAO = new DevDAO();
	      
	      ArticleListDTO articleListDTO = devDAO.selectOne(articleNum);
//	      FileDAO fileDAO = new FileDAO();
	      
	      //게시글이 존재하지 않을 경우 처리
	      if(articleListDTO == null) {
	         System.out.println("존재하지 않는 게시글 입니다." + articleNum);
	         result.setPath("/app/board/boardList.jsp");
	         result.setRedirect(true);
	         return result;
	      }
	      
//	      List<FileDTO> files = fileDAO.select(boardNumber);
//	      boardListDTO.setFiles(files);
	      
//	      HttpSession session = request.getSession();
	      
	      //로그인한 사용자 번호 가져오기
	      UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
	      int loginUserNum = thisUser.getUserNum();
	      System.out.println("로그인한 멤버 번호 : " + loginUserNum);
	      
	      
	      session.setAttribute("userNum", loginUserNum);  // loginUserNum은 로그인한 사용자의 번호
	      session.getAttribute("userNum");
	      
	      
	   // 로그인 여부 확인
	        if (thisUser == null) {
	            session.setAttribute("message", "로그인 후 추천이 가능합니다.");
	            result.setPath("/dev/askDetail.dev");
	            result.setRedirect(true);
	            return result;
	        }
	      
//	       ArticleListDTO writeUser = (ArticleListDTO) session.getAttribute("ArticleListDTO");
//	       int writeUserNum = writeUser.getUserNum();
//	       System.out.println("현재 게시글 작성자 번호 : " + loginUserNum);
	       
	        
	      int articleWriterNum = articleListDTO.getUserNum();
			System.out.println("현재 게시글 작성자 번호 : " + articleWriterNum);
	    
	        // 중복 추천 방지 (세션 활용)
	        String likeKey = "liked_" + articleNum;
	        if (session.getAttribute(likeKey) != null) {
	            session.setAttribute("message", "이미 추천한 게시글입니다.");
	            result.setPath("/dev/detailAsk.dev");
	            result.setRedirect(false);
	            return result;
	        }
	    
        // 추천 수 증가
       
        devDAO.incrementArticleMonitor(articleNum);
        System.out.println("추천수 메소드 완료");
        
        //추천수 증가시 유저 모니터 증가
        devDAO.incrementUserMonitor(articleNum);
        System.out.println("추천시 유저 모니터 증가 메소드 완료");
        
        

//         추천 완료 상태 저장
        session.setAttribute(likeKey, true);

        // 추천 후 경로
        result.setPath("/dev/detailAsk.dev");
        result.setRedirect(false);
        return result;
    }
}
