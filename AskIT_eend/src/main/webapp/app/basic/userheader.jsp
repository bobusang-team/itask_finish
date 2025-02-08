<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO" %>

<!-- 로그인 성공 시 헤더 -->
<!-- 헤더 -->
  <header class="header-box">
    <div class="header-container">
      <!-- 로고 -->
      <a href="${pageContext.request.contextPath}/usermain.jsp" class="header-brand">
        <img src="${pageContext.request.contextPath}/assets/img/logo/logo_b.png" alt="iTask Logo" class="header-logo">
      </a>
      <!-- 검색 -->
      <div class="search-box">
        <div class="search-input-container">
          <input type="text" class="search-input" placeholder="검색어를 입력하세요">
          <button class="search-logo">
            <img src="${pageContext.request.contextPath}/assets/img/readingGlass.png" alt="search-icon">
          </button>
        </div>
        <!-- 검색상자 -->
        <a href="${pageContext.request.contextPath }/write/write.wr" class="write-box">
          <img src="${pageContext.request.contextPath}/assets/img/File Plus 02.png" alt="fileplus2" class="icon"> 글쓰기
        </a>
      </div>
      <!-- 헤더 네비바 -->
      <nav class="header-nav">
        <ul class="head-container">
          <li class="head-item">
            <!-- 내정보 모니터 -->
            <%@ page session="true" %>
			<%
			    UserDTO userInfo = (UserDTO)session.getAttribute("userDTO");
				System.out.println(userInfo);
				String userNick = "";
				int userMonitor = 0;
			
			    if (userInfo != null) {
			        userNick = userInfo.getUserNick();
			        userMonitor = userInfo.getUserMonitor();
			        
			      	System.out.println(userMonitor);
			    }else{
			%>
			
			<script>
				location.href = "${pageContext.request.contextPath}/app/member/login.jsp";
			</script>
			<%
			    }
			%>
            
            <a href="${pageContext.request.contextPath}/mypage/mypageMainOk.my" class="head-link">
              <span id="user-name">
				<%= userNick %>님
              </span>
              <div class="monitor-box">
                <div class="monitor-level" id="monitor-levelup">
                <%= userMonitor/100 %> inch
                </div>
                <img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="monitor" class="monitor-icon">
                <span id="monitor-level">
				<%= userMonitor%100 %> m
                </span>
              </div>
            </a>
          </li>
          <li class="head-item">
            <!-- 유저 아이콘 -->
            <a href="${pageContext.request.contextPath}/mypage/mypageMainOk.my" class="head-link">
              <div class="user-png">
                <img src="${pageContext.request.contextPath}/assets/img/user.png" alt="user" class="user-icon">
              </div>
            </a>
          </li>
          <li class="head-item">
            <!-- 로그아웃 -->
            <a href="${pageContext.request.contextPath}" class="head-link logout-box">
              <img src="${pageContext.request.contextPath}/assets/img/Logout.png" alt="logout" class="logout-top">
           	 	<!-- <script>
           	 		document.getElementsByClassName('logout-top').addEventListener('click', ()=>sessionStorage.clear());
           	 	</script> -->
            </a>
          </li>
        </ul>
      </nav>
    </div>
  </header>
  <!-- 네비게이션 바 -->
  <nav class="navbar-box">
    <div class="navbar-container">
      <ul class="navbar-nav">
        <li class="nav-item dropdown">
          <a href="${pageContext.request.contextPath}/app/introduce/itask.jsp" class="nav-link">ITASK란?</a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/app/intro/itask.jsp" class="dropdown-link">소개글</a></li>
            <li><a href="${pageContext.request.contextPath}/app/intro/contents.jsp" class="dropdown-link">명예의 전당</a></li>
          </ul>
        </li>
        <li class="nav-item"><a href="${pageContext.request.contextPath}/app/notice/notice.no"
         class="nav-link">공지사항</a></li>
        <li class="nav-item dropdown">
          <a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=질문" class="nav-link">개발</a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=질문" class="dropdown-link">질문</a></li>
            <li><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=꿀팁" class="dropdown-link">꿀팁</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
         <a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=보안&articleBotcate=질문" class="nav-link">보안</a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=보안&articleBotcate=질문" class="dropdown-link">질문</a></li>
            <li><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=보안&articleBotcate=꿀팁" class="dropdown-link">꿀팁</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp" class="nav-link">자격증</a>
          <ul class="dropdown-menu">
            <li><a href="${pageContext.request.contextPath}/app/article/qual/guide/infoPro.jsp" class="dropdown-link">시험안내</a></li>
           <li><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=자격증&articleBotcate=질문" class="dropdown-link">질문</a></li>
            <li><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=자격증&articleBotcate=꿀팁" class="dropdown-link">꿀팁</a></li>
          </ul>
        </li>
      </ul>
    </div>
  </nav>