<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>웹페이지 통합</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/article/dev/askEdit.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/article/dev/askEdit.js"></script>

</head>

<body>
	<!-- 헤더 -->
	<header> </header>
	<main class="itAskBox">
		<!-- 메인 -->
		<!-- 카테고리 선택 -->
		<div class="mjh-askEdit-modify">
			<p class="mjh-askEdit-modify-title">글 수정</p>
			<p class="mjh-askEdit-modify-category">카테고리</p>
			<!-- 총카테고리리(태그포함) -->
			<div class="mjh-askEdit-modify-totalcategory" id="totalcategory">
				<!-- 상위카테고리리 -->
				<div class="mjh-askEdit-modify-category1">
					<div class="mjh-askEdit-modify-category1-button mjh-askEdit-select"
						data-category1=>
						<c:out value="${dev.articleTopcate}" />
					</div>
				</div>
				<!-- 하위 카테고리리 -->
				<div class="mjh-askEdit-modify-category2">
					<div class="mjh-askEdit-modify-category2-button mjh-askEdit-select"
						data-category2=>
						<c:out value="${dev.articleBotcate}" />
					</div>
				</div>
				<!-- 태그그 -->
				<p class="mjh-askEdit-modify-category">태그</p>
				<div class="mjh-askEdit-modify-tag">
					<div class="mjh-askEdit-modify-tag-button mjh-askEdit-select"
						data-tag=>
						<c:out value="${dev.articleTagname}" />
					</div>
				</div>
			</div>
			<!-- 제목 -->

			<form method="POST"
				action="${pageContext.request.contextPath}/dev/updateOk.dev?articleNum=${dev.articleNum}">
				<div class="mjh-askEdit-modify-title-section">
					<input type="text" name="articleTitle" id="title" value="${dev.articleTitle}"
						minlength="8" required />
				</div>
				<!-- 글상자 -->
				<div class="mjh-askEdit-modify-content-section">
					<textarea name="articleText" id="content" rows="30" minlength="20" required>
							${dev.articleText}</textarea>
				</div>
				<button id="submitbtn" type="submit">글 수정하기</button>
			</form>
		</div>
	</main>
</body>
<footer>
	<div class="mjh-askEdit-modify-file-binbox"></div>
</footer>

</html>