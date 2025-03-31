package com.itask.app.write;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.ArticleDTO;
import com.itask.app.dto.AttachedFileDTO;
import com.itask.app.dto.UserDTO;
import com.itask.app.write.dao.AttachedFileDAO;
import com.itask.app.write.dao.WriteDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class WriteController implements Execute {

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("WriteController==확인");
		ArticleDTO articleDTO = new ArticleDTO();
		WriteDAO writeDAO = new WriteDAO();
		Result result = new Result();

		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
		System.out.println("Session UserDTO: " + userDTO); // 디버깅용

		///
		
//        UserDTO thisUser = null;
//        int loginUserNum = -1;
//        boolean isLoggedIn = false;
//
//        try {
//            thisUser = (UserDTO) session.getAttribute("userDTO");
//
//            if (thisUser != null) {
//                loginUserNum = thisUser.getUserNum();
//                isLoggedIn = true;
//                System.out.println("로그인한 멤버 번호 : " + loginUserNum);
//                session.setAttribute("userNum", loginUserNum);
//            } else {
//                System.out.println("로그인하지 않은 사용자입니다.");
//            }
//        } catch (Exception e) {
//            System.out.println("예외 발생: " + e.getMessage());
//        }
        
        
        
        /////
        
        
        
		// 선택한 카테고리에 따라 글 작성 완료후 경로 설정을 다 따로 해줘야 해서 path 변수 미리 선언
		String path = null;

		if (userDTO != null) {
			articleDTO.setUserNum(userDTO.getUserNum());
		}

		// 첨부파일 업로드
		final String UPLOAD_PATH = "C:/itask_finish2/AskIT_eend/src/main/webapp/assets/upload";
//		final String UPLOAD_PATH = request.getServletContext().getRealPath("/") + "app/assets/upload/";
		final int FILE_SIZE = 1024 * 1024 * 5; // 5mb
		System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);

		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
				new DefaultFileRenamePolicy());
//		 이 부분을 설정하니까 안보이던 게시글 제목이 보이게 되었다.

		String topCate = multipartRequest.getParameter("topCate");
	    String botCate = multipartRequest.getParameter("botCate");
	    String tagDev = multipartRequest.getParameter("tagDev");
	    String tagSec = multipartRequest.getParameter("tagSec");
	    String tagQual = multipartRequest.getParameter("tagQual");

		//글쓰기시 잘 작동함
//		articleDTO.setUserNum(userDTO.getUserNum());
//		articleDTO.setArticleTopCate(request.getParameter("topCate"));
//		articleDTO.setArticleBotCate(request.getParameter("botCate"));
//		articleDTO.setArticleTitle(request.getParameter("title"));
//		articleDTO.setArticleText(request.getParameter("content"));
	    
	    articleDTO.setUserNum(userDTO.getUserNum());
	    articleDTO.setArticleTopCate(topCate);
	    articleDTO.setArticleBotCate(botCate);
	    articleDTO.setArticleTitle(multipartRequest.getParameter("title"));
	    articleDTO.setArticleText(multipartRequest.getParameter("content"));

	    
		// 태그네임 선택된것만 넣기
		if (topCate.equals("개발") && tagDev != null) {
			articleDTO.setArticleTagName(tagDev);
		} else if (topCate.equals("보안") && tagSec != null) {
			articleDTO.setArticleTagName(tagSec);
		} else if (topCate.equals("자격증") && tagQual != null) {
			articleDTO.setArticleTagName(tagQual);
		}

		// 콘솔 확인용
		System.out.println(userDTO.getUserNum());
		System.out.println("카테고리 확인용 : " + topCate + botCate + tagDev + tagSec + tagQual);
		System.out.println(articleDTO);

	    // 글쓰기 실행
	    writeDAO.insertArticle(articleDTO);
	    int articleNum = articleDTO.getArticleNum();
		System.out.println("생성된 게시글 번호 : " + articleNum);

		AttachedFileDTO attachedFileDTO = new AttachedFileDTO();		


		// 첨부파일 있다면 첨부파일 처리
		Enumeration<String> fileNames = multipartRequest.getFileNames();
		while (fileNames.hasMoreElements()) {
		    String name = fileNames.nextElement();
		    String attachedfileName = multipartRequest.getFilesystemName(name);

		    if (attachedfileName != null) {
		        attachedFileDTO.setArticleNum(articleNum);
		        attachedFileDTO.setAttachedFileName(attachedfileName);

		        System.out.println("업로드된 파일 정보 : " + attachedFileDTO);

		        AttachedFileDAO attachedFileDAO = new AttachedFileDAO();
		        int attachedFileNum = attachedFileDAO.insert(attachedFileDTO);//첨부파일 번호 받아오기
		        System.out.println("생성된 첨부파일 번호: " + attachedFileNum); 
		    }
		}
		
		// 글쓰기 완료 후 본인이 쓴 게시물 상세보기로 바로 넘어간다
		path = "/dev/detailAsk.dev?articleNum=" + articleNum;

		// 결과 설정
		result.setRedirect(true);
		result.setPath(request.getContextPath() + path); // 해당 게시판으로 이동하게 위에서 분기점 나눠주었음.
		return result;

	}

}
