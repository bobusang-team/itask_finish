<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
<!-- 내정보 수정하기 - 2.내정보 수정하기 -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>내 정보 수정하기</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/editInfo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
    <script defer src="${pageContext.request.contextPath}/assets/js/mypage/editInfo.js"></script>
  </head>
  <body>
  <jsp:include page="./../basic/userheader.jsp"/>
  <%request.setCharacterEncoding("utf-8");%>
    <%
    	UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");
  	%>
  	<%-- <h1><%= userInfo.getUserId() %></h1> --%>
      
    <main class="itAskBox">   
      <a href="#">
        <img src="${pageContext.request.contextPath}/assets/img/logo.png" alt="ITASK 로고">
      </a>   
                       
      <p>
        내 정보 수정하기<br>
        <span>회원정보를 입력해주세요</span>
      </p>

      <section>        
        <ul>
          <li><strong>인증된 정보</strong></li>
          <li>이름 : 
          <% 
/*           UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");
 */          out.println(userInfo.getUserName()); // 이름출력
          %>
          </li>
          <li>
          아이디 : 
		  <% 
/*           UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");
 */          out.println(userInfo.getUserId()); // 아이디출력
          %>
          </li>
          <li>핸드폰 번호 : +82 
          <% 
/*           UserDTO userInfo = (UserDTO) session.getAttribute("userDTO");
 */         String phoneNum = userInfo.getUserPhone().substring(1); 
 			out.println(phoneNum); // 폰번호출력
          %>
           </li>
        </ul>
      </section>
      <!-- 닉네임 입력칸 -->
      <form action="${pageContext.request.contextPath }/mypage/editInfoOk.my" name="keh-editInfo-infoForm" class="keh-editInfo-infoForm" method="post">
        <div class="keh-editInfo-nickNameBox">
          <input type="text" name="userNick" class="keh-editInfo-nickName" placeholder="변경할 닉네임">
          <input type="submit" name="keh-editInfo-nickName-btn" class="keh-editInfo-nickName-btn" value="수정">
        </div>   

        <p>공백없이 한글, 영문, 숫자 포함 6~15자</p>
        <p>특수문자 사용불가</p>
        
        <!-- 닉네임 중복일시 출력되는 문구.  이외의 유효성검사는 모두 alert()로 날릴것임-->
        <div class="bjs-editInfo-duplicate-nickName"></div>
        
      </form>
      <hr>
      <button><a href="${pageContext.request.contextPath }/mypage/editPw.my">비밀번호 수정하기</a></button><br>
      <button><a href="${pageContext.request.contextPath }/mypage/editPhoneNum.my">핸드폰 번호 수정하기</a></button><br>
      <button><a href="${pageContext.request.contextPath }/mypage/userDeleteOk.my" id="idid">회원 탈퇴하기</a></button><br>
      
    </main>
    <jsp:include page="../basic/footer.jsp" />
  </body>
  <script>

     	 
         document.getElementById("idid").addEventListener("click", function(){
        	 const isExit = confirm("진짜 탈퇴하겠습니까?");
        	 if(isExit){
        		 alert("탈퇴되었습니다.");
        	 }else{
        		 location.reload(true);
        	 }
        		 
         }
        
  </script>
</html>
