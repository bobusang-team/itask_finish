<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 내정보 수정하기 - 3.비밀번호변경 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>비밀번호변경</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/mypage/editPw.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
    <script defer src="${pageContext.request.contextPath }/assets/js/mypage/editPw.js"></script>
  </head>
  <body>
  <jsp:include page="./../basic/userheader.jsp"/>
    <main class="itAskBox">   
      <a href="#">
        <img src="${pageContext.request.contextPath }/assets/img/logo.png" alt="ITASK 로고">
      </a>   
      
      <p>
        비밀번호 변경하기<br>
        <!-- <span>비밀번호는 8~20자의 영문, 숫자, 특수문자를 포함해야합니다</span> -->
      </p>
      <!-- 비번입력칸 -->
      <form action="${pageContext.request.contextPath }/mypage/editPwOk.my" name="keh-editPw-pwForm" class="keh-editPw-pwForm" method="get">
        <div class="keh-editPw-pwBox1">

          <input type="password" name="userNewPw" class="keh-editPw-pw" placeholder="새 비밀번호를 입력하세요">
          <img src="${pageContext.request.contextPath }/assets/img/hidden 4.png" alt="비밀번호 숨김" class="mark">
          <p class="keh-editPw-check1">비밀번호는 8~20자의 영문, 숫자, 특수문자를 포함해야합니다</p>
          <p class="keh-editPw-check2">비밀번호로 적합합니다</p>
        </div>
        <div class="keh-editPw-pwBox2">
          <input type="password" name="userRepeatPw" class="keh-editPw-pw2 keh-editPw-pw" placeholder="비밀번호 확인">
          <img src="${pageContext.request.contextPath }/assets/img/hidden 4.png" alt="비밀번호 숨김" class="mark2 mark">
          <p class="keh-editPw-check1 keh-editPw-check2-1">비밀번호가 일치하지 않습니다</p>
          <p class="keh-editPw-check2 keh-editPw-check2-2">비밀번호가 일치합니다</p>
        </div>
          <input type="submit" name="keh-editPw-pwBtn" class="keh-editPw-pwBtn" value="비밀번호 변경하기">
      </form>
      
  	<script>
 // 새 비밀번호 눈 버튼 기능
  	const pwInput = document.querySelector(".keh-editPw-pw");
  	const mark = document.querySelector(".mark");
  	const pwInput2 = document.querySelector(".keh-editPw-pw2");
  	const mark2 = document.querySelector(".mark2");

  	let pwStatus1 = false; // 새 비밀번호 상태
  	let pwStatus2 = false; // 비밀번호 확인 상태
  	let changeStatus = false; // 비밀번호 변경 막기

  	mark.addEventListener("click", () => {
  		if (pwStatus1) {
  			pwInput.type = "password";
  			mark.src = "${pageContext.request.contextPath }/assets/img/hidden 4.png";
  		} else {
  			pwInput.type = "text";
  			mark.src = "${pageContext.request.contextPath }/assets/img/Eye.png";
  		}
  		pwStatus1 = !pwStatus1;
  	});

  	mark2.addEventListener("click", () => {
  		if (pwStatus2) {
  			pwInput2.type = "password";
  			mark2.src = "${pageContext.request.contextPath }/assets/img/hidden 4.png";
  		} else {
  			pwInput2.type = "text";
  			mark2.src = "${pageContext.request.contextPath }/assets/img/Eye.png";
  		}
  		pwStatus2 = !pwStatus2;
  	});
  	
  	</script>
      
      
    </main>
    <jsp:include page="../basic/footer.jsp" />
  </body>
</html>