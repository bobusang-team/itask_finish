package com.itask.app.notice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.NoticeListDTO;
import com.itask.app.notice.dao.NoticeDAO;

//공지사항 목록 처리해주는 컨트롤러
public class NoticeListController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("== NoticeListController == 확인");
		
		NoticeDAO noticeDAO = new NoticeDAO();
		Result result = new Result();
		
		String temp = request.getParameter("page");		
//		request.getParameter("page");에서 말하는 "page"는 noticeList.jsp에서 
//		href="${pageContext.request.contextPath}/notice/noticeList.bo?page=${startPage - 1}" 이라는 코드에서 찾아볼 수 있다
//		page=${startPage - 1} 이 부분인데 page라고 그냥 변수처럼 선언해주고 쿼리스트링으로 ${startPage - 1}값을 넣어준 것이다	
		
		int page = (temp == null) ? 1 : Integer.valueOf(temp); //페이지 설정을 기본값 1로 하겠다
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; //페이지 버튼 수
		
		//페이징 처리
		int startRow = (page - 1) * rowCount +1; //시작행(1,11,21,31 ...)	
//		int startRow = (1 - 1) * 10 + 1 
//		page, rowCount는 인덱스 번호로 처리하려고 -1 
		int endRow = startRow + rowCount -1; //끝 행(10,20,30...)
		
		
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		//게시글 목록 조회
		List<NoticeListDTO> noticeList = noticeDAO.selectAll(pageMap);
		request.setAttribute("noticeList", noticeList);
		
		//페이징 정보 설정
		// NoticeMapper.xml 의 getTotal을 이용해서 전체 게시글 갯수 조회
		// 실제 마지막 페이지 번호(realEndPage)를 계산함
		int total = noticeDAO.getTotal(); //총 게시글 수를 total에 저장함
		
		int realEndPage = (int) Math.ceil(total / (double) rowCount); //전체 게시글 기준으로 실제 마지막 페이지
//		int 진짜마지막페이지 = (int강제형변환) 올림처리(전체게시글수 / (실수강제형변환) 한페이지당게시글수10개)
		
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); //현재 페이지 그룹 기준으로 마지막 페이지
//		int 현재그룹마지막페이지 = (강제형변환) (올림처리 (현재페이지 / (실수강제형변환) 페이지버튼수5) * 페이지버튼수5)
		
		int startPage = endPage - (pageCount -1 ); //현재 페이지 그룹에서의 첫 페이지
//		int 현재그룹시작페이지 = 현재그룹마지막페이지 - (페이지버튼수5 - 1)		
		
//      startPage = Math.max(startPage, 0);
		endPage = Math.min(endPage, realEndPage); // endPage가 실제 존재하는 마지막 페이지(realEndPage)보다 크면 조정한다
//		현재그룹마지막페이지 = 둘중작은걸로 넣어줘(현재그룹마지막페이지, 진짜마지막페이지)
		
		//prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1; 
		boolean next = endPage < realEndPage;
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		request.setAttribute("realEndPage", realEndPage);
		// realEndPage는 이 컨트롤러에서만 사용하고 다른곳에서는 꺼내서 쓸 필요가 없기 때문에 request에 저장하지 않는다
		
		System.out.println("== 페이징 정보 확인 ==");
		System.out.println("== pageMap : " + pageMap);
		System.out.println("== noticeList : " + noticeList);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next" + next);
		System.out.println("== 페이징 정보 확인 끝 ==");
		
		result.setPath("/app/notice/notice.jsp");
		result.setRedirect(false);
		
		
		
		return result;
	}
	
	

}
