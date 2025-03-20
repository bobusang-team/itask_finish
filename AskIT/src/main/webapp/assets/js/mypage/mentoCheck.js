// 이미지 수정하기 버튼 접근
const profileImgBtn = document.querySelector('.bjs-profileImg-btn');

// 모달 창에 접근
const modalBox = document.querySelector('.modal-Box');

// x 버튼에 접근
const xBox = document.querySelector('.x-Box');

// 프로필 이미지 변경하기 클릭시
profileImgBtn.addEventListener("click", function(){
  modalBox.style.display = "flex";
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