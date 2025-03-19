// 질문 / 꿀팁 눌렀을 때 해당 색상 변화 이벤트
const categoryBtns = document.querySelectorAll('.bjs-ask-category-btn');

const posts = document.querySelectorAll('.bjs-ask-post-item');

categoryBtns.forEach((categoryBtn) => {
  categoryBtn.addEventListener('click', function() {
    // 모든 버튼에서 bjs-ask-select 클래스 제거
    categoryBtns.forEach((cateBtn) => cateBtn.classList.remove('bjs-ask-select'));
  
    // 클릭된 버튼에 bjs-ask-select 클래스 추가
    categoryBtn.classList.add('bjs-ask-select');
	
	// 클릭된 버튼의 텍스트 내용 가져오기
	const selectedTag = categoryBtn.textContent.trim();
	
	// 게시글 필터링
	posts.forEach((post) => {
	const postTag = post.dataset.tag; // 게시글의 data-tag 값
	  if (selectedTag === '전체' || postTag === selectedTag) {
	    post.style.display = ''; // 보이기
	  } else {
	    post.style.display = 'none'; // 숨기기
	  }
    });
  });
});


// 모달창 부분

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


// fetch 사용하고싶어서 1세션 박음 250206
/*const categoryBtns = document.querySelectorAll('.bjs-ask-category-btn');
const postList = document.querySelector('#post-list');

categoryBtns.forEach((categoryBtn) => {
	categoryBtn.addEventListener('click', function(){
		//console.log(categoryBtn.textContent.trim());
		const cate = categoryBtn.getAttribute('data-category')
		console.log(cate);
		// 모든 버튼에서 bjs-ask-select 클래스 제거
		categoryBtns.forEach((cateBtn) => cateBtn.classList.remove('bjs-ask-select'));

		// 클릭된 버튼에 bjs-ask-select 클래스 추가
		categoryBtn.classList.add('bjs-ask-select');

		// 클릭된 버튼의 텍스트 내용 가져오기
		//const selectedTag = categoryBtn.textContent.trim();
		
		//console.log(selectedTag);
		// 게시글 필터링을 fetch 기반으로 전환
	    fetch(`/mypage/myTotalArticleCate.my`, {
			method: "POST",
			headers: {"Content-Type" : "application/json"},
			body: JSON.stringify({ category: cate })
		})
		.then(response => {
		    if (!response.ok) throw new Error(`HTTP 오류! 상태 코드: ${response.status}`);
		    return response.json();
		 })
	      .then((data) => {
	        // 기존 게시물 초기화
	        postList.innerHTML = '';

	        // 새로운 게시물 추가
	        data.forEach((post) => {
	          const postItem = document.createElement('article');
	          postItem.classList.add('bjs-ask-post-item');
	          postItem.dataset.tag = post.articleTagname; // data-tag 속성 설정

	          postItem.innerHTML = `
	            <div class="bjs-ask-post-header">
	              <span class="bjs-ask-post-tag">${post.articleTagname}</span>
	              <span class="bjs-ask-post-title">
	                <a href="/dev/detailAsk.dev?articleNum=${post.articleNum}">
	                  ${post.articleTitle}
	                </a>
	              </span>
	            </div>
	            <div class="bjs-ask-post-body">${post.articleText}</div>
	            <div class="bjs-ask-post-footer">
	              <div class="bjs-ask-post-info">
	                <span class="bjs-ask-post-author">${post.badge} ${post.userNick}</span>
	                <span class="bjs-ask-post-views">조회수 ${post.articleView}</span>
	                <span class="bjs-ask-post-date">${post.articleDate}</span>
	              </div>
	            </div>
	          `;
	          postList.appendChild(postItem);
	        });
	      })
	      .catch((error) => console.error('Error fetching posts:', error));
	  });
	});*/