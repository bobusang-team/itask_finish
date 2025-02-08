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
<!-- 헤더 추가시 오류발생..ㅠㅠ  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/mypage/mypageMain.css" />
<script defer src="${pageContext.request.contextPath}/assets/js/mypage/mypageMain.js"></script>
</head>
<body>
   <jsp:include page="./../basic/userheader.jsp"/>
   <main class="itAskBox">
      <!-- 마이페이지 페이지 제목 -->
      <h3>마이페이지</h3>
      <!-- 좌측 프로필사진 -->
      <section class="keh-mypageMain-profile-left">
         <!-- 프로필사진 - 내 정보 -->
         <ul>
            <li class="keh-mypageMain-pic">
              <img src="${profileImgSrc}" alt="${profileAlt}">
               <%-- <img src="${pageContext.request.contextPath}/assets/img/profile_01.png" alt="프로필사진"> --%>
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
            <span><c:out value = "${mypageMainDTO.userNick }" />님</span>
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
         	<li class="bjs-profileImg-btn onclick="openModal()">프로필 사진 변경하기</li>
            <li><a href="${pageContext.request.contextPath}/mypage/pwCheck.my">내 정보 수정하기</a></li>
            <li><a href="${pageContext.request.contextPath}/mypage/mentoCheck.my">자격/멘토 뱃지 추가하기</a></li>
            <li><a href="${pageContext.request.contextPath}/mypage/myTotalArticle.my">내가 쓴 전체 게시글 보기</a></li>
         </ul>
      </section>

      <!-- 우측 내 활동 -->
      <section class="keh-mypageMain-profile-right">
         <!-- 1. 내가 쓴 게시글 / 내가 쓴 답변 -->
         <div class="keh-mypageMain-article">
            <ul>
               <li>내가 쓴 게시글
                  <p>${mypageMainDTO.articleCount}개</p>
               </li>
               <li>내가 쓴 댓글
                  <p>${mypageMainDTO.commentCount}개</p>
               </li>
            </ul>
         </div>
         <!-- 2. 뱃지 -->
         <div class="keh-mypageMain-badge">
            <ul>
               <li>내가 획득한 뱃지
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
               <li>나의 경력</li>
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
   <!-- +++++0207++++++ -->
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
