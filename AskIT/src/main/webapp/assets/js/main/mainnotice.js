document.addEventListener("DOMContentLoaded", () => {
	console.log("공지사항 스크립트 로드됨");

	fetch(window.location.pathname.includes('/AskIT')
		? "/AskIT/notice/mainNotices.main"
		: "/notice/mainNotices.main") // 컨트롤러에서 JSON 응답을 받음
		.then(response => {
			if (!response.ok) {
				throw new Error(`서버 응답 오류 : ${response.status}`);
			}
			return response.json();
		})
		.then(notices => {
			console.log("공지사항 데이터 수신:", notices);
			const noticeList = document.querySelector(".main-notice-list");
			noticeList.innerHTML = "";

			notices.forEach(notice => {
				const noticeItem = document.createElement("div");
				noticeItem.classList.add("main-notice-item");
				noticeItem.setAttribute("data-id", notice.noticeNum);

				noticeItem.innerHTML = `
                <span class="main-notice-category">${notice.noticeCategory}</span>
                <span class="main-notice-title">${notice.noticeTitle}</span>
                <span class="main-notice-date">${notice.noticeDate}</span>
            `;

				noticeItem.addEventListener("click", () => {
					window.location.href = `/workspace/webapp/html/notice/noticeDetail.html?id=${notice.noticeNum}`;
				});

				noticeList.appendChild(noticeItem);
			});
		})
		.catch(error => console.error("공지사항 데이터를 불러오는 중 오류 발생:", error));
});
