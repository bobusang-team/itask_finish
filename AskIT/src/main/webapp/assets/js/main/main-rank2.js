<<<<<<< HEAD
// data-path 값을 가져옴
const basePathElement = document.getElementById('context-path');

//context-path가 정상적으로 로드되었는지 확인
if (basePathElement) {
	const basePath = basePathElement.getAttribute('data-path');
	console.log("베이스패스 경로 확인", basePath);

	// 명예의 전당 데이터를 불러오는 함수
	async function fetchRanking() {
		try {
			const requestUrl = `${basePath}/ranking/mainRank.main`;
			console.log('데이터 요청 시작', requestUrl);

			const response = await fetch(requestUrl);

			if (!response.ok) {
				throw new Error(`서버 응답 오류: HTTP ${response.status} - ${response.statusText}`);
			}

			const responseData = await response.text();
			console.log('서버 응답 데이터', responseData);

			let data; // 변수 선언

			try {
				data = JSON.parse(responseData);  // 중복 선언 방지
				console.log('JSON 데이터 파싱 완료', data);
			} catch (error) {
				console.error('JSON 파싱 오류: 응답이 JSON이 아님', error);
				return;
			}

			// JSON 데이터로 변환 및 화면에 렌더링
			const rankingContainer = document.getElementById('main-ranking-container');
			rankingContainer.innerHTML = ''; // 기존 목록 초기화

			data.forEach((user, index) => {
				console.log(`사용자 추가: ID=${user.userId}, 닉네임=${user.userNick}, 모니터수=${user.userMonitor}`);
				const rankingCard = document.createElement('div');
				rankingCard.classList.add('ranking-card');
				rankingCard.innerHTML = `
                    <div class="ranking">${index + 1}</div>
                    <div class="info">
                        <div class="name">
                            <a href="/user/${user.userId}" class="ranking-link">${user.userNick}</a>
                        </div>
						
                        <div class="monitor-count">
						<img src="${basePath}/assets/img/monitor.png" alt="monitor" class="monitor-icon" />
						${user.userMonitor || 0}</div>
                    </div>
                    <div class="icon">
                        <img src="/assets/img/user.png" alt="${user.userNick} icon" />
                    </div>
                `;
				rankingContainer.appendChild(rankingCard);
			});

			console.log('렌더링 성공');

		} catch (error) {
			console.error('데이터를 불러오는 중 오류 발생:', error);
			const rankingContainer = document.getElementById('main-ranking-container');
			rankingContainer.innerHTML = '<p>데이터를 불러올 수 없습니다. 잠시 후 다시 시도해주세요.</p>';
		}
	}

	// 60초마다 데이터 갱신
	setInterval(fetchRanking, 60000 * 60 * 24);
	fetchRanking();  // 초기 실행
} else {
	console.error("context-path 엘리먼트를 찾을 수 없습니다.");
}

=======
/**
 * 
 */const rankingData = [
  { ranking: 1, rankingname: '김영선', rankingdetails: '27inch 87m / 경력8+', rankingicon: '/path/to/kimyoungsun-icon.jpg', profilePage: '/user/kimyoungsun' },
  { ranking: 2, rankingname: '지수지듀', rankingdetails: '17inch 67m / 경력5+', rankingicon: '/path/to/jisujidu-icon.jpg', profilePage: '/user/jisujidu' },
  { ranking: 3, rankingname: '새운매우깡', rankingdetails: '27inch 87m / 경력2+', rankingicon: '/path/to/saeunmaeunggang-icon.jpg', profilePage: '/user/saeunmaeunggang' },
  { ranking: 4, rankingname: '깃신', rankingdetails: '8inch 3m / 경력6+', rankingicon: '/path/to/gitsin-icon.jpg', profilePage: '/user/gitsin' },
  { ranking: 5, rankingname: '지지베베', rankingdetails: '4inch 0m / 경력3+', rankingicon: '/path/to/jijibebe-icon.jpg', profilePage: '/user/jijibebe' }
];

// DOM 가져오기
const rankingContainer = document.getElementById('main-ranking-container');

// 랭킹 함수
function createRankingCard(data) {
  const card = document.createElement('div');
  card.classList.add('ranking-card');

  card.innerHTML = `
    <div class="ranking">${data.ranking}</div>
    <div class="info">
      <div class="name"><a href="${data.profilePage}" class="ranking-link">${data.rankingname}</a></div>
      <div class="details">${data.rankingdetails}</div>
    </div>
    <div class="icon"><img src="${data.rankingicon}" alt="${data.rankingname} icon" /></div>
  `;

  return card;
}

// 랭킹 데이터
function renderRanking() {
  rankingData.forEach(data => {
    const card = createRankingCard(data);
    rankingContainer.appendChild(card);
  });
}

// 초기 렌더링 실행
renderRanking();
>>>>>>> 22696a287004b177852cb532813ae6a882a5f99d
