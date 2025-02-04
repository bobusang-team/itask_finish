document.addEventListener("DOMContentLoaded", function() {

const nickNameRegex = /^[가-힣a-zA-Z0-9]{6,15}$/;
const nickNameCheckBtn = document.querySelector("input[name='keh-editInfo-nickName-btn']");

nickNameCheckBtn.addEventListener("click", function(event){
	event.preventDefault(); 
	const userNick = document.querySelector("input[name='userNick']").value;
	
	if(userNick == ""){
		alert("닉네임을 입력해주세요.");
		return;
	}
	
	if(!nickNameRegex.test(userNick)){
		alert("닉네임 조건에 맞지 않습니다");
		return;
	}
	
	fetch(`checkNickOk.my?userNick=${encodeURIComponent(userNick)}`)
		.then(response => response.json())
		.then(data => {
			const nickNameCheckResult = document.querySelector(".bjs-editInfo-duplicate-nickName");
			
			if(data.exists){
				nickNameCheckResult.textContent = "이미 있는 닉네임입니다.";
			}else{
				nickNameCheckResult.textContent = "닉네임이 변경되었습니다.";
				fetch(`editInfoOk.my?userNick=${encodeURIComponent(userNick)}`)
					.then(response => response.json())
					
			}
		})
		.catch(error => {
			console.error("Error checking nickName:", error);
		});
	
});


});


// 회원탈퇴하기

document.getElementById("idid").addEventListener("click", function(event){
  // confirm("진짜 탈퇴하겠습니까?");
  const isExit = confirm("진짜 탈퇴하겠습니까?");
  if(isExit){
    //눌렀을 때 비회원메인 경로로 가게 하기
	// 추후에는 해당 유저의 아이디를 입력하게끔 해보자!
	alert("탈퇴되었습니다.")
    //location.href = "./../../main.jsp"; 
    // 나중에 메인 도메인 정해지면 메인으로 이동하기로함
    // return "https://www.naver.com/"; 이렇게 하면 이동 안됨
  }else{
	event.preventDefault();
	alert("취소되었습니다");
    //return;
  }
 //console.log(isExit);
})
