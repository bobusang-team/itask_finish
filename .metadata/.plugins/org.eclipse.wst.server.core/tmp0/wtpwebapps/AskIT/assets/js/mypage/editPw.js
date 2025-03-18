/**
 * 
 */
const input = document.querySelector(".keh-editPw-pw");
const input2 = document.querySelector(".keh-editPw-pw2");

// 유효성 검사 메시지와 비밀번호 확인 메시지
const check1 = document.querySelector(".keh-editPw-check1");
const check2 = document.querySelector(".keh-editPw-check2");
const matchMessage1 = document.querySelector(".keh-editPw-check2-1");
const matchMessage2 = document.querySelector(".keh-editPw-check2-2");

const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{8,20}$/;
const form = document.querySelector(".keh-editPw-pwForm"); // 폼 요소

// 비밀번호 일치 확인 함수
function checkPasswordMatch() {
	if (input.value === input2.value && passwordRegex.test(input.value)) {
		matchMessage1.style.display = "none";
		matchMessage2.style.display = "block";
		
		return true;
	} else {
		matchMessage1.style.display = "block";
		matchMessage2.style.display = "none";
		return false;
	}
}


const Btn = document.querySelector('.keh-editPw-pwBtn');

// 비밀번호 입력 이벤트
input.addEventListener("input", () => {

	const value = input.value;

	if (value === "") {
		check1.style.display = "none";
		check2.style.display = "none";
		
	} else if (passwordRegex.test(value)) {
		check1.style.display = "none";
		check2.style.display = "block";
		
	} else {
		check1.style.display = "block";
		check2.style.display = "none";
		
	}
	checkPasswordMatch();

});

input2.addEventListener("input", checkPasswordMatch);


Btn.addEventListener("click", function(event) {
	
	if(input.value === input2.value && passwordRegex.test(input.value)){
		alert("비밀번호가 변경되었습니다. \n로그인화면으로 이동합니다");
	}else{
		alert("비밀번호 조건이 일치하지 않습니다.");
		event.preventDefault();
	}
	
})





