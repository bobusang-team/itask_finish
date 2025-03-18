<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>visitor header</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/header.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/footer.css">
<script defer
	src="${pageContext.request.contextPath }/assets/js/main/main-rank2.js"></script>
<script defer
	src="${pageContext.request.contextPath }/assets/js/main/mainbem.js"></script>
<script defer
	src="${pageContext.request.contextPath }/assets/js/main/mainclick.js"></script>
<script defer
	src="${pageContext.request.contextPath }/assets/js/main/mainnotice.js"></script>
<script defer
	src="${pageContext.request.contextPath }/assets/js/main/mainpro.js"></script>
</head>
<body>
	<jsp:include page="./app/basic/header.jsp" />
	<div class=" main-banner">
		<div class="main-outer">
			<div id="banner-slider" class="slider">
				<div class="banner-item">

					<img
						src="${pageContext.request.contextPath }/assets/img/it-img2.jpg"
						alt="Banner 1" class="bannermall"> <span
						class="banner-img-text">Banner Text 1</span>
				</div>
				<div class="banner-item">
					<img
						src="${pageContext.request.contextPath }/assets/img/it-img3.jpg"
						alt="Banner 2" class="bannermall"> <span
						class="banner-img-text">Banner Text 2</span>
				</div>
				<div class="banner-item">
					<img
						src="${pageContext.request.contextPath }/assets/img/it-img6.jpg"
						alt="Banner 3" class="bannermall"> <span
						class="banner-img-text">Banner Text 3</span>
				</div>
			</div>

			<div class="banner-controls">
				<main-clickbox-button class="banner-left"> <img
					src="${pageContext.request.contextPath }/assets/img/arrow_left.png"
					alt="main-clickbox-button 1" class="bannerbtn"> </main-clickbox-button>
				<main-clickbox-button class="banner-right"> <img
					src="${pageContext.request.contextPath }/assets/img/arrow_right.png"
					alt="main-clickbox-button 2" class="bannerbtn"> </main-clickbox-button>
			</div>
		</div>
	</div>

	<main>
		<div class="main-container">
			<div class="main-content-wrapper">
				<!-- 랭킹 (왼쪽 상단) -->

				<section class="main-ranking-body">
					<div class="main-ranking-list">
						<h1>명예의 전당</h1>
						<div class="main-ranking-container" id="main-ranking-container">
							<!-- js로 구현 -->
							<div id="context-path" data-path="<%=request.getContextPath()%>"></div>

						</div>
				</section>
				
				<!-- 메인 (랭킹 오른쪽에 위치) -->
				<!-- 이달의 Best Moon(질문) -->
				<section class="bestQ">
				
					<h3>이달의 Best 질문</h3>
					<a id="bestMoonLink" href="#"> 
					<span id="bestMoonTag">카테고리</span>
						<div>
							<img src="./assets/img/best-que.png" alt="">
						</div>
						<h4 id="bestMoonTitle">게시물 제목</h4>
						<p id="bestMoonText">이달의 베스트 질문 게시물 내용입니다.</p>
						<p>
						작성자 : <span id ="bestMoonUserNick"> 닉네임 없음</span>
						<img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="monitor" class="monitor-icon">
						<span id = "bestMoonMonitor" > 0 </span>						
						</p>
					</a>
				</section>

				<!-- 이달의 Best 꿀팁 -->
				<section class="bestT">
					<h3>이달의 Best 꿀팁</h3>
					<a id="bestTipLink" href="#">
					<span id="bestTipTag">카테고리</span>
						<div>
							<img src="./assets/img/best-tip.png" alt="">
						</div>
						<h4 id="bestTipTitle">게시물 제목</h4>
						<p id="bestTipText">이달의 베스트 꿀팁 게시물 내용입니다. </p>
						<p>
						작성자 : <span id ="bestTipUserNick"> 닉네임 없음</span>
						<img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="monitor" class="monitor-icon">
						<span id = "bestTipMonitor" > 0 </span>
						</p>
					</a>
				</section>
				
				<script>
				console.log(window.location.pathname);
				document.addEventListener("DOMContentLoaded", function () {
					fetch(window.location.pathname.includes('/AskIT_eend') 
							? "/AskIT_eend/bestArticles/mainBestArticles.main" 
							: "/bestArticles/mainBestArticles.main") // 컨트롤러에서 JSON 응답을 받음
				        .then(response => {
				            if (!response.ok) {
				                throw new Error(`서버 응답 오류 : ${response.status}`);
				            }	
				            return response.json();
				        })
				        .then(data => {
				            console.log("받은 데이터:", data); // 디버깅용 출력

				            if (data.bestMoon) {
				                document.getElementById("bestMoonTag").textContent = data.bestMoon.articleBotCate || "카테고리 없음";
				                document.getElementById("bestMoonTitle").textContent = data.bestMoon.articleTitle || "제목 없음";
				                document.getElementById("bestMoonText").textContent = data.bestMoon.articleText || "내용 없음";

				                document.getElementById("bestMoonUserNick").textContent = data.bestMoon.userNick || "닉네임 없음";
				                document.getElementById("bestMoonMonitor").textContent = data.bestMoon.articleMonitorNum || "0";
				             
				                document.getElementById("bestMoonLink").href = `${pageContext.request.contextPath}/dev/detailAsk.dev?articleNum=${data.bestMoon.articleNum}`;
				            }

				            if (data.bestTip) {
				                document.getElementById("bestTipTag").textContent = data.bestTip.articleBotCate || "카테고리 없음";
				                document.getElementById("bestTipTitle").textContent = data.bestTip.articleTitle || "제목 없음";
				                document.getElementById("bestTipText").textContent = data.bestTip.articleText || "내용 없음";

				                document.getElementById("bestTipUserNick").textContent = data.bestTip.userNick || "닉네임 없음";
				                document.getElementById("bestTipMonitor").textContent = data.bestTip.articleMonitorNum || "0";
				                
				                document.getElementById("bestTipLink").href = `${pageContext.request.contextPath}/dev/detailAsk.dev?articleNum=${data.bestMoon.articleNum}`;
				            }
				        })
				        .catch(error => console.error("데이터 로딩 오류:", error));
				});
