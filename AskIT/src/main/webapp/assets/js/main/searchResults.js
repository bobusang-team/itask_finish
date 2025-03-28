document.addEventListener("DOMContentLoaded", function() {

	const searchForm = document.getElementById("searchForm"); // 검색 폼 ID 지정
	const searchInput = document.getElementById("searchInput") // 검색 입력창 ID 지정 

	function performSearch(query, page = 1) {
		const cleanContextPath = contextPath.replace(/\/$/, "");
		const requestURL = `${cleanContextPath}/search/mainSearch.main?query=
		${encodeURIComponent(query)}&page=${page}&json=true`;
		
		console.log("Request URL:", requestURL); 
		
		fetch(requestURL)
			.then(response => {
				console.log("서버 응답 :", response);
				if (!response.ok) {
					throw new Error(`HTTP error! status: ${response.status}`);
				}
				return response.json();
			})
			.then(data => {
				console.log("서버 응답 데이터:", data); // 응답 데이터 확인
				if (!data.searchResults || data.searchResults.length === 0) {
					document.getElementById("articlecontainer").innerHTML = `<p>검색 결과가 없습니다.</p>`;
					return;
				}
				renderSearchResults(data);
				updatePagination(data);
			})
			.catch(error => console.error("검색 요청 중 오류 발생:", error));
	}

	<script>
	    const contextPath = "${pageContext.request.contextPath}";
	    console.log("contextPath:", contextPath);
	</script>
	
	// 페이지 로드시 URL 파라미터에서 검색에 가져와서 실해
	const params = new URLSearchParams(window.location.search);
	const initialQuery = params.get("query") || "";
	const initialPage = params.get("page") || 1;
	if (initialQuery) {
		performSearch(initialQuery, initialPage);
	}

	// 검색버튼 클릭 또는 엔터 입력시 검색 실행 
	searchForm.addEventListener("submit", function(event) {
		event.preventDefault(); // 페이지 새로고침 방지
		const query = searchInput.value.trim();
		if (query) {
			performSearch(query, 1); // 검색 시 첫 페이지부터 시작
			history.pushState({}, "", `?query=${encodeURIComponent(query)}&page=1`); // URL 변경
		}
	});
});

//  검색 결과 렌더링 함수 
function renderSearchResults(data) {
	const resultsContainer = document.getElementById("articlecontainer");
	if (!resultsContainer) return;

	resultsContainer.innerHTML = "";

	data.searchResults.forEach(post => {
		const postHTML = `
	            <section class="bjs-ask-post-list">
	                <article class="bjs-ask-post-item" data-category="${post.category}">
	                    <div class="bjs-ask-post-header">
	                        <span class="bjs-ask-post-tag">${post.category}</span>
	                        <span class="bjs-ask-post-title">
								<a href="${contextPath}/dev/${detailPage}?articleNum=${post.articleNum}">
	                                ${post.articleTitle}
	                            </a>
	                        </span>
	                    </div>
	                        ${post.articleText.length > 50 ? post.articleText.substring(0, 50) + '...' : post.articleText}
	                    </div>
	                    <div class="bjs-ask-post-footer">
	                        <div class="bjs-ask-post-info">
	                            <span class="bjs-ask-post-author">${post.userNick}</span>
	                            <span class="bjs-ask-post-views">조회수 ${post.articleView}</span>
	                        </div>
	                        <span class="bjs-ask-post-date">${post.articleDate}</span>
	                    </div>
	                </article>
	            </section>
	        `;
		resultsContainer.innerHTML += postHTML;
	});

	// 검색 결과 추가 후 스타일 재적용
	setTimeout(() => {
		document.querySelectorAll(".bjs-ask-post-item").forEach(item => {
			item.style.display = "block";
		});
	}, 100);
}

//  페이지네이션 함수
function updatePagination(data) {
	const paginationContainer = document.querySelector(".pagination ul");
	if (!paginationContainer) return;

	paginationContainer.innerHTML = ""; // 기존 페이지네이션 삭제

	if (data.prev) {
		paginationContainer.innerHTML += `<li><a href="?query=${encodeURIComponent(data.query)}&page=${data.startPage - 1}" class="prev">&lt;</a></li>`;
	}

	for (let i = data.startPage; i <= data.endPage; i++) {
		if (i === data.page) {
			paginationContainer.innerHTML += `<li><a href="#" class="active">${i}</a></li>`;
		} else {
			paginationContainer.innerHTML += `<li><a href="?query=${encodeURIComponent(data.query)}&page=${i}">${i}</a></li>`;
		}
	}

	if (data.next) {
		paginationContainer.innerHTML += `<li><a href="?query=${encodeURIComponent(data.query)}&page=${data.endPage + 1}" class="next">&gt;</a></li>`;
	}
}
