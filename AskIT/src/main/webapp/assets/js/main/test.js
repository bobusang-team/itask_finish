// data-path 값을 가져옴
const basePathElement = document.getElementById('context-path');

//context-path가 정상적으로 로드되었는지 확인
if (basePathElement) {
	const basePath = basePathElement.getAttribute('data-path');
	console.log("베이스패스 경로 확인", basePath);


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
        
		let data;
        
		try {
            data = JSON.parse(responseData);
            console.log('JSON 데이터 파싱 완료', data);
        } catch (error) {
            console.error('JSON 파싱 오류 : 응답이 JSON이 아님', error);
            return;
        }

        if (!data || !Array.isArray(data)) {
            console.error('데이터 형식이 올바르지 않습니다.', data);
            return;
        }

		
        rankingContainer.innerHTML = '';

        data.forEach((user, index) => {
            console.log(`사용자 추가 : ID=${user.userId}, 닉네임=${user.userNick}, 경력=${user.userCareer}`);
            const rankingCard = document.createElement('div');
            rankingCard.classList.add('ranking-card');
            rankingCard.innerHTML = `
                <div class="ranking">${index + 1}</div>
                <div class="info">
                    <div class="name">
                        <a href="/user/${user.userId}" class="ranking-link">${user.userNick}</a>
                    </div>
                    <div class="details">${user.userCareer || '경력 정보 없음'}</div>
                </div>
                <div class="icon">
                    <img src="/assets/icons/${user.userId}.jpg" alt="${user.userNick} icon" />
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