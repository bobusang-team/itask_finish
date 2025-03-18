document.addEventListener("DOMContentLoaded", function() {
	const totalBtn = document.querySelector('.keh-agreement-total');

	const terms = document.querySelectorAll('.keh-agreement-terms');
	
	const agreeCheckbox1 = document.querySelector('#keh-agreement-require-term01');
	const agreeCheckbox2 = document.querySelector('#keh-agreement-require-term02');
	
	const nextBtn = document.querySelector('.keh-agreement-btn');
	
	const agreeOption = document.querySelector('#keh-agreement-terms03');

	// 노드리스트에서 map을 사용할 수 있도록
	NodeList.prototype.map = Array.prototype.map;


	// 전체 클릭시 -> 나머지 모두 동의
	totalBtn.addEventListener('click', function(){
		terms.forEach((term) => {
	  		term.checked = totalBtn.checked;
		});
		const agreement = agreeOption.checked;
		
		fetch("agreeOK.me", {
			method: "POST",
			headers : {"Content-Type": "application/json"},
			body: JSON.stringify({check : agreement})
		})
		.then(response =>{
			if(!response.ok) throw new Error(`HTTP 오류! 상태코드 : ${response.status}`);
			return response.json();
		})
		.then(data =>{
			console.log("선택 약관 동의 상태 : "+data);
		})
		.catch(error =>{
			console.error("선택 약관 동의 오류", error);
		})
	});

	// 전체 제외 모두 클릭시 -> 전체도 체크
	terms.forEach((term) => {
	  term.addEventListener('click', function(){
	    totalBtn.checked = terms.map(term => term.checked).filter((checked)=> checked).length === 3;});
	});
	
	//선택 약관동의 체크 유무 데이터베이스에 입력하기
	agreeOption.addEventListener('click', function(){
		const agreement = agreeOption.checked;
		
		fetch("agreeOK.me", {
			method: "POST",
			headers : {"Content-Type": "application/json"},
			body: JSON.stringify({check : agreement})
		})
		.then(response =>{
			if(!response.ok) throw new Error(`HTTP 오류! 상태코드 : ${response.status}`);
			return response.json();
		})
		.then(data =>{
			console.log("선택 약관 동의 상태 : "+data);
		})
		.catch(error =>{
			console.error("선택 약관 동의 오류", error);
		})
		
	});

	// 필수 약관 체크 누락 시 알림창 띄우기 
	nextBtn.addEventListener('click', function(e){
		if (!agreeCheckbox1.checked || !agreeCheckbox2.checked) {
	        e.preventDefault();
	        alert("필수 약관에 동의해주세요.");
	    }else{
			location.href="join.jsp";
		}
	});
	
});
