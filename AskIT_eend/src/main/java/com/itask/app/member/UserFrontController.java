package com.itask.app.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;

/**
 * Servlet implementation class UserFrontController
 */
public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public UserFrontController() {
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
	      System.out.println("user 서블릿 실행");
	      
	      
	      System.out.println(request.getContextPath());
	      System.out.println(request.getRequestURI());

	      String target = request.getRequestURI().substring(request.getContextPath().length());
	      System.out.println(target);
	      
	      Result result = null;

	      switch (target) {
	      case "/member/joinOk.me":
	         System.out.println("joinOk!!");
	         //sqlSession을 이용한다
	         result = new JoinOkController().execute(request, response);
	         System.out.println(result);
	         System.out.println(result.getPath() + "==========");
	         break;
	      case "/member/loginOk.me":
	    	  System.out.println("loginOk!!");
	    	  result = new LoginOkController().execute(request, response);
	    	  break;
	      case "/member/pwFindOk.me":
	    	  System.out.println("pwfindOK!!");
	    	  result = new PwfindOkController().execute(request, response);
	    	  break;
	      case "/member/pwresetOk.me":
	    	  System.out.println("pwresetOk!!");
	    	  result = new PwresetOkController().execute(request, response);
	    	  break;
	      case "/app/member/checkIdOk.me":
	    	  System.out.println("join checkIdOk");
	    	  result = new CheckIdDuplicateController().execute(request, response);
	    	  break;
	      case "/app/member/checkNickOk.me":
	    	  System.out.println("join checkNickOk");
	    	  result = new CheckNickDuplicateController().execute(request, response);
	    	  break;
	      case "/app/member/sendSMS.me":
	    	  System.out.println("sendSMS OK");
	    	  result = new JoinSMSController().execute(request, response);
	    	  break;
	      case "/app/member/verifyCode.me":
	    	  System.out.println("/member/verifyCode.me");
	    	  result = new VerifyCodeController().execute(request, response);
	    	  break;
	      case "/app/member/agreeOK.me":
	    	  System.out.println("선택약관 동의 프컨");
	    	  result = new AgreementOkController().execute(request, response);
	    	  break;
	      case "/app/member/certOk.me":
	    	  System.out.println("자격증 초기화 프컨 ");
	    	  result = new CertInitController().execute(request, response);
	    	  break;
	      case "/app/member/checkMailOk.me":
	    	  System.out.println("이메일 중복체크 프컨");
	    	  result = new CheckMailDuplicateController().execute(request, response);
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