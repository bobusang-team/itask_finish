package com.itask.app.dev;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;

public class DevListTipController {

	public Result execute(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		System.out.println("DevListTipController 실행");
		DevDAO devDAO = new DevDAO();
		System.out.println("DevListTipController DAO 객체");
		Result result = new Result();
		ArticleListDTO articleListDTO = new ArticleListDTO();
		
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
	    
	    // 개발 꿀팁 게시글 목록 조회
	    
	    List<ArticleListDTO> devListTip = devDAO.selectAllTip();
	    request.setAttribute("devListTip", devListTip);
	    
	    result.setRedirect(false);
	    result.setPath("/app/article/dev/tip.jsp");
	    return result;
	    
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
	    

	}

}
