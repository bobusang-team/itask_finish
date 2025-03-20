document.addEventListener("DOMContentLoaded", function() {
	const searchButton = document.querySelector(".search-logo");
	const searchInput = document.querySelector(".search-input");

	if (!searchButton || !searchInput) {
		console.error("검색 버튼 또는 입력창을 찾을 수 없습니다.");
		return;
	}

	searchButton.addEventListener("click", function() {
		performSearch();
	});

	// 엔터키 입력 시 검색 처리
	searchInput.addEventListener("keydown", function(event) {
		if (event.key === "Enter") {
			event.preventDefault();
			performSearch();
		}
	});

	function performSearch() {
		let keyword = searchInput.value; // 여기서 직접 가져오기
		if (!keyword || keyword.trim().length < 2) {
			alert("검색어는 2글자 이상 입력해주세요.");
			return;
		}

		let url = "search/mainSearch.main?query=" + encodeURIComponent(keyword);
		window.location.href = url;
	}
});
