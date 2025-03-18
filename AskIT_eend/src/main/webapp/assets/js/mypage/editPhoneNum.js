
/*// 이름 필드에 접근 : 나중에 백에서 값 저장할때 사용
const name = document.querySelector('.keh-editPhoneNum-name');

// 핸드폰 필드에 접근 : 나중에 백에서 값 저장할때 사용
const userPhoneNum = document.querySelector('.keh-editPhoneNum-phoneNum');

// 임시 인증번호 : 1!2@3#4$
const temp_number = "123";

// 인증번호 받기 버튼
const getNumber = document.querySelector('.keh-editPhoneNum-phoneNum-btn');


// 사용자가 인증번호 입력하는 필드 접근
const checkNumber = document.querySelector('.keh-editPhoneNum-phoneNum2');

// 인증번호 확인 버튼
const checkBtn = document.querySelector('.keh-editPhoneNum-phoneNum-btn2');

//인증완료 메시지에 접근
const checkMsg = document.querySelector('.keh-editPhoneNum-checkInfo');

//변경된 정보 저장하기 버튼에 접근
const changeBtn = document.querySelector('.keh-editPhoneNum-submit-btn');

//폼요소에 접근
const form = document.querySelector('.keh-editPhoneNum-infoForm');


// 인증번호를 받았는지를 알려주는 상태
let userStatus = false; // 디폴트 = 받지 않음
let changeStatus = false;

// 인증번호 받기 버튼 클릭시
getNumber.addEventListener('click', function(){
  // console.log(userPhoneNum.value);
  if(userPhoneNum.value === ""){
    alert("핸드폰번호가 유효하지 않습니다.")
  }else{
    alert("핸드폰으로 인증번호가 발송되었습니다. \n인증번호가 오지 않는다면 핸드폰 번호를 다시 확인해주세요")
    userStatus = true; // 인증 대기 상태
  }
})

// 인증번호 확인 버튼 클릭시
checkBtn.addEventListener('click', function(){
  //인증번호를 받지 않은 상태라면
  if(!userStatus){
    alert("인증번호를 받아주세요");
  }else if(checkNumber.value !== temp_number){
    alert("인증번호가 틀렸습니다");
  }else{
      checkMsg.style.display = "block";
      changeStatus = true;

      // changeBtn.style.disabled = "false";
      // console.log(changeBtn.disabled);
    }
  });
*/



/*// 이름 필드에 접근 : 나중에 백에서 값 저장할때 사용
const name = document.querySelector('.keh-editPhoneNum-name');

// 핸드폰 필드에 접근 : 나중에 백에서 값 저장할때 사용
const userPhoneNum = document.querySelector('.keh-editPhoneNum-phoneNum');

// 임시 인증번호 : 1!2@3#4$
//const temp_number = "123";

// 인증번호 받기 버튼
const getNumber = document.querySelector('.keh-editPhoneNum-phoneNum-btn');

// 사용자가 인증번호 입력하는 필드 접근
const checkNumberInput = document.querySelector('.keh-editPhoneNum-phoneNum2');

// 인증번호 확인 버튼
const checkBtn = document.querySelector('.keh-editPhoneNum-phoneNum-btn2');

//인증완료 메시지에 접근
const checkMsg = document.querySelector('.keh-editPhoneNum-checkInfo');

//변경된 정보 저장하기 버튼에 접근
const changeBtn = document.querySelector('.keh-editPhoneNum-submit-btn');

//폼요소에 접근
const form = document.querySelector('.keh-editPhoneNum-infoForm');*/

/*
// 인증번호를 받았는지를 알려주는 상태
let userStatus = false; // 디폴트 = 받지 않음
let changeStatus = false;

// 인증번호 받기 버튼 클릭시
getNumber.addEventListener('click', function(){
  // console.log(userPhoneNum.value);
  if(userPhoneNum.value === ""){
	alert("핸드폰번호가 유효하지 않습니다.")
  }else{
	alert("핸드폰으로 인증번호가 발송되었습니다. \n인증번호가 오지 않는다면 핸드폰 번호를 다시 확인해주세요")
	userStatus = true; // 인증 대기 상태
  }
})

// 인증번호 확인 버튼 클릭시
checkBtn.addEventListener('click', function(){
  //인증번호를 받지 않은 상태라면
  if(!userStatus){
	alert("인증번호를 받아주세요");
  }else if(checkNumber.value !== temp_number){
	alert("인증번호가 틀렸습니다");
  }else{
	  checkMsg.style.display = "block";
	  changeStatus = true;

	  // changeBtn.style.disabled = "false";
	  // console.log(changeBtn.disabled);
	}
  });*/
  
//$(document).ready(function() {
//document.addEventListener("DOMContentLoaded", function() {
	// 인증번호 받기 버튼
	const getNumber = document.querySelector('.keh-editPhoneNum-phoneNum-btn');

	// 사용자가 인증번호 입력하는 필드
	const checkNumberInput = document.querySelector('.keh-editPhoneNum-phoneNum2');

	// 인증번호 확인 버튼
	const checkBtn = document.querySelector('.keh-editPhoneNum-phoneNum-btn2');
	
	// 핸드폰 필드에 접근 : 나중에 백에서 값 저장할때 사용
	const userPhoneNum = document.querySelector('.keh-editPhoneNum-phoneNum');

	// 인증번호 상태 메시지
	const checkNumberStatus = document.querySelector('.keh-editPhoneNum-checkInfo');
	
	// 인증번호 받기 클릭시
	getNumber.addEventListener("submit", function() {
		// 유저폰넘버 받기
		const phoneNumber = userPhoneNum.value;
		console.log(phoneNumber);
		
		console.log(phoneNumber);
		if(phoneNumber === "") {
			alert("핸드폰 번호를 입력해주세요.");
			return;
		}
		
		fetch(`/mypage/sendSMS.my`, {
			method: "POST",
			headers: { "Content-Type": "application/json; charset=UTF-8" },
			body: JSON.stringify({ phoneNumber: phoneNumber})
		})
		 .then(response => {
			if(!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
		 })
		 .then(() => {
			console.log("발송 성공");
			console.log(checkNumberInput.disabled);
			checkNumberInput.disabled = false;
			console.log(checkNumberInput.disabled);
		 })
		 .catch(error => {
			console.error("SMS 발송 오류:", error);
			alert("인증번호 발송 중 오류가 발생했습니다.");
		 });
	});
	
	// 인증번호 확인
	checkNumberInput.addEventListener("blur", function() {
		const checkNumberCode = checkNumberInput.value.trim();
		if(checkNumberCode === "") {
			checkNumberStatus.textContent = "인증번호를 입력해주세요";
			checkNumberStatus.style.color = "red";
			return;
		}
		
		fetch("/mypage/verifyCode.my", {
			method: "POST",
			headers: { "Content-Type": "application/json" },
			body: JSON.stringify({ code: checkNumberCode})
		})
		  .then(response => {
			if (!response.ok) throw new Error(`HTTP 오류! 상태 코드 : ${response.status}`);
			return response.json();
		  } )
		  .then(data => {
			console.log(data);
			if(data.success){
				checkNumberStatus.textContent = "인증에 성공했습니다.";
				checkNumberStatus.style.color = "green";
			} else {
				checkNumberStatus.textContent = "인증정보가 일치하지 않습니다."
				checkNumberStatus.style.color = "red";
			}
		  })
		  .catch(error => {
			console.error("인증 확인 오류:", error);
			checkNumberStatus.textContent = "인증 처리 중 오류가 발생했습니다.";
			checkNumberStatus.style.color = "red";
		  });
	});
//});
