<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ page import="com.itask.app.dto.UserDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>웹페이지 통합</title>

<link rel="stylesheet"
   href="${pageContext.request.contextPath }/assets/css/header.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath }/assets/css/footer.css">
<link rel="stylesheet"
   href="${pageContext.request.contextPath }/assets/css/write/write.css">
   	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script defer
   src="${pageContext.request.contextPath }/assets/js/write/write.js"></script>

</head>

<body>
<% UserDTO userInfo = (UserDTO)session.getAttribute("userDTO"); %>
<% if(userInfo != null){ %>
<jsp:include page="./../basic/userheader.jsp"/>		  
<% }else{ %>
<jsp:include page="./../basic/header.jsp"/>		  
<%} %>		  
  
 <main class="itAskBox">
  <form action="${pageContext.request.contextPath}/app/write/writeOk.wr" method="post" enctype="multipart/form-data" >
    <!-- <div class="write-click"> -->
      <h3>카테고리 선택</h3>
      <!-- 카테고리선택 시작 -->
      <div class="topCate">
        <!-- 대분류 -->
        <input type="radio" id="dev" name="topCate" value="개발" required="required" >
        <label for="dev">개발</label>        
        <input type="radio" id="sec" name="topCate" value="보안" required="required" >
        <label for="sec">보안</label>
        <input type="radio" id="qual" name="topCate" value="자격증" required="required" >
        <label for="qual">자격증</label>

        <!-- 중분류 -->
        <div class="botCate">
          <input type="radio" id="ask" name="botCate" value="질문" required="required" >
          <label for="ask">질문</label>
          <input type="radio" id="tip" name="botCate" value="꿀팁" required="required" >
          <label for="tip">꿀팁</label>
        </div>

        <!-- 개발태그네임 -->
        <div class="tagDev">
          <input type="radio" id="JAVA" name="tagDev" value="JAVA">
          <label for="JAVA">JAVA</label>
          <input type="radio" id="HTML" name="tagDev" value="HTML">
          <label for="HTML">HTML</label>
          <input type="radio" id="CSS" name="tagDev" value="CSS">
          <label for="CSS">CSS</label>
          <input type="radio" id="JAVASCRIPT" name="tagDev" value="JAVASCRIPT">
          <label for="JAVASCRIPT">JAVASCRIPT</label>
          <input type="radio" id="ORACLE" name="tagDev" value="ORACLE">
          <label for="ORACLE">ORACLE</label>
        </div>
        <!-- 보안태그네임 -->        
        <div class="tagSec">
          <input type="radio" id="NETWORK" name="tagSec" value="NETWORK" >
          <label for="NETWORK">NETWORK</label>
          <input type="radio" id="WEB" name="tagSec" value="WEB" >
          <label for="WEB">WEB</label>
          <input type="radio" id="MOBILE" name="tagSec" value="MOBILE">
          <label for="MOBILE">MOBILE</label>
          <input type="radio" id="FORENSICS" name="tagSec" value="포렌식" >
          <label for="FORENSICS">포렌식</label>
          <input type="radio" id="MALWARE" name="tagSec" value="악성코드">
          <label for="MALWARE">악성코드</label>
        </div>
        <!-- 자격증태그네임 -->
        <div class="tagQual">
          <input type="radio" id="INFOSEC" name="tagQual" value="정보보안" >
          <label for="INFOSEC">정보보안</label>
          <input type="radio" id="INFOPROCE" name="tagQual" value="정보처리" >
          <label for="INFOPROCE">정보처리</label>
          <input type="radio" id="NETMANAGER" name="tagQual" value="네트워크관리사">
          <label for="NETMANAGER">네트워크관리사</label>
          <input type="radio" id="LINUXMASTER" name="tagQual" value="리눅스마스터" >
          <label for="LINUXMASTER">리눅스마스터</label>
          <input type="radio" id="SQLD" name="tagQual" value="SQLD">
          <label for="SQLD">SQLD</label>
        </div>
      </div>
      <!-- 카테고리선택끝 -->
      <hr>
      <!-- 제목 -->
      <div class="write-title-section">
        <p>제목</p>
        <input type="text" id="title" name="title" placeholder="&nbsp;&nbsp;&nbsp;제목 : 최소 8글자 이상 입력해주세요" minlength="8" required />
      </div>
      <!-- 내용 -->
      <div class="write-content-section">
        <p>작성내용</p>
        <textarea id="content" name="content" placeholder="&nbsp;&nbsp;&nbsp;내용 : 최소 20글자 이상 입력해주세요" minlength="20" rows="30" required></textarea>
      </div>


      <!-- 첨부파일 -->
      		<div class="form-group">
				<label for="file">파일 첨부</label>

				<div class="image-upload-wrap">
					<input type="file" id="file" name="boardFile" accept=".jpg, .jpeg, .png" multiple />
			
<!-- 	파일형식 제한하고 싶으면 accept=".jpg, .jpeg, .png" multiple  제거 -->

					<div class="image-upload-box">
						<div class="upload-text">
							<!-- <div class="upload-icon">
								<svg viewBox="0 0 48 48">
						<path fill-rule="evenodd" clip-rule="evenodd"
										d="M25.9087 8.12155L36.4566 18.3158C37.2603 18.7156 38.2648 18.6156 38.968 18.3158C39.6712 17.5163 39.6712 16.4169 38.968 15.7173L25.3059 2.5247C24.6027 1.8251 23.4977 1.8251 22.7945 2.5247L9.03196 15.8172C8.32877 16.5168 8.32877 17.6162 9.03196 18.3158C9.73516 19.0154 10.9406 19.0154 11.6438 18.3158L22.2922 8.12155V28.4111C22.2922 29.4106 23.0959 30.2091 24.1005 30.2091C25.105 30.2091 25.9087 29.4106 25.9087 28.4111V8.12155ZM5.61644 29.4104C5.61644 28.4109 4.81279 27.6104 3.80822 27.6104C2.80365 27.6104 2 28.5099 2 29.5093V44.202C2 45.2015 2.80365 46 3.80822 46H44.1918C45.1963 46 46 45.2015 46 44.202V29.5093C46 28.5099 45.1963 27.7113 44.1918 27.7113C43.1872 27.7113 42.3836 28.5099 42.3836 29.5093V42.3021H5.61644V29.4104Z"></path></svg>
							</div> -->
							<div class="upload-count">
								이미지 업로드(<span class="cnt">0</span>/1)
							</div>
						</div>
						<div class="upload-text">최대 1개까지 업로드가능합니다.(파일 형식 : jpg, png, jpeg) ※ 이미지를 등록하면 즉시 반영됩니다.</div>
						<!-- <div class="upload-text"></div>
						<div class="upload-text"></div> -->
					</div>
				</div>
				<div class="img-controller-box">
					<ul class="file-list">
						
					</ul>
				</div>
			</div>
      

      <button class="submit-button" type="submit">글 작성하기</button>      
    </form>
  </main>
	
   <!-- 푸터 영역 -->
   <jsp:include page="./../basic/footer.jsp" />
</body>

</html>
