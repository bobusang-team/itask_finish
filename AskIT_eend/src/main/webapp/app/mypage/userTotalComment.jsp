<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- <%@ page import="com.itask.app.dto.UserDTO" %>
<%@ page import="com.itask.app.dto.MypageMainDTO" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>해당 유저가 작성한 전체 댓글</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/userTotalComment.css">
<script defer src="${pageContext.request.contextPath}/assets/js/mypage/userTotalComment.js"></script>
</head>
<body>
   <jsp:include page="./../basic/userheader.jsp"/>
   <main class="itAskBox">
      <!-- 마이페이지 페이지 제목 -->
      <h3><a href="${pageContext.request.contextPath}/mypage/userPageSearch.my?userNick=${mypageMainDTO.userNick}">${mypageMainDTO.userNick}</a>님의 전체 댓글</h3>
      <!-- 좌측 프로필사진 -->
      <section class="keh-mypageMain-profile-left">
         <!-- 프로필사진 - 내 정보 -->
         <ul>
            <li class="keh-mypageMain-pic">
               <img src="${profileImgSrc}" alt="${profileAlt}">
            </li>
            <li class="keh-mypageMain-memType">
            <!-- 일반회원/멘토회원 표시하는 부분 -->
            <c:choose>
    	      <c:when test="${mypageMainDTO.userMentoCert == 'T'}">멘토회원🏅</c:when>
   			  <c:when test="${mypageMainDTO.userMentoCert == 'F'}">일반회원</c:when>
			</c:choose>
               <span><img src="" alt="멘토뱃지"></span>
            </li>
            <li class="keh-mypageMain-memNickName">
            <!-- 닉네임을 표시하는 부분 -->
            <span><a href="${pageContext.request.contextPath}/mypage/userPageSearch.my?userNick=${mypageMainDTO.userNick}"><c:out value = "${mypageMainDTO.userNick }"/></a>님</span>
            </li>
            <li class="keh-mypageMain-myMonitor">
               <!-- 인치 표시하는 부분 -->
               <span>${mypageMainDTO.getFormattedMonitor()}</span>
            </li>
         </ul>

         <hr>
         <!-- 선 -->

         <!-- 프로필사진 - 수정/인증/전체글/댓글 메뉴 -->
         <ul class="keh-mypageMain-myMenu">
            <li><a href="${pageContext.request.contextPath}/mypage/userTotalArticle.my?userNick=${mypageMainDTO.userNick}">작성한 게시글 보기</a></li>
            <li><a href="${pageContext.request.contextPath}/mypage/userTotalComment.my?userNick=${mypageMainDTO.userNick}">작성한 댓글 보기</a></li>
         </ul>
      </section>
      
      <!-- 우측 댓글 표시부분 -->
      <section class="keh-mypageMain-profile-right">
      <!--게시물 목록-->
		<div id="comment-list"> <!-- post -> comment로 수정 -->
		  <c:choose>
		    <c:when test="${not empty myCommentList}">
				<c:forEach var="myClist" items="${myCommentList}">
				  <section class="bjs-ask-post-list">
					<!-- 댓글들 반복 -->
					<article class="bjs-ask-post-item" data-tag="${myClist.articleTagName}">
					  <div class="bjs-ask-post-header">
						<span class="bjs-ask-post-tag">${myClist.articleTopCate} - ${myClist.articleBotCate} - ${myClist.articleTagName}</span>   
						<span class="bjs-ask-post-title">
						  <a href="${pageContext.request.contextPath}/mypage/myArticleDetail.my?articleNum=${myClist.articleNum}">
						    ${myClist.articleTitle}
						  </a>
						</span>
					  </div>
					  <div class="bjs-ask-post-body">
					  <a href="${pageContext.request.contextPath}/mypage/myArticleDetail.my?articleNum=${myClist.articleNum}">
						${myClist.commentText} <!--  댓글이 실제로 출력되는 부분 -->
						 </a><!-- 댓글내용 누르면 상세로 -->
				      </div>
					  <div class="bjs-ask-post-footer">
						<div class="bjs-ask-post-info">
						  <span class="bjs-ask-post-author">
						    <%-- ${myClist.badge} --%>
						    ${mypageMainDTO.userNick}
						  </span>
						  <%-- <span class="bjs-ask-post-views">조회수 ${myList.articleView}</span>
						  <span class="bjs-ask-post-replies">답글 100+</span> --%>
						  <span class="bjs-ask-post-monitor">
						  <img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="사진오류"> 
						    ${myClist.commentMonitorNum}
						  </span>
						</div>
						<span class="bjs-ask-post-date">
						  ${myClist.commentDate}
						</span>
					  </div>
					</article>
			      </section>
			      </c:forEach>
		      </c:when>		    
		    <c:otherwise>
		    <div>
			  <div colspan="5" align="center">등록된 댓글이 없습니다.</div>
			</div>
			</c:otherwise>
		   </c:choose> 
	      </div>
	      <div class="pagination">
		    <ul>
		      <c:if test="${prev}">
		        <li><a
		        href="${pageContext.request.contextPath}/mypage/myTotalComment.my?page=${startPage - 1}"
				class="prev">&lt;</a></li>
			  </c:if>
			  <c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
			  <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
					<c:choose>
						<c:when test="${!(i == page)}">
							<li><a
								href="${pageContext.request.contextPath}/mypage/myTotalComment.my?page=${i}">
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
						href="${pageContext.request.contextPath}/mypage/myTotalComment.my?page=${endPage + 1}"
						class="next">&gt;</a></li>
				</c:if>
				<!-- ========== /페이징 처리 예시 ============ -->
			</ul>


		</div>
<!-- 		    <script>
		      function setCategory(category) {
		        document.getElementById('noticeCategory').value = category;
		      }
		    </script> -->
      </section>
    </main>
    <jsp:include page="../basic/footer.jsp" />
</body>
</html>