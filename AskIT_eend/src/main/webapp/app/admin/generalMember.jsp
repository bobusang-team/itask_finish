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
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/generalMember.css">
<script defer src="${pageContext.request.contextPath}/assets/js/admin/generalMember.js"></script>
</head>
<body>
<jsp:include page="./basic/header.jsp" />
	 <main>
    <nav class="mtable">
        <div class="head">
            <div class="title">일반회원 목록</div>
            <div class="buttons">
                <button id="warnButton">경고주기</button>
                <button id="deleteButton">삭제</button>
            </div>
        </div>
        <hr>
        <div class="memColumn header">
            <input type="checkbox" id="selectAll">
            <p>등급</p>
            <p class="user-id">아이디</p>
            <p>닉네임</p>
            <p>뱃지</p>
            <p>모니터</p>
            <p>가입일자</p>
            <p>누적경고횟수</p>
        </div>
        <hr>
       <!-- 회원 데이터 반복 출력 -->
			<c:forEach var="users" items="${users}">
				<div class="memColumn">
					<input type="checkbox" class="item-checkbox">
					<p>${users.grade}</p>
					<!-- user의 grade 속성 -->
					<p class="userId">${users.userId}</p>
					<!-- user의 username 속성 -->
					<p>${users.userNick}</p>
					<!-- user의 nickname 속성 -->
					<p>${users.badge}</p>
					<!-- user의 badge 속성 -->
					<p>${users.formattedMoniter}</p>
					<!-- user의 monitor 속성 -->
					<p>${users.userJoinDate}</p>
					<!-- user의 joinDate 속성 -->
					<p>-</p>
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