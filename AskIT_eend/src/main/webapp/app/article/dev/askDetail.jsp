<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/article/dev/askDetail.css">
  <script defer src="${pageContext.request.contextPath}/assets/js/article/dev/askDetail.js"></script>
</head>

<body>
		<% UserDTO userInfo = (UserDTO)session.getAttribute("userDTO"); %>
		<% if(userInfo != null){ %>
		  <jsp:include page="./../../basic/userheader.jsp"/>
		  
		<% }else{ %>
		<jsp:include page="./../../basic/header.jsp"/>
		  
		  <%} %>
  <!-- 메인 영역 -->
  <main class="itAskBox">
    <!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
    <article class="bjs-askDetail-elements">
      <!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
      <div class="bjs-askDetail-topcontainer">
        <!-- 자격증  -->
        <span class="bjs-askDetail-title">개발</span>
        <!-- 자격증 상위 카테고리 -->
        <div class="bjs-askDetail-category">
          <button class="bjs-askDetail-category-btn bjs-askDetail-select"><a href="${pageContext.request.contextPath}/dev/listAsk.dev">질문</a></button>
          <button class="bjs-askDetail-category-btn"><a href="${pageContext.request.contextPath}/dev/listTip.dev">꿀팁</a></button>
        </div>
      </div>
      <!-- 준혁님 코드 들어갈 부분 (게시글 내용) -->
      <!-- 본문 전체체 -->
      <article class="bjs-askDetail-text-total" data-tag=<c:out value ="${dev.articleTagname}" />>
        <!-- 본문 헤더더 -->
        <div class="askDetail-text-header">
          <span class="bjs-askDetail-text-tag"><c:out value ="${dev.articleTagname}" /></span>
          <div class="bjs-askDetail-text-title">${dev.articleTitle}</div>
          <div class="bjs-askDetail-text-profile">
            <img src="./../../../assets/img/profile.png" alt="">
            <span class="bjs-askDetail-text-author"><b><c:out value ="${dev.userMoniter}" />inch</b><br><c:out value ="${dev.userNick}" /><c:out value ="${dev.badge}" /></span>
          </div>
          <div class="bjs-askDetail-text-date"><c:out value ="${dev.articleDate}" /></div>
        </div>
        <!-- 본문 메인인 -->
        <article class="bjs-askDetail-text-textbody">
         <c:out value ="${dev.articleText}" />
        </article>
        <!-- 본문 바텀텀 -->
        <article class="bjs-askDetail-text-textbottom">
          <!-- 본문 태그그 -->
          <span class="bjs-askDetail-text-bottom-tag"><c:out value ="${dev.articleTopcate}" /></span>
          <span class="bjs-askDetail-text-bottom-tag"><c:out value ="${dev.articleBotcate}" /></span>
          <span class="bjs-askDetail-text-bottom-tag"><c:out value ="${dev.articleTagname}" /></span>
          <!-- 본문 모니터, 댓글, 공유수 -->
          <div class="bjs-askDetail-content">
            <img src="${pageContext.request.contextPath}/assets/img/moniter.png" alt="모니터수" id="Detail-moniter-img">
            <span id="Detail-monitercount"><c:out value ="${dev.articleMoniter}" /></span>
            <img src="${pageContext.request.contextPath}/assets/img/view.png" alt="조회수" id="Detail-view-img">
            <span id="Detail-viewcount"><c:out value ="${dev.getArticleView()}" /></span>
            <!-- 본문 수정삭제 드롭다운-->
            <div class="bjs-askDetail-dropdown">
              <img src="${pageContext.request.contextPath}/assets/img/Container.png" alt="드롭다운 이미지" class="bjs-askDetail-dropdown-img"
                onclick="Dropdown()">
              <div class="bjs-askDetail-dropdown-menu" id="dropdownMenu">
              	<c:if test="${sessionScope.userNum == article.getUserNum()}">
                	<a href="${pageContext.request.contextPath}/dev/update.dev?articleNum=${dev.articleNum}"><span id = "modifyDeletebtn">수정</span></a>
                	<a href="${pageContext.request.contextPath}/dev/delete.dev?articleNum=${dev.articleNum}" id="postdelete"><span id = "modifyDeletebtn">삭제</span></a>
             	</c:if>
              </div>
            </div>
          </div>
        </article>
      </article>
      <!-- 게시글 내용에 대한 댓글 부분 -->
      <article class="bjs-askDetail-comment-box">

        <!-- 총 댓글 수 -->
        <div class="bjs-askDetail-comment-count">댓글 <span id="comment-count">1</span></div>
        <!-- 댓글 작성 창 -->
        <form method="POST"
				action="${pageContext.request.contextPath}/dev/commentupdate.dev?articleNum=${dev.articleNum}">
	        <div class="bjs-askDetail-comment-input">
	          <textarea id="comment-input" name="bjs-askDetail-ask-box" rows="4" cols="50" placeholder="칭찬 댓글은 작성자에게 큰 힘이 됩니다."></textarea>
	          <button onclick="addComment()" type="submit" class="bjs-askDetail-add-btn">올리기</button>
	        </div>
		</form>
        <!-- 작성된 댓글이 보여지는 리스트 창 -->
       <c:forEach var="dev" items="${comments}">
        <div id="comment-section">
          <!-- --------------------------여기서부터 댓글 하나당-------------------- -->
          <div class="bjs-askDetail-comment-show">
            <span class="bjs-askDetail-commnet-author"> ${dev.userNick}</span>
            <div class="bjs-askDetail-comment-section"> ${dev.commentText}</div>
            <!-- 작성된 날짜, 조회수, 모니터를 담은 박스 -->
            <div class="bjs-askDetail-comment-info">
              <span class="bjs-askDetail-comment-date">${dev.commentDate}</span>
              <span class="bjs-askDetail-comment-monitor">
                <img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="사진오류" class="bjs-askDetail-comment-cnt"> 
                <span id="askDetail-comment-monitor-num" class="bjs-askDetail-comment-monitor-num">${dev.commentMonitorNum}</span>
              </span>
           	</div>
          	</div>
           </div>
         </c:forEach>
          <!-- --------------------------이만큼 추가돼야함^_^~-------------------- -->
       
      </article>

    </article>
  </main>
</body>

</html>