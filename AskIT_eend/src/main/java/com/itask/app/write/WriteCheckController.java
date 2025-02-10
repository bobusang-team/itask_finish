package com.itask.app.write;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itask.app.Execute;
import com.itask.app.Result;
import com.itask.app.dto.UserDTO;
import com.itask.app.write.dao.WriteDAO;


//회원이면 글쓰기, 비회원이면 로그인화면으로 가게 한다
public class WriteCheckController implements Execute{

	@Override
	public Result execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("WriteCheckController==확인=회원/비회원 구분용 컨트롤러");
		
		WriteDAO writeDAO = new WriteDAO();
		Result result = new Result();
		HttpSession session = request.getSession();
				
		String path = null; //패스를 if 안에서 비회훤/회원을 나눠야하니까 미리 선언해둬
		
		UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        Integer userNum = null;
		
        if (userDTO != null) {
            userNum = userDTO.getUserNum();
        }
        
        System.out.println("userNum 확인: " + userNum);
		
        if (userNum == null) {
            // 비회원이니까 로그인으로 이동
            System.out.println("비회원 확인");
            path = "/app/member/login.jsp";
        } else {
            // 회원이면 글쓰기 화면으로 이동 & userId 가져오기
            System.out.println("회원 확인");
            path = "/app/write/write.jsp";
            request.setAttribute("userId", writeDAO.getUserId(userNum));
        }
		
		result.setPath(path);
		System.out.println(path);//확인용
		result.setRedirect(false); //회원정보 가지고 가야하니까 forward 방식으로 가
		
		return result;
	}

}
