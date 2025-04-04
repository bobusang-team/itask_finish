<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/article/sec/tipDetail.css">
  <script defer src="${pageContext.request.contextPath }/assets/js/article/sec/tipDetail.js"></script>
</head>

<body>
    	<!-- 헤더 영역 -->
	<jsp:include page="./../../basic/userheader.jsp" />
  <!-- 메인 영역 -->
  <main class="itAskBox">
    <!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
    <article class="mjh-tipDetail-elements">
      <!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
      <div class="mjh-tipDetail-topcontainer">
        <!-- 자격증  -->
        <span class="mjh-tipDetail-title">보안</span>
        <!-- 자격증 상위 카테고리 -->
        <div class="mjh-tipDetail-category">
          <button class="mjh-tipDetail-category-btn" onclick="location.href='./ask.html'">질문</button>
          <button class="mjh-tipDetail-category-btn mjh-tipDetail-select" onclick="location.href='./tip.html'">꿀팁</button>
        </div>
      </div>
      <!-- 준혁님 코드 들어갈 부분 (게시글 내용) -->
      <!-- 본문 전체체 -->
      <article class="mjh-tipDetail-text-total" data-tag="악성코드">
        <!-- 본문 헤더더 -->
        <div class="tipDetail-text-header">
          <span class="mjh-tipDetail-text-tag">악성코드</span>
          <div class="mjh-tipDetail-text-title">게시물 제목 예시</div>
          <div class="mjh-tipDetail-text-profile">
            <img src="${pageContext.request.contextPath }/assets/img/profile.png" alt="">
            <span class="mjh-tipDetail-text-author"><b>27inch</b> 문준혁🏅</span>
          </div>
          <div class="mjh-tipDetail-text-date">2025-01-09 00:00</div>
        </div>
        <!-- 본문 메인인 -->
        <article class="mjh-tipDetail-text-textbody">
          본문내용1 본문내용1
        </article>
        <!-- 본문 바텀텀 -->
        <article class="mjh-tipDetail-text-textbottom">
          <!-- 본문 태그그 -->
          <span class="mjh-tipDetail-text-bottom-tag">보안</span>
          <span class="mjh-tipDetail-text-bottom-tag">꿀팁</span>
          <span class="mjh-tipDetail-text-bottom-tag">악성코드</span>
          <!-- 본문 모니터, 댓글, 공유수 -->
          <div class="mjh-tipDetail-content">
            <img src="${pageContext.request.contextPath }/assets/img/moniter.png" alt="모니터수" id="Detail-moniter-img">
            <span id="Detail-monitercount">0</span>
            <img src="${pageContext.request.contextPath }/assets/img/view.png" alt="조회수" id="Detail-view-img">
            <span id="Detail-viewcount">0</span>
            <img src="${pageContext.request.contextPath }/assets/img/share.png" alt="공유수" id="Detail-share-img">
            <span id="Detail-sharecount">0</span>
            <!-- 본문 수정삭제 드롭다운-->
            <div class="mjh-tipDetail-dropdown">
              <img src="${pageContext.request.contextPath }/assets/img/Container.png" alt="드롭다운 이미지" class="mjh-tipDetail-dropdown-img"
                onclick="Dropdown()">
              <div class="mjh-tipDetail-dropdown-menu" id="dropdownMenu">
                <a href="#">수정</a>
                <a href="#" id="postdelete">삭제</a>
              </div>
            </div>
          </div>
        </article>
      </article>
      <!-- 게시글 내용에 대한 댓글 부분 -->
      <article class="mjh-tipDetail-comment-box">

        <!-- 총 댓글 수 -->
        <div class="mjh-tipDetail-comment-count">댓글 <span id="comment-count">1</span></div>
        <!-- 댓글 작성 창 -->
        <div class="mjh-tipDetail-comment-input">
          <textarea id="comment-input" name="mjh-tipDetail-ask-box" rows="4" cols="50" placeholder="칭찬 댓글은 작성자에게 큰 힘이 됩니다."></textarea>
          <button onclick="addComment()" class="mjh-tipDetail-add-btn">올리기</button>
        </div>

        <!-- 작성된 댓글이 보여지는 리스트 창 -->
        <div id="comment-section">
          <!-- --------------------------여기서부터 댓글 하나당-------------------- -->
          <div class="mjh-tipDetail-comment-show">
            <span class="mjh-tipDetail-commnet-author">27inch 문준혁🏅</span>
            <div class="mjh-tipDetail-comment-section"> 보여주기용 댓글 입니다</div>
            <!-- 작성된 날짜, 조회수, 모니터를 담은 박스 -->
            <div class="mjh-tipDetail-comment-info">
              <span class="mjh-tipDetail-comment-date">14일전</span>
              <span class="mjh-tipDetail-comment-monitor">
                <img src="${pageContext.request.contextPath }/assets/img/monitor.png" alt="사진오류" class="mjh-tipDetail-comment-cnt"> 
                <span id="tipDetail-comment-monitor-num" class="mjh-tipDetail-comment-monitor-num">100</span>
              </span>
            </div>
          </div>
          <!-- --------------------------이만큼 추가돼야함^_^~-------------------- -->
        </div>
      </article>

    </article>
  </main>
    	<!-- 푸터 영역 -->
	<jsp:include page="./../../basic/footer.jsp" />
</body>

</html>