<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic/header.css">
 <script defer src="${pageContext.request.contextPath}/assets/js/admin/basic/header.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/askSec.css">
<script defer src="${pageContext.request.contextPath}/assets/js/admin/askSec.js"></script>
</head>
<body>
<jsp:include page="./basic/header.jsp" />
	<main>
        <nav class="mtable">
            <div class="head">
                <div class="title">질문게시판-보안</div>
                <div class="buttons">
                    <button id="editButton">수정</button>
                    <button id="deleteButton">삭제</button>
                </div>
            </div>
            <hr>

            <div class="asksecList header">
                <input type="checkbox" id="selectAll" onclick="toggleSelectAll()">
                <p>태그</p>
                <p class="asksec-title">글제목</p>
                <p>작성자</p>
                <p>회원분류</p>
                <p>작성일</p>
                <p>조회수</p>
            </div>
            <hr>

			<!-- 게시글 출력 -->
			<c:forEach var="askSec" items="${askSec}">
				<div class="asksecList">
					<div>
						<input type="checkbox" class="item-checkbox">
						<p>${askSec.articleTagname}</p>
						<a href="${pageContext.request.contextPath}/admin/articleDetail.ad?articleNum=${askSec.articleNum}">
						<p class="asksec-title">${askSec.articleTitle}</p>
						</a>
						<p>${askSec.userNick}</p>
						<p>${askSec.grade}</p>
						<p>${askSec.articledate}</p>
						<p>${askSec.articleView}</p>
					</div>
				</div>
			</c:forEach>

            <div class="pagination">
                <a href="#">«</a>
                <a href="#">‹</a>
                <a href="#">1</a>
                <a href="#">2</a>
                <a href="#">3</a>
                <a href="#">›</a>
                <a href="#">»</a>
            </div>
        </nav>
    </main>
</body>
</html>