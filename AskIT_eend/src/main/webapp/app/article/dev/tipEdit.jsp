<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>웹페이지 통합</title>
  <link rel="stylesheet" href="./../../../assets/css/article/dev/tipEdit.css">
  <script defer src="./../../../assets/js/article/dev/tipEdit.js"></script>

</head>

<body>
  <!-- 헤더 -->
  <header>
    
  </header>
  <main class="itAskBox">
    <!-- 메인 -->
    <!-- 카테고리 선택 -->
    <div class="mjh-tipEdit-modify">
      <p class="mjh-tipEdit-modify-title">글 수정</p>
      
      <!-- 총카테고리리(태그포함) -->
      <div class="mjh-tipEdit-modify-totalcategory" id="totalcategory">
      <p class="mjh-tipEdit-modify-category">카테고리</p>
      <p class="mjh-tipEdit-modify-category">카테고리</p>
        <!-- 상위카테고리리 -->
        <div class="mjh-tipEdit-modify-category1">
          <div class="mjh-tipEdit-modify-category1-button mjh-tipEdit-select" data-category1="개발">개발</div>
          <div class="mjh-tipEdit-modify-category1-button" data-category1="보안">보안</div>
          <div class="mjh-tipEdit-modify-category1-button" data-category1="자격증">자격증</div>
        </div>
        <!-- 하위 카테고리리 -->
        <div class="mjh-tipEdit-modify-category2">
          <div class="mjh-tipEdit-modify-category2-button" data-category2="질문">질문</div>
          <div class="mjh-tipEdit-modify-category2-button mjh-tipEdit-select" data-category2="꿀팁">꿀팁</div>
        </div>
        <!-- 태그그 -->
        <p class="mjh-tipEdit-modify-category">태그</p>
        <div class="mjh-tipEdit-modify-tag">
          <div class="mjh-tipEdit-modify-tag-button mjh-tipEdit-select" data-tag="Java">Java</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="HTML">HTML</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="Css">Css</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="JavaScript">JavaScript</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="Oracle">Oracle</div>
        </div>
      </div>
      <!-- 제목 -->
     <form method="POST"
				action="${pageContext.request.contextPath}/dev/updateOk.dev?articleNum=${dev.articleNum}">
	      <div class="mjh-tipEdit-modify-title-section">
	        <input type="text" id="title" value="게시물 제목 예시"  minlength="8" required />
	      </div>
	      <!-- 글상자 -->
	      <div class="mjh-tipEdit-modify-content-section">
	        <textarea id="content" rows="30" minlength="20" required>본문내용1 본문내용1</textarea>
	      </div>
	      <!-- 글 수정하기 버튼 -->
      	<button id="submitbtn" type="submit">글 수정하기</button>
      </form>
    </div>
  </main>
</body>
<footer>
  <div class="mjh-tipEdit-modify-file-binbox"></div>
</footer>

</html>