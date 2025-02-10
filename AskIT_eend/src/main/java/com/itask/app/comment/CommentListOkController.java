package com.itask.app.comment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.comment.dao.CommentDAO;
import com.itask.app.dto.ArticleListDTO;

public class CommentListOkController implements Execute{

   @Override
   public Result execute(HttpServletRequest request, HttpServletResponse response)
         throws IOException, ServletException {
	   

      int articleNum = Integer.valueOf(request.getParameter("articleNum"));
      System.out.println("현재 게시글 번호 : " + articleNum);
      System.out.println();
      CommentDAO commentDAO = new CommentDAO();
      System.out.println("commentDAO 객체 생성");
      Gson gson = new Gson();
      JsonArray comments = new JsonArray();
      System.out.println("여기까진 실행되니...?");
      commentDAO.selectAll(articleNum).stream().map(gson::toJson).map(JsonParser::parseString).forEach(comments::add);
      System.out.println("댓글 목록 불러오기 메소드 실행");
      
      int countComment = commentDAO.getTotalComment();
      System.out.println("댓글 수 : " + countComment);
      
      request.setAttribute("countComment", countComment);
      
      System.out.println(comments.toString());
      
      response.setContentType("application/json; charset=utf-8");
      PrintWriter out = response.getWriter();
      out.print(comments.toString());
      out.close();
            
      return null;
   }
   

}
