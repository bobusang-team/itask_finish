<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/basic/header.css">
 <script defer src="${pageContext.request.contextPath}/assets/js/admin/basic/header.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin/askDev.css">
<script defer src="${pageContext.request.contextPath}/assets/js/admin/askDev.js"></script>
</head>
<body>
<jsp:include page="./basic/header.jsp" />
	    <main>
        <nav class="mtable">
            <div class="head">
                <div class="title">질문게시판-개발</div>
                <div class="buttons">
                    <button onclick="submitEditForm()">수정</button>
                    <button onclick="submitDeleteForm()">삭제</button>
                </div>
            </div>
            <hr>

            <div class="askdevList header">
                <input type="checkbox" id="selectAll" onclick="toggleSelectAll()">
                <p>태그</p>
                <p class="askdev-title">글제목</p>
                <p>작성자</p>
                <p>회원분류</p>
                <p>작성일</p>
                <p>조회수</p>
            </div>
            <hr>

			<!-- 게시글 출력 -->
			<c:forEach var="askDev" items="${askDev}">
				<div class="askdevList">
					<div>
						<input type="checkbox" class="item-checkbox" onclick="updateSelectAll()">
						<input type="hidden" class="articleNum" value="${askDev.articleNum }">
						<input type="hidden" name="articleTopCate" id="articleTopCate" value="${askDev.articleTopCate }">
						<input type="hidden" name="articleBotCate" id="articleBotCate" value="${askDev.articleBotCate }">
						<p>${askDev.articleTagName}</p>
						<a href="${pageContext.request.contextPath}/admin/articleDetail.ad?articleNum=${askDev.articleNum}">
						<p class="askdev-title">${askDev.articleTitle}</p>
						</a> 
						<p>${askDev.userNick}</p>
						<p>${askDev.grade}</p>
						<p>${askDev.articleDate}</p>
						<p>${askDev.articleView}</p>
					</div>
				</div>
			</c:forEach>
			<!-- 삭제용 Form -->
			<form id="deleteForm"
				action="${pageContext.request.contextPath}/admin/deleteArticle.ad"
				method="post">
				<input type="hidden" name="articleNums" id="articleNums">
				<input type="hidden" name="articleTopcate" id="articleTopcate">
				<input type="hidden" name="articleBotcate" id="articleBotcate">
			</form>
			
            <div class="pagination">
      <c:if test="${prev}"> <!-- 아주 처음으로 가는 버튼 -->
         <a href="${pageContext.request.contextPath}/admin/askDev.ad?page=1"
                  class="firstPage">«</a>
     </c:if>
      <c:if test="${prev}"> <!-- 이전페이지가 있을 시 이전페이지로 넘어가는 버튼 생성 -->
         <a href="${pageContext.request.contextPath}/admin/askDev.ad?page=1"
                  class="prev">‹</a>
     </c:if>
     <c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
              <c:forEach var="i" begin="${realStartPage}" end="${endPage}">

            <c:choose>
               <c:when test="${!(i == page)}">
                  <a href="${pageContext.request.contextPath}/admin/askDev.ad?page=${i}">
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
            <a href="${pageContext.request.contextPath}/admin/askDev.ad?page=${endPage + 1}"
                  class="next">›</a>
      </c:if>
      <c:if test="${next}"> <!-- 완전 끝으로 가는 버튼 생성 -->
            <a href="${pageContext.request.contextPath}/admin/askDev.ad?page=${realEndPage}"
                  class="realEndPage">»</a>
      </c:if>
            
         <!-- <a href="#">«</a> <a href="#">‹</a> <a href="#">1</a> <a href="#">2</a>
         <a href="#">3</a> <a href="#">›</a> <a href="#">»</a> -->
      </div>
        </nav>
    </main>
</body>
</html>