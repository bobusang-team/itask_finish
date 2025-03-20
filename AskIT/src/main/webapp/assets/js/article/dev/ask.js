const tagBtns = document.querySelectorAll('.mjh-ask-tag-btn');

// tag 버튼 눌렀을 때 해당 색상 변화 이벤트
/*tagBtns.forEach((tagBtn) => {
  tagBtn.addEventListener('click', function () {
    // 모든 버튼에서 bjs-ask-select 클래스 제거
    tagBtns.forEach((Btn) => Btn.classList.remove('mjh-ask-select'));
	console.log(Btn);
    // 클릭된 버튼에 bjs-ask-select 클래스 추가
    tagBtn.classList.add('mjh-ask-select');
  });
});*/

// 질문 / 꿀팁 눌렀을 때 해당 색상 변화 이벤트
/*const categoryBtns = document.querySelectorAll('.mjh-ask-category-btn');

categoryBtns.forEach((categoryBtn) => {
  categoryBtn.addEventListener('click', function() {
    // 모든 버튼에서 bjs-ask-select 클래스 제거
    categoryBtns.forEach((cateBtn) => cateBtn.classList.remove('mjh-ask-select'));
  
    // 클릭된 버튼에 bjs-ask-select 클래스 추가
    categoryBtn.classList.add('mjh-ask-select');
  });
});*/
document.addEventListener("DOMContentLoaded", function () {
    // URL에서 articleTagname 값을 가져오기
    const urlParams = new URLSearchParams(window.location.search);
    const articleTagname = urlParams.get('articleTagname');

    // 모든 <a> 태그 찾기
    const links = document.querySelectorAll(".bjs-ask-tag1");

    // URL 파라미터 값과 일치하는 <a> 태그에 클래스 추가
    let hasSelected = false;
    links.forEach(link => {
        const url = new URL(link.href);
        const tagname = url.searchParams.get("articleTagname");

        if (tagname === articleTagname) {
            link.classList.add("bjs-ask-select");
            hasSelected = true;
        } else {
            link.classList.remove("bjs-ask-select");
        }
    });

    // 만약 URL에 articleTagname이 없으면 첫 번째 <a>를 기본 선택
    if (!hasSelected && links.length > 0) {
        links[0].classList.add("bjs-ask-select");
    }

    // 클릭 이벤트 추가
    links.forEach(link => {
        link.addEventListener("click", function () {
            // 기존 선택 해제
            document.querySelector(".bjs-ask-select")?.classList.remove("bjs-ask-select");

            // 새 선택 추가
            this.classList.add("bjs-ask-select");
        });
    });
});


document.addEventListener("DOMContentLoaded", function () {
    // URL에서 articleTagname 값을 가져오기
    const urlParams1 = new URLSearchParams(window.location.search);
    const articleBotcate = urlParams1.get('articleBotcate');
	console.log(articleBotcate)
    // 모든 <a> 태그 찾기
    const links1 = document.querySelectorAll(".bjs-ask-category-btn");

    // URL 파라미터 값과 일치하는 <a> 태그에 클래스 추가
    let hasSelected1 = false;
    links1.forEach(link1 => {
        const url1 = new URL(link1.href);
        const botcate = url1.searchParams.get("articleBotcate");

        if (botcate === articleBotcate) {
            link1.classList.add("bjs-ask-select");
            hasSelected1 = true;
        } else {
            link1.classList.remove("bjs-ask-select");
        }
    });

    // 만약 URL에 articleTagname이 없으면 첫 번째 <a>를 기본 선택
    if (!hasSelected1 && links1.length > 0) {
        links1[0].classList.add("bjs-ask-select");
    }

    // 클릭 이벤트 추가
    links1.forEach(link => {
        link.addEventListener("click", function () {
            // 기존 선택 해제
            document.querySelector(".bjs-ask-select")?.classList.remove("bjs-ask-select");

            // 새 선택 추가
            this.classList.add("bjs-ask-select");
        });
    });
});


