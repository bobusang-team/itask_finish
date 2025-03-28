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
	href="${pageContext.request.contextPath}/assets/css/admin/blackList.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/blackList.js"></script>
</head>
<body>
	<jsp:include page="./basic/header.jsp" />
	<main>
		<nav class="mtable">
			<div class="head">
				<div class="title">블랙리스트 목록</div>
				<div class="buttons">
					<button onclick="submitUpdateBlackForm()">변경</button>
					<button onclick="submitDeleteForm()">취소</button>
				</div>
			</div>
			<hr>
			<div class="memColumn header">
				<input type="checkbox" id="selectAll" onclick="toggleSelectAll()">
				<p>닉네임</p>
				<p class="user-id">아이디</p>
				<p>경고 날짜</p>
				<p>해제 예정일</p>
				<p>사유</p>
			</div>
			<hr>
			<!-- 회원 데이터 반복 출력 -->
			<c:forEach var="users" items="${users}">
				<div class="memColumn">
					<input type="checkbox" class="item-checkbox"
						onclick="updateSelectAll()">
					<input type="hidden" class="blackListNum" value="${users.blackListNum }">
					<!-- 이름 -->
					<p>${users.blackListName}</p>
					<!-- ID -->
					<p class="userId">${users.blackListId}</p>
					<!-- 등록 날짜 -->
					<p>${fn:substring(users.blackListDate, 0, 10)}</p>
					<!-- 해제 예정일 -->
					<p>${fn:substring(users.blackListReleaseDate, 0, 10)}</p>
					<!-- 사유 -->
					<p>${users.blackListComment}</p>
				</div>
			</c:forEach>

			<!-- 삭제용 Form -->
			<form id="deleteForm"
				action="${pageContext.request.contextPath}/admin/deleteBlackList.ad"
				method="post">
				<input type="hidden" name="blackListNum" id="blackListNum">
			</form> 

			<form id="submitUpdateBlackForm"
				action="${pageContext.request.contextPath}/admin/updateBlackList.ad"
				method="post">
				<input type="hidden" name="blackListIds" id="blackListIds"> <!-- 해당ID -->
				<input type="hidden" name="blacklistPeriod" id="blacklistPeriod"> <!-- 변경일 -->
			</form>
			<div class="pagination">
				<c:if test="${prev}">
					<!-- 아주 처음으로 가는 버튼 -->
					<a
						href="${pageContext.request.contextPath}/admin/blackList.ad?page=1"
						class="firstPage">«</a>
				</c:if>
				<c:if test="${prev}">
					<!-- 이전페이지가 있을 시 이전페이지로 넘어가는 버튼 생성 -->
					<a
						href="${pageContext.request.contextPath}/admin/blackList.ad?page=1"
						class="prev">‹</a>
				</c:if>
				<c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
				<c:forEach var="i" begin="${realStartPage}" end="${endPage}">

					<c:choose>
						<c:when test="${!(i == page)}">
							<a
								href="${pageContext.request.contextPath}/admin/blackList.ad?page=${i}">
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
						href="${pageContext.request.contextPath}/admin/blackList.ad?page=${endPage + 1}"
						class="next">›</a>
				</c:if>
				<c:if test="${next}">
					<!-- 완전 끝으로 가는 버튼 생성 -->
					<a
						href="${pageContext.request.contextPath}/admin/blackList.ad?page=${realEndPage}"
						class="realEndPage">»</a>
				</c:if>

				<!-- <a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
         <a href="#">3</a> <a href="#">›</a> <a href="#">»</a> -->
			</div>
		</nav>
	</main>
</body>
</html>