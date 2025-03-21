<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>itask란?</title>
  <link rel="stylesheet" href="./../../assets/css/introduce/itask.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<%@ page import="com.itask.app.dto.UserDTO" %>
  <script defer src="./../../assets/js/introduce/itask.js"></script>
</head>
<body>
   <% UserDTO userInfo = (UserDTO)session.getAttribute("userDTO"); %>
		<% if(userInfo != null){ %>
		  <jsp:include page="./../basic/userheader.jsp"/>
		  
		<% }else{ %>
		<jsp:include page="./../basic/header.jsp"/>
		  
		  <%} %>
  <main class="itAskBox">
    <!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
    <div class="bjs-itask-topcontainer">
      <!-- 제목 -->
      <span class="bjs-itask-title">ITAsk</span>
        <!-- 소개 카테고리 -->
        <div class="bjs-itask-category">
          <button class="bjs-itask-category-btn bjs-itask-select">ITAsk 란?</button>
          <button class="bjs-itask-category-btn"><a href="./contents.jsp">뱃지, 모니터, 인치, 명예의 전당</a></button>
        </div>
    </div>
    <!-- 하단에 고정되어 있는 회원가입 버튼 링크 추가 필요 로그인시에는 사라져야함-->
    <div class="bjs-itask-tag"> 
      <button class="bjs-itask-tag-btn bjs-itask-select"><a href="./../member/agreement.jsp">바로 가입하기</a></button>
    </div>
    <!-- 소개 시작하는 영역-->
    <article>
      <section class="bjs-itask-intro-list">
        <!--로고 & 소개-->
        <div class="bjs-itask-imgbox">
          <img src="./../../assets/img/itask-intro.png" alt="소개 로고와의미">
        </div>
        <div class="bjs-itask-imgbox">
          <img src="./../../assets/img/itask-first.png" alt="소개 첫번째사진">
        </div>
        <div class="bjs-itask-imgbox">
          <img src="./../../assets/img/itask-second.png" alt="소개 두번째사진">
        </div>
        <div class="bjs-itask-imgbox">
          <img src="./../../assets/img/itask-third.png" alt="소개 세번째사진">
        </div>
        <div class="bjs-itask-imgbox">
          <img src="./../../assets/img/itask-fourth.png" alt="소개 네번째사진">
        </div>
      </section>
    </article>
  </main>
  <jsp:include page="../basic/footer.jsp" />
</body>
</html>