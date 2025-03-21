<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>visitor header</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath }/assets/css/main.css">
<script defer
   src="${pageContext.request.contextPath }/assets/js/main/main-rank2.js"></script>
</head>
<body>
   <jsp:include page="./app/basic/header.jsp"/>
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
               <main-clickbox-button class="banner-right">
               <img
                  src="${pageContext.request.contextPath }/assets/img/arrow_right.png"
                  alt="main-clickbox-button 2" class="bannerbtn"> </main-clickbox-button>
            </div>
         </div>
      </div>

      <main>
         <div class="main-container">
            <div class="main-content-wrapper">
               <!-- 명예의 전당 (왼쪽 상단) -->

               <script>
               //명예의 전당 데이터를 불러오는 함수
               async function fetchRanking(){
                  try{
                     const response = await fetch('/ranking/mainRank.ma'); // 서블릿 호출
                     if(!response.ok){
                        throw new Error('서버 응답 오류');
                     }
                     const data = await response.json(); //joson -> 데이터로 변환
                     
                     const rankingContainer = document.getElementById('main-ranking-container');
                     rankingContainer.innerHTML = ''; //기존 목록 초기화
                     
                     data.forEach((user, index) => {
                        const rankingCard = document.createElement('div');
                        rankingCard.classList.add('ranking-card');
                        rankingCard.innerHTML = `
                        <div class = "ranking">${index + 1}</div>
                        <div class = "info">
                           <dic class = "name"><a href="/user/${user.userId}" class="ranking=link">${user.userNick}</a></div>
                           <div class = "details">${user.userCareer || '경력 정보 없음'}</div>
                           </div>
                           <div class = "icon">
                              <img src="/path/to/icon/${user.userId}.jpg" alt="${user.userNick} icon" />
                              </div>
                              `;
                              rankingContainer.appendChild(rankingCard);
                           });
                     } catch (error) {
                        console.error('데이터를 불러오는 중 error 발생:', error);
                        }                                 
                     }
               
               setInterval(fetchRanking, 60000); //60초마다 갱신
               fetchRanking(); // 페이지 로딩 시 초기 실행                                             
               </script>
               
               <section class="main-ranking-body">
                  <div class="main-ranking-list">
                     <h1>명예의 전당</h1>
                     <div class="main-ranking-container" id="main-ranking-container">

                     </div>
                  </div>
               </section>
               

               <!-- 메인 (랭킹 오른쪽에 위치) -->
               <section class="bestQ">
            <h3>이달의 Best 질문</h3>
            <a href="#">
              <span>java</span>
              <div><img src="./assets/img/best-que.png" alt=""></div>
              <h4>게시물 제목</h4>
              <p>이달의 베스트 질문 게시물 내용입니다 이달의 베스트 질문 게시물 내용입니다 이달의 베스트 질문 게시물 내용입니다 이달의 베스트 질문 게시물 내용입니다이달의 베스트 질문 게시물 내용입니다 </p>
            </a>
          </section>

          <section class="bestT">
            <h3>이달의 Best 질문</h3>
            <a href="#">
              <span>java</span>
              <div><img src="./assets/img/best-tip.png" alt=""></div>
              <h4>게시물 제목</h4>
              <p>이달의 베스트 질문 게시물 내용입니다 이달의 베스트 질문 게시물 내용입니다 이달의 베스트 질문 게시물 내용입니다 이달의 베스트 질문 게시물 내용입니다 이달의 베스트 질문 게시물 내용입니다</p>
            </a>
          </section>
      </main>

      <!-- 메인 공지사항 -->

      <section class="main-notice">
         <biv class="main-notice-head"> <main-clickbox-button
            class="main-notice-main-clickbox-button" id="noticebutton">공지사항</main-clickbox-button>
         </biv>
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
            <p class="main-pro-quiz-question">이건 뭘까요? 문제문제</p>
            <main-clickbox-button class="main-pro-answer-btn"
               id="check-answer-btn">문제풀기</main-clickbox-button>
         </div>
      </div>
      <!-- 문제 모달 창 -->
      <div class="main-pro-modal" id="quiz-modal">
         <div class="main-pro-modal-content">
            <p class="main-pro-modal-question">Q. 1+1=?</p>
            <div class="main-pro-quiz-options">
               <label><input type="radio" name="quiz-option" value="1">
                  1. 귀요미</label><br> <label><input type="radio"
                  name="quiz-option" value="2"> 2. 2</label><br> <label><input
                  type="radio" name="quiz-option" value="3"> 3. 0</label><br> <label><input
                  type="radio" name="quiz-option" value="4"> 4. 정답없음</label>
            </div>
            <main-clickbox-button class="main-pro-answer-btn"
               id="show-answer-btn">정답 확인</main-clickbox-button>
            <p id="pro-answer-dropdown" style="display: none; margin-top: 10px;">
               정답: <strong>2. 2</strong>
            </p>
            <main-clickbox-button class="main-pro-modal-close-btn"
               id="close-quiz-modal">닫기</main-clickbox-button>
         </div>
      </div>
      <script>
         // 문제풀기 버튼 클릭 시 모달 창 열기
         document
               .getElementById('check-answer-btn')
               .addEventListener(
                     'clickbox',
                     function() {
                        document.getElementById('quiz-modal').style.display = 'flex';
                     });
         // 정답 확인 버튼 클릭 시 정답 표시
         document
               .getElementById('show-answer-btn')
               .addEventListener(
                     'clickbox',
                     function() {
                        document.getElementById('pro-answer-dropdown').style.display = 'block'; // 정답 표시
                     });
         // 모달 닫기
         document
               .getElementById('close-quiz-modal')
               .addEventListener(
                     'clickbox',
                     function() {
                        document.getElementById('quiz-modal').style.display = 'none';
                     });
      </script>
      </div>
      <!-- 자격증(랜덤 퀴즈 아래 위치) -->
      <div class="main-clickbox">
         <p class="main-title">
            따고싶은 자격증이 있으신가요? 빠르게 <a href="./../article/qual/guide/infoSec.html"
               class="main-date">일정</a> 확인하세요!
         </p>
         <div class="main-clickbox">
            <div class="main-clickbox-button">
               <a href="./../article/qual/guide/infoSec.html">정보보안기사</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/qual/guide/infoSec.html">정보보안산업기사</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/qual/guide/infoPro.html">정보처리기사</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/qual/guide/infoPro.html">정보처리산업기사</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/qual/guide/infoPro.html">정보처리기능사</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/qual/guide/linuxMaster.html">리눅스 마스터</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/qual/guide/netManager.html">네트워크관리사</a>
            </div>
         </div>
         <p class="main-title">
            관심있는 <a href="./../article/dev/ask.html" class="main-date">태그</a>를
            클릭해보세요!
         </p>
         <div class="main-clickbox main-interest">
            <div class="main-clickbox-button">
               <a href="./../article/dev/ask.html">Java</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/dev/ask.html">HTML</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/dev/ask.html">CSS</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/dev/ask.html">JavaScript</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/dev/ask.html">Oracle</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/sec/ask.html">Web</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/sec/ask.html">Network</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/sec/ask.html">Mobile</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/sec/ask.html">포렌식</a>
            </div>
            <div class="main-clickbox-button">
               <a href="./../article/sec/ask.html">악성코드</a>
            </div>
         </div>
      </div>
      </div>
      <jsp:include page="./app/basic/footer.jsp"/></body>
</html>
