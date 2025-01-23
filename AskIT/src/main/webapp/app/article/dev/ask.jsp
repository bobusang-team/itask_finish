		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		<%@ page import="com.itask.app.dto.UserDTO" %>
		<!DOCTYPE html>
		<html lang="en">
		<head>
		  <meta charset="UTF-8">
		  <meta name="viewport" content="width=device-width, initial-scale=1.0">
		  <title>Document</title>
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/article/dev/ask.css">
		  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
		  <script defer src="${pageContext.request.contextPath}/assets/js/article/dev/ask.js"></script>
		</head>
		<body>
		<% UserDTO userInfo = (UserDTO)session.getAttribute("userDTO"); %>
		<% if(userInfo != null){ %>
		  <jsp:include page="./../../basic/userheader.jsp"/>
		  
		<% }else{ %>
		<jsp:include page="./../../basic/header.jsp"/>
		  
		  <%} %>
		  <main class="itAskBox">
		    <!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
		    <div class="bjs-ask-topcontainer">
		      <!-- 개발  -->
		      <span class="bjs-ask-title">개발</span>
		        <!-- 자격증 상위 카테고리 -->
		        <div class="bjs-ask-category">
		          <button class="bjs-ask-category-btn bjs-ask-select "><a href="${pageContext.request.contextPath}/dev/listAsk.dev">질문</a></button>
		          <button class="bjs-ask-category-btn "><a href="${pageContext.request.contextPath}/dev/listTip.dev">꿀팁</a></button>
		        </div>
		      <!-- 자격증 태그 버튼 --> <!-- 나중에 더 추가될 수 있으니 ul > li로 바꾸는 것은 어떤지 초현님과 상의 필요-->
		      <div class="bjs-ask-tag"> 
		        <button class="bjs-ask-tag-btn bjs-ask-select">전체</button>
		        <button class="bjs-ask-tag-btn">JAVA</button>
		        <button class="bjs-ask-tag-btn">HTML</button>
		        <button class="bjs-ask-tag-btn">CSS</button>
		        <button class="bjs-ask-tag-btn">JAVASCRIPT</button>
		        <button class="bjs-ask-tag-btn">ORACLE</button>
		      </div>
		
		    </div>
		      <!--게시물 목록-->
		      <c:forEach var="dev" items="${devListAsk}">
				    <section class="bjs-ask-post-list">
				        <!-- 게시물 반복 -->
				         <article class="bjs-ask-post-item" data-tag="${dev.articleTagname}">
				            <div class="bjs-ask-post-header">
				                <span class="bjs-ask-post-tag">${dev.articleTagname}</span>   
				                <span class="bjs-ask-post-title">
				                    <a href="${pageContext.request.contextPath}/dev/detailAsk.dev?articleNum=${dev.articleNum}">
				                        ${dev.articleTitle}
				                    </a>
				                </span>
				            </div>
				            <div class="bjs-ask-post-body">
				            	${dev.articleText}
				               <%--  <c:out value="${fn:length(dev.articleText) > 50 ? fn:substring(dev.articleText, 0, 50) + '...' : dev.articleText}" /> --%>
				               <a href="${pageContext.request.contextPath}/dev/DetailAsk.dev?articleNum=${dev.articleNum}"></a> 
				            </div>
				            <div class="bjs-ask-post-footer">
				                <div class="bjs-ask-post-info">
				                    <span class="bjs-ask-post-author">
				                        ${dev.badge} 
				                        ${dev.userNick}
				                    </span>
				                    <span class="bjs-ask-post-views">조회수 ${dev.articleView}</span>
				                    <span class="bjs-ask-post-replies">답글 100+</span>
				                    <span class="bjs-ask-post-monitor">
				                        <img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="사진오류"> 
				                        ${dev.articleMoniter}
				                    </span>
				                </div>
				                <span class="bjs-ask-post-date">
				                    ${dev.articleDate}
				                </span>
				            </div>
				        </article>
				    </section>
				</c:forEach>
				<div class="pagination">
		        <a href="#">«</a>
		        <a href="#">‹</a>
		        <a href="#">1</a>
		        <a href="#">2</a>
		        <a href="#">3</a>
		        <a href="#">›</a>
		        <a href="#">»</a>
		    	</div>
		    	<script>
		    	 function setCategory(category) {
		    	        document.getElementById('noticeCategory').value = category;
		    	    }
		    	</script>
			  </main>
			  <jsp:include page="../../basic/footer.jsp" />
		</body>
		</html>
		
