//package com.itask.app.main;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.google.gson.Gson;
//import com.itask.app.Execute;
//import com.itask.app.Result;
//import com.itask.app.dto.ArticleDTO;
//import com.itask.app.main.dao.ArticleDAO;
//
//public class TagFilterController implements Execute{
//
//	@Override
//	public Result execute(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String selectedTag = request.getParameter("tag"); // 사용자가 선택한 태그
//		System.out.println("전달된 태그 확인 :" + selectedTag);
//		
//		if (selectedTag == null || selectedTag.trim().isEmpty()) {
//			response.sendError(HttpServletResponse.SC_BAD_REQUEST, "태그 값이 없습니다.");
//			return null;
//		}
//
//		// DAO를 통해 태그별 게시글 가져오기
//		ArticleDAO dao = new ArticleDAO();
//		List<ArticleDTO> filteredArticles = dao.getArticlesByTag(selectedTag);
//		System.out.println("필터링된 게시글 수 :" + filteredArticles.size());
//		
//		// JSON 변환
//		Gson gson = new Gson();
//		String json = gson.toJson(filteredArticles);
//
//		// JSON 응답 처리
//		response.setContentType("application/json; charset=UTF-8");
//		response.getWriter().write(json);
//
//		return null;
//	}
//}