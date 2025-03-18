<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항리스트</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/notice/notice.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>
<body>
<<<<<<< HEAD
   <jsp:include page="../basic/userheader.jsp" />
=======
   <jsp:include page="../basic/header.jsp" />
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
   <div class="mjh-notice-main">
      <h2 class="mjh-notice-title">공지사항</h2>
      <div class="mjh-notice-articel-list">
      
         <div class="mjh-notice-articel-item" data-id="1">
            <span class="mjh-notice-articel-category">보안</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail1.jsp">악성코드 경고</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="2">
            <span class="mjh-notice-articel-category">전체</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail2.jsp">서비스 점검 알림</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="3">
            <span class="mjh-notice-articel-category">자격증</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail3.jsp">네트워크 관리사 자격증 일정</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="4">
            <span class="mjh-notice-articel-category">개발</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">Node.js 버전 업데이트</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="5">
            <span class="mjh-notice-articel-category">보안</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">중요 보안 패치</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="6">
            <span class="mjh-notice-articel-category">전체</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">서비스 개선 안내</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="7">
            <span class="mjh-notice-articel-category">자격증</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">정보보안 자격증 시험 일정</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="8">
            <span class="mjh-notice-articel-category">보안</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">보안 취약점 패치 공지</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="9">
            <span class="mjh-notice-articel-category">개발</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">자바 업데이트 안내</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="10">
            <span class="mjh-notice-articel-category">전체</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">시스템 점검 안내</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>


      </div>
      <div class="pagination">
         <a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
         <a href="#">3</a> <a href="#">›</a> <a href="#">»</a>
      </div>
   </div>
   <jsp:include page="../basic/footer.jsp" />



   <!--       <div class="mjh-notice-articel-item" data-id="5">
            <span class="mjh-notice-articel-category">전체</span> <span
               class="mjh-notice-articel-title">사이트 점검 안내✴</span> <span
               class="mjh-notice-articel-date">2025-01-09 00:00</span>
         </div> -->

</body>
</html>