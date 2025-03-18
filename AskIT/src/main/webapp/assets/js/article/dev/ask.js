<<<<<<< HEAD
const tagBtns = document.querySelectorAll('.mjh-ask-tag-btn');
=======
const tagBtns = document.querySelectorAll('.bjs-ask-tag-btn');
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d

// tag 버튼 눌렀을 때 해당 색상 변화 이벤트
tagBtns.forEach((tagBtn) => {
  tagBtn.addEventListener('click', function () {
    // 모든 버튼에서 bjs-ask-select 클래스 제거
<<<<<<< HEAD
    tagBtns.forEach((Btn) => Btn.classList.remove('mjh-ask-select'));
	console.log(Btn);
    // 클릭된 버튼에 bjs-ask-select 클래스 추가
    tagBtn.classList.add('mjh-ask-select');
=======
    tagBtns.forEach((Btn) => Btn.classList.remove('bjs-ask-select'));

    // 클릭된 버튼에 bjs-ask-select 클래스 추가
    tagBtn.classList.add('bjs-ask-select');
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
  });
});

// 질문 / 꿀팁 눌렀을 때 해당 색상 변화 이벤트
<<<<<<< HEAD
const categoryBtns = document.querySelectorAll('.mjh-ask-category-btn');
=======
const categoryBtns = document.querySelectorAll('.bjs-ask-category-btn');
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d

categoryBtns.forEach((categoryBtn) => {
  categoryBtn.addEventListener('click', function() {
    // 모든 버튼에서 bjs-ask-select 클래스 제거
<<<<<<< HEAD
    categoryBtns.forEach((cateBtn) => cateBtn.classList.remove('mjh-ask-select'));
  
    // 클릭된 버튼에 bjs-ask-select 클래스 추가
    categoryBtn.classList.add('mjh-ask-select');
=======
    categoryBtns.forEach((cateBtn) => cateBtn.classList.remove('bjs-ask-select'));
  
    // 클릭된 버튼에 bjs-ask-select 클래스 추가
    categoryBtn.classList.add('bjs-ask-select');
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
  });
});

const posts = document.querySelectorAll('.bjs-ask-post-item');

// 태그 버튼 클릭 이벤트
tagBtns.forEach((tagBtn) => {
  tagBtn.addEventListener('click', function () {
    // 모든 버튼에서 'bjs-ask-select' 제거 후 클릭된 버튼에 추가
<<<<<<< HEAD
    tagBtns.forEach((btn) => btn.classList.remove('mjh-ask-select'));
    tagBtn.classList.add('mjh-ask-select');
=======
    tagBtns.forEach((btn) => btn.classList.remove('bjs-ask-select'));
    tagBtn.classList.add('bjs-ask-select');
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d

    // 클릭된 버튼의 텍스트 내용 가져오기
    const selectedTag = tagBtn.textContent.trim();

    // 게시글 필터링
<<<<<<< HEAD
/*    posts.forEach((post) => {
=======
    posts.forEach((post) => {
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
      const postTag = post.dataset.tag; // 게시글의 data-tag 값
      if (selectedTag === '전체' || postTag === selectedTag) {
        post.style.display = ''; // 보이기
      } else {
        post.style.display = 'none'; // 숨기기
      }
<<<<<<< HEAD
    });*/
=======
    });
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
  });
});