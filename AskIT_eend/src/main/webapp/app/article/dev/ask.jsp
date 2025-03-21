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
		    <c:out value = "${devLsitAsk}" />
		      <!-- 개발  -->
		      <!-- devListAsk 개발/보안/자격증 -> 질문/꿀팁 -->
		      <span class="bjs-ask-title">${devListAsk[0].getArticleTopcate()}</span>
		        <!-- 자격증 상위 카테고리 -->
		        <div class="bjs-ask-category">
		          <button class="bjs-ask-category-btn bjs-ask-select "><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=질문">질문</a></button>
		          <button class="bjs-ask-category-btn "><a href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=꿀팁">꿀팁</a></button>
		        </div>
		      <!-- 자격증 태그 버튼 --> <!-- 나중에 더 추가될 수 있으니 ul > li로 바꾸는 것은 어떤지 초현님과 상의 필요-->
		      
		      <!-- 태그 분류하기 위한 jstl -->
		     <c:choose>
		      <c:when test="${devListAsk[0].getArticleTopcate() == '개발'}">
		      	<c:set var="tag1" value="JAVA" />
		      	<c:set var="tag2" value="HTML" />
		      	<c:set var="tag3" value="CSS" />
		      	<c:set var="tag4" value="JAVASCRIPT" />
		      	<c:set var="tag5" value="ORACLE" />
		      </c:when>
		      <c:when test="${devListAsk[0].getArticleTopcate() == '보안'}">
		      	<c:set var="tag1" value="NETWORK" />
		      	<c:set var="tag2" value="WEB" />
		      	<c:set var="tag3" value="MOBILE" />
		      	<c:set var="tag4" value="포렌식" />
		      	<c:set var="tag5" value="악성코드" />
		      </c:when>	 
		      <c:when test="${devListAsk[0].getArticleTopcate() == '자격증'}">
		      	<c:set var="tag1" value="정보보안" />
		      	<c:set var="tag2" value="정보처리" />
		      	<c:set var="tag3" value="네트워크관리사" />
		      	<c:set var="tag4" value="SQLD" />
		      	<c:set var="tag5" value="리눅스마스터" />
		      </c:when> 
		     </c:choose>    
		      <div class="bjs-ask-tag"> 
		        <a class="bjs-ask-tag1 bjs-ask-tag-btn bjs-ask-select" 
				   href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=${devListAsk[0].getArticleTopcate()}&articleBotcate=${devListAsk[0].getArticleBotcate()}">
				   전체
				</a>
				
				<a class="bjs-ask-tag1 bjs-ask-tag-btn" 
				   href="${pageContext.request.contextPath}/dev/listAskTag.dev?articleTopcate=${devListAsk[0].getArticleTopcate()}&articleBotcate=${devListAsk[0].getArticleBotcate()}&articleTagname=${tag1}">
				   ${tag1}
				</a>
				
				<a class="bjs-ask-tag1 bjs-ask-tag-btn" 
				   href="${pageContext.request.contextPath}/dev/listAskTag.dev?articleTopcate=${devListAsk[0].getArticleTopcate()}&articleBotcate=${devListAsk[0].getArticleBotcate()}&articleTagname=${tag2}">
				   ${tag2}
				</a>
				
				<a class="bjs-ask-tag1 bjs-ask-tag-btn" 
				   href="${pageContext.request.contextPath}/dev/listAskTag.dev?articleTopcate=${devListAsk[0].getArticleTopcate()}&articleBotcate=${devListAsk[0].getArticleBotcate()}&articleTagname=${tag3}">
				   ${tag3}
				</a>
				
				<a class="bjs-ask-tag1 bjs-ask-tag-btn" 
				   href="${pageContext.request.contextPath}/dev/listAskTag.dev?articleTopcate=${devListAsk[0].getArticleTopcate()}&articleBotcate=${devListAsk[0].getArticleBotcate()}&articleTagname=${tag4}">
				   ${tag4}
				</a>
				
				<a class="bjs-ask-tag1 bjs-ask-tag-btn" 
				   href="${pageContext.request.contextPath}/dev/listAskTag.dev?articleTopcate=${devListAsk[0].getArticleTopcate()}&articleBotcate=${devListAsk[0].getArticleBotcate()}&articleTagname=${tag5}">
				   ${tag5}
				</a>
		      </div>
		
		    </div>
		      <!--게시물 목록-->
		      <c:forEach var="dev" items="${devListAsk}">
				    <section class="bjs-ask-post-list">
				        <!-- 게시물 반복 -->
				         <article class="bjs-ask-post-item" data-tag="${dev.articleTagname}">
<%-- 				         <input type="text" value="${dev.getUserNum()} readonly" /> --%>	
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
				                        <a href="${pageContext.request.contextPath}/mypage/userPageSearch.my?userNick=${dev.getUserNick()}">
				                        ${dev.badge} 
				                        ${dev.getUserNick()}</a>
				                    </span>
				                    <span class="bjs-ask-post-views">조회수 ${dev.getArticleView()}</span>
				                    <span class="bjs-ask-post-replies">답글 0</span>
				                    <span class="bjs-ask-post-monitor">
				                        <img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="사진오류"> 
				                        ${dev.getArticleMonitorNum()}
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
         <ul>
            <!-- ========== 페이징 처리 예시 ============ -->
            <!--             <li><a href="#" class="prev">&lt;</a></li>
            <li><a href="#" class="active">1</a></li>
            <li><a href="#">2</a></li>
            <li><a href="#">3</a></li>
            <li><a href="#">4</a></li>
            <li><a href="#">5</a></li>
            <li><a href="#" class="next">&gt;</a></li> -->
            <c:if test="${prev}">
               <li><a
                  href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=질문&page=${startPage - 1}"
                  class="prev">&lt;</a></li>
            </c:if>
            <c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
            <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
               <c:choose>
                  <c:when test="${!(i == page)}">
                     <li><a
                        href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=질문&page=${i}">
                           <c:out value="${i}" />
                     </a></li>
                  </c:when>
                  <c:otherwise>
                     <li><a href="#" class="active"> <c:out value="${i}" />
                     </a></li>
                  </c:otherwise>
               </c:choose>

            </c:forEach>
            <c:if test="${next}">
               <li><a
                  href="${pageContext.request.contextPath}/dev/listAsk.dev?articleTopcate=개발&articleBotcate=질문&page=${endPage + 1}"
                  class="next">&gt;</a></li>
            </c:if>
            <!-- ========== /페이징 처리 예시 ============ -->
         </ul>


      </div>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
      
      <script>
      let userNum = "${sessionScope.userNum}";
   	  </script>
		    	<script>
		    	 function setCategory(category) {
		    	        document.getElementById('noticeCategory').value = category;
		    	    }
		    	</script>
			  </main>
			  <jsp:include page="../../basic/footer.jsp" />
		</body>
		</html>
		
