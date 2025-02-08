<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page import="com.itask.app.dto.UserDTO" %>
<%@ page import="com.itask.app.dto.MypageMainDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/myTotalArticle.css">
<script defer src="${pageContext.request.contextPath}/assets/js/mypage/myTotalArticle.js"></script>
</head>
<body>
   <jsp:include page="./../basic/userheader.jsp"/>
   <main class="itAskBox">
      <!-- 마이페이지 페이지 제목 -->
      <h3>내가 쓴 전체 게시글</h3>
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
            <span><c:out value = "${mypageMainDTO.userNick }" />님</span>
            </li>
            <li class="keh-mypageMain-myMonitor"><img
               src="${pageContext.request.contextPath}/assets/img/Monitor.png" alt=""> 
               <!-- 인치 표시하는 부분 -->
               <b>
               <fmt:formatNumber value="${mypageMainDTO.userMonitor / 100}" type="number" maxFractionDigits="0"/>
               </b>inch 
               <!-- 모니터 표시하는 부분 -->
               <b>${mypageMainDTO.userMonitor % 100} </b>m
            </li>
         </ul>

         <hr>
         <!-- 선 -->

         <!-- 프로필사진 - 수정/인증/전체글/댓글 메뉴 -->
         <ul class="keh-mypageMain-myMenu">
            <li class="bjs-profileImg-btn onclick="openModal()">프로필 사진 변경하기</li>
            <li><a href="${pageContext.request.contextPath}/mypage/pwCheck.my">내 정보 수정하기</a></li>
            <li><a href="${pageContext.request.contextPath}/mypage/mentoCheck.my">자격/멘토 뱃지 추가하기</a></li>
            <li><a href="${pageContext.request.contextPath}/mypage/myTotalArticle.my">내가 쓴 전체 게시글 보기</a></li>
         </ul>
      </section>
      
      <!-- 우측 게시글 표시부분 -->
      <section class="keh-mypageMain-profile-right">
      	<!-- fetch 사용시 주석 삭제 -->
      	<!-- <div class="bjs-ask-category">
      	주소 수정 필요함 0129
      	  <button class="bjs-ask-category-btn bjs-ask-select " data-category="전체" >전체</button>
		  <button class="bjs-ask-category-btn " data-category="질문">질문</button>
		  <button class="bjs-ask-category-btn " data-category="꿀팁">꿀팁</button>
		</div> -->
		
		<!--게시물 목록-->
		<div id="post-list">
		  <c:choose>
		    <c:when test="${not empty myArticleList}">
				<c:forEach var="myList" items="${myArticleList}">
				  <section class="bjs-ask-post-list">
					<!-- 게시물 반복 -->
					<article class="bjs-ask-post-item" data-tag="${myList.articleTagname}">
					  <div class="bjs-ask-post-header">
						<span class="bjs-ask-post-tag">${myList.articleTagname}</span>   
						<span class="bjs-ask-post-title">
						  <a href="${pageContext.request.contextPath}/mypage/myArticleDetail.my?articleNum=${myList.articleNum}">
						    ${myList.articleTitle}
						  </a>
						</span>
					  </div>
					  <div class="bjs-ask-post-body">
						${myList.articleText}
						<%--  <c:out value="${fn:length(dev.articleText) > 50 ? fn:substring(dev.articleText, 0, 50) + '...' : dev.articleText}" /> --%>
						<a href="${pageContext.request.contextPath}/mypage/myArticleDetail.my?articleNum=${myList.articleNum}"></a> 
				      </div>
					  <div class="bjs-ask-post-footer">
						<div class="bjs-ask-post-info">
						  <span class="bjs-ask-post-author">
						    ${myList.badge} 
						    ${myList.userNick}
						  </span>
						  <span class="bjs-ask-post-views">조회수 ${myList.articleView}</span>
						  <span class="bjs-ask-post-replies">답글 100+</span>
						  <span class="bjs-ask-post-monitor">
						  <img src="${pageContext.request.contextPath}/assets/img/monitor.png" alt="사진오류"> 
						    ${myList.articleMonitorNum}
						  </span>
						</div>
						<span class="bjs-ask-post-date">
						  ${myList.articleDate}
						</span>
					  </div>
					</article>
			      </section>
			      </c:forEach>
		      </c:when>		    
		    <c:otherwise>
		    <div>
			  <div colspan="5" align="center">등록된 게시물이 없습니다.</div>
			</div>
			</c:otherwise>
		   </c:choose> 
	      </div>
	      <!-- <div class="pagination">
		    <a href="#">«</a>
		    <a href="#">‹</a>
		    <a href="#">1</a>
		    <a href="#">2</a>
		    <a href="#">3</a>
		    <a href="#">›</a>
		    <a href="#">»</a>
		  </div> -->
		  <div class="pagination">
		    <ul>
		      <c:if test="${prev}">
		        <li><a
		        href="${pageContext.request.contextPath}/mypage/myTotalArticle.my?page=${startPage - 1}"
				class="prev">&lt;</a></li>
			  </c:if>
			  <c:set var="realStartPage" value="${startPage < 0 ? 0:startPage }" />
			  <c:forEach var="i" begin="${realStartPage}" end="${endPage}">
					<c:choose>
						<c:when test="${!(i == page)}">
							<li><a
								href="${pageContext.request.contextPath}/mypage/myTotalArticle.my?page=${i}">
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
						href="${pageContext.request.contextPath}/mypage/myTotalArticle.my?page=${endPage + 1}"
						class="next">&gt;</a></li>
				</c:if>
				<!-- ========== /페이징 처리 예시 ============ -->
			</ul>


		</div>
		    <script>
		      function setCategory(category) {
		        document.getElementById('noticeCategory').value = category;
		      }
		    </script>
      </section>
    </main>
    <jsp:include page="../basic/footer.jsp" />
    <article class="modal-Box">
      <div class="modal-profile-selectBox">
       <div class="x-Box">&times;</div>
       <form action="${pageContext.request.contextPath }/mypage/myProfileImgChange.my" name="myProfileImg" class="bjs-myProfileImg" method="post">
         <div>
         	  <input type="radio" id="option1" name="option" value="1">
         	    <label for="option1"><img src="${pageContext.request.contextPath}/assets/img/profile_01.png" alt="프로필1번"></label>
         	  <input type="radio" id="option2" name="option" value="2">
         	     <label for="option2"><img src="${pageContext.request.contextPath}/assets/img/profile_02.png" alt="프로필2번"></label>
         	  <input type="radio" id="option3" name="option" value="3">
         	    <label for="option3"><img src="${pageContext.request.contextPath}/assets/img/profile_03.png" alt="프로필3번"></label>
         	  <input type="radio" id="option4" name="option" value="4">
         	    <label for="option4"><img src="${pageContext.request.contextPath}/assets/img/profile_04.png" alt="프로필4번"></label>
         	  <input type="radio" id="option5" name="option" value="5">
         	    <label for="option5"><img src="${pageContext.request.contextPath}/assets/img/profile_05.png" alt="프로필5번"></label>
         </div>
         <div>
         	  <input type="radio" id="option6" name="option" value="6">
         	    <label for="option6"><img src="${pageContext.request.contextPath}/assets/img/profile_06.png" alt="프로필6번"></label>
         	  <input type="radio" id="option7" name="option" value="7">
         	    <label for="option7"><img src="${pageContext.request.contextPath}/assets/img/profile_07.png" alt="프로필7번"></label>
         	  <input type="radio" id="option8" name="option" value="8">
         	    <label for="option8"><img src="${pageContext.request.contextPath}/assets/img/profile_08.png" alt="프로필8번"></label>
         	  <input type="radio" id="option9" name="option" value="9">
         	    <label for="option9"><img src="${pageContext.request.contextPath}/assets/img/profile_09.png" alt="프로필9번"></label>
         	  <input type="radio" id="option10" name="option" value="10">
         	    <label for="option10"><img src="${pageContext.request.contextPath}/assets/img/profile_10.png" alt="프로필10번"></label>
         </div>
         <button value="프로필사진변경" class="bjs-profileImgChange-btn">프로필사진 변경</button>
       </form>
     </div>
   </article>

</body>
</html>