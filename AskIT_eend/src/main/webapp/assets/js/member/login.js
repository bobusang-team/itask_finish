// 로그인페이지

// 눈버튼 누르면 password에서 text박스로 바뀌게 하는 기능
const input = document.querySelector(".keh-login-pw");  // 이거는 input 태그의 class명을 적용하면됩니다 
const mark = document.querySelector(".mark"); // 이거는 눈있는 태그에 class="mark" 를 추가하고 사용해야합니다

let pwStatus = false; // 초기 상태: 비밀번호 숨김

mark.addEventListener("click", () => {
  if (pwStatus) {
    input.type = "password"; // 비밀번호 숨김
    mark.src = "./../../assets/img/hidden 4.png"; // 아이콘 변경
  } else {
    input.type = "text"; // 비밀번호 표시
    mark.src = "./../../assets/img/Eye.png"; // 아이콘 변경
  }
  pwStatus = !pwStatus; // 상태 변경
});
