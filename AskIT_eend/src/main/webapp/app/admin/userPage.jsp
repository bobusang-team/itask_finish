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
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/admin/basic/header.css">
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/basic/header.js"></script>
<link rel="stylesheet"
   href="${pageContext.request.contextPath}/assets/css/admin/userPage.css" />
<script defer
	src="${pageContext.request.contextPath}/assets/js/admin/userPage.js"></script>
</head>
<body>
   <jsp:include page="./basic/header.jsp"/>
   <main class="itAskBox">
      <!-- 마이페이지 페이지 제목 -->
      <h3>회원 상세페이지</h3>
      <!-- 좌측 프로필사진 -->
      <section class="keh-mypageMain-profile-left">
         <!-- 프로필사진 - 내 정보 -->
         <ul>
            <li class="keh-mypageMain-pic">
               <div></div>
            </li>
            <li class="keh-mypageMain-memType">
            <!-- 일반회원/멘토회원 표시하는 부분 -->
            <c:set scope="session" var="userpage" value="userpage" />
            <c:choose>
             <c:when test="${userpage.userMentoCert == 'T'}">멘토회원🏅</c:when>
              <c:when test="${userpage.userMentoCert == 'F'}">일반회원</c:when>
         </c:choose>
               <span><img src="" alt="멘토뱃지"></span>
            </li>
            <li class="keh-mypageMain-memNickName">
            <!-- 닉네임을 표시하는 부분 -->
            <span><c:out value = "${userpage.userNick }" />님</span>
            </li>
            <li class="keh-mypageMain-myMonitor"><img
               src="${pageContext.request.contextPath}/assets/img/Monitor.png" alt=""> 
               <!-- 인치 표시하는 부분 -->
               <b>
               ${userpage.getFormattedMonitor() }
               </b>
               
            </li>
         </ul>

         <hr>
         <!-- 선 -->

         <!-- 프로필사진 - 수정/인증/전체글/댓글 메뉴 -->
         <ul class="keh-mypageMain-myMenu">
            <li class="bjs-profileImg-btn" id="grade-btn">회원 등급 변경</li>
            <li class="bjs-profileImg-btn" id="badge-btn">뱃지 추가</li>
           <li class="bjs-profileImg-btn" id="career-btn" data-career="${userpage.userCareer}">경력 추가</li>
         </ul>
      </section>

      <!-- 우측 내 활동 -->
      <section class="keh-mypageMain-profile-right">
         <!-- 1. 내가 쓴 게시글 / 내가 쓴 답변 -->
         <div class="keh-mypageMain-article">
            <ul>
               <li>내가 쓴 게시글
                  <p>${userpage.articleCount}개</p>
               </li>
               <li>내가 쓴 댓글
                  <p>${userpage.commentCount}개</p>
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
                  	<c:forEach var="mentoBadges" items="${mentoBadges}">
                       <c:if test="${mentoBadges.status == 'T' }">
                         <li>
                           <div>
                             <img src="${mentoBadges.imgSrc}" alt="${mentoBadges.alt}" />
                           </div>
                           <strong><c:out value="${mentoBadges.name}" /></strong>
                         </li>
                       </c:if>
                     </c:forEach>
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
               <c:when test="${userpage.userMentoCert == 'T'}">
                   <c:if test="${not empty userpage.userCareer}">
                     <ul>
                       <c:forEach var="career" items="${fn:split(userpage.userCareer, ',')}">
                         <li><c:out value="${career}" /></li>
                       </c:forEach>
                     </ul>
                   </c:if>
                   <c:if test="${empty userpage.userCareer}">
                     <p>현재 등록된 경력사항이 없습니다</p>
                   </c:if>
                 </c:when>
                 <c:when test="${userpage.userMentoCert == 'F'}">
                   <p>현재 등록된 경력사항이 없습니다</p>
                 </c:when>
               </c:choose>
               </li>
            </ul>
         </div>
      </section>
   </main>
   <article id="badgeModal" class="modal-Box">
  <div class="modal-profile-selectBox">
    <div class="x-Box">&times;</div>
    <form action="${pageContext.request.contextPath}/admin/UserCerts.ad" method="post">
      
      <input type="hidden" name="userNum" value="${userpage.userNum}">
      <input type="hidden" name="userNick" value="${userpage.userNick}">
      
      <div class="checkbox-container">
        <c:forEach var="badge" items="${badges}">
          <input type="checkbox" id="option${badge.name}" name="option" value="${badge.column}" 
            <c:if test="${badge.status == 'T'}">checked</c:if>
          >
          <label for="option${badge.name}">
            <img src="${badge.imgSrc}" alt="${badge.alt}">${badge.name}
          </label>
        </c:forEach>
      </div>
	 
      <button type="submit" class="bjs-profileImgChange-btn">뱃지 수정</button>
    </form>
  </div>
</article>

<form id="updateGradeForm" action="${pageContext.request.contextPath}/admin/updateGrade.ad" method="post">
	<input type="hidden" name="userNum" value="${userpage.userNum}">
    <input type="hidden" name="userNick" value="${userpage.userNick}">
</form>

<form id="careerForm" action="${pageContext.request.contextPath}/admin/updateCareer.ad" method="post">
    <input type="hidden" name="userNum" value="${userpage.userNum}">
    <input type="hidden" name="userNick" value="${userpage.userNick}">
    <input type="hidden" id="careerInput" name="userCareer" value="">
</form>

<!-- 경력 추가 모달창 -->
<article id="careerModal" class="modal-Box">
  <div class="modal-profile-selectBox">
    <div class="x-Box" id="closeCareerModal">&times;</div>
    <form id="careerFormModal" action="${pageContext.request.contextPath}/admin/updateCareer.ad" method="post">
      <input type="hidden" name="userNum" value="${userpage.userNum}">
      <input type="hidden" name="userNick" value="${userpage.userNick}">
      
      <label for="careerTextarea" style="font-size:20px"><b>경력 추가 / 수정</b></label><br><br>
      <textarea id="careerTextarea" name="userCareer" rows="20" cols="100" placeholder="경력을 입력하세요..."></textarea>
      
      <button type="submit" class="bjs-profileImgChange-btn">저장</button>
    </form>
  </div>
</article>

   <%-- <article class="modal-Box">
  <div class="modal-profile-selectBox">
    <div class="x-Box">&times;</div>
    <form action="${pageContext.request.contextPath}/admin/UserCerts.ad" method="post">
      <div class="checkbox-container">
        <input type="checkbox" id="option1" name="option" value="1">
        <label for="option1"><img src="${pageContext.request.contextPath}/assets/img/cert_ipe.png" alt="정보처리기사">정보처리기사</label>

        <input type="checkbox" id="option2" name="option" value="2">
        <label for="option2"><img src="${pageContext.request.contextPath}/assets/img/cert_ipie.png" alt="정보처리산업기사">정보처리산업기사</label>

        <input type="checkbox" id="option3" name="option" value="3">
        <label for="option3"><img src="${pageContext.request.contextPath}/assets/img/cert_ipt.png" alt="정보처리기능사">정보처리기능사</label>

        <input type="checkbox" id="option4" name="option" value="4">
        <label for="option4"><img src="${pageContext.request.contextPath}/assets/img/cert_ise.png" alt="정보보안기사">정보보안기사</label>

        <input type="checkbox" id="option5" name="option" value="5">
        <label for="option5"><img src="${pageContext.request.contextPath}/assets/img/cert_isie.png" alt="정보보안산업기사">정보보안산업기사</label>
      </div>

      <div class="checkbox-container">
        <input type="checkbox" id="option6" name="option" value="6">
        <label for="option6"><img src="${pageContext.request.contextPath}/assets/img/cert_netmanager1.png" alt="네트워크관리사1급">네트워크관리사1급</label>

        <input type="checkbox" id="option7" name="option" value="7">
        <label for="option7"><img src="${pageContext.request.contextPath}/assets/img/cert_netmanager2.png" alt="네트워크관리사2급">네트워크관리사2급</label>

        <input type="checkbox" id="option8" name="option" value="8">
        <label for="option8"><img src="${pageContext.request.contextPath}/assets/img/cert_sqld.png" alt="SQLD">SQLD</label>

        <input type="checkbox" id="option9" name="option" value="9">
        <label for="option9"><img src="${pageContext.request.contextPath}/assets/img/cert_linuxmaster1.png" alt="리눅스마스터1급">리눅스마스터1급</label>

        <input type="checkbox" id="option10" name="option" value="10">
        <label for="option10"><img src="${pageContext.request.contextPath}/assets/img/cert_linuxmaster2.png" alt="리눅스마스터2급">리눅스마스터2급</label>
      </div>

      <button type="submit" class="bjs-profileImgChange-btn">뱃지 수정</button>
    </form>
  </div>
</article>
    --%>
</body>
</html>
