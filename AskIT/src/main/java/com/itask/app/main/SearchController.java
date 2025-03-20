package com.itask.app.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.UserDTO;
import com.itask.app.main.dao.SearchDAO;

public class SearchController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		String isJson = request.getParameter("json"); // JSON 반환

		// 세션 가져오기
		HttpSession session = request.getSession();
		UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");

		if (userInfo != null) {
			System.out.println("로그인 상태 : " + userInfo.getUserNick());
		} else {
			System.out.println("비로그인 상태");
		}

		// 검색어 및 페이지 정보 가져오기
		String query = request.getParameter("query"); // 검색어
		String selectedTag = request.getParameter("tag"); // 태그 검색
		String tempPage = request.getParameter("page");

		int page = (tempPage == null) ? 1 : Integer.parseInt(tempPage);
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 3; // 페이지 버튼 개수
		int startRow = (page - 1) * rowCount + 1;
		int endRow = startRow + rowCount - 1;

		SearchDAO dao = new SearchDAO();
		List<ArticleListDTO> searchResults = null;
		int total = 0;

		// 검색어 기반 게시글 검색
		if (query != null && query.trim().length() >= 2) {
			searchResults = dao.searchArticles(query, startRow, endRow);
			total = dao.getTotalCount(query);
		}
		// 태그 검색
		else if (selectedTag != null && !selectedTag.trim().isEmpty()) {
			searchResults = dao.searchArticlesByTag(selectedTag);
			total = dao.getTotalCountByTag(selectedTag);
		}

		// 빈 검색어 방지
		if (query == null || query.trim().isEmpty()) {
			query = "";
		}

		int realEndPage = (int) Math.ceil(total / (double) rowCount);
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount);
		int startPage = endPage - (pageCount - 1);
		endPage = Math.min(endPage, realEndPage);
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;

		// JSON 데이터 구성
		Map<String, Object> responseData = new HashMap<>();
		responseData.put("query", query);
		responseData.put("page", page);
		responseData.put("startPage", startPage);
		responseData.put("endPage", endPage);
		responseData.put("realEndPage", realEndPage);
		responseData.put("prev", prev);
		responseData.put("next", next);
		responseData.put("total", total);
		responseData.put("searchResults", searchResults);

		// JSON 응답을 요청했으면 JSON 반환하고 종료
		if ("true".equals(isJson)) {
			response.setContentType("application/json; charset=UTF-8");
			Gson gson = new Gson();
			PrintWriter out = response.getWriter();
			
			String jsonResponse = gson.toJson(responseData);
			System.out.println("Json 응답 :" + jsonResponse);
			
			out.print(gson.toJson(responseData));
			out.flush();
			out.close();
			return null;
		}

		//JSP로 이동하는 경우
		request.setAttribute("searchResults", searchResults);
		request.setAttribute("query", query);
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("realEndPage", realEndPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("total", total);

		// Result 객체 반환
		Result result = new Result();
		result.setPath("/app/basic/search.jsp"); // JSON 페이지 이동
		result.setRedirect(false);
		return result;
	}
}
