package com.itask.app.dev;

import java.io.IOException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dev.dao.DevDAO;
import com.itask.app.dto.ArticleListDTO;
import com.itask.app.dto.UserDTO;

public class DevDetailAskController implements Execute {

    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Result result = new Result();
        String articleNumStr = request.getParameter("articleNum");
        System.out.println("현재 게시글 번호: " + articleNumStr);

        if (articleNumStr == null || articleNumStr.trim().isEmpty()) {
            System.out.println("articleNum 값이 없습니다.");
            result.setPath("/app/article/dev/ask.jsp"); // 게시글 목록 페이지로 리다이렉트
            result.setRedirect(true);
            return result;
        }

        int articleNum = Integer.parseInt(articleNumStr);

        DevDAO devDAO = new DevDAO();
        ArticleListDTO articleListDTO = devDAO.selectOne(articleNum);
        System.out.println(articleListDTO);

        if (articleListDTO == null) {
            System.out.println("존재하지 않는 게시글 입니다." + articleNum);
            result.setPath("/app/board/boardList.jsp");
            result.setRedirect(true);
            return result;
        }

        
        HttpSession session = request.getSession();
        UserDTO thisUser = null;
        int loginUserNum = -1;
        boolean isLoggedIn = false;

        try {
            thisUser = (UserDTO) session.getAttribute("userDTO");

            if (thisUser != null) {
                loginUserNum = thisUser.getUserNum();
                isLoggedIn = true;
                System.out.println("로그인한 멤버 번호 : " + loginUserNum);
                session.setAttribute("userNum", loginUserNum);
            } else {
                System.out.println("로그인하지 않은 사용자입니다.");
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        

        // 게시글 정보 가져오기 (JSP에서 사용할 수 있도록 설정)
        request.setAttribute("dev", articleListDTO);
        request.setAttribute("devDetail", articleListDTO);
        request.setAttribute("isLoggedIn", isLoggedIn);
        request.setAttribute("userNum", loginUserNum != -1 ? loginUserNum : null);
        System.out.println("현재 게시글 정보 : " + articleListDTO);

        int articleWriterNum = articleListDTO.getUserNum();
        System.out.println("현재 게시글 작성자 번호 : " + articleWriterNum);
        
        int detailArticleNum = articleListDTO.getArticleNum();
        System.out.println("현재 게시글 번호 : " + detailArticleNum);
        
        String detailArticleTopcate = articleListDTO.getArticleTopcate();
        System.out.println("현재 게시글 카테고리 : " + detailArticleNum);
        
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write("{\"articleNum\": " + articleNum + "}");

        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write("{\"articleWriterNum\": " + articleWriterNum + "}");

        
        if (loginUserNum != -1 && !Objects.equals(loginUserNum, articleWriterNum)) {
            devDAO.increaseView(articleNum);
        }

        result.setPath("/app/article/dev/askDetail.jsp");
        result.setRedirect(false);
        return result;
    }
}
