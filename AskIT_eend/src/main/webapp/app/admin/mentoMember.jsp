<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	href="${pageContext.request.contextPath}/assets/css/admin/mentoMember.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/mentoMember.js"></script>
</head>
<body>
	<jsp:include page="./basic/header.jsp" />
	<main>
		<nav class="mtable">
			<div class="head">
				<div class="title">멘토회원 목록</div>
				<div class="buttons">
					<button type="button" onclick="submitBlacklistForm()">블랙리스트</button>
					<button type="button" onclick="submitUserpageForm()">상세보기</button>
					<button type="button" onclick="submitDeleteForm()">삭제</button>
				</div>
			</div>
			<hr>
			<div class="memColumn header">
				<input type="checkbox" id="selectAll" onclick="toggleSelectAll()">
				<p>등급</p>
				<p>아이디</p>
				<p>닉네임</p>
				<p>뱃지</p>
				<p>모니터</p>
				<p>가입일자</p>
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
					<p class="userNick">${users.userNick}</p>
					<!-- user의 nickname 속성 -->
					<p>${users.badge}</p>
					<!-- user의 badge 속성 -->
					<p>${users.formattedMonitor}</p>
					<!-- user의 monitor 속성 -->
					<p>${fn:substring(users.userJoinDate, 0 ,10) }</p>
					<!-- user의 joinDate 속성 -->
				</div>
			</c:forEach>

			<!-- 삭제용 Form -->
			<form id="deleteForm"
				action="${pageContext.request.contextPath}/admin/deleteMember.ad"
				method="post">
				<input type="hidden" name="userIds" id="deleteUserIds">
			</form>

			<!-- 블랙리스트 추가용 Form -->
			<form id="blacklistForm"
				action="${pageContext.request.contextPath}/admin/addBlackList.ad"
				method="post">
				<input type="hidden" name="userId" id="blacklistUserIds"> <input
					type="hidden" name="userNick" id="blacklistUserNicks"> <input
					type="hidden" name="reason" id="blacklistReason"> <input
					type="hidden" name="day" id="blacklistDays">
			</form>

			<!-- 상세보기용 -->
			<form id="userpageForm"
				action="${pageContext.request.contextPath}/admin/userPage.ad"
				method="post">
				<input type="hidden" name="userNick" id="userNick">
			</form>

			<div class="pagination">
				<c:if test="${prev}">
					<!-- 아주 처음으로 가는 버튼 -->
					<a
						href="${pageContext.request.contextPath}/admin/mentoMember.ad?page=1"
						class="firstPage">«</a>
				</c:if>
				<c:if test="${prev}">
					<!-- 이전페이지가 있을 시 이전페이지로 넘어가는 버튼 생성 -->
					<a
						href="${pageContext.request.contextPath}/admin/mentoMember.ad?page=1"
						class="prev">‹</a>
				</c:if>
				<c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
				<c:forEach var="i" begin="${realStartPage}" end="${endPage}">

					<c:choose>
						<c:when test="${!(i == page)}">
							<a
								href="${pageContext.request.contextPath}/admin/mentoMember.ad?page=${i}">
								<c:out value="${i}" />
							</a>
						</c:when>
						<c:otherwise>
							<a href="#" class="active"> <c:out value="${i}" /> <!-- 선택한 현재페이지를 버튼에서 활성화 시켜주는 부분 -->
							</a>
						</c:otherwise>
					</c:choose>

				</c:forEach>
				<c:if test="${next}">
					<!-- 다음 페이지가 있다면 다음으로 넘어가는 버튼 생성 -->
					<a
						href="${pageContext.request.contextPath}/admin/mentoMember.ad?page=${endPage + 1}"
						class="next">›</a>
				</c:if>
				<c:if test="${next}">
					<!-- 완전 끝으로 가는 버튼 생성 -->
					<a
						href="${pageContext.request.contextPath}/admin/mentoMember.ad?page=${realEndPage}"
						class="realEndPage">»</a>
				</c:if>

				<!-- <a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
         <a href="#">3</a> <a href="#">›</a> <a href="#">»</a> -->
			</div>

		</nav>
	</main>

</body>
</html>