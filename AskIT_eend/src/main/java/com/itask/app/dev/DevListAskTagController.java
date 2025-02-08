package com.itask.app.dev;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;

public class DevListAskTagController {

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		System.out.println("DevListAskTagController 실행");
		DevDAO devDAO = new DevDAO();
		System.out.println("DevListAskTagController DAO 객체");
		Result result = new Result();
		ArticleListDTO articleListDTO = new ArticleListDTO();
		
		
		 String temp = request.getParameter("page");
	      int page = (temp == null) ? 1 : Integer.valueOf(temp); //페이지번호 기본값 : 1
	      int rowCount = 7; // 한 페이지당 게시글 수
	      int pageCount = 5; //페이지 버튼 수
	      
	      //페이징 처리
	      int startRow = (page - 1) * rowCount + 1; // 
	      int endRow = startRow + rowCount - 1; //
	      
	     
	      
	      String articleTopcate = request.getParameter("articleTopcate");
	      System.out.println(request.getParameter("articleTopcate"));
	      
	      String articleBotcate = request.getParameter("articleBotcate");
	      System.out.println(request.getParameter("articleBotcate"));
	      
	      String articleTagname = request.getParameter("articleTagname");
	      System.out.println(request.getParameter("articleTagname"));
	      
	      
	      Map pageMap = new HashMap<>();
	      pageMap.put("startRow", startRow);
	      pageMap.put("endRow", endRow);
	      pageMap.put("articleTopcate", articleTopcate);
	      pageMap.put("articleBotcate", articleBotcate);
	      pageMap.put("articleTagname", articleTagname);
	      
	      
	      
	    // 개발 질문 게시글 목록 조회
	    List<ArticleListDTO> devListAskTag = devDAO.selectAllAskTag(pageMap);
	    System.out.println(devListAskTag);
	    request.setAttribute("devListAskTag", devListAskTag);

	    
	      //페이징 정보 설정
	      //BoardMapper.xml의 getTotal을 이용하여 전체 게시글 개수 조회
	      //실제 마지막 페이지 번호(realEndPage)를 계산함
	      
	      int total = devDAO.getTotalDevAskTag(pageMap);
	      int realEndPage = (int) Math.ceil(total / (double) rowCount); //실제 마지막 페이지 (전체게시글 기준으로 계산)
	      
	      int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현제 페이지 그룹에서의 마지막 페이지
//	      int endPage = 50;
	      int startPage = endPage - (pageCount - 1); //현재 페이지 그룹에서의 첫 페이지
	      
//	      startPage = Math.max(startPage, 0);
	      endPage = Math.min(endPage, realEndPage); //endPage가 실제 존재하는 마지막 페이지(realEndPage)보다 크면 조정
	      System.out.println(endPage);
	      System.out.println(realEndPage);
	      
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
	      System.out.println("boardList : " + devListAskTag);
	      System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
	      System.out.println("===================");
	    
	    
	    result.setRedirect(false);
	    result.setPath("/app/article/dev/ListAskTag.jsp");
	    return result;
	    

	    

	}

}
