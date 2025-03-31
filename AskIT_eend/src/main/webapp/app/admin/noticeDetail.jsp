<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.AdminDTO"%>
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
	href="${pageContext.request.contextPath}/assets/css/admin/noticeDetail.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/noticeDetail.js"></script>
</head>
<body>
	<jsp:include page="./basic/header.jsp" />
	<main class="itAskBox">


		<!-- 메인 -->
		<!-- 카테고리 선택 -->
		<form action="${pageContext.request.contextPath}/admin/noticeEdit.ad"
			method="post">
			<div class="write-click">
				<br>
				<br>
				<p class="noticeWrite">공지게시판 수정</p>
				<hr>

				<p class="write-title">카테고리 선택</p>
				<div class="write-clickbox1">
					<input type="hidden" name="noticeCategory" id="noticeCategory"
						value="${notice.noticeCategory }" />
					<input type="hidden" name="noticeNum" id="noticeNum"
						value="${notice.noticeNum }" />
					<div class="write-buttons" id="전체" onclick="setCategory('전체')">
						전체</div>
					<div class="write-buttons" id="개발" onclick="setCategory('개발')">
						개발</div>
					<div class="write-buttons" id="보안" onclick="setCategory('보안')">
						보안</div>
					<div class="write-buttons" id="자격증" onclick="setCategory('자격증')">
						자격증</div>
				</div>
				<!-- 제목 -->
				<div class="write-title-section">
					<input type="text" name="noticeTitle" id="title"
						value="${notice.noticeTitle }" minlength="8" required />
				</div>
				<!-- 글상자 -->
				<div class="write-content-section">
					<textarea rows="30" name="noticeText" id="content" minlength="20"
						required>${notice.noticeText }</textarea>
				</div>
				<button class="submit-button" type="submit">글 작성하기</button>
				<br>
				<br>
			</div>
		</form>

		<script>
    // 세션에서 adminNum 값을 가져와 hidden input에 설정
    document.getElementById('adminNum').value = '<%=((AdminDTO) session.getAttribute("adminDTO")).getAdminNum()%>';

			// 카테고리 선택
			function setCategory(category) {
				document.getElementById('noticeCategory').value = category;
			}
		</script>
	</main>
</body>
</html>