document.addEventListener("DOMContentLoaded", function() {
    // 중복 확인 버튼 클릭 시 처리
    const idCheckBtn = document.querySelector("input[name='lsa-join-info-id-btn']");
    const nickNameCheckBtn = document.querySelector("input[name='lsa-join-info-nicName-btn']");
	// 회원가입 버튼 lsa-join-infoBtn
	const joinCheckBtn = document.querySelector(".lsa-join-infoBtn");
	// 인증번화 확인 버튼 
	const checkCheckBtn = document.querySelector(".lsa-join-certiNumber-btn");
	// 인증번호 받기 버튼 lsa-join-info-phoneNumber-btn
	const phoneCheckBtn = document.querySelector(".lsa-join-info-phoneNumber-btn");

	// 아이디 입력창 
	const idInput = document.querySelector(".lsa-join-info-id");
	// 비밀번호 입력창
	const pwInput = document.querySelector("input[name='userPw']");
	// 비밀번호 확인창
	const pwCheck = document.querySelector("input[name='userPwCheck']");
	// 닉네임 입력창
	const nickInput = document.querySelector(".lsa-join-info-nickName");
	// 인증번호 입력창 
	const checkInput = document.querySelector(".lsa-join-info-certiNumber");
	// 핸드폰 번호 입력창
	const phoneInput = document.querySelector(".lsa-join-info-phoneNumber");
	
	// 아이디 유효성 검사
	const idRegex = /^[A-Za-z0-9]{6,15}$/;
	// 비밀번호 유효성 검사
	const pwRegex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*])[A-Za-z\d!@#$%^&*]{8,20}$/;
	// 닉네임 유효성 검사
	const nickRegex = /^[가-힣a-zA-Z0-9]{2,10}$/;
	// 핸드폰 번호 유효성 검사
	const phoneRegex = /^010\d{8}$/;
	
	// 아이디 메시지
	const idCheckResult1 = document.querySelector(".lsa-join-info-id-check1"); 
	const idCheckResult2 = document.querySelector(".lsa-join-info-id-check2"); 
	
	//비밀번호 메시지
	const pwCheckResult1 = document.querySelector(".lsa-join-info-pw-check1");
	
	// 비밀번호 재확인 메시지
	const pwCheckAgainResult1 = document.querySelector(".lsa-join-info-pw-check-again1");
	
	//닉네임 메시지
	const nickCheckResult1 = document.querySelector(".lsa-join-info-nickName-check1");
	const nickCheckResult2 = document.querySelector(".lsa-join-info-nickName-check2");
	
	//인증번호 메시지
	const checkCheckResult1 = document.querySelector(".lsa-join-info-certiNumber-check");
	
	//휴대폰 메시지 
	const phoneCheckResult1 = document.querySelector(".lsa-join-info-phone-check");
	
	let idFlag = false; // 아이디 유효성 체크 플래그
	let pwFlag = false; // 비밀번호 유효성 체크 플래그
	let pwCheckFlag = false; // 비밀번호 재확인 체크 플래그
	let nickFlag = false; // 닉네임 유효성 체크 플래그
	let idFinFlag = false;
	let nickFinFlag = false;
	let checkFlag = false;
	let phoneCheckFlag = false;
	
	
	// 아이디 중복 체크
	idCheckBtn.addEventListener("click", function(event) {
        event.preventDefault(); // 폼 제출 방지
        const userId = document.querySelector("input[name='userId']").value;
		
        if (userId === "") {
            alert("아이디를 입력해주세요.");
            return;
        }

        fetch(`checkIdOk.me?userId=${encodeURIComponent(userId)}`)
            .then(response => response.json())
            .then(data => {
				
				if(!idFlag){
					idCheckResult1.textContent = "유효한 아이디를 입력해주세요";
					idCheckResult1.style.color = "red";
				}else if (data.exists) {
                    idCheckResult1.textContent = "다른 유저가 사용중인 아이디입니다.";
					idCheckResult2.textContent = "";
					idCheckResult1.style.color = "red";
					idFinFlag = false;
                }else{
					idCheckResult1.textContent = "사용가능한 아이디입니다.";
					idCheckResult1.style.color = "#22A309";
					idCheckResult2.textContent = "";
					idFinFlag = true;
				}
            })
            .catch(error => {
                console.error("Error checking ID:", error);
            });
    });
	
	//인증번호 받기 버튼 
	phoneCheckBtn.addEventListener("click", function(event){
		event.preventDefault(); // 폼 제출 방지
		const phone = phoneInput.value;
		phoneCheckFlag = false;
		
		if(phoneRegex.test(phone)){
			phoneCheckFlag = true;
			phoneCheckResult1.textContent = "인증번호가 전송되었습니다.";
			phoneCheckResult1.style.color = "#22A309";
			
			/*인증번호 보내는 fetch 시작 */
			const phoneNumber = phoneInput.value.trim();
		        if (phoneNumber === "") {
		            alert("핸드폰 번호를 입력해주세요.");
		            return;
		        }

		        fetch("sendSMS.me", {
		            method: "POST",
		            headers: { "Content-Type": "application/json" },
		            body: JSON.stringify({ phoneNumber: phoneNumber })
		        })
		         .then(response => {
		                 if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
		             })
		         .then(() => {
		            console.log("발송 성공");
		         })
	            .catch(error => {
	                console.error("SMS 발송 오류:", error);
	                alert("인증번호 발송 중 오류가 발생했습니다.");
	            });
			/*인증번호 보내는 fetch 끝 */
			
		}else if(phone === ""){
			phoneCheckResult1.textContent = "핸드폰 번호를 입력해주세요 (-없이 입력)";
			phoneCheckResult1.style.color = "red";
		}else {
			phoneCheckFlag = false;
			phoneCheckResult1.textContent = "유효한 핸드폰 번호를 입력해주세요 (-없이 입력)";
			phoneCheckResult1.style.color = "red";
		}
	});
	
	// 인증번호 확인
    checkCheckBtn.addEventListener("click", function(event) {
		event.preventDefault(); // 폼 제출 방지
		checkFlag = false;
        const verificationCode = checkInput.value.trim();
        if (verificationCode === "") {
            checkCheckResult1.textContent = "인증번호를 입력해주세요."; 
            checkCheckResult1.style.color = "red";
            return;
        }

        fetch("verifyCode.me", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ code: verificationCode })
        })
            .then(response => {
                if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
                return response.json();
            })
            .then(data => {
            console.log(data);
                if (data.success) {
                    checkCheckResult1.textContent = "인증에 성공했습니다.";
                    checkCheckResult1.style.color = "green";
                } else {
                    checkCheckResult1.textContent = "인증번호가 일치하지 않습니다.";
                    checkCheckResult1.style.color = "red";
                }
            })
            .catch(error => {
                console.error("인증 확인 오류:", error);
                checkCheckResult1.textContent = "인증 처리 중 오류가 발생했습니다.";
                checkCheckResult1.style.color = "red";
            });
    });
	
	// 아이디 유효성 검사
	idInput.addEventListener("blur", function(){
		const id = idInput.value.trim();
		idFlag = false;
		
		if(idRegex.test(id)){
			idCheckResult1.textContent = "사용가능한 아이디입니다";
			idCheckResult1.style.color = "#22A309";
			idCheckResult2.textContent = "아이디 중복확인이 필요합니다.";
			idCheckResult2.style.color = "red";
			idFlag = true;
		}else {
			idCheckResult1.textContent = "아이디는 공백없이 영문,숫자 6~15자 이내로 작성 가능합니다";
			idCheckResult1.style.color = "red";
			idCheckResult2.textContent = "";
			idFlag = false;
		}
	});
	
	// 비밀번호 유효성 검사
	pwInput.addEventListener("blur", function(){
		pwFlag = false;
		const pw = pwInput.value.trim();
		if(pwRegex.test(pw)){
			pwCheckResult1.textContent = "사용가능한 비밀번호입니다.";
			pwCheckResult1.style.color = "#22A309";
			pwFlag = true;
		}else {
			pwCheckResult1.textContent = "비밀번호는 공백없이 영문(대/소문자) 숫자 및 특수문자 조합 8~20자 이내로 작성 가능합니다";
			pwCheckResult1.style.color = "red";
			pwFlag = false;
		}
		pwCheckAgainResult1.textContent = "비밀번호를 재입력/확인해주십시오." ;
		pwCheckAgainResult1.style.color = "red";
	});
    
	//비밀번호 재확인 
	pwCheck.addEventListener("blur", function(){
		pwCheckFlag = false;
		const pw = pwCheck.value.trim();
		const check = pwInput.value.trim();
		pwCheckAgainResult1.textContent = "test";
		if(pw===check){
			pwCheckAgainResult1.textContent = "비밀번호가 일치합니다.";
			pwCheckAgainResult1.style.color = "#22A309";
			pwCheckFlag = true;
		}else {
			pwCheckAgainResult1.textContent = "비밀번호가 일치하지 않습니다";
			pwCheckAgainResult1.style.color = "red";
			pwCheckFlag = false;
		}
	});

	// 닉네임 중복 체크
	nickNameCheckBtn.addEventListener("click", function(event) {
        event.preventDefault(); // 폼 제출 방지
		// nickInput -> 닉네임 입력되는 창 
		const userNick = nickInput.value;
		
        if (userNick === "") {
            alert("닉네임을 입력해주세요.");
            return;
        }

        fetch(`checkNickOk.me?userNick=${encodeURIComponent(userNick)}`)
            .then(response => response.json())
            .then(data => {
				
				if(!nickFlag){
					nickCheckResult1.textContent = "유효한 닉네임을 입력해주세요";
					nickCheckResult1.style.color = "red";
				}else if (data.exists) {
                    nickCheckResult1.textContent = "다른 유저가 사용중인 닉네임입니다.";
					nickCheckResult2.textContent = "";
					nickCheckResult1.style.color = "red";
					nickFinFlag = false;
                }else{
					nickCheckResult1.textContent = "사용가능한 닉네임입니다.";
					nickCheckResult1.style.color = "#22A309";
					nickCheckResult2.textContent = "";
					nickFinFlag = true;
				}
            })
            .catch(error => {
                console.error("Error checking ID:", error);
            });
    });
		
	// 닉네임 유효성 검사
	nickInput.addEventListener("blur", function(){
		const nick = nickInput.value.trim();
		
		if(nickRegex.test(nick)){
			nickCheckResult1.textContent = "사용가능한 닉네임입니다";
			nickCheckResult1.style.color = "#22A309";
			nickCheckResult2.textContent = "닉네임 중복확인이 필요합니다.";
			nickCheckResult2.style.color = "red";
			nickFlag = true;
		}else {
			nickCheckResult1.textContent = "닉네임은 공백없이 한글,영문,숫자 2~10자 이내로 작성 가능합니다";
			nickCheckResult1.style.color = "red";
			nickCheckResult2.textContent = "";
			nickFlag = false;
		}
	});
	
	

});

// 눈버튼 누르면 password에서 text박스로 바뀌게 하는 기능
const input = document.querySelectorAll(".lsa-join-info-pw");  
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


