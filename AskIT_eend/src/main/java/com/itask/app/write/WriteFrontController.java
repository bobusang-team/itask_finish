package com.itask.app.write;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Result;

/**
 * Servlet implementation class WriteFrontController
 */
@WebServlet("/WriteFrontController")
public class WriteFrontController extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doProcess(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
	   request.setCharacterEncoding("UTF-8"); //한글깨짐 방지
      doProcess(request, response);
   }
   
   protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
   
	   
      System.out.println(request.getContextPath());
      System.out.println(request.getRequestURI());
      
       // 요청 URI에서 필요한 경로만 추출
        String target = request.getRequestURI().substring(request.getContextPath().length());
        System.out.println(request.getContextPath() + "컨텍스트패스");
        System.out.println(target + "타겟");
        Result result = new Result();
        
      switch (target) {
        case "/app/write/write.wr": // 글쓰기
            System.out.println("회원/비회원체크하기");
            result = new WriteCheckController().execute(request, response);
//            request.getRequestDispatcher("/app/write/write.jsp").forward(request, response);
            break;
            
        case "/app/write/writeOk.wr": // 글쓰기 성공
            System.out.println("글쓰기시작");
            result = new WriteController().execute(request, response);     
            break;
            
      }

        // 결과 처리
        
      if (result != null) {
            if (result.isRedirect()) {
            	System.out.println("경로확인용 : "+ result.getPath());
                response.sendRedirect(result.getPath());
            } else {
            	System.out.println("경로확인용2 : "+ result.getPath());
                request.getRequestDispatcher(result.getPath()).forward(request, response);
            }
        }
       
   
   }
   
   
   

}
