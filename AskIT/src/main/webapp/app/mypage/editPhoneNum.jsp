<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 내정보 수정하기 - 4.핸드폰번호수정 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>내 정보 수정하기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/mypage/editPhoneNum.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
    <script defer src="${pageContext.request.contextPath }/assets/js/mypage/editPhoneNum.js"></script>
  </head>
  <jsp:include page="./../basic/userheader.jsp"/>
  <body>
    <main class="itAskBox">   
      <a href="#">
        <img src="${pageContext.request.contextPath }/assets/img/logo.png" alt="ITASK 로고">
      </a>   
      
      <p>
        핸드폰 번호 수정<br>
        <span>핸드폰 번호를 입력해주세요</span>
      </p>

      <!-- 정보입력 폼 -->
      <form action="${pageContext.request.contextPath }/mypage/editPhoneNumOk.my" name="keh-editPhoneNum-info" class="keh-editPhoneNum-infoForm" method="get">
        <!-- 이름입력칸 -->
        <div class="">
          <input type="text" name="userName" class="keh-editPhoneNum-name" placeholder="이름">
        </div>
        <!-- 폰번호입력칸 -->
        <div class="keh-editPhoneNum-phoneNum-Box">
          <input type="text" name="userPhoneNum" class="keh-editPhoneNum-phoneNum" placeholder="핸드폰번호( -없이 입력)">
          <input type="button" name="keh-editPhoneNum-phoneNum-btn" class="keh-editPhoneNum-phoneNum-btn" value="인증번호받기">
        </div>             
        <!-- 인증번호입력칸 -->
        <div class="keh-editPhoneNum-phoneNum-Box">
          <input type="text" name="certNum" class="keh-editPhoneNum-phoneNum2" placeholder="인증번호를 입력해주세요">
          <input type="button" name="keh-editPhoneNum-phoneNum-btn" class="keh-editPhoneNum-phoneNum-btn2" value="인증번호확인">
        </div>
        
        <!-- 아래 p태그 안에 인증번호가 확인되었습니다 문구가 들어가야합니다.
        default값은 아무 문자 없으며 글씨가 들어가면 자동으로 그린이 적용됩니다 -->
        <p class="keh-editPhoneNum-checkInfo">인증번호가 확인되었습니다.</p>
        <input type="submit" name="keh-editPhoneNum-submit-btn" class="keh-editPhoneNum-submit-btn" value="변경된 정보 저장하기">
      </form>
      
      
    </main>
    <jsp:include page="../basic/footer.jsp" />
  </body>
</html>

