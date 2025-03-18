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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/askDev.css">
<script defer src="${pageContext.request.contextPath}/assets/js/admin/askDev.js"></script>
</head>
<body>
<jsp:include page="./basic/header.jsp" />
	    <main>
        <nav class="mtable">
            <div class="head">
                <div class="title">질문게시판-개발</div>
                <div class="buttons">
                    <button id="editButton">수정</button>
                    <button id="deleteButton">삭제</button>
                </div>
            </div>
            <hr>

            <div class="askdevList header">
                <input type="checkbox" id="selectAll" onclick="toggleSelectAll()">
                <p>태그</p>
                <p class="askdev-title">글제목</p>
                <p>작성자</p>
                <p>회원분류</p>
                <p>작성일</p>
                <p>조회수</p>
            </div>
            <hr>

			<!-- 게시글 출력 -->
			<c:forEach var="askDev" items="${askDev}">
				<div class="askdevList">
					<div>
						<input type="checkbox" class="item-checkbox">
						<p>${askDev.articleTagname}</p>
						<a href="${pageContext.request.contextPath}/admin/articleDetail.ad?articleNum=${askDev.articleNum}">
						<p class="askdev-title">${askDev.articleTitle}</p>
						</a> 
						<p>${askDev.userNick}</p>
						<p>${askDev.grade}</p>
						<p>${askDev.articledate}</p>
						<p>${askDev.articleView}</p>
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