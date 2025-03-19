<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>검색 결과</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath }/assets/js/main/searchResults.js"></script>
</head>
<body>
	
	<% UserDTO userInfo = (UserDTO)session.getAttribute("userDTO"); 
		String headerPath = (userInfo != null) ? "../basic/userheader.jsp" : "../basic/header.jsp";
		%>
		<jsp:include page="<%= headerPath %>"/>


	<main class="itAskBox">
		<div class="bjs-ask-topcontainer">
			<h2 class="bjs-ask-title">통합 검색</h2>

			
			<div id = "articlecontainer">
				<p>검색 결과를 불러오는 중...</p> <!-- fetch 완료 전 표시 -->
			</div>
		

			<!-- 페이지네이션 -->
			<div class="pagination">
				<ul>
					<!-- fetch 후 동적으로 추가 -->
				</ul>
			</div>
		</div>
	</main>

	<jsp:include page="../basic/footer.jsp" />
</body>
</html>