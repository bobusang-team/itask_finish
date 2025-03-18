<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
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
            <div></div>
          </li>
          <li class="keh-mentoCheck-memType">
          <!-- 일반회원/멘토회원 표시하는 부분 -->
            <%
               UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");
               System.out.println(userInfo);
               if (userInfo != null) {
                  char userCert = userInfo.getUserCert();
                  if (userCert == 'T') {
                     out.println("멘토회원🏅");
                  } else if (userCert == 'F') {
                     out.println("일반회원");
                  }
               } else {
                  out.println("사용자 정보가 없습니다.");
               }
               
               %>
            <span><img src="" alt="멘토뱃지" /></span>
          </li>
          <li class="keh-mentoCheck-memNickName">
          <%
               if (userInfo != null){
                    String userNick = userInfo.getUserNick();
                    out.println(userNick+"님");
               } else{
            	  /* alert("로그인 세션이 없습니다. \n로그인페이지로 이동합니다."); */
                  response.sendRedirect(request.getContextPath() + "/app/member/login.jsp");
               }
            %>
          </li>
          <li class="keh-mentoCheck-myMonitor">
            <img src="${pageContext.request.contextPath}/assets/img/Monitor.png" alt="" />
            <b>
            <%
               	if (userInfo != null){
                  int userInch = Integer.parseInt(userInfo.getUserMoniter())/100;
                  out.println(userInch);
               	}else{
               		
               	}
               
             %>
            </b>inch 
            <b>
            <%
               int userMonitor = Integer.parseInt(userInfo.getUserMoniter());
               out.println(userMonitor%100);
            %> 
            </b>m
          </li>
        </ul>

        <hr />
        <!-- 선 -->

        <!-- 프로필사진 - 수정/인증/전체글/댓글 메뉴 -->
        <ul class="keh-mentoCheck-myMenu">
          <li><a href="${pageContext.request.contextPath}/app/mypage/pwCheck.jsp">내 정보 수정하기</a></li>
          <li><a href="${pageContext.request.contextPath}/app/mypage/mentoCheck.jsp">자격/멘토 뱃지 추가하기</a></li>
        </ul>
      </section>


      <!-- 우측 자격/경력/뱃지 안내 -->
      <section class="keh-mentoCheck-profile-right">
        <h4>자격 뱃지 인증</h4>

        <!-- 1.뱃지이미지 -->
        <article class="keh-mentoCheck-badgeIcon">
          <div>
            <img src="${pageContext.request.contextPath}/assets/img/Briefcase.png" alt="경력뱃지" />경력
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
            <strong>&lt;멘토 인증 절차 필요서류&gt;</strong><br /><br />
            사진, 경력<br />
            수상이력or자격증 중 택 1
          </p>
          <p>
            <strong>&lt;자격증 뱃지 절차 필요서류&gt;</strong><br /><br />
            자격증 or 자격증확인서<br />
            신분증
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
  </body>
</html>
