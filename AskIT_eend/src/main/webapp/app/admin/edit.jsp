<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic/header.css">
 <script defer src="${pageContext.request.contextPath}/assets/js/admin/basic/header.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/edit.css">
<script defer src="${pageContext.request.contextPath}/assets/js/admin/edit.js"></script>
</head>
<body>
<jsp:include page="./basic/header.jsp" />
	<main class="itAskBox">
        <div class="notice">공지게시판 게시글 수정</div>
        <!-- 메인 -->
        <!-- 카테고리 선택 -->
        <div class="write-click">
            <p class="write-title">카테고리 선택</p>
            <div class="write-clickbox1">
                <div class="write-button"  id="all"> 전체</div>
                <div class="write-button"  id="dev"> 개발</div>
                <div class="write-button" id="sec">보안</div>
                <div class="write-button" id="qual">자격증</div>
            </div>
            <!-- 제목 -->
            <div class="write-title-section">
                <input type="text" id="title" value="<공지>블랙리스트 회원안내" minlength="8" required />
            </div>
            <!-- 글상자 -->
            <div class="write-content-section">
                <textarea rows="30" id="content" minlength="20" required>지수지듀</textarea>
            </div>
            <!-- 첨부파일 입력 -->
            <div class="write-file">
                <div class="file-up-container">
                    <div class="file-upload-container">
                        <div class="upload-box">
                            <label for="file-upload">첨부파일 선택</label>
                            <input type="file" id="file-upload" accept="image/*">
                        </div>
                        <!-- 업로드 버튼 -->
                        <div class="upload-button">업로드</div>
                    </div>
                </div>
                <!-- 첨부파일 안내 -->
                <br><br><br><br>
                <!-- 글 작성하기 버튼 -->
                <div class="submit-button">글 작성하기</div>
            </div>
        </div>
    </main>
</body>
</html>