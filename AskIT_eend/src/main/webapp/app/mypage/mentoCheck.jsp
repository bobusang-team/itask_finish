<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!-- 자격/경력/뱃지 추가하기 -->

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>자격/경력/뱃지 추가하기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/mentoCheck.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
    <script defer src="${pageContext.request.contextPath}/assets/js/mypage/mentoCheck.js"></script>
  </head>
  <body>
  <jsp:include page="./../basic/userheader.jsp"/>
    <main class="itAskBox">
      <!-- 마이페이지 페이지 제목 -->
      <h3>마이페이지</h3>
      <!-- 좌측 프로필사진 -->
      <section class="keh-mentoCheck-profile-left">
        <!-- 프로필사진 - 내 정보 -->
        <ul>
          <li class="keh-mentoCheck-pic">
            <img src="${profileImgSrc}" alt="${profileAlt}">
          </li>
          <li class="keh-mentoCheck-memType">
          <!-- 일반회원/멘토회원 표시하는 부분 -->
            <c:choose>
    	      <c:when test="${mypageMainDTO.userMentoCert == 'T'}">멘토회원🏅</c:when>
   			  <c:when test="${mypageMainDTO.userMentoCert == 'F'}">일반회원</c:when>
			</c:choose>
            <span><img src="" alt="멘토뱃지" /></span>
          </li>
          <li class="keh-mentoCheck-memNickName">
            <!-- 닉네임을 표시하는 부분 -->
            <span><c:out value = "${mypageMainDTO.userNick }" />님</span>
          </li>
          <li class="keh-mentoCheck-myMonitor">
            <img src="${pageContext.request.contextPath}/assets/img/Monitor.png" alt="" />
                 <span>${mypageMainDTO.getFormattedMonitor()}</span>
            </li>
         </ul>

        <hr />
        <!-- 선 -->

        <!-- 프로필사진 - 수정/인증/전체글/댓글 메뉴 -->
        <ul class="keh-mentoCheck-myMenu">
          <li class="bjs-profileImg-btn onclick="openModal()">프로필 사진 변경하기</li>
          <li><a href="${pageContext.request.contextPath}/mypage/pwCheck.my">내 정보 수정하기</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/mentoCheck.my">자격/멘토 뱃지 추가하기</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/myTotalArticle.my">내가 쓴 전체 게시글 보기</a></li>
          <li><a href="${pageContext.request.contextPath}/mypage/myTotalComment.my">내가 쓴 전체 댓글 보기</a></li>
        </ul>
      </section>


      <!-- 우측 자격/경력/뱃지 안내 -->
      <section class="keh-mentoCheck-profile-right">
        <h4>뱃지 인증</h4>

        <!-- 1.뱃지이미지 -->
        <article class="keh-mentoCheck-badgeIcon">
          <div>
            <img src="${pageContext.request.contextPath}/assets/img/Award.png" alt="멘토뱃지" />멘토
            뱃지
          </div>
          <div>
            <img src="${pageContext.request.contextPath}/assets/img/Book.png" alt="자격증뱃지" />자격증
            뱃지
          </div>
        </article>

        <!-- 2.필요서류 -->
        <article class="keh-mentoCheck-needPaper">
          <p>
            <strong>&lt;멘토 인증 필요서류&gt;</strong><br /><br />
            사진 1매, 경력서 1부<br />
            수상이력/자격증 확인서 중 택 1
          </p>
          <p>
            <strong>&lt;자격증 뱃지 인증 필요서류&gt;</strong><br /><br />
            신분증 사진 1매<br />
            자격증/자격증확인서 중 택 1
          </p>
        </article>

        <!-- 3.제출할 곳 -->
        <article class="keh-mentoCheck-email">
          해당 양식에 맞추어 작성하신 후 아래의 이메일로 제출 바랍니다<br /><br />
          <strong>제출이메일 : itask@itask.com</strong>
        </article>

        <!-- 4.멘토뱃지 최소조건 -->
        <h4>멘토 뱃지 최소 조건</h4>
        <article class="keh-mentoCheck-condition">
          <div>
            <img src="${pageContext.request.contextPath}/assets/img/Award.png" alt="멘토뱃지" />멘토
            뱃지
          </div>   
          <p>
            경력(5년 이상)<br>
            관련자격증 or 수상이력(1개 이상)
          </p>       
        </article>
        
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
