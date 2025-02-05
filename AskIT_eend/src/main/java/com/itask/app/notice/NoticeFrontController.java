package com.itask.app.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;

public class NoticeFrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public NoticeFrontController() {
		super();
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
	         throws ServletException, IOException {
		
		System.out.println("notice 서블릿 실행");
		System.out.println(request.getContextPath());
	    System.out.println(request.getRequestURI());
	    
	    String target = request.getRequestURI().substring(request.getContextPath().length());
	    System.out.println(target);
	    
	    Result result = new Result();
	    
	    switch (target) {
	    case "/app/notice/notice.no":
	         System.out.println("공지사항 목록보기");
	         result = new NoticeListController().execute(request, response);
	         System.out.println(result);
	         System.out.println(result.getPath() + "==========");
	         break;
	      case "/app/notice/noticeDetail.no":
	         System.out.println("공지사항 글상세보기");
	         result = new NoticeDetailController().execute(request, response);
	         System.out.println(result);
	         System.out.println(result.getPath() + "==========");
	         break;	     
	      }
	    
	    if (result != null) {
			if (result.isRedirect()) {
				response.sendRedirect(result.getPath());
			} else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}
		
	}

}
