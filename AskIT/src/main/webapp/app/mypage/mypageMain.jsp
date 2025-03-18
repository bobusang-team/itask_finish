<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
<%@ page import="com.itask.app.dto.MypageMainDTO" %>
<!-- 마이페이지-일반회원 -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>My Page</title>
<!-- 헤더 추가시 오류발생..ㅠㅠ  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/mypage/mypageMain.css" />
</head>
<body>
   <!-- 헤더 추가시 오류발생..ㅜㅜ -->
   <jsp:include page="./../basic/userheader.jsp"/>
   <main class="itAskBox">
      <!-- 마이페이지 페이지 제목 -->
      <h3>마이페이지</h3>
      <!-- 좌측 프로필사진 -->
      <section class="keh-mypageMain-profile-left">
         <!-- 프로필사진 - 내 정보 -->
         <ul>
            <li class="keh-mypageMain-pic">
               <div></div>
            </li>
            <li class="keh-mypageMain-memType">
            <!-- 일반회원/멘토회원 표시하는 부분 -->
               <%
               UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");
               MypageMainDTO userInfo2 = (MypageMainDTO) session.getAttribute("MypageMainDTO");
<<<<<<< HEAD
               
               
=======
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
               if (userInfo == null) {
                   // 세션에 유저 정보가 없는 경우 -> 로그인 페이지
                   response.sendRedirect(request.getContextPath() + "/app/member/login.jsp");
                   return;
               }
               
               
               System.out.println(session);
               System.out.println(userInfo);
             
<<<<<<< HEAD
               char userCert = userInfo.getUserCert();
               if (userCert == 'T') {
                  out.println("멘토회원🏅");
               } else if (userCert == 'F') {
=======
               boolean userCert = userInfo.isUserCert();
               if (userCert == true) {
                  out.println("멘토회원🏅");
               } else if (userCert == false) {
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
                  out.println("일반회원");
               }
               
               %>
               <%-- <h1><%= userInfo.getUserId() %></h1> --%>
               <span><img src="" alt="멘토뱃지"></span>
            </li>
            <li class="keh-mypageMain-memNickName">
            <!-- 닉네임을 표시하는 부분 -->
            <%
                    String userNick = userInfo.getUserNick();
                    out.println(userNick+"님");
            %>
            </li>
            <li class="keh-mypageMain-myMonitor"><img
               src="${pageContext.request.contextPath}/assets/img/Monitor.png" alt=""> 
               <!-- 인치 표시하는 부분 -->
               <b>
               <%

                  int userInch = Integer.parseInt(userInfo.getUserMoniter())/100;
                  out.println(userInch);
               
               %>
               </b>inch 
               <!-- 모니터 표시하는 부분 -->
               <b>
               <%
                   int userMonitor = Integer.parseInt(userInfo.getUserMoniter())%100;
                   out.println(userMonitor);
               %> 
               </b>m
            </li>
         </ul>

         <hr>
         <!-- 선 -->

         <!-- 프로필사진 - 수정/인증/전체글/댓글 메뉴 -->
         <ul class="keh-mypageMain-myMenu">
            <li><a href="${pageContext.request.contextPath}/mypage/pwCheck.my">내 정보 수정하기</a></li>
            <li><a href="${pageContext.request.contextPath}/mypage/mentoCheck.my">자격/멘토 뱃지 추가하기</a></li>
         </ul>
      </section>

      <!-- 우측 내 활동 -->
      <section class="keh-mypageMain-profile-right">
         <!-- 1. 내가 쓴 게시글 / 내가 쓴 답변 -->
         <div class="keh-mypageMain-article">
            <ul>
               <li>내가 쓴 게시글
                  <p>
                  <%
                  	int articleCount = userInfo2.getArticleCount();
                  	out.println(articleCount);
                  %>
                  개</p>
               </li>
               <li>내가 쓴 답변
                  <p>
                  <%
                  	int commentCount = userInfo2.getCommentCount();
                  	out.println(commentCount);
                  %>
                  개</p>
               </li>
            </ul>
         </div>
         <!-- 2. 뱃지 -->
         <div class="keh-mypageMain-badge">
            <ul>
               <li>내가 획득한 뱃지
                  <p>
                  <%
                  	int badgeCount = userInfo2.getBadgeCount();
                  	out.println(badgeCount);
                  %>
                  개</p>
               </li>
               <li>
                  <!-- 뱃지 아이콘 목록 8개 -->
                  <ul class="keh-mypageMain-badgeList">
                  <!-- 숫자만 받아오기 -->
                  <!-- 반복수  -->
                  <%
                  	int Count = userInfo2.getBadgeCount(); 
                  	for(int i = 0; i < Count; i++){
                  %>
                     <li>
                        <div><img src="${pageContext.request.contextPath}/assets/img/badge22.png" alt="Badge Image"></div>
                     </li>
                  <% 
                  	}
                  %>
                     <!-- <li>
                        <div></div>
                     </li>
                     <li>
                        <div></div>
                     </li>
                     <li>
                        <div></div>
                     </li>
                     <li>
                        <div></div>
                     </li>
                     <li>
                        <div></div>
                     </li>
                     <li>
                        <div></div>
                     </li>
                     <li>
                        <div></div>
                     </li> -->
                  </ul>
               </li>
            </ul>
         </div>
         <!-- 3. 경력 -->
         <div class="keh-mypageMain-career">
            <ul>
               <li>나의 경력</li>
               <li>
               <!-- 우선 T/F인지를 체크 -->
               <!-- 세션이 있으면 -->
               <%
               		/* 멘토회원이면 */
<<<<<<< HEAD
               		if(userInfo.getUserCert() == 'T'){
=======
               		if(userInfo.isUserCert() == true){
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
               			String career = userInfo.getUserCareer();
               			/* ,단위로 라인을 바꿔가며 출력 */
               			career = career.replace(",", "<br>");
               			/* System.out.println(career); //확인용 */
               			String[] careers = career.split("<br>");
               			for(String text : careers){
               				/* System.out.println(text); //확인용 */
               				out.println("<li>" + text + "</li>");
               			}
               			
               			
<<<<<<< HEAD
               		}else if(userInfo.getUserCert() == 'F'){
=======
               		}else if(userInfo.isUserCert() == false){
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
               			out.println("현재 등록된 경력사항이 없습니다");
               		}
               %>
               </li>
            </ul>
         </div>
      </section>
   </main>
   <jsp:include page="../basic/footer.jsp" />
</body>
</html>
