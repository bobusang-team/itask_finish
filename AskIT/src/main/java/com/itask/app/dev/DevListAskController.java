package com.itask.app.dev;

import java.io.IOException;
<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======
import java.util.List;
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
=======
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d

import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;

public class DevListAskController {

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		System.out.println("DevListAskController 실행");
		DevDAO devDAO = new DevDAO();
		System.out.println("DevListAskController DAO 객체");
		Result result = new Result();
		ArticleListDTO articleListDTO = new ArticleListDTO();
<<<<<<< HEAD
//		HttpSession session = .getSession();
		
		 String temp = request.getParameter("page");
	      int page = (temp == null) ? 1 : Integer.valueOf(temp); //페이지번호 기본값 : 1
	      int rowCount = 7; // 한 페이지당 게시글 수
	      int pageCount = 5; //페이지 버튼 수
	      
	      //페이징 처리
	      int startRow = (page - 1) * rowCount + 1; // 
	      int endRow = startRow + rowCount - 1; // 
	      
	      Map<String, Integer> pageMap = new HashMap<>();
	      pageMap.put("startRow", startRow);
	      pageMap.put("endRow", endRow);
		

	    // 개발 질문 게시글 목록 조회
	    List<ArticleListDTO> devListAsk = devDAO.selectAllAsk(pageMap);
	    request.setAttribute("devListAsk", devListAsk);
	    
	      //페이징 정보 설정
	      //BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회
	      //실제 마지막 페이지 번호(realEndPage)를 계산함
	      
	      int total = devDAO.getTotalDevAsk();
	      int realEndPage = (int) Math.ceil(total / (double) rowCount); //실제 마지막 페이지 (전체게시글 기준으로 계산)
	      int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현제 페이지 그룹에서의 마지막 페이지
	      int startPage = endPage - (pageCount - 1); //현재 페이지 그룹에서의 첫 페이지
	      
//	      startPage = Math.max(startPage, 0);
	      endPage = Math.min(endPage, realEndPage); //endPage가 실제 존재하는 마지막 페이지(realEndPage)보다 크면 조정
	      
	      //prev, next 버튼 활성화 여부 확인
	      boolean prev = startPage > 1;
	      boolean next = endPage < realEndPage;
	      
	      request.setAttribute("page", page);
	      request.setAttribute("startPage", startPage);
	      request.setAttribute("endPage", endPage);
	      request.setAttribute("prev", prev);
	      request.setAttribute("next", next);
	      
	      System.out.println("====페이징 정보확인====");
	      System.out.println("pageMap : " + pageMap);
	      System.out.println("articleList : " + devListAsk);
	      System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
	      System.out.println("===================");
=======
		
		/*
		 * String temp = request.getParameter("page"); // 페이지 번호 파라미터 int page = (temp
		 * == null) ? 1 : Integer.valueOf(temp); // 페이지 번호 기본값: 1
		 * 
		 * int rowCount = 10; // 한 페이지당 게시글 수 int pageCount = 3; // 페이지 버튼 수
		 * 
		 * 
		 * int startRow = (page - 1) * rowCount + 1; int endRow = startRow + rowCount -
		 * 1;
		 * 
		 * Map<String, Integer> pageMap = new HashMap<>(); pageMap.put("startRow",
		 * startRow); pageMap.put("endRow", endRow);
		 */
	    
	    // 개발 질문 게시글 목록 조회
	    List<ArticleListDTO> devListAsk = devDAO.selectAllAsk();
	    request.setAttribute("devListAsk", devListAsk);
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
	    
	    
	    result.setRedirect(false);
	    result.setPath("/app/article/dev/ask.jsp");
	    return result;
	    
<<<<<<< HEAD

=======
		/*
		 * // 페이징 정보 설정 int total = devDAO.getTotal(); // 총 게시글 수 int realEndPage =
		 * (int) Math.ceil(total / (double) rowCount); // 실제 마지막 페이지 int endPage = (int)
		 * (Math.ceil(page / (double) pageCount) * pageCount); int startPage = endPage -
		 * (pageCount - 1);
		 * 
		 * endPage = Math.min(endPage, realEndPage); // 마지막 페이지 조정 boolean prev =
		 * startPage > 1; boolean next = endPage < realEndPage;
		 * 
		 * request.setAttribute("page", page); request.setAttribute("startPage",
		 * startPage); request.setAttribute("endPage", endPage);
		 * request.setAttribute("prev", prev); request.setAttribute("next", next);
		 * 
		 * // 디버깅 출력 System.out.println("pageMap: " + pageMap);
		 * System.out.println("devList: " + devList); System.out.println("startPage: " +
		 * startPage + ", endPage: " + endPage + ", prev: " + prev + ", next: " + next);
		 * 
		 * result.setPath("/app/article/dev/ask.jsp"); result.setRedirect(false);
		 * 
		 * System.out.println("Start Row: " + startRow); System.out.println("End Row: "
		 * + endRow);
		 * 
		 * List<ArticleListDTO> devList1 = devDAO.selectAll(pageMap);
		 * System.out.println("devList from DAO: " + devList1);
		 * 
		 * request.setAttribute("devList", devList);
		 * System.out.println("Request Attribute Set: " +
		 * request.getAttribute("devList"));
		 */
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
	    

	}

}
