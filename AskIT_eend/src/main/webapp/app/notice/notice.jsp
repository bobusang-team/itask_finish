<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항리스트</title>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/notice/notice.css">
   <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
    		<%@ page import="com.itask.app.dto.UserDTO" %>
</head>
<body>
   <% UserDTO userInfo = (UserDTO)session.getAttribute("userDTO"); %>
		<% if(userInfo != null){ %>
		  <jsp:include page="./../basic/userheader.jsp"/>
		  
		<% }else{ %>
		<jsp:include page="./../basic/header.jsp"/>
		  
		  <%} %>
   <div class="mjh-notice-main">
      <h2 class="mjh-notice-title">공지사항</h2>
      <div class="mjh-notice-articel-list">
      
      <!-- ========== 게시글 목록 예시 =========== -->
				<c:choose>
					<c:when test="${not empty boardList}">
						<c:forEach var="notice" items="${noticeList}">
						<%-- 
						c:forEach var="변수명" items="반복할 아이템" forEach 문으로 어떤걸 계속 순회해서 보여줄건지 정하는거야
						보통 ${boardList}는 List<BoardDTO> 형태로 저장이 되어 있는데 item 속성은 그 컬렉션을 받아서 안에 있는 속성들을 꺼내서 반복하게 해줘
						변수명에 board라고 저장되어 있다면 한번 반복할 때 마다 하나의 객체가 board에 들어가
						c:forEach var="board" items="${boardList}" varStatus="status" 이런식으로  varStatus="status" 속성이 있다면 몇번째 글인지 확인할 수도 있어
						${status.index}번째 게시글: <c:out value="${board.boardTitle}" /> 이렇게말이야
						--%>
						
							<div class="mjh-notice-articel-item" data-id="1">
								<!-- 글제목 -->
            					<span class="mjh-notice-articel-category">보안</span> 
            					<span class="mjh-notice-articel-title"><a href="./noticeDetail1.jsp">악성코드 경고</a></span> 
         					    <span class="mjh-notice-articel-date">2025-01-09 </span>
       					  </div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div>
							<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
						</div>
					</c:otherwise>
				</c:choose>
      <!-- 아래부터는 퍼블리싱으로 만들어 둔 목록 -->
      
         <!-- <div class="mjh-notice-articel-item" data-id="1">
            <span class="mjh-notice-articel-category">보안</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail1.jsp">악성코드 경고</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="2">
            <span class="mjh-notice-articel-category">전체</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail2.jsp">서비스 점검 알림</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="3">
            <span class="mjh-notice-articel-category">자격증</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail3.jsp">네트워크 관리사 자격증 일정</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="4">
            <span class="mjh-notice-articel-category">개발</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">Node.js 버전 업데이트</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="5">
            <span class="mjh-notice-articel-category">보안</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">중요 보안 패치</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="6">
            <span class="mjh-notice-articel-category">전체</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">서비스 개선 안내</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="7">
            <span class="mjh-notice-articel-category">자격증</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">정보보안 자격증 시험 일정</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="8">
            <span class="mjh-notice-articel-category">보안</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">보안 취약점 패치 공지</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="9">
            <span class="mjh-notice-articel-category">개발</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">자바 업데이트 안내</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div>
         <div class="mjh-notice-articel-item" data-id="10">
            <span class="mjh-notice-articel-category">전체</span> 
            <span class="mjh-notice-articel-title"><a href="./noticeDetail.jsp">시스템 점검 안내</a></span> 
            <span class="mjh-notice-articel-date">2025-01-09 </span>
         </div> -->
         
<!-- 위까지 퍼블리싱으로 만들어둔 목록 -->

      </div>
      <div class="pagination">
         <a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
         <a href="#">3</a> <a href="#">›</a> <a href="#">»</a>
      </div>
   </div>
   <jsp:include page="../basic/footer.jsp" />



   <!--       <div class="mjh-notice-articel-item" data-id="5">
            <span class="mjh-notice-articel-category">전체</span> <span
               class="mjh-notice-articel-title">사이트 점검 안내✴</span> <span
               class="mjh-notice-articel-date">2025-01-09 00:00</span>
         </div> -->

</body>
</html>