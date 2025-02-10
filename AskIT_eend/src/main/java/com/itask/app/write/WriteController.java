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

		// 선택한 카테고리에 따라 글 작성 완료후 경로 설정을 다 따로 해줘야 해서 path 변수 미리 선언
		String path = null;

		if (userDTO != null) {
			articleDTO.setUserNum(userDTO.getUserNum());
		}

		// 첨부파일 업로드
//		final String UPLOAD_PATH = "C:/kdt/TEAM_boboosang/itask_finish/AskIT_eend/src/main/webapp/assets/upload";
////		final String UPLOAD_PATH = request.getSession().getServletContext().getRealPath("/") + "app/assets/upload/";
//		final int FILE_SIZE = 1024 * 1024 * 5; // 5mb
//		System.out.println("파일 업로드 경로 : " + UPLOAD_PATH);
//
//		MultipartRequest multipartRequest = new MultipartRequest(request, UPLOAD_PATH, FILE_SIZE, "utf-8",
//				new DefaultFileRenamePolicy());
		// 이 부분을 설정하니까 안보이던 게시글 제목이 보이게 되었다.

		String topCate = request.getParameter("topCate");
		String botCate = request.getParameter("botCate");
		String tagDev = request.getParameter("tagDev");
		String tagSec = request.getParameter("tagSec");
		String tagQual = request.getParameter("tagQual");

		//글쓰기시 잘 작동함
		articleDTO.setUserNum(userDTO.getUserNum());
		articleDTO.setArticleTopCate(request.getParameter("topCate"));
		articleDTO.setArticleBotCate(request.getParameter("botCate"));
		articleDTO.setArticleTitle(request.getParameter("title"));
		articleDTO.setArticleText(request.getParameter("content"));
		
//		multipartRequest를 써서 글쓰기 실행
		
//		articleDTO.setUserNum(userDTO.getUserNum());
//		articleDTO.setArticleTopCate(multipartRequest.getParameter("topCate"));
//		articleDTO.setArticleBotCate(multipartRequest.getParameter("botCate"));
//		articleDTO.setArticleTitle(multipartRequest.getParameter("title"));
//		articleDTO.setArticleText(multipartRequest.getParameter("content"));
		

		// 대분류/중분류 별 경로 설정
		if (topCate.equals("개발") && botCate.equals("질문")) { // 개발-질문
			path = "/app/article/dev/ask.jsp";
		} else if (topCate.equals("개발") && botCate.equals("꿀팁")) {// 개발-꿀팁
			path = "/app/article/dev/tip.jsp";
		} else if (topCate.equals("보안") && botCate.equals("질문")) { // 보안-질문
			path = "/app/article/sec/ask.jsp";
		} else if (topCate.equals("보안") && botCate.equals("꿀팁")) {// 보안-꿀팁
			path = "/app/article/sec/tip.jsp";
		} else if (topCate.equals("자격증") && botCate.equals("질문")) { // 자격증-질문
			path = "/app/article/qual/ask.jsp";
		} else if (topCate.equals("자격증") && botCate.equals("꿀팁")) {// 자격증-꿀팁
			path = "/app/article/qual/tip.jsp";
		}

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

//		첨부파일코드 작성시 여기도 주석해제
//		int articleNum = articleDTO.getArticleNum();
//		System.out.println("생성된 게시글 번호 : " + articleNum);
		
		AttachedFileDTO attachedFileDTO = new AttachedFileDTO();

//		만약 첨부파일이 있다면 첨부파일 업로드 처리하기
//		if(//조건식 어떻게 써야함?) {
//			
//			// 파일업로드 처리
//			// Enumeration : java.util 패키지에 포함된 인터페이스, Iterator와 비슷한 역할
//
//			Enumeration<String> fileNames = multipartRequest.getFileNames();
//			while (fileNames.hasMoreElements()) { // 하나씩 꺼내오자~
//				String name = fileNames.nextElement();
//				String attachedfileName = multipartRequest.getFilesystemName(name); // 네임을 매개변수로 넣어줌
//				
//				if (attachedfileName == null) {
//					continue;
//				}
//				
//				attachedFileDTO.setArticleNum(articleNum);
//				attachedFileDTO.setAttachedFileName(attachedfileName);
//
//				System.out.println("업로드된 파일 정보 : " + attachedFileDTO);
//				AttachedFileDAO attachedFileDAO = new AttachedFileDAO();
//				attachedFileDAO.insert(attachedFileDTO);
//
//			}
//			// 파일업로드 처리끝			
//		}
		

		// 결과 설정
		result.setRedirect(true);
		result.setPath(request.getContextPath() + path); // 해당 게시판으로 이동하게 위에서 분기점 나눠주었음.
		return result;

	}

}