</script>
	</main>

	<!-- 메인 공지사항 -->

	<section class="main-notice">
		<div class="main-notice-head">
			<main-clickbox-button class="main-notice-main-clickbox-button"
				id="noticebutton">공지사항</main-clickbox-button>
		</div>
		<div class="main-notice-body">
			<div class="main-notice-list">
				<div class="main-notice-item" data-id="1">
					<span class="main-notice-category">공지</span> <span
						class="main-notice-title">공지제목</span> <span
						class="main-notice-date">2025-01-15</span>
				</div>
				<div class="main-notice-item" data-id="2">
					<span class="main-notice-category">공지</span> <span
						class="main-notice-title">공지제목</span> <span
						class="main-notice-date">2025-01-15</span>
				</div>
				<div class="main-notice-item" data-id="3">
					<span class="main-notice-category">공지</span> <span
						class="main-notice-title">공지제목</span> <span
						class="main-notice-date">2025-01-15</span>
				</div>
			</div>
		</div>
	</section>

	<!-- 오늘의 랜덤 퀴즈 (랭킹 메인 아래 위치)-->
	<div class="main-pro-quiz-container">
		<h3 class="main-pro-quiz-title">오늘의 랜덤퀴즈!</h3>
		<div class="main-pro-quiz-box">
			<p class="main-pro-quiz-question">이건 뭘까요?</p>
			<button class="main-pro-answer-btn" id="check-answer-btn">문제풀기</button>
		</div>
	</div>
	<!-- 문제 모달 창 -->
	<div class="main-pro-modal" id="quiz-modal">
		<div class="main-pro-modal-content">
			<p class="main-pro-modal-question">Q.</p>
			<div class="main-pro-quiz-options"></div>

			<button class="main-pro-answer-btn" id="show-answer-btn">정답
				확인</button>
			<p id="pro-answer-dropdown" style="display: none; margin-top: 10px;"></p>

			<button class="main-pro-modal-close-btn" id="close-quiz-modal">닫기</button>
		</div>
	</div>

	<button id="open-quiz-modal"></button>
	<script>
        // 문제풀기 버튼 클릭 시 모달 창 열기

        document
                .getElementById('check-answer-btn')
                .addEventListener(
                        'click',
                        function() {
                            document.getElementById('quiz-modal').style.display = 'flex';
                        });
        // 정답 확인 버튼 클릭 시 정답 표시
        document
                .getElementById('show-answer-btn')
                .addEventListener(
                        'click',
                        function() {
                            document.getElementById('pro-answer-dropdown').style.display = 'block'; // 정답 표시
                        });
        // 모달 닫기
        document
                .getElementById('close-quiz-modal')
                .addEventListener(
                        'click',
                        function() {
                            document.getElementById('quiz-modal').style.display = 'none';
                        });
    </script>
	<!-- 자격증(랜덤 퀴즈 아래 위치) -->
	<div class="main-clickbox">
		<p class="main-title">
			따고싶은 자격증이 있으신가요? 빠르게 <a href="./../article/qual/guide/infoSec.html"
				class="main-date">일정</a> 확인하세요!
		</p>
		<div class="main-clickbox">
			<div class="main-clickbox-button">
				<a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp">정보보안기사</a>
			</div>
			<div class="main-clickbox-button">
				<a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp">정보보안산업기사</a>
			</div>
			<div class="main-clickbox-button">
				<a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp">정보처리기사</a>
			</div>
			<div class="main-clickbox-button">
				<a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp">정보처리산업기사</a>
			</div>
			<div class="main-clickbox-button">
				<a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp">정보처리기능사</a>
			</div>
			<div class="main-clickbox-button">
				<a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp">리눅스
					마스터</a>
			</div>
			<div class="main-clickbox-button">
				<a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp">네트워크관리사</a>
			</div>
		</div>
		<p class="main-title">
			관심있는 <a href="${pageContext.request.contextPath}/dev/listAsk.dev"
				class="main-date">태그</a>를 클릭해보세요!
		</p>
		<div class="main-clickbox main-interest">
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/dev/listAsk.dev">Java</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/dev/listAsk.dev">HTML</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/dev/listAsk.dev">CSS</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/dev/listAsk.dev">JavaScript</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/dev/listAsk.dev">Oracle</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/dev/listAsk.dev">Web</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/app/article/sec/ask.jsp">Network</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/app/article/sec/ask.jsp">Mobile</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/app/article/sec/ask.jsp">포렌식</a>
			</div>
			<div class="main-clickbox-button">
				<a href="${pageContext.request.contextPath}/app/article/sec/ask.jsp">악성코드</a>
			</div>
		</div>
	</div>
	<jsp:include page="./app/basic/footer.jsp" /></body>
</html>




