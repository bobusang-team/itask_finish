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
  <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/article/sec/ask.css">
  <script defer src="${pageContext.request.contextPath }/assets/js/article/sec/ask.js"></script>
</head>
<body>

    	<!-- 헤더 영역 -->
	<jsp:include page="./../../basic/header.jsp" />

  <main class="itAskBox">
    <!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
    <div class="bjs-ask-topcontainer">
      <!-- 개발  -->
      <span class="bjs-ask-title">보안</span>
        <!-- 자격증 상위 카테고리 -->
        <div class="bjs-ask-category">
          <button class="bjs-ask-category-btn bjs-ask-select">질문</button>
          <button class="bjs-ask-category-btn"><a href="./tip.jsp">꿀팁</a></button>
        </div>
      <!-- 자격증 태그 버튼 --> <!-- 나중에 더 추가될 수 있으니 ul > li로 바꾸는 것은 어떤지 초현님과 상의 필요-->
      <div class="bjs-ask-tag"> 
        <button class="bjs-ask-tag-btn bjs-ask-select">전체</button>
        <button class="bjs-ask-tag-btn">Network</button>
        <button class="bjs-ask-tag-btn">Web</button>
        <button class="bjs-ask-tag-btn">Mobile</button>
        <button class="bjs-ask-tag-btn">포렌식</button>
        <button class="bjs-ask-tag-btn">악성코드</button>
      </div>

    </div>
      <!--게시물 목록-->
      <section class="bjs-ask-post-list">
        <!-- 게시물 반복 -->
        <article class="bjs-ask-post-item" data-tag="Network">
          <div class="bjs-ask-post-header">
            <span class="bjs-ask-post-tag">Network</span>
            <span class="bjs-ask-post-title"><a href="./askDetail.html"></a></span>
          </div>
          <div class="bjs-ask-post-body">
            <a href="./askDetail.html">최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한</a>
          </div>
          <div class="bjs-ask-post-footer">
            <div class="bjs-ask-post-info">
              <span class="bjs-ask-post-author">27inch 문준혁🏅</span>
              <span class="bjs-ask-post-views">조회수 1000+</span>
              <span class="bjs-ask-post-replies">답글 100+</span>
              <span class="bjs-ask-post-monitor">
                <img src="${pageContext.request.contextPath }/assets/img/monitor.png" alt="사진오류"> 100+
              </span>
            </div>
            <span class="bjs-ask-post-date">2025-01-09 00:00</span>
          </div>
        </article>
        <!-- 추가 게시물은 동일한 구조를 복제 -->
      </section>
      <section class="bjs-ask-post-list">
        <!-- 게시물 반복 -->
        <article class="bjs-ask-post-item" data-tag="Network">
          <div class="bjs-ask-post-header">
            <span class="bjs-ask-post-tag">Network</span>
            <span class="bjs-ask-post-title">게시물 제목 예시</span>
          </div>
          <div class="bjs-ask-post-body">
            최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한
          </div>
          <div class="bjs-ask-post-footer">
            <div class="bjs-ask-post-info">
              <span class="bjs-ask-post-author">27inch 문준혁🏅</span>
              <span class="bjs-ask-post-views">조회수 1000+</span>
              <span class="bjs-ask-post-replies">답글 100+</span>
              <span class="bjs-ask-post-monitor">
                <img src="${pageContext.request.contextPath }/assets/img/monitor.png" alt="사진오류"> 100+
              </span>
            </div>
            <span class="bjs-ask-post-date">2025-01-09 00:00</span>
          </div>
        </article>
        <!-- 추가 게시물은 동일한 구조를 복제 -->
      </section>
      <section class="bjs-ask-post-list">
        <!-- 게시물 반복 -->
        <article class="bjs-ask-post-item" data-tag="Web">
          <div class="bjs-ask-post-header">
            <span class="bjs-ask-post-tag">Web</span>
            <span class="bjs-ask-post-title">게시물 제목 예시</span>
          </div>
          <div class="bjs-ask-post-body">
            최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한
          </div>
          <div class="bjs-ask-post-footer">
            <div class="bjs-ask-post-info">
              <span class="bjs-ask-post-author">27inch 문준혁🏅</span>
              <span class="bjs-ask-post-views">조회수 1000+</span>
              <span class="bjs-ask-post-replies">답글 100+</span>
              <span class="bjs-ask-post-monitor">
                <img src="${pageContext.request.contextPath }/assets/img/monitor.png" alt="사진오류"> 100+
              </span>
            </div>
            <span class="bjs-ask-post-date">2025-01-09 00:00</span>
          </div>
        </article>
        <!-- 추가 게시물은 동일한 구조를 복제 -->
      </section>
      <section class="bjs-ask-post-list">
        <!-- 게시물 반복 -->
        <article class="bjs-ask-post-item" data-tag="Mobile">
          <div class="bjs-ask-post-header">
            <span class="bjs-ask-post-tag">Mobile</span>
            <span class="bjs-ask-post-title">게시물 제목 예시</span>
          </div>
          <div class="bjs-ask-post-body">
            최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한
          </div>
          <div class="bjs-ask-post-footer">
            <div class="bjs-ask-post-info">
              <span class="bjs-ask-post-author">27inch 문준혁🏅</span>
              <span class="bjs-ask-post-views">조회수 1000+</span>
              <span class="bjs-ask-post-replies">답글 100+</span>
              <span class="bjs-ask-post-monitor">
                <img src="${pageContext.request.contextPath }/assets/img/monitor.png" alt="사진오류"> 100+
              </span>
            </div>
            <span class="bjs-ask-post-date">2025-01-09 00:00</span>
          </div>
        </article>
        <!-- 추가 게시물은 동일한 구조를 복제 -->
      </section>
      <section class="bjs-ask-post-list">
        <!-- 게시물 반복 -->
        <article class="bjs-ask-post-item" data-tag="포렌식">
          <div class="bjs-ask-post-header">
            <span class="bjs-ask-post-tag">포렌식</span>
            <span class="bjs-ask-post-title">게시물 제목 예시</span>
          </div>
          <div class="bjs-ask-post-body">
            최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한
          </div>
          <div class="bjs-ask-post-footer">
            <div class="bjs-ask-post-info">
              <span class="bjs-ask-post-author">27inch 문준혁🏅</span>
              <span class="bjs-ask-post-views">조회수 1000+</span>
              <span class="bjs-ask-post-replies">답글 100+</span>
              <span class="bjs-ask-post-monitor">
                <img src="${pageContext.request.contextPath }/assets/img/monitor.png" alt="사진오류"> 100+
              </span>
            </div>
            <span class="bjs-ask-post-date">2025-01-09 00:00</span>
          </div>
        </article>
        <!-- 추가 게시물은 동일한 구조를 복제 -->
      </section>
      <section class="bjs-ask-post-list">
        <!-- 게시물 반복 -->
        <article class="bjs-ask-post-item" data-tag="악성코드">
          <div class="bjs-ask-post-header">
            <span class="bjs-ask-post-tag">악성코드</span>
            <span class="bjs-ask-post-title">게시물 제목 예시</span>
          </div>
          <div class="bjs-ask-post-body">
            최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한최대 글자 수 100자 제한 최대 글자 수 100자 제한 최대 글자 수 100자 제한
          </div>
          <div class="bjs-ask-post-footer">
            <div class="bjs-ask-post-info">
              <span class="bjs-ask-post-author">27inch 문준혁🏅</span>
              <span class="bjs-ask-post-views">조회수 1000+</span>
              <span class="bjs-ask-post-replies">답글 100+</span>
              <span class="bjs-ask-post-monitor">
                <img src="${pageContext.request.contextPath }/assets/img/monitor.png" alt="사진오류"> 100+
              </span>
            </div>
            <span class="bjs-ask-post-date">2025-01-09 00:00</span>
          </div>
        </article>
        <!-- 추가 게시물은 동일한 구조를 복제 -->
      </section>
      <div class="pagination">
        <a href="#">«</a>
        <a href="#">‹</a>
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">›</a>
        <a href="#">»</a>
    </div>
  </main>
  	<!-- 푸터 영역 -->
	<jsp:include page="./../../basic/footer.jsp" />
</body>
</html>