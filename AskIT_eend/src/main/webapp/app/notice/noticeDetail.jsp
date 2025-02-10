<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="com.itask.app.dto.UserDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>공지사항게시글화면</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/notice/noticeDetail.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css">
</head>

<body>
<% UserDTO userInfo = (UserDTO)session.getAttribute("userDTO"); %>
<% if(userInfo != null){ %>
<jsp:include page="./../basic/userheader.jsp"/>		  
<% }else{ %>
<jsp:include page="./../basic/header.jsp"/> 
<%} %>

	<div class="mjh-noticeDetail-main">
    <div class="mjh-noticeDetail-title">공지사항</div>
    
    <div class="mjh-noticeDetail-articel-header">
    	<!-- 카테고리 -->
     	<div class="mjh-noticeDetail-articel-category" id="notice-category">
   	    <c:out value="${noticeList.getNoticeCategory()}" /></div>
      
    	<!-- 글제목 -->
     	<div class="mjh-noticeDetail-articel-title">
      	<c:out value="${noticeList.getNoticeTitle()}" /></div>
      
      	<div class = "textInfo">
      	<!-- 작성자 -->
      		작성자 <Strong><c:out value="${noticeList.getAdminNick()}" /></Strong>
     
      	<!-- 작성일 -->
      		&nbsp;&nbsp;작성일 <Strong>
	  		<c:out value="${fn:substring(noticeList.getNoticeDate(), 0 ,10) }" /></Strong>
	  	  
	  	<!-- 조회수 -->
	  		&nbsp;&nbsp;조회수 <Strong><c:out value="${noticeList.getNoticeView()}" /></Strong>
     	</div>
    </div> 
        
    <hr class="mjh-noticeDetail-articel-line">
    
    <!-- 글내용 -->
    <div class="mjh-noticeDetail-articel-text" id="notice-text">
    <c:out value="${noticeList.getNoticeText()}" /></div>
 
    <hr class="mjh-noticeDetail-articel-line2">
    
   	<!-- 목록버튼 -->
    <span class="mjh-noticeDetail-listbutton"><a href="${pageContext.request.contextPath}/app/notice/notice.no">목록</a></span>
  </div>
  <br>
  <br>
  <br>
  <br>
  <br>
  <jsp:include page="../basic/footer.jsp" />
  
</body>
</html>