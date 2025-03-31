package com.itask.app.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.admin.dao.AdminDAO;
import com.itask.app.dto.UserAdminDTO;

public class SearchMemberController implements Execute {

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDAO adminDAO = new AdminDAO();
        Result result = new Result();
        
        // 'search' 파라미터 가져오기
        String search = request.getParameter("search");
        String temp = request.getParameter("page");
        System.out.println("검색어: " + search);
        
        // 페이지 번호 기본값 설정
        int page = (temp == null) ? 1 : Integer.valueOf(temp);
        int rowCount = 10; // 한 페이지당 게시글 수
        int pageCount = 5; // 페이지 버튼 수

        // 페이징 처리
        int startRow = (page - 1) * rowCount + 1; // 시작 행 (1, 11, 21)
        int endRow = startRow + rowCount - 1; // 끝 행 (10, 20, 30)
        System.out.println(startRow);
        System.out.println(endRow);
        // pageMap에 페이징 정보와 search 값을 담아서 전달
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("startRow", startRow);
        pageMap.put("endRow", endRow);
        pageMap.put("search", search); // search 값 추가

        // 회원 목록 가져오기
        List<UserAdminDTO> users = adminDAO.SearchMember(pageMap);  // 인자 수정: pageMap을 전달
        for (UserAdminDTO user : users) {
            System.out.println("회원 데이터: " + user);
        }

        // 회원 목록을 request 객체에 담아서 JSP로 전달
        request.setAttribute("users", users);
        // 전체 게시글 수로 실제 페이지 계산
        int total = adminDAO.getSearchTotal(search); // 총 게시글 수
        int realEndPage = (int) Math.ceil(total / (double) rowCount); // 전체 게시글 수로 실제 마지막 페이지 계산
        int endPage = (int) (Math.ceil(page / (double) pageCount) * pageCount); // 현 페이지 그룹의 마지막 페이지
        int startPage = endPage - (pageCount - 1); // 현 페이지 그룹의 첫 페이지

        // endPage가 실제 마지막 페이지보다 크면 조정
        endPage = Math.min(endPage, realEndPage);
        
        // prev, next 버튼 활성화 여부 확인
        boolean prev = startPage > 1;
        boolean next = endPage < realEndPage;

        // 페이징 관련 데이터를 request에 저장
        request.setAttribute("page", page);
        request.setAttribute("startPage", startPage);
        request.setAttribute("endPage", endPage);
        request.setAttribute("prev", prev);
        request.setAttribute("next", next);
        request.setAttribute("search", search);

        System.out.println("====페이징 정보 확인====");
        System.out.println("pageMap : " + pageMap);
        System.out.println("users : " + users);
        System.out.println("startPage : " + startPage + ", endPage : " + endPage + ", prev : " + prev + ", next : " + next);
        System.out.println("===================");

        // 결과 페이지 설정
        result.setPath("/app/admin/searchMember.jsp");
        result.setRedirect(false);
        return result;
    }
}
