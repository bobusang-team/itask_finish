$(document).ready(function() {

//게시글 모니터 버튼 누르면 1증가
/*let count = -1;
const img = document.getElementById('Detail-moniter-img');
const countplus = document.getElementById('Detail-monitercount');
img.addEventListener('click', function () {
  if (count === -1) {
	count = 1;
  } else {
	count = -1;
  }
  countplus.textContent = parseInt(countplus.textContent) + count;
});*/

//수정삭제 드롭다운
function Dropdown() {
	const menu = document.getElementById('dropdownMenu');
	menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
}

//게시물 삭제
/*const postDeletebtn = document.getElementById('postdelete');
postDeletebtn.addEventListener('click', function () {
  confirm('게시글을 삭제하시겠습니까?');
});*/

//게시글 공유
/*const postshare = document.getElementById('Detail-share-img');
postshare.addEventListener('click', function () {
  confirm('다음 링크를 복사하세요');
});*/


// 댓글 수 초기화는 0으로 해야되는데 html에 더미 댓글 하나 있어서
// 초기 세팅을 1로 설정해뒀습니다~
// 나중에 바꿔주시면 됩니다!
/*let commentCount = 1;

function addComment() {
  const commentInput = document.getElementById('comment-input');
  const commentText = commentInput.value.trim();
  // 댓글이 비어 있지 않으면
  if (commentText !== '') {
	// 새로운 댓글을 생성

	// 댓글의 모든 정보를 담은 제일 큰 박스
	const commentArea = document.createElement('div');
	commentArea.classList.add('bjs-askDetail-comment-show');

	// 댓글 작성자
	const commmentAuthor = document.createElement('span');
	commmentAuthor.classList.add('bjs-askDetail-commnet-author');
	//bjs-askDetail-commnet-author
	commmentAuthor.textContent = "3inch 임초현🏅"; // 나중에 불러오는거 여기 추가

	// 댓글 (진짜)
	const comment = document.createElement('div');
	comment.classList.add('bjs-askDetail-comment-section');
	comment.textContent = commentText;

	// 작성일자, 조회수, 모니터 담은 박스
	const commentInfo = document.createElement('div');
	commentInfo.classList.add('bjs-askDetail-comment-info');

	// 작성일자
	const commentDate = document.createElement('span');
	commentDate.classList.add('bjs-askDetail-comment-date');
	commentDate.textContent = "1시간 전" // 나중에 불러오는거 여기 추가

	// 모니터 수, 이미지 박스
	const commentMonitor = document.createElement('span');
	commentMonitor.classList.add('bjs-askDetail-comment-monitor');


	// 모니터 수
	const commentMonitorNum = document.createElement('span');
	commentMonitorNum.classList.add('bjs-askDetail-comment-monitor-num');
	commentMonitorNum.textContent = " 0"; // 나중에 불러오는거 여기 추가


	 

	//댓글 삭제
	const commentdelete = document.createElement('span');
	commentdelete.addEventListener('click', function () {
	  if(comment.classList.contains("bjs-askDetail-delete-comment-style")){
		alert('이미 삭제된 댓글입니다.');
	  }else if (confirm('댓글을 삭제하시겠습니까?')) {
		comment.textContent = '삭제된 댓글입니다.';
		comment.classList.add('bjs-askDetail-delete-comment-style');
		// 모니터 수 - 변경
		commentMonitorNum.textContent = '-';
	  }
	});
	commentdelete.classList.add('bjs-askDetail-comment-delete');
	commentdelete.textContent = " 삭제";

	//댓글 수정
	const commentmodify = document.createElement('span');

	//null값 출력 오류 코드 수정 ------------------------------------
	commentmodify.addEventListener('click', function () {
	  if (comment.textContent === '삭제된 댓글입니다.') {
		alert('삭제한 댓글은 수정할 수 없습니다.')
	  } else if (confirm('댓글을 수정하시겠습니까?')) {

		const modifycomment = prompt('수정할 댓글을 입력해주세요');
		//여깅입니다 준혁님!
		console.log(modifycomment);
		if(modifycomment!==null){
		  comment.textContent = modifycomment + ' (수정됨)';
		}
	  }
	});
	// 코드 수정 ---------------------------------------------------
	commentmodify.classList.add('bjs-askDetail-comment-modify');
	commentmodify.textContent = "수정 ";


	//모니터 이미지
	const monitorImg = document.createElement('img');
	monitorImg.setAttribute('src', '${pageContext.request.contextPath}/assets/img/monitor.png');
	monitorImg.setAttribute('alt', '추가된 모니터 이미지 사진오류');

	let commentCnt = -1;

	monitorImg.addEventListener('click', function () {
	  if (comment.textContent === '삭제된 댓글입니다.') {
		alert('삭제한 댓글에는 모니터기능이 제한됩니다.');
		commentCnt = 316;
	  } else if (commentCnt === -1) {
		commentCnt = 1;
		commentMonitorNum.textContent = parseInt(commentMonitorNum.textContent) + commentCnt;
	  } else {
		commentCnt = -1;
		commentMonitorNum.textContent = parseInt(commentMonitorNum.textContent) + commentCnt;
	  }
	});

	// 댓글을 댓글 섹션에 추가
	const commentSection = document.getElementById('comment-section');
	commentSection.appendChild(commentArea);
	commentArea.appendChild(commmentAuthor);
	commentArea.appendChild(comment);
	commentArea.appendChild(commentInfo);
	commentInfo.appendChild(commentDate);
	commentInfo.appendChild(commentMonitor);
	commentMonitor.appendChild(monitorImg);
	commentMonitor.appendChild(commentMonitorNum);
	commentInfo.appendChild(commentmodify);
	commentInfo.appendChild(commentdelete);

	// 댓글 수 증가
	commentCount++;

	// 댓글 수 업데이트
	document.getElementById('comment-count').textContent = commentCount;

	// 입력창 비우기
	commentInput.value = '';
    
  } else {
	alert('댓글을 입력해주세요!');
  }
}*/

/*	const listBtn = $(".list-btn");
	const articleNum = listBtn.data("articlenum"); 
	
	console.log("확인 articleNum:", articleNum);
	console.log("userNum:", userNum);
*/
	const listBtn = document.querySelector(".list-btn");
	const aritcleNum = listBtn.get
	console.log(listBtn);
	console.log(articleNum + "확인 ======");
	console.log(userNum);
	
// 댓글 작성(fetch)
	document.querySelector(".submit-btn")?.addEventListener("click", async function() {
		console.log(document.querySelector(".submit-btn"));
		const content = document.querySelector("#content").value.trim();
		if (!content) {
			alert("칭찬 댓글은 작성자에게 큰 힘이 됩니다.");
			return;
		}
	
		try {
			const response = await fetch("/AskIT_eend/comment/commentWriteOk.co", {
				
				method: "POST",
				headers: { "Content-Type": "application/json; charset=utf-8" },
				body: JSON.stringify({ articleNum, userNum, commentText: content })
			});
			console.log('댓글 작성 컨트롤러 실행 완료' + userNum + ", comment : " + content);
	
			const result = await response.json();
			if (result.status === "success") {
				alert("댓글이 작성되었습니다.");
				document.querySelector("#content").value = "";
				document.querySelector("#comment-count").value ++;
				loadReplies();
			} else {
				alert("댓글 작성에 실패했습니다.");
			}
		} catch (error) {
			console.error("댓글 작성 실패:", error);
			alert("댓글 작성 중 오류가 발생했습니다.");
		}
	});
	//댓글 목록 로드 (fetch)
	async function loadReplies() {
		try {
			const response = await fetch(`/AskIT_eend/comment/commentListOk.co?articleNum=${articleNum}`);
			if (!response.ok) throw new Error("댓글 목록을 불러오는 데 실패했습니다.");
			const replies = await response.json();
			renderReplies(replies);
		} catch (error) {
			console.error("댓글 목록 불러오기 실패:", error);
			alert("댓글 목록을 불러오는데 실패했습니다.");
		}
	}
	const imagePath = "/assets/img/moniter.png";
	//댓글 렌더링
	function renderReplies(replies) {
		const commentList = document.querySelector("#comment-list");
		commentList.innerHTML = "";
	
		if (replies.length === 0) {
			commentList.innerHTML = "<li>댓글이 없습니다.</li>";
			return;
		}
		
		replies.forEach(comment => {
			const isMyComment = comment.userNum == userNum;
			const li = document.createElement("li");
			li.innerHTML = `
	                <div class="comment-info">
	                    <span class="writer">${comment.badge}${comment.userNick}</span>
	                    <span class="date">${comment.commentDate}</span>
	                </div>
	                <div class="comment-content-wrap">
	                    <div class="comment-content">${comment.commentText}</div>
	                    ${isMyComment ? `
	                        <div class="comment-btn-group">
	                            <button type="button" class="comment-modify-ready" data-number="${comment.commentNum}">수정</button>
	                            <button type="button" class="comment-delete" data-number="${comment.commentNum}">삭제</button>
	                        </div>
	                    ` : ""}
	                </div>
					<div class="comment-monitor">
					<a href="${contextPath}/comment/commentMonitor.co?commentNum=${comment.commentNum}">
					<img src="http://localhost:8080/AskIT_eend/assets/img/moniter.png" alt="모니터 이미지">
						${comment.commentMonitorNum}
					</div>`;
			commentList.appendChild(li);
		});
	}
	//댓글 수정 준비 (fetch)
		document.querySelector(".comment-list").addEventListener("click", function(event) {
			if (event.target.matches(".comment-modify-ready")) {
				const li = event.target.closest("li");
				const contentDiv = li.querySelector(".comment-content");
				const originalContent = contentDiv.textContent.trim();

				contentDiv.innerHTML = `<textarea class="modify-content">${originalContent}</textarea>`;
				event.target.closest(".comment-btn-group").innerHTML = `
		                <button type="button" class="comment-modify" data-number="${event.target.dataset.number}">수정 완료</button>
		            `;
			}
		});

		//댓글 수정 완료 (fetch)
		document.querySelector(".comment-list").addEventListener("click", async function(event) {
			if (event.target.matches(".comment-modify")) {
				const replyNumber = event.target.dataset.number;
				const newContent = event.target.closest("li").querySelector(".modify-content").value.trim();

				if (!newContent) {
					alert("댓글 내용을 입력해주세요.");
					return;
				}

				try {
					const response = await fetch("/reply/replyUpdateOk.re", {
						method: "POST",
						headers: { "Content-Type": "application/json; charset=utf-8" },
						body: JSON.stringify({ replyNumber, replyContent: newContent })
					});

					const result = await response.json();
					if (result.status === "success") {
						alert("댓글이 수정되었습니다.");
						loadReplies();
					} else {
						alert("댓글 수정에 실패했습니다.");
					}
				} catch (error) {
					console.error("댓글 수정 실패:", error);
					alert("댓글 수정 중 오류가 발생했습니다.");
				}
			}
		});

// 초기 댓글 로드
loadReplies();
});