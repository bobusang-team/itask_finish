<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
<!-- 내정보 수정하기 - 1.비밀번호 재입력 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>내 정보 수정하기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/pwCheck.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
    <script defer src="${pageContext.request.contextPath}/assets/js/mypage/pwCheck.js"></script>
  </head>
  <body>
  <jsp:include page="./../basic/userheader.jsp"/>
  <%
    UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");
  
  if (userInfo == null) {
      // 세션에 유저 정보가 없는 경우 -> 로그인 페이지
      response.sendRedirect(request.getContextPath() + "/app/member/login.jsp");
      return;
  }
  %>
                 <%-- <h1><%= userInfo.getUserId() %></h1> --%>
  
    <main class="itAskBox">   
      <!-- 아무 동작 없도록 링크 x -->
      <a href="#">
        <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="ITASK 로고">
      </a>   
      
      <p>
        내 정보 수정하기<br>
        <span>비밀번호를 입력해주세요</span>
      </p>
      <!-- 비번입력칸 -->
      <form action="${pageContext.request.contextPath}/mypage/pwCheckOk.my" name="keh-pwCheck-pw" class="keh-pwCheck-pwForm" method="post">
        <div>
          <input type="password" name="userPw" maxlength="18" class="keh-pwCheck-pw" placeholder="비밀번호를 입력하세요">
          <img src="${pageContext.request.contextPath}/assets/img/hidden 4.png" alt="비밀번호 숨김" class="mark">
          
          <%
          	String pwCheckFailMsg = (String)session.getAttribute("pwCheckFailMsg");
          	if(pwCheckFailMsg != null){
          %>
          <script>
          	alert("<%= pwCheckFailMsg %> ");
          </script>
          <%}
          	//비밀번호 체크 메시지 해제
          	session.removeAttribute("pwCheckFailMsg");
          	
          	%>
          
        </div>
        <!-- <div class="mark"></div> -->

          <input type="submit" class="keh-pwCheck-pwBtn" value="내 정보 수정하기 페이지로 가기">
        <!-- <button name="keh-pwCheck-pwBtn" type="submit">내 정보 수정하기 페이지로 가기</button> -->
      </form>
      
    </main>
    <jsp:include page="../basic/footer.jsp" />
  </body>
  
  <!-- 비밀번호 hide -->
<script>
          	const mark = document.querySelector(".mark");
          	const input = document.querySelector(".keh-pwCheck-pw");

          	let pwStatus = false; // 초기 상태: 비밀번호 숨김

          	// 비밀번호 표시하기 / 가리기
          	mark.addEventListener("click", () => {
          	  if (pwStatus) {
          	    input.type = "password"; // 비밀번호 숨김
           	   mark.src = "${pageContext.request.contextPath}/assets/img/hidden 4.png"; // 아이콘 변경
           	 } else {
           	   input.type = "text"; // 비밀번호 표시
           	   mark.src = "${pageContext.request.contextPath}/assets/img/Eye.png"; // 아이콘 변경
           	 }
           	 pwStatus = !pwStatus; // 상태 변경
          	});
          </script>
</html>
