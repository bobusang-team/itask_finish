package com.itask.app.admin;

import java.io.IOException;
import java.nio.file.spi.FileSystemProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;

/**
 * Servlet implementation class MemberFrontController
 */
//@WebServlet("/MemberFrontController")
public class AdminFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminFrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //한글깨짐 방지
		doProcess(request, response);
	}

	// get과 post를 구분하지 않고 사용할 것이다
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("member 서블릿 실행");

		// request.getContextPath() URL 루트경로를 의미
		System.out.println(request.getContextPath());

		// request.getRequestURI 현재 요청의 URI를 의미
		System.out.println(request.getRequestURI());

		// 요청url이 뭔지 구분하기
		// 우리가 필요한 것은 전체 URI에서 ContextPath를 제외시킨 부분이다
		String target = request.getRequestURI().substring(request.getContextPath().length());
		System.out.println(target);
		
		Result result = new Result(); //+++++

		switch (target) {
		case "/admin/adminLogin.ad": 
			System.out.println("adminlogin");
			request.getRequestDispatcher("/app/admin/adminLogin.jsp").forward(request, response);
			break;
		case "/admin/adminLoginOk.ad":
			System.out.println("adminLoginOk" + request.getParameter("adminId"));
			result = new AdminLoginOkController().execute(request, response);
			break;
		case "/admin/basic/totalMember.ad":
			System.out.println("totalMember");
			result = new TotalMemberController().execute(request, response);
			break;
		case "/admin/generalMember.ad":
			System.out.println("generalMember");
			result = new GeneralMemberController().execute(request, response);
			break;
		case "/admin/mentoMember.ad":
			System.out.println("mentoMember");
			result = new MentoMemberController().execute(request, response);
			break;
		case "/admin/notice.ad":
			System.out.println("notice");
			result = new NoticeController().execute(request, response);
			break;
		case "/admin/tipDev.ad":
			System.out.println("tipdev");
			result = new TipDevController().execute(request, response);
			break;
		case "/admin/tipSec.ad":
			System.out.println("tipsec");
			result = new TipSecController().execute(request, response);
			break;
		case "/admin/tipQual.ad":
			System.out.println("tipqual");
			result = new TipQualController().execute(request, response);
			break;
		case "/admin/askDev.ad":
			System.out.println("askdev");
			result = new AskDevController().execute(request, response);
			break;
		case "/admin/askSec.ad":
			System.out.println("asksec");
			result = new AskSecController().execute(request, response);
			break;
		case "/admin/askQual.ad":
			System.out.println("askqual");
			result = new AskQualController().execute(request, response);
			break;
		case "/admin/write.ad":
			System.out.println("write");	
			request.getRequestDispatcher("/app/admin/write.jsp").forward(request, response);
			break;
		case "/admin/writeOk.ad":
			System.out.println("writeOk");
			result = new WriteController().execute(request, response);
			break;
		case "/admin/logout.ad":
			System.out.println("logout");
			result = new LogoutController().execute(request, response);
			break;
		case "/admin/articleDetail.ad":
			System.out.println("aricleDetail");
			result = new ArticleDetailController().execute(request, response);
			break;
		case "/admin/AddComment.ad":
			System.out.println("addComment");
			result = new AddCommentController().execute(request, response);
			break;
		}
		
		if(result != null) {
			if(result.isRedirect()) {
				response.sendRedirect(result.getPath());
			}else {
				request.getRequestDispatcher(result.getPath()).forward(request, response);
			}
		}

	}

}
