<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.itask.app.dto.AdminDTO" %>
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
	href="${pageContext.request.contextPath}/assets/css/admin/write.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/write.js"></script>
</head>
<body>
	<jsp:include page="./basic/header.jsp" />
	<main class="itAskBox">
		
		
		<!-- 메인 -->
		<!-- 카테고리 선택 -->
		<form action="${pageContext.request.contextPath}/admin/writeOk.ad" method="post">
    <div class="write-click">
        <p class="noticeWrite">공지게시판 글쓰기</p>
        <hr>

        <p class="write-title">카테고리 선택</p>
        <div class="write-clickbox1">
            <input type="hidden" name="noticeCategory" id="noticeCategory" value="전체" />
            <div class="write-button" id="all" onclick="setCategory('전체')"> 전체</div>
            <div class="write-button" id="dev" onclick="setCategory('개발')"> 개발</div>
            <div class="write-button" id="sec" onclick="setCategory('보안')"> 보안</div>
            <div class="write-button" id="qual" onclick="setCategory('자격증')"> 자격증</div>
        </div>
        <!-- 제목 -->
        <div class="write-title-section">
            <input type="text" name="noticeTitle" id="title" placeholder="제목을 입력하세요(최소 8자)"
                minlength="8" required />
        </div>
        <!-- 글상자 -->
        <div class="write-content-section">
            <textarea rows="30" name="noticeText" id="content" minlength="20"
                placeholder="내용을 입력하세요(최소 20자)" required></textarea>
        </div>
        <!-- 첨부파일 입력 -->
        <div class="write-file">
            <input type="hidden" name="adminNum" id="adminNum" />
            <div class="file-up-container">
                <div class="file-upload-container">
                    <div class="upload-box">
                        <label for="file-upload">첨부파일 선택</label> 
                        <input type="file" id="file-upload" name="fileUpload" accept="image/*">
                    </div>
                </div>
            </div>
            <button class="submit-button" type="submit">글 작성하기</button>
        </div>
    </div>
</form>

<script>
    // 세션에서 adminNum 값을 가져와 hidden input에 설정
    document.getElementById('adminNum').value = '<%= ((AdminDTO) session.getAttribute("adminDTO")).getAdminNum() %>';

    // 카테고리 선택
    function setCategory(category) {
        document.getElementById('noticeCategory').value = category;
    }
</script>
	</main>
</body>
</html>