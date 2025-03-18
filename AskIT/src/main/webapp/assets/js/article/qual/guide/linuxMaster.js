function calculateDay(target){
  const today = new Date();
  const targetDay = new Date(target);

  const sec = targetDay - today;

  const day = Math.ceil(sec / (1000 * 60 * 60 * 24));

  return day;
}

// 날짜 바꾸려면 여기만 t 의 값만 업뎃해주면됨
<<<<<<< HEAD
const t = '2025-07-28';
=======
const t = '2025-01-20';
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
const dDay = calculateDay(t);

document.addEventListener("DOMContentLoaded", function() {
  const elements = document.querySelector(".lch-linuxMaster-dday").innerText = dDay;
});