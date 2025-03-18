<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>공지사항게시글화면</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notice/noticeDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>

<body>
<<<<<<< HEAD
<jsp:include page="../basic/userheader.jsp" />
=======
<jsp:include page="../basic/header.jsp" />
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
  <div class="mjh-noticeDetail-main">
    <div class="mjh-noticeDetail-title">공지사항</div>
    <span id="main-notice-id"></span>
    <div class="mjh-noticeDetail-articel-header">
      <div class="mjh-noticeDetail-articel-category" id="notice-category">보안</div>
      <div class="mjh-noticeDetail-articel-title" id="notice-title">악성코드 경고</div>
      <div class="mjh-noticeDetail-profile">
        <img src="./../../assets/img/profile.png" id="mjh-noticeDtail-profile-img" alt="">
        <span class="mjh-noticeDetail-text-author"><b>**inch</b> 관리자</span>
      </div>
      <span class="mjh-noticeDetail-date" id="notice-data">2025-01-09 00:00 </span>
    </div>
    <hr class="mjh-noticeDetail-articel-line">
    <div class="mjh-noticeDetail-articel-text" id="notice-text">최근 악성코드가 발견되어 보안 패치를 권장합니다. 사용자 여러분은 즉시 업데이트를 완료해 주세요.</div>
    <div class="mjh-noticeDetail-content">
      <img src="./../../assets/img/moniter.png" alt="모니터" id="Detail-moniter-img">
      <span id="Detail-monitercount">0</span>
      <img src="./../../assets/img/view.png" alt="조회수" id="Detail-view-img">
      <span id="Detail-viewcount">0</span>
      <img src="./../../assets/img/share.png" alt="공유수" id="Detail-share-img">
      <span id="Detail-sharecount">0</span>
    </div>
    <hr class="mjh-noticeDetail-articel-line">
    <span class="mjh-noticeDetail-listbutton"><a href="./notice.jsp">목록</a></span>
  </div>
  <jsp:include page="../basic/footer.jsp" /></body>
  
</body>

</html>