<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 비밀번호 찾기 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>비밀번호 찾기</title>
    <link rel="stylesheet" href="./../../assets/css/member/pwFind.css">
	<link rel="stylesheet" href="./../../assets/css/header.css">
	<link rel="stylesheet" href="./../../assets/css/footer.css">
    <script defer src="./../../assets/js/member/pwFind.js"></script>
  </head>
  <body>
  	<jsp:include page="../basic/header.jsp" />
    <main class="itAskBox">   
      <a href="#">
        <img src="./../../assets/img/logo.png" alt="ITASK 로고">
      </a>  
      
     	<%
			String pwfindFailMsg = (String)session.getAttribute("pwfindFail");
			if(pwfindFailMsg != null){
		%>
		<script>
			alert("<%= pwfindFailMsg %>");
		</script>
		<%} 
			//로그인 실패 메시지값 해제 
			session.removeAttribute("pwfindFail");
		%> 
      
      <p>
        비밀번호 찾기<br>
        <span>등록된 전화번호로만 찾을 수 있습니다</span>
      </p>
      <!-- 정보입력칸 -->
      <form action="${pageContext.request.contextPath }/member/pwFindOk.me" name="keh-pwFind-pwForm" class="keh-pwFind-pwForm" method="post">
        <input type="text" name="userId" class="keh-pwFind-id" placeholder="ID">
        <input type="text" name="userName" class="keh-pwFind-name" placeholder="이름">
        <div class="keh-pwFind-phoneNumBox">
          <input type="text" name="userPhone" class="keh-pwFind-phoneNum" placeholder="휴대폰 번호 입력(-없이)">
          <input type="button" name="keh-pwFind-phoneNum-btn" class="keh-pwFind-phoneNum-btn" value="인증번호받기">
        </div>
        <div class="keh-pwFind-phoneNumBox">
          <input type="text" name="checkNum" class="keh-pwFind-checkNum2" placeholder="수신된 인증번호를 입력하세요">
          <input type="button" name="keh-pwFind-phoneNum-btn" class="keh-pwFind-phoneNum-btn2" value="인증번호확인">
        </div>
        <p class="keh-pwFind-checkInfo">인증번호가 확인되었습니다.</p>
        <input type="submit" name="keh-pwFind-pwBtn" class="keh-pwFind-pwBtn" value="비밀번호 재설정">        
      </form>
    </main>
    <jsp:include page="../basic/footer.jsp" />
  </body>
</html>
