<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 비밀번호 재설정 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>비밀번호변경</title>
    <link rel="stylesheet" href="./../../assets/css/member/pwReset.css">
    <link rel="stylesheet" href="./../../assets/css/header.css">
	<link rel="stylesheet" href="./../../assets/css/footer.css">
  </head>
  <body>
  	<jsp:include page="../basic/header.jsp" />
    <main class="itAskBox">   
      <a href="#">
        <img src="./../../assets/img/logo.png" alt="ITASK 로고">
      </a>   
      	<%
			String pwCheckMsg = (String)session.getAttribute("pwCheck");
			if(pwCheckMsg != null){
		%>
		<script>
			alert("<%= pwCheckMsg %>");
		</script>
		<%} 
			//비밀번호 불일치 메시지값 해제 
			session.removeAttribute("pwCheck");
		%>
      <p>
        비밀번호 재설정<br>
        <span>비밀번호는 8~20자의 영문, 숫자, 특수문자를 포함해야합니다</span>
      </p>
      <!-- 비번입력칸 pwReseting-->
      <form action="${pageContext.request.contextPath }/member/pwresetOk.me" name="keh-pwReseting-pwForm" class="keh-pwReseting-pwForm" method="post">
        <div class="keh-pwReseting-pwBox1">
          <input type="password" name="userNewPw" class="keh-pwReseting-pw" placeholder="새 비밀번호를 입력하세요">
          <img src="./../../assets/img/hidden 4.png" alt="비밀번호 숨김">
          <p class="keh-pwReseting-check1">비밀번호는 8~20자의 영문, 숫자, 특수문자를 포함해야합니다</p>
          <p class="keh-pwReseting-check2">비밀번호로 적합합니다</p><!--현재 이 문구는 css에서서 display:none; 으로 숨겨져있습니다-->
        </div>
        <div class="keh-pwReseting-pwBox2">
          <input type="password" name="userNewPwCheck" class="keh-pwReseting-pw" placeholder="비밀번호 확인">
          <img src="./../../assets/img/hidden 4.png" alt="비밀번호 숨김">
          <p class="keh-pwReseting-check1">비밀번호가 일치하지 않습니다</p>
          <p class="keh-pwReseting-check2">비밀번호가 일치합니다</p><!--현재 이 문구는 css에서서 display:none; 으로 숨겨져있습니다-->
        </div>
          <input type="submit" name="keh-pwReseting-pwBtn" class="keh-pwReseting-pwBtn" value="비밀번호 변경">
        
      </form>
      
    </main>
    <jsp:include page="../basic/footer.jsp" />
  </body>
</html>
