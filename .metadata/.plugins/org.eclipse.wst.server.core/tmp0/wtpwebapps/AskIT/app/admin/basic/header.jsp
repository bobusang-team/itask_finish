<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.AdminDTO"%>

<% 
// AdminDTO 객체를 세션에서 가져오고 변수 초기화
AdminDTO userInfo = (AdminDTO) session.getAttribute("adminDTO");
String adminNick = null;
int adminNum = 0;

if (userInfo != null) {
    adminNick = userInfo.getAdminNick();
    adminNum = userInfo.getAdminNum();
} else {
%>
<script>
    location.href = "${pageContext.request.contextPath}/app/admin/adminLogin.jsp";
</script>
<%
}
%>

<header class="adminheader">
    <div class="header-container">
        <div class="header-brand">
            <img src="${pageContext.request.contextPath}/assets/img/logo/logo_b.png" alt="ITASK 로고" class="header-logo">
        </div>

        <div class="search-container">
            <div class="search-wrapper">
                <input type="text" class="search-input" placeholder="키워드를 입력하세요">
                <button class="search-button">
                    <img src="${pageContext.request.contextPath}/assets/img/readingGlass.png" alt="검색 아이콘">
                </button>
            </div>

            <form id="writeForm" method="post" action="${pageContext.request.contextPath}/admin/write.ad" style="display: none;">
                <!-- adminNum 값 추가 -->
                <input type="hidden" name="adminNum" value="<%= adminNum %>">
            </form>

            <a href="#" class="write-button" onclick="document.getElementById('writeForm').submit(); return false;" target="main">
                <img src="${pageContext.request.contextPath}/assets/img/File Plus 02.png" alt="글쓰기 아이콘"> 글쓰기
            </a>
        </div>

        <div class="admin-info">
            <span class="admin-nickname"><%= adminNick %>님 환영합니다</span>
            <a href="${pageContext.request.contextPath}/admin/logout.ad" class="logout-link" target="main">로그아웃</a>
        </div>
    </div>
</header>

<nav class="navbar">
    <ul class="navbar-menu">
        <li class="menu-item"><a href="#" class="menu-link">회원관리</a>
            <div class="submenu">
                <a href="#" class="submenu-link">블랙리스트</a>
                <a href="${pageContext.request.contextPath}/admin/basic/totalMember.ad" target="main" class="submenu-link" id="total">전체회원</a>
                <a href="${pageContext.request.contextPath}/admin/generalMember.ad" target="main" class="submenu-link" id="general">일반회원</a>
                <a href="${pageContext.request.contextPath}/admin/mentoMember.ad" target="main" class="submenu-link" id="mento">멘토회원</a>
            </div>
        </li>
        <li class="menu-item"><a href="#" class="menu-link">공지게시판</a>
            <div class="submenu">
                <a href="${pageContext.request.contextPath}/admin/notice.ad" target="main" class="submenu-link" id="notice">공지게시판 목록</a>
            </div>
        </li>
        <li class="menu-item"><a href="#" class="menu-link">꿀팁게시판</a>
            <div class="submenu">
                <a href="${pageContext.request.contextPath}/admin/tipDev.ad" target="main" class="submenu-link">개발</a>
                <a href="${pageContext.request.contextPath}/admin/tipSec.ad" target="main" class="submenu-link">보안</a>
                <a href="${pageContext.request.contextPath}/admin/tipQual.ad" target="main" class="submenu-link">자격증</a>
            </div>
        </li>
        <li class="menu-item"><a href="#" class="menu-link">질문게시판</a>
            <div class="submenu">
                <a href="${pageContext.request.contextPath}/admin/askDev.ad" target="main" class="submenu-link">개발</a>
                <a href="${pageContext.request.contextPath}/admin/askSec.ad" target="main" class="submenu-link">보안</a>
                <a href="${pageContext.request.contextPath}/admin/askQual.ad" target="main" class="submenu-link">자격증</a>
            </div>
        </li>
    </ul>
</nav>
