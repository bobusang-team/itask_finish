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
					<button id="editButton">수정</button>
					<button id="deleteButton">삭제</button>
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
						<input type="checkbox" class="item-checkbox">
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

			<div class="pagination">
				<a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
				<a href="#">3</a> <a href="#">›</a> <a href="#">»</a>
			</div>
		</nav>
	</main>
</body>

</html>
