package com.itask.app.member;

<<<<<<< HEAD
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

=======
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
import com.google.gson.Gson;
import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.member.dao.UserDAO;

<<<<<<< HEAD
=======
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
public class CheckIdDuplicateController implements Execute {

    private UserDAO userDAO = new UserDAO();
    private Gson gson = new Gson();  // GSON 객체 생성

    @Override
    public Result execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userId = request.getParameter("userId");

        boolean exists = false;
        
        exists = userDAO.isId(userId); // 아이디 중복 확인

        // GSON을 이용해 JSON 응답 생성 (일단 아이디만)
        String jsonResponse = gson.toJson(new CheckResponse(exists));
        

        // 응답 처리
        response.setContentType("application/json; charset=UTF-8");
        response.getWriter().write(jsonResponse);

        return null;  // 결과 페이지로 이동하지 않음
    }

    // JSON 응답 형식 클래스
    private class CheckResponse {
        private boolean exists;

        public CheckResponse(boolean exists) {
            this.exists = exists;
        }

        public boolean isExists() {
            return exists;
        }
    }
}
