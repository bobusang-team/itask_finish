package com.itask.app.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.comment.dao.CommentDAO;
import com.itask.app.dto.UserDTO;

public class CommentMonitorController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Result result = new Result();
		CommentDAO commentDAO = new CommentDAO();
		
        HttpSession session = request.getSession();
        
        System.out.println("댓글 모니터 컨트롤러 실행====");
        //댓글 번호 가져오기
        String commentNumStr = request.getParameter("commentNum");
	    System.out.println("추천한 댓글 번호: " + request.getParameter("commentNum"));
	    int commentNum = Integer.parseInt(commentNumStr);
	      
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

	        // 중복 추천 방지 (세션 활용)
	        String likeKey = "liked_" + commentNum;
	        if (session.getAttribute(likeKey) != null) {
	            session.setAttribute("message", "이미 추천한 댓글입니다.");
	            result.setPath("/dev/detailAsk.dev");
	            result.setRedirect(false);
	            return result;
	        }
	        
	        commentDAO.incrementCommentMonitor(commentNum);
	        System.out.println("댓글 추천수 메소드 완료");
	        
	        // 추천 후 경로
	        result.setPath("/comment/commentListOk.co");
	        result.setRedirect(true);
	        System.out.println("너 뭐야");
	        
	        //추천 완료 상태 저장
	        session.setAttribute(likeKey, true);
	        
	       
	        
		return result;
	}

}
