document.addEventListener("DOMContentLoaded", function(){
	//[0]이 위에 입력창 [1]이 밑에 재확인 입력창
	//비밀번호 입력창
	const pwInput = document.querySelectorAll(".keh-pwReseting-pw");
	
	//비밀번호 오류 메시지
	const pwCheckResult1 = document.querySelectorAll(".keh-pwReseting-check1");
	//비밀번호 성공 메시지
	const pwCheckResult2 = document.querySelectorAll(".keh-pwReseting-check2");
	
	//비밀번호 변경버튼 
	const pwChangeBtn = document.querySelector(".keh-pwReseting-pwBtn");
	
	//비밀번호 유효성 확인 플래그 
	let pwFlag = false;
	//비밀번호 재입력 일치 확인 플래그 
	let pwCheckFlag = false;
	
	// 비밀번호 유효성 검사
	const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,20}$/;
	
	// 비밀번호 재설정 유효성 검사 
	pwInput[0].addEventListener("blur", function(){
		const pw = pwInput[0].value.trim();
		console.log(pw);
		if(pwRegex.test(pw)){
			pwCheckResult1[0].style.display = "none";
			pwCheckResult2[0].style.display = "flex";
			pwFlag = true;
		}else{
			pwCheckResult1[0].style.display = "flex";
			pwCheckResult2[0].style.display = "none";
			pwFlag = false;
		}
		pwCheckResult1[1].style.display = "flex";
		pwCheckResult2[1].style.display = "none";
		pwCheckFlag = false;
	});
	
	//비밀번호 재설정 재확인 
	pwInput[1].addEventListener("blur", function(){
		const pw = pwInput[0].value.trim();
		const check = pwInput[1].value.trim();
		console.log(check);
		console.log(pw)
		if(pw===check){
			pwCheckResult1[1].style.display = "none";
			pwCheckResult2[1].style.display = "flex";
			pwCheckFlag = true;
		}else{
			pwCheckResult1[1].style.display = "flex";
			pwCheckResult2[1].style.display = "none";
			pwCheckFlag = false;
		}
	});
	
	pwChangeBtn.addEventListener("click", function(event){
		if(!pwFlag || !pwCheckFlag){
			event.preventDefault();
			alert("비밀번호를 확인해주세요");
			pwInput[0].focus();
		}else{
		}
	})
	
});

// 눈버튼 누르면 password에서 text박스로 바뀌게 하는 기능
const input = document.querySelectorAll(".keh-pwReseting-pw");  
const mark1 = document.querySelector(".mark1"); 
const mark2 = document.querySelector(".mark2");

let pwStatus1 = false; // 초기 상태: 비밀번호 숨김
let pwStatus2 = false; // 초기 상태: 비밀번호 숨김


mark1.addEventListener("click", () => {
  if (pwStatus1) {
    input[0].type = "password"; // 비밀번호 숨김
    mark1.src = "./../../assets/img/hidden 4.png"; // 아이콘 변경
  } else {
    input[0].type = "text"; // 비밀번호 표시
    mark1.src = "./../../assets/img/Eye.png"; // 아이콘 변경
  }
  pwStatus1 = !pwStatus1; // 상태 변경
});

mark2.addEventListener("click", () => {
  if (pwStatus2) {
   	input[1].type = "password"; // 비밀번호 숨김
    mark2.src = "./../../assets/img/hidden 4.png"; // 아이콘 변경
  } else {
    input[1].type = "text"; // 비밀번호 표시
    mark2.src = "./../../assets/img/Eye.png"; // 아이콘 변경
  }
  pwStatus2 = !pwStatus2; // 상태 변경
});
