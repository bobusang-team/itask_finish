<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script defer
	src="${pageContext.request.contextPath }/assets/js/main/headerVisitor.js"></script>
<!-- 헤더 -->
<header class="header-box">
	<div class="header-container">
		<a href="${pageContext.request.contextPath }/main.jsp" class="header-brand"> <img
			src="${pageContext.request.contextPath }/assets/img/logo/logo_b.png"
			alt="iTask Logo" class="header-logo">
		</a>
		<div class="search-box">
			<div class="search-input-container">
				<input type="text" class="search-input" placeholder="검색어를 입력하세요">
				<button class="search-logo">
					<img
						src="${pageContext.request.contextPath }/assets/img/readingGlass.png"
						alt="search-icon">
				</button>
			</div>
			<a href="${pageContext.request.contextPath }/write/write.wr"
				class="write-box"> <img
				src="${pageContext.request.contextPath }/assets/img/File Plus 02.png"
				alt="fileplus2" class="icon"> 글쓰기
			</a>
		</div>
		<nav class="header-nav">
			<ul class="head-container">
				<li class="head-item"><a
					href="${pageContext.request.contextPath }/app/member/login.jsp"
					class="head-link"> 로그인 </a></li>
					
				<li class="head-item"><a
					href="${pageContext.request.contextPath }/app/member/agreement.jsp"
					class="head-link"> 회원가입 </a></li>
			</ul>
		</nav>
	</div>
	<!-- 네비게이션 바 -->
	<nav class="navbar-box">
		<div class="navbar-container">
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					href="${pageContext.request.contextPath}/app/introduce/itask.jsp"
					class="nav-link">ITASK란?</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/app/introduce/itask.jsp"
							class="dropdown-link">소개글</a></li>
						<li><a
							href="${pageContext.request.contextPath}/app/introduce/contents.jsp"
							class="dropdown-link">명예의 전당</a></li>
					</ul></li>
				<li class="nav-item"><a
					href="${pageContext.request.contextPath}/app/notice/notice.no"
					class="nav-link">공지사항</a></li>
				<li class="nav-item dropdown"><a
					href="${pageContext.request.contextPath}/dev/listAsk.dev"
					class="nav-link">개발</a>
					<ul class="dropdown-menu">
					<li><a href="${pageContext.request.contextPath}/dev/listAsk.dev"class="dropdown-link">질문</a></li>
						<li><a href="${pageContext.request.contextPath}/dev/listTip.dev"class="dropdown-link">꿀팁</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					href="${pageContext.request.contextPath}/app/article/sec/ask.jsp"
					class="nav-link">보안</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/app/article/sec/ask.jsp"
							class="dropdown-link">질문</a></li>
						<li><a
							href="${pageContext.request.contextPath}/app/article/sec/tip.jsp"
							class="dropdown-link">꿀팁</a></li>
					</ul></li>
				<li class="nav-item dropdown"><a
					href="${pageContext.request.contextPath}/app/article/qual/guide/infoSec.jsp"
					class="nav-link">자격증</a>
					<ul class="dropdown-menu">
						<li><a
							href="${pageContext.request.contextPath}/app/article/qual/guide/infoSec.jsp"
							class="dropdown-link">시험안내</a></li>
						<li><a
							href="${pageContext.request.contextPath}/app/article/qual/ask.jsp"
							class="dropdown-link">질문</a></li>
						<li><a
							href="${pageContext.request.contextPath}/app/article/qual/tip.jsp"
							class="dropdown-link">꿀팁</a></li>
					</ul></li>
			</ul>
		</div>
	</nav>
</header>