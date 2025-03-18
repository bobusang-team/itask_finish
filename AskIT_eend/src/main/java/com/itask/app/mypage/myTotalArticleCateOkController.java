
/*fetch 사용시 주석풀것 */
/*
 * package com.itask.app.mypage;
 * 
 * import java.io.IOException; import java.util.HashMap; import java.util.List;
 * import java.util.Map;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.google.gson.Gson; import com.itask.app.Execute; import
 * com.itask.app.Result; import com.itask.app.dto.ArticleListDTO; import
 * com.itask.app.dto.MypageMainDTO; import com.itask.app.dto.UserDTO; import
 * com.itask.app.mypage.dao.MypageDAO;
 * 
 * public class myTotalArticleCateOkController implements Execute {
 * 
 * @Override public Result execute(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * 
 * response.setCharacterEncoding("UTF-8");
 * request.setCharacterEncoding("UTF-8");
 * 
 * Result result = new Result(); HttpSession session = request.getSession();
 * UserDTO thisUser = (UserDTO) session.getAttribute("userDTO"); String path =
 * null;
 * 
 * // 로그인 상태가 아니라면 if (thisUser == null) { path = "/app/member/login.jsp";
 * result.setPath(path); result.setRedirect(true); return result; }
 * 
 * ArticleListDTO articleListDTO = new ArticleListDTO(); MypageDAO mypageDAO =
 * new MypageDAO(); MypageMainDTO mypageMainDTO = new MypageMainDTO();
 * 
 * // 회원 아이디 값 받아오기 String userId = thisUser.getUserId(); //
 * System.out.println("================userId확인용" + userId);
 * 
 * // 쿼리 실행 mypageMainDTO = mypageDAO.mainPageSelect(userId);
 * request.setAttribute("mypageMainDTO", mypageMainDTO);
 * 
 * // 회원 번호 int userNum = thisUser.getUserNum();
 * 
 * String category = request.getParameter("category"); // 요청으로부터 카테고리 받기
 * System.out.println("카테고리 확인: " + category);
 * 
 * Map<String, Object> myMap = new HashMap<>(); myMap.put("userNum", userNum);
 * myMap.put("category", category);
 * 
 * List<ArticleListDTO> myList; if (category != null && !category.equals("전체"))
 * { myList = mypageDAO.selectArticlesByCategory(myMap); // 카테고리가 있는 게시글 조회 }
 * else { myList = mypageDAO.selectAllMy(userNum); // 모든 게시글 조회 }
 * 
 * // JSON 응답 생성 Gson gson = new Gson(); String jsonResponse =
 * gson.toJson(myList); response.setContentType("application/json");
 * response.getWriter().write(jsonResponse);
 * 
 * return null; }
 * 
 * }
 */