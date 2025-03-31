package com.itask.app.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.ArticleDetailDTO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.AttachedFileDTO;
import com.itask.app.dto.UserDTO;
import com.itask.app.mypage.dao.MypageDAO;
import com.itask.app.write.dao.AttachedFileDAO;

public class myArticleDetailOkController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Result result = new Result();
		MypageDAO mypageDAO = new MypageDAO();
		
		HttpSession session = request.getSession();
		UserDTO thisUser = (UserDTO) session.getAttribute("userDTO");
		ArticleListDTO articleListDTO = new ArticleListDTO();
		AttachedFileDAO attachedFileDAO = new AttachedFileDAO();
		String path = null;
		
		
		
		// 로그인 상태가 아니라면
		if (thisUser == null) {
			path = request.getContextPath() + "/app/member/login.jsp";
			result.setPath(path);
			result.setRedirect(true);
		}
		path = "/app/article/dev/askDetail.jsp";

		int articleNum = Integer.parseInt(request.getParameter("articleNum"));
//		System.out.println("해당 articleNum: " + articleNum);
		 List<AttachedFileDTO> files = attachedFileDAO.select(articleNum);
		// 게시글 상세 불러오는 쿼리 실행
		articleListDTO = mypageDAO.selectArticleDetail(articleNum);
		articleListDTO.setFiles(files);
//		System.out.println("프컨에서 articleDetailDTO 확인 " + articleListDTO);
		
		request.setAttribute("dev", articleListDTO);
		
		result.setPath(path);
		result.setRedirect(false);

		return result;
	}

}
