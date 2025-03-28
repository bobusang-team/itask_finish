package com.itask.app.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.ArticleAdminDTO;
import com.itask.app.dto.CommentAdminDTO;

public class ArticleDetailController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("articleNum") + "=================");
		int articleNum = Integer.parseInt(request.getParameter("articleNum"));
//        String articleNumber = request.getParameter("articleNum");
		System.out.println(articleNum);

		AdminDAO adminDAO = new AdminDAO();
		System.out.println("게시글 정보받기전");
		ArticleAdminDTO article = adminDAO.ArticleDetail(articleNum); // 게시글 정보 가져오기
		System.out.println("게시글 정보받은 후");
        List<CommentAdminDTO> comments = adminDAO.Comment(articleNum); // 댓글 리스트 가져오기
		request.setAttribute("article", article);
        request.setAttribute("comments", comments); 
     // 댓글 번호 출력 (예시)
        for (CommentAdminDTO comment : comments) {
            System.out.println("댓글 번호: " + comment.getCommentNum()); // getCommentNum() 메서드로 댓글 번호 확인
        }
        
        // 댓글 리스트의 총 갯수를 저장
        int commentCount = comments.size();
        request.setAttribute("commentCount", commentCount); // 댓글 갯수 저장
		Result result = new Result();
		
		System.out.println(article.getArticleTopCate());
		String topCate = article.getArticleTopCate();
		if(topCate.equals("개발")) {
		    result.setPath("/app/admin/articleDevDetail.jsp");
		}
		else if(topCate.equals("보안")) {
		    result.setPath("/app/admin/articleSecDetail.jsp");
		}
		else if(topCate.equals("자격증")) {
		    result.setPath("/app/admin/articleQualDetail.jsp");
		}
		result.setRedirect(false);
		return result;
	}
}