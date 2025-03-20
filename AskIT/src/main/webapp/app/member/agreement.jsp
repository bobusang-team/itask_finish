<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 전체약관 동의 페이지 -->
<!DOCTYPE html>
<html lang="en">

<!--문자인증 API_KEY, API_SECRET, PHONE 값 빼고 넘기 -->

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/member/agreement.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <script defer src="../../assets/js/member/agreement.js"></script>
  <title>약관동의</title>
</head>

<body>
<jsp:include page="../basic/header.jsp" />
  <main class="itAskBox">

    <a href="#">
      <img src="./../../assets/img/logo.png" alt="ITASK 로고">
    </a> 

    <form action="./join.jsp" name="keh-agreement-form" method="post">

      <!-- 전체동의버튼 -->
      <input type="checkbox" name="keh-agreement-total" id="keh-agreement-total" class="keh-agreement-total">
      <label for="keh-agreement-total">모두 확인하였으며 동의합니다</label>

      <!-- 필수약관 1. itask 이용약관동의 -->
      <article>
        <input type="checkbox" name="keh-agreement-terms01" id="keh-agreement-require-term01" class="keh-agreement-terms" required>
        <label for="keh-agreement-terms01">[필수] ITASK 이용약관 동의</label>
        <p>
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
        </p>
        <a href="./terms01.jsp"> 약관 전체보기 &gt;</a>
      </article>

      <!-- 필수약관 2. 개인정보 수집 및 이용 -->
      <article>
        <input type="checkbox" name="keh-agreement-terms02" id="keh-agreement-require-term02" class="keh-agreement-terms" required>
        <label for="keh-agreement-terms02">[필수] 개인정보 수집 및 이용</label>
        <p>
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
        </p>
        <a href="./terms01.jsp"> 약관 전체보기 &gt;</a>
      </article>

      <!-- 선택약관 이벤트,혜택 정보 수신 동의 -->
      <article>
        <input type="checkbox" name="keh-agreement-terms03" id="keh-agreement-terms03" class="keh-agreement-terms" required>
        <label for="keh-agreement-terms03">[선택] 이벤트·혜택 정보 수신 동의</label>
        <p>
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
          더미 텍스트입니다 뜻이 없는 아무 내용을 적었습니다. 
        </p>
        <a href="./terms01.jsp"> 약관 전체보기 &gt;</a>
      </article>

      <!-- 다음 버튼 -->
      <input type="submit" name="keh-agreement-btn" class="keh-agreement-btn" value="다음">

    </form>
  </main>
  <jsp:include page="../basic/footer.jsp" />
</body>

</html>
</html>