<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic/header.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/articleDetail.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/articleDetail.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/basic/header.js"></script>
</head>
<body>
	<jsp:include page="./basic/header.jsp" />
	<main class="itaskBox">
		<!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
		<article class="askDetail-elements">
			<!-- 자격증  -->
			<main class="askBox">
				<!-- 메인 안에 요소들이 담길 컨테이너 박스 -->
				<div class="ask-topcontainer">
					<!-- 개발  -->
					<span class="ask-title">${article.articleTopCate}</span>
					<!-- 자격증 상위 카테고리 -->
					<div class="ask-category">
						<button class="category-btn" onclick="setBotCate('질문')">질문</button>
						<button class="category-btn" onclick="setBotCate('꿀팁')">꿀팁</button>
					</div>
					<!-- 자격증 태그 버튼 -->
					<div class="ask-tag">
						<button class="ask-tag-btn" onclick="setTag('정보처리')">정보처리</button>
						<button class="ask-tag-btn" onclick="setTag('정보보안')">정보보안</button>
						<button class="ask-tag-btn" onclick="setTag('네트워크관리사')">네트워크관리사</button>
						<button class="ask-tag-btn" onclick="setTag('리눅스마스터')">리눅스마스터</button>
						<button class="ask-tag-btn" onclick="setTag('SQLD')">SQLD</button>
						`
					</div>
				</div>
			</main>
			<!-- 준혁님 코드 들어갈 부분 (게시글 내용) -->
			<!-- 본문 전체체 -->
			<article class="ask-text-total" data-tag="${articleBotCate}">
				<div class="ask-text-header">
					<span class="ask-text-tag">${article.articleTagName}</span>
					<input type="text" class="ask-text-title" value="${article.articleTitle }">
					<%-- <div class="ask-text-title">${article.articleTitle }</div> --%>
					<div class="ask-text-profile">
						<img src="./../assets/img/profile.png" alt=""> <span
							class="ask-text-author"><b>${article.formattedMonitor}</b>
							${article.userNick }</span>
					</div>
					<div class="ask-text-date">${article.articleDate}</div>
				</div>
				<!-- 본문 메인인 -->
				<textarea cols="30" class="ask-text-textbody">${article.articleText}
          </textarea>
				<!-- 본문 바텀텀 -->
				<article class="text-textbottom">
					<!-- 본문 태그그 -->
					<span class="ask-text-bottom-tag">${article.articleTopCate }</span>
					<span class="ask-text-bottom-tag">${article.articleBotCate }</span>
					<span class="ask-text-bottom-tag">${article.articleTagName }</span>
					<!-- 본문 모니터, 댓글, 공유수수 -->
					<div class="Detail-content">
						<img src="./../assets/img/moniter.png" alt="모니터수"
							id="Detail-moniter-img"> <span id="Detail-monitercount">${article.articleMonitorNum }</span>
						<img src="./../assets/img/view.png" alt="조회수"
							id="Detail-view-img"> <span id="Detail-viewcount">${article.articleView }</span>

					</div>
					<div class="buttons">
						<button id="articleSave">저장</button>
						<button id="articleDelete">삭제</button>
					</div>
				</article>
			</article>
			<!-- 게시글 내용에 대한 댓글 부분 -->
			<article class="askDetail-comment-box">

				<!-- 총 댓글 수 -->
				<div class="askDetail-comment-count">
					댓글 <span id="comment-count">${commentCount }</span>
				</div>

				<c:forEach var="comments" items="${comments}">
					<!-- 작성된 댓글이 보여지는 리스트 창 -->
					<div id="comment-section">
						<!-- --------------------------여기서부터 댓글 하나당-------------------- -->
						<div class="askDetail-comment-show">
							<span class="askDetail-comment-author">${comments.commentMonitorNum}${comments.userNick}</span>
							<input type="hidden" id="commentNums" value="${comments.commentNum }">
							<div class="mjh-askDetail-comment-section ${comments.commentText == '(관리자에 의해 삭제된 댓글입니다)' ? 'deleted-comment' : ''}">${comments.commentText }</div>
							<!-- 작성된 날짜, 조회수, 모니터를 담은 박스 -->
							<div class="askDetail-comment-info">
								<span class="askDetail-comment-date">${comments.commentDate}</span>
								<span class="askDetail-comment-monitor"> <img
									src="./../asset0.s/img/moniter.png" alt="사진오류">
									${comments.commentMonitorNum}
								</span> <span id="commentDelete" class="askDetail-comment-delete">삭제</span>
							</div>
						</div>
						<!-- --------------------------이만큼 추가돼야함^_^~-------------------- -->
					</div>
				</c:forEach>
			</article>

		</article>
		<form id="articleForm">
    		<input type="hidden" id="articleBotCate" value="${article.articleBotCate}">
    		<input type="hidden" id="articleTagName" value="${article.articleTagName}">
		</form>
		<!-- 삭제용 Form -->
			<form id="deleteForm"
				action="${pageContext.request.contextPath}/admin/deleteArticle.ad"
				method="post">
				<input type="hidden" name="articleNums" id="articleNums" value="${article.articleNum }">
				<input type="hidden" name="articleTopcate" id="articleTopcate" value="${article.articleTopCate }">
				<input type="hidden" name="articleBotcate" id="articleBotcate" value="${article.articleBotCate }">
			</form>
		<!-- 수정용 Form -->
		<form id="articleEdit" action="${pageContext.request.contextPath}/admin/updateArticle.ad" method="post">			
			<input type="hidden" name="articleNum" id="articleNum" value="${article.articleNum }">
			<input type="hidden" name="articleTopcate" id="updateTopcate" value="${article.articleTopCate } ">
			<input type="hidden" name="articleBotcate" id="updateBotcate">
    		<input type="hidden" name="articleTagName" id="updateTagName">
    		<input type="hidden" name="articleTitle" id="updateTitle">
    		<input type="hidden" name="articleText" id="updateText">   		
		</form>
		<!-- 댓글삭제용 Form -->
		<form id="deleteCommentsForm"
			action="${pageContext.request.contextPath}/admin/deleteComment.ad"
			method="post">
			<input type="hidden" name="articleNum" id="articleNum" value="${article.articleNum }">
			<input type="hidden" name="commentNum" id="commentNum"> 
		</form>
	</main>
</body>
</html>