<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- 마이페이지-일반회원 -->

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>My Page</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/mypage/userPageSearch.css" />
<script defer src="${pageContext.request.contextPath}/assets/js/mypage/userPageSearch.js"></script>
</head>
<body>
   <jsp:include page="./../basic/userheader.jsp"/>
   <main class="itAskBox">
      <!-- 마이페이지 페이지 제목 -->
      <h3><a href="${pageContext.request.contextPath}/mypage/userPageSearch.my?userNick=${mypageMainDTO.userNick}">${mypageMainDTO.userNick}</a>님의 프로필</h3>
      <!-- 좌측 프로필사진 -->
      <section class="keh-mypageMain-profile-left">
         <!-- 프로필사진 - 내 정보 -->
         <ul>
            <li class="keh-mypageMain-pic">
              <img src="${profileImgSrc}" alt="${profileAlt}">
            </li>
            <li class="keh-mypageMain-memType">
            <!-- 일반회원/멘토회원 표시하는 부분 -->
            <c:set scope="session" var="mypageMainDTO" value="mypageMainDTO" />
            <c:choose>
    	      <c:when test="${mypageMainDTO.userMentoCert == 'T'}">멘토회원🏅</c:when>
   			  <c:when test="${mypageMainDTO.userMentoCert == 'F'}">일반회원</c:when>
			</c:choose>
               <span><img src="" alt="멘토뱃지"></span>
            </li>
            <li class="keh-mypageMain-memNickName">
            <!-- 닉네임을 표시하는 부분 -->
            <span><a href="${pageContext.request.contextPath}/mypage/userPageSearch.my?userNick=${mypageMainDTO.userNick}"><c:out value = "${mypageMainDTO.userNick }" /></a>님</span>
            </li>
            <li class="keh-mypageMain-myMonitor"><img
               src="${pageContext.request.contextPath}/assets/img/Monitor.png" alt=""> 
               <!-- 인치 표시하는 부분 -->
               <b>
               ${mypageMainDTO.getFormattedMonitor()}
               </b>
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

      <!-- 우측 내 활동 -->
      <section class="keh-mypageMain-profile-right">
         <!-- 1. 내가 쓴 게시글 / 내가 쓴 답변 -->
         <div class="keh-mypageMain-article">
            <ul>
               <li>작성한 게시글
                  <p><a href="${pageContext.request.contextPath}/mypage/userTotalArticle.my?userNick=${mypageMainDTO.userNick}">${mypageMainDTO.articleCount}개</a></p>
               </li>
               <li>작성한 댓글
                  <p><a href="${pageContext.request.contextPath}/mypage/userTotalComment.my?userNick=${mypageMainDTO.userNick}">${mypageMainDTO.commentCount}개</a></p>
               </li>
            </ul>
         </div>
         <!-- 2. 뱃지 -->
         <div class="keh-mypageMain-badge">
            <ul>
               <li>획득한 뱃지
                  <p>${Tcount}개</p>
               </li>
               <li>
                  <ul class="keh-mypageMain-badgeList">
                  <!-- 방법1 forEach -->
                  	<c:forEach var="badge" items="${badges}">
                  	  <c:if test="${badge.status == 'T' }">
                  	    <li>
                  	      <div>
                  	        <img src="${badge.imgSrc}" alt="${badge.alt}" />
                  	      </div>
                  	      <strong><c:out value="${badge.name}" /></strong>
                  	    </li>
                  	  </c:if>
                  	</c:forEach>
                  </ul>
                </li>
              </ul>
            </div>                     
         <!-- 3. 경력 -->
         <div class="keh-mypageMain-career">
            <ul>
               <li>경력</li>
               <li>
               <!-- 우선 멘토가 T/F인지를 체크 -->
               <c:choose>
    		     <c:when test="${mypageMainDTO.userMentoCert == 'T'}">
                   <c:if test="${not empty mypageMainDTO.userCareer}">
                     <ul>
                       <c:forEach var="career" items="${fn:split(mypageMainDTO.userCareer, ',')}">
                         <li><c:out value="${career}" /></li>
                       </c:forEach>
                     </ul>
                   </c:if>
                   <c:if test="${empty mypageMainDTO.userCareer}">
                     <p>현재 등록된 경력사항이 없습니다</p>
                   </c:if>
                 </c:when>
                 <c:when test="${mypageMainDTO.userMentoCert == 'F'}">
                   <p>현재 등록된 경력사항이 없습니다</p>
                 </c:when>
               </c:choose>
               </li>
            </ul>
         </div>
         <div class="profile-light-box">
         </div>
      </section>
   </main>
   <jsp:include page="../basic/footer.jsp" />
</body>
</html>
