// 이미지 수정하기 버튼 접근
const badgeBtn = document.querySelector('#badge-btn');
const gradeBtn = document.querySelector('#grade-btn');
const careerBtn = document.querySelector('#career-btn');
const contextPath = '${request.contextPath}';
// 모달 창에 접근
const modalBox = document.querySelector('#badgeModal');

// x 버튼에 접근
const xBox = document.querySelector('.x-Box');

// 프로필 이미지 변경하기 클릭시
badgeBtn.addEventListener("click", function(){
  modalBox.style.display = "flex";
});

gradeBtn.addEventListener("click", function() {
	const grade = confirm('회원등급을 변경하시겠습니까?');
	console.log(grade);
	if(grade) {
		document.getElementById("updateGradeForm").submit(); // 폼 제출
	}
});

document.addEventListener("DOMContentLoaded", function() {
    const careerBtn = document.getElementById("career-btn"); // 버튼
    const careerModal = document.getElementById("careerModal"); // 모달창
    const closeCareerModal = document.getElementById("closeCareerModal"); // 닫기 버튼
    const careerTextarea = document.getElementById("careerTextarea"); // textarea
    const careerForm = document.getElementById("careerFormModal"); // 폼

    // 기존 경력 가져오기
    const userCareer = careerBtn.dataset.career || ""; 
    careerTextarea.value = userCareer; // textarea에 기존 값 넣기

    // 버튼 클릭 시 모달창 열기
    careerBtn.addEventListener("click", function() {
        careerModal.style.display = "block";
    });

    // 닫기 버튼 클릭 시 모달창 닫기
    closeCareerModal.addEventListener("click", function() {
        careerModal.style.display = "none";
    });

    // 폼 제출 시 값 설정
    careerForm.addEventListener("submit", function() {
        document.getElementById("careerInput").value = careerTextarea.value; 
    });
});

// 모달창의 x버튼 클릭시
xBox.addEventListener("click", function(){
  modalBox.style.display = "none";
})

xBox.addEventListener("mouseover", function(){
  this.style.color="red";
})

xBox.addEventListener("mouseout", function(){
  this.style.color="black";
})

/*const checkboxes = document.querySelectorAll('.checkbox-container');
console.log(checkboxes);
function openModal() {
	
}
*/