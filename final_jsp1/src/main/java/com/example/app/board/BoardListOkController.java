package com.example.app.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.Result;
import com.example.app.board.dao.BoardDAO;
import com.example.app.dto.BoardListDTO;

public class BoardListOkController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		System.out.println("====================== BoardListOkController");
		
		BoardDAO boardDAO = new BoardDAO();
		Result result = new Result();
		
		String temp = request.getParameter("page"); // jsp에서 쿼리스트링으로 전달되는 파라미터값임
		int page = (temp == null) ? 1 : Integer.valueOf(temp); // 페이지번호 기본값 : 1 ( 페이지 네이션 쪽)
		int rowCount = 10; // 한 페이지당 게시글 수
		int pageCount = 5; // 페이지 버튼 수
		
		// 페이징 처리
		int startRow = (page - 1) * rowCount + 1; // 시작행(1, 11, 21) ( 한 페이지에 보이는 게시물의 시작 )
		int endRow = startRow + rowCount - 1; // 끝 행(10, 20, 30) ( 한 페이지에 보이는 게시물의 끝 )
		
		Map<String, Integer> pageMap = new HashMap<>();
		pageMap.put("startRow", startRow);
		pageMap.put("endRow", endRow);
		
		//게시글 목록 조회
		List<BoardListDTO> boardList = boardDAO.selectAll(pageMap);
		request.setAttribute("boardList", boardList);
		
		// 게시글의 총 개수를 먼저 알아와야함
		int total = boardDAO.getTotal();
		
		// 올림 함수를 사용해서 페이지네이션 총 수를 구해야함
		int realEndPage = (int) Math.ceil(total/ (double) rowCount); // 리얼 마지막 페이지 네이션
		int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현재 페이지를 기준으로 보여주는 페이지네이션 그룹
		int startPage = endPage - (pageCount - 1); //현재 페이지 그룹에서의 첫 페이지
		
		// 음수 페이지가 start 인 것을 방지
//      startPage = Math.max(startPage, 0);
		endPage = Math.min(endPage, realEndPage); // endPage가 실제 존재하는 마지막 페이지(realEndPage)보다 크면 조정
		
		//prev, next 버튼 활성화 여부 확인
		boolean prev = startPage > 1;
		boolean next = endPage < realEndPage;
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("prev", prev);
		request.setAttribute("next", next);
		
		System.out.println("=======페이징 정보확인===========");
		System.out.println("== pageMap : " + pageMap);
		System.out.println("== pageMap : " + pageMap);
		System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev+ ", next : " + next );
		System.out.println("===============================");
		
		result.setPath("/app/board/boardList.jsp");
		result.setRedirect(false);
		
		return result;
	}
	
}
