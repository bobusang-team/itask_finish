<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>웹페이지 통합</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/article/sec/tipEdit.css">
  <script defer src="${pageContext.request.contextPath }/assets/js/article/sec/tipEdit.js"></script>

</head>

<body>
     	<!-- 헤더 영역 -->
	<jsp:include page="./../../basic/userheader.jsp" />
  <main class="itAskBox">
    <!-- 메인 -->
    <!-- 카테고리 선택 -->
    <div class="mjh-tipEdit-modify">
      <p class="mjh-tipEdit-modify-title">글 수정</p>
      <p class="mjh-tipEdit-modify-category">카테고리</p>
      <!-- 총카테고리리(태그포함) -->
      <div class="mjh-tipEdit-modify-totalcategory" id="totalcategory">
        <!-- 상위카테고리리 -->
        <div class="mjh-tipEdit-modify-category1">
          <div class="mjh-tipEdit-modify-category1-button " data-category1="개발">개발</div>
          <div class="mjh-tipEdit-modify-category1-button mjh-tipEdit-select" data-category1="보안">보안</div>
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
          <div class="mjh-tipEdit-modify-tag-button mjh-tipEdit-select" data-tag="Network">Network</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="Web">Web</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="Mobile">Mobile</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="포렌식">포렌식</div>
          <div class="mjh-tipEdit-modify-tag-button" data-tag="악성코드">악성코드</div>
        </div>
      </div>
      <!-- 제목 -->
      <div class="mjh-tipEdit-modify-title-section">
        <input type="text" id="title" value="게시물 제목 예시"  minlength="8" required />
      </div>
      <!-- 글상자 -->
      <div class="mjh-tipEdit-modify-content-section">
        <textarea id="content" rows="30" minlength="20" required>본문내용1 본문내용1</textarea>
      </div>
      <!-- 첨부파일 입력 -->
      <div class="mjh-tipEdit-modify-file">
        <div class="mjh-tipEdit-modify-file-up-container">
          <div class="mjh-tipEdit-modify-file-upload-container">
            <div class="mjh-tipEdit-modify-upload-box">
              <label for="file-upload">첨부파일 선택</label>
              <input type="file" id="file-upload" accept="image/*">
            </div>
            <!-- 업로드 버튼 -->
            <div class="mjh-tipEdit-modify-upload-button">업로드</div>
          </div>
        </div>
        <!-- 첨부파일 안내 -->
        <!-- <div class="file-upload-hint">첨부 파일은 자격증 글쓰기 페이지에서만 보여짐</div> -->
      </div>
      <!-- 글 수정하기 버튼 -->
      <div class="mjh-tipEdit-modify-submit-button">글 수정하기</div>
    </div>
  </main>
    	<!-- 푸터 영역 -->
	<jsp:include page="./../../basic/footer.jsp" />
</body>


</html>