<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항리스트</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notice/notice.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">

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
					<c:when test="${not empty noticeList}">
						<c:forEach var="notice" items="${noticeList}">
						<%-- 
						c:forEach var="변수명" items="반복할 아이템" forEach 문으로 어떤걸 계속 순회해서 보여줄건지 정하는거야
						보통 ${boardList}는 List<BoardDTO> 형태로 저장이 되어 있는데 item 속성은 그 컬렉션을 받아서 안에 있는 속성들을 꺼내서 반복하게 해줘
						변수명에 board라고 저장되어 있다면 한번 반복할 때 마다 하나의 객체가 board에 들어가
						c:forEach var="board" items="${boardList}" varStatus="status" 이런식으로  varStatus="status" 속성이 있다면 몇번째 글인지 확인할 수도 있어
						${status.index}번째 게시글: <c:out value="${board.boardTitle}" /> 이렇게말이야
						--%>
						
							<div class="mjh-notice-articel-item" data-id="1">
								<!-- 공지사항 카테고리 -->
            					<span class="mjh-notice-articel-category">
            					<c:out value="${notice.getNoticeCategory()}" />
            					</span> 
            					<!-- 공지사항 제목 -->
            					<span class="mjh-notice-articel-title">
            					<a href="${pageContext.request.contextPath}/app/notice/noticeDetail.no?noticeNum=${notice.getNoticeNum()}">
            					<c:out value="${notice.getNoticeTitle()}" />
            					</a>
            					</span> 
            					<!-- 작성일 -->
         					    <span class="mjh-notice-articel-date">
         					    <c:out value="${fn:substring(notice.noticeDate, 0 ,10) }" />
									<!-- 이렇게 쓴다면 잘짜에서 10자리만 표기 된다 yyyy-mm-dd 이렇게! -->	
									<!-- 출력되는 날짜데이터 형식이 yyyy-mm-dd hh:mm:ss 형식일 경우 fn:substring 이용하여 날짜 부분만 출력 가능하다 -->
         					    </span>
       					  </div>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div>
							<div colspan="5" align="center">등록된 게시물이 없습니다.</div>
						</div>
					</c:otherwise>
				</c:choose>      
      </div>
      
      
      <div class="pagination">
      <c:if test="${prev}"> <!-- 아주 처음으로 가는 버튼 -->
			<a href="${pageContext.request.contextPath}/app/notice/notice.no?page=1"
						class="firstPage">«</a>
	  </c:if>
      <c:if test="${prev}"> <!-- 이전페이지가 있을 시 이전페이지로 넘어가는 버튼 생성 -->
			<a href="${pageContext.request.contextPath}/app/notice/notice.no?page=1"
						class="prev">‹</a>
	  </c:if>
	  <c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
           	<c:forEach var="i" begin="${realStartPage}" end="${endPage}">

				<c:choose>
					<c:when test="${!(i == page)}">
						<a href="${pageContext.request.contextPath}/app/notice/notice.no?page=${i}">
									<c:out value="${i}" />
						</a>
					</c:when>
					<c:otherwise>
							<a href="#" class="active"> <c:out value="${i}" /> <!-- 선택한 현재페이지를 버튼에서 활성화 시켜주는 부분 -->
							</a>
					</c:otherwise>	
				</c:choose>

			</c:forEach>
		<c:if test="${next}"> <!-- 다음 페이지가 있다면 다음으로 넘어가는 버튼 생성 -->
				<a href="${pageContext.request.contextPath}/app/notice/notice.no?page=${endPage + 1}"
						class="next">›</a>
		</c:if>
		<c:if test="${next}"> <!-- 완전 끝으로 가는 버튼 생성 -->
				<a href="${pageContext.request.contextPath}/app/notice/notice.no?page=${realEndPage}"
						class="realEndPage">»</a>
		</c:if>
				
         <!-- <a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
         <a href="#">3</a> <a href="#">›</a> <a href="#">»</a> -->
      </div>
   </div>
   <jsp:include page="../basic/footer.jsp" />

		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>


   <!--       <div class="mjh-notice-articel-item" data-id="5">
            <span class="mjh-notice-articel-category">전체</span> <span
               class="mjh-notice-articel-title">사이트 점검 안내✴</span> <span
               class="mjh-notice-articel-date">2025-01-09 00:00</span>
         </div> -->

</body>
</html>