
// 기여도 m
let monitorLevel = 0;
// 모디터 인치
let monitorInches = 0;

function increaseMonitorLevel() {
	monitorLevel++; //증가
	document.getElementById("monitor-level").textContent =
		`${monitorLevel}m`; // 모니터 값 업뎃

	// 100m 시 1inch
	if (monitorLevel >= 100) {
		monitorInches++;
		monitorLevel = 0; //초기화
		document.getElementById("monitor-levelup").textContent =
			`${monitorInches} inch`;
	}
}


// 통합검색
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
		}

		let url = "search/mainSearch.main?query=" + encodeURIComponent(keyword);
		window.location.href = url;
	}
});
