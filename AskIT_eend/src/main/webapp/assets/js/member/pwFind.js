document.addEventListener("DOMContentLoaded", function() {
	//휴대폰 번호 입력창
	const phoneInput = document.querySelector(".keh-pwFind-phoneNum");
	//인증번호 입력창 
	const checkInput = document.querySelector(".keh-pwFind-checkNum2");
	//인증번호 받기 버튼
	const phoneCheckBtn = document.querySelector(".keh-pwFind-phoneNum-btn");
	//인증번호 확인 버튼 
	const checkCheckBtn = document.querySelector(".keh-pwFind-phoneNum-btn2");
	//비밀번호 재설정 버튼
	const pwResetBtn = document.querySelector(".keh-pwFind-pwBtn");
	//인증번호 확인 메시지
	const checkCheckResult = document.querySelector(".keh-pwFind-checkInfo");
	// 핸드폰 번호 유효성 검사
	const phoneRegex = /^010\d{8}$/;
	
	//인증번호 일치 여부 검사 flag
	const flag = false;
	
	//인증번호 받기 버튼 
	phoneCheckBtn.addEventListener("click", function(event){
		event.preventDefault(); // 폼 제출 방지
		const phone = phoneInput.value;
		if(phoneRegex.test(phone)){
			// 알림 안보냄 오류 -> 수정중
			alert("인증번호가 전송되었습니다.");
			
			/*인증번호 보내는 fetch 시작 */
			const phoneNumber = phoneInput.value.trim();
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
			alert("핸드폰 번호를 입력해주세요 (숫자만 입력)");
		}else {
			alter("유효한 핸드폰 번호를 입력해주세요 (숫자만 입력)");
		}
	});
	
	// 인증번호 확인
    checkCheckBtn.addEventListener("click", function(event) {
		event.preventDefault(); // 폼 제출 방지
        const verificationCode = checkInput.value.trim();
        if (verificationCode === "") {
            checkCheckResult.textContent = "인증번호를 입력해주세요."; 
            checkCheckResult.style.color = "red";
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
                checkCheckResult.textContent = "인증에 성공했습니다.";
                checkCheckResult.style.color = "green";
            } else {
                checkCheckResult.textContent = "인증번호가 일치하지 않습니다.";
                checkCheckResult.style.color = "red";
            }
        })
        .catch(error => {
            console.error("인증 확인 오류:", error);
            checkCheckResult.textContent = "인증 처리 중 오류가 발생했습니다.";
            checkCheckResult.style.color = "red";
        });
	});
	
	pwResetBtn.addEventListener("click", function(event){
		if(checkCheckResult.textContent==="인증에 성공했습니다."){
		}else{
			event.preventDefault();
			alert("알맞은 인증번호를 입력해주세요");
		}
		
	})
	
})