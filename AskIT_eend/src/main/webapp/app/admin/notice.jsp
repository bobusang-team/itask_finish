<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic/header.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/basic/header.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/notice.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/notice.js"></script>
</head>
<body>
	<jsp:include page="./basic/header.jsp" />
	<main>
		<nav class="mtable">

			<div class="head">
				<div class="title">공지게시판 목록</div>
				<div class="buttons">
					<button onclick="submitEditForm()">수정</button>
					<button onclick="submitDeleteForm()">삭제</button>
				</div>
			</div>
			<hr>

			<!-- Table Header -->
			<div class="memColumn header">
				<input type="checkbox" id="selectAll" onclick="toggleSelectAll()">
				<p>분류</p>
				<p class="notice-title">글제목</p>
				<p>작성일</p>
				<p>조회수</p>
			</div>
			<hr>

			<!-- 반복문으로 Notice 출력 -->
			<c:forEach var="noticeList" items="${noticeList}">
				<div class="memColumn">
					<div>
						<input type="checkbox" class="item-checkbox" onclick="updateSelectAll()">
						<input type="hidden" class="noticeNum" value="${noticeList.noticeNum }">
						<p>${noticeList.noticeCategory}</p>
						<!-- 분류 -->
						<p class="notice-title" onclick="toggleText(this)">${noticeList.noticeTitle}</p>
						<!-- 글제목 -->
						<p>${noticeList.noticeDate}</p>
						<!-- 작성일 -->
						<p>${noticeList.noticeView}</p>
						<!-- 조회수 -->
					</div>
					<div class="notice-text" style="display: none;">${noticeList.noticeText}</div>
				</div>
			</c:forEach>
			
			<!-- 삭제용 Form -->
			<form id="deleteForm"
				action="${pageContext.request.contextPath}/admin/deleteNotice.ad"
				method="post">
				<input type="hidden" name="deleteNoticeNums" id="deleteNoticeNums">
			</form>
			
			
			<div class="pagination">
      <c:if test="${prev}"> <!-- 아주 처음으로 가는 버튼 -->
         <a href="${pageContext.request.contextPath}/admin/notice.ad?page=1"
                  class="firstPage">«</a>
     </c:if>
      <c:if test="${prev}"> <!-- 이전페이지가 있을 시 이전페이지로 넘어가는 버튼 생성 -->
         <a href="${pageContext.request.contextPath}/admin/notice.ad?page=1"
                  class="prev">‹</a>
     </c:if>
     <c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
              <c:forEach var="i" begin="${realStartPage}" end="${endPage}">

            <c:choose>
               <c:when test="${!(i == page)}">
                  <a href="${pageContext.request.contextPath}/admin/notice.ad?page=${i}">
                           <c:out value="${i}" />
                  </a>
               </c:when>
               <c:otherwise>
                     <a href="#" class="active"> <c:out value="${i}" /> <!-- 선택한 현재페이지를 버튼에서 활성화 시켜주는 부분 -->
                     </a>
               </c:otherwise>   
            </c:choose>

         </c:forEach>
      <c:if test="${next}"> <!-- 다음 페이지가 있다면 다음으로 넘어가는 버튼 생성 -->
            <a href="${pageContext.request.contextPath}/admin/notice.ad?page=${endPage + 1}"
                  class="next">›</a>
      </c:if>
      <c:if test="${next}"> <!-- 완전 끝으로 가는 버튼 생성 -->
            <a href="${pageContext.request.contextPath}/admin/notice.ad?page=${realEndPage}"
                  class="realEndPage">»</a>
      </c:if>
            
         <!-- <a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
         <a href="#">3</a> <a href="#">›</a> <a href="#">»</a> -->
      </div>
		</nav>
	</main>
</body>

</html>
