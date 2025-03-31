package com.itask.app.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;

/**
 * Servlet implementation class MainFrontController
 */
//@WebServlet("*.main")
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MainFrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(request.getContextPath().length() + "길이!!! ===========");
		System.out.println("Request URI:" + request.getRequestURI());
		System.out.println("Context Path:" + request.getContextPath());
		System.out.println("Target:" + target);

		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());

		Result result = null;

		switch (target) {
//		case "/AskIT":
//			System.out.println("메인페이지 =============");
//			break;

		case "/ranking/mainRank.main": // 명예의 전당
			System.out.println("확인========명예의 전당 =========");
			result = new RankingController().execute(request, response);
			break;

		case "/bestArticles/mainBestArticles.main": // 질문 꿀팁
			System.out.println("확인~~~~~~~~~질문 꿀팁~~~~~~~~~~~~");
			result = new BestArticlesController().execute(request, response);
			if (result == null) {
				return;
			}
			break;
		case "/notice/mainNotices.main": // 공지사항
			System.out.println("확인**********공지사항************");
			new MainNoticeController().execute(request, response);
			return;
//		
//		case "/tag/filterTag.main": // 태그별 게시글 필터링
//			System.out.println("태그 필터링 요청 실행!");
//			System.out.println("요청 태그 : " + request.getParameter("tag"));
//			new TagFilterController().execute(request, response);
//				return;
//				
		case "/search/mainSearch.main": // 검색어 받아옴
			System.out.println("!!!!!!!검색어 받아옴");
			result = new SearchController().execute(request, response);
			
			if (result == null || result.getPath() == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "검색 결과 페이지를 찾을 수 없습니다.");
				return;
			}
			break;

		default:
			result = new Result();
			result.setPath("/error/404.jsp");
			result.setRedirect(false);
			break;
		}
		
		if (command.equals("/search/mainSearch.main")) {
			result = new SearchController().execute(request, response);	
		}

		if (command.equals("bestArticles/mainBestArticles.main")) {
	        result = new BestArticlesController().execute(request, response);
	    }
		
		if (result != null) {
			if (result.getPath() == null) {
				response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "RequestDispatcher의 경로가 null입니다");
				return;
			}
			
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(result.getPath());
				if (dispatcher == null) {
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "RequestDispatcher를 찾을 수 없습니다");
					return;
				}
				dispatcher.forward(request, response);
			}
		} else {
			if (result == null) {
				if (!response.isCommitted()) {
					response.sendError(HttpServletResponse.SC_NOT_FOUND, "Result 객체가 null");
				}
			}
		}
	}
}
	
