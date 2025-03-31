//게시물 수정/삭제 드롭다운
function Dropdown() {
	const menu = document.getElementById('dropdownMenu');
	menu.style.display = menu.style.display === 'block' ? 'none' : 'block';
}

//게시물 삭제
document.addEventListener("DOMContentLoaded", function () {
    // 삭제 버튼을 가져옴
    const deleteBtn = document.getElementById("postdelete");

    if (deleteBtn) {
        deleteBtn.addEventListener("click", function (event) {
            // 삭제 확인 창 띄우기
            const isConfirmed = confirm("게시물을 삭제하시겠습니까?");
            
            if (!isConfirmed) {
                event.preventDefault(); // 취소하면 페이지 이동을 막음
            }
        });
    }
});

$(document).ready(function() {

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
	                    <span class="writer">${comment.badge} ${comment.userNick}</span>
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
						<img src="${contextPath}/assets/img/moniter.png" alt="모니터 이미지">
						${comment.commentMonitorNum}
					</div>`;
			commentList.appendChild(li);
			
		});
		document.addEventListener("DOMContentLoaded", () => {
		    document.addEventListener("click", (event) => {
		        const link = event.target.closest(".comment-monitor a");
		        if (link) {
		            event.preventDefault(); // 기본 링크 이동 막기
		            window.location.href = link.href; // 강제 이동
		        }
		    });
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

		
		// 댓글 수정 완료
		$(".comment-list").on("click", ".comment-modify", function () {
		    const commentNum = $(this).data("number");
		    const newText = $(this).closest("li").find(".modify-content").val().trim();

		    if (!newText) {
		        alert("댓글 내용을 입력해주세요.");
		        return;
		    }

		    $.ajax({
		        url: `/comment/commentUpdate.co?commentNum=${commentNum}`,
		        type: "POST",
		        contentType: "application/json; charset=utf-8",
		        data: JSON.stringify({
		            commentNum: commentNum,
		            commentText: newText
		        }),
		        success: () => {
		            alert("댓글이 수정되었습니다.");
		            loadReplies();
		        },
		        error: (xhr, status, error) => {
		            console.error("댓글 수정 실패:", error);
		            alert("댓글 수정에 실패했습니다.");
		        }
		    });
		});
		
		// 댓글 삭제
		$(".comment-list").on("click", ".comment-delete", function () {
		    const replyNumber = $(this).data("number");
		    if (confirm("댓글을 삭제하시겠습니까?")) {
		        $.ajax({
		            url: `/reply/replyDeleteOk.re?replyNumber=${replyNumber}`,
		            type: "GET",
		            success: () => {
		                alert("댓글이 삭제되었습니다.");
		                loadReplies();
		            },
		            error: (xhr, status, error) => {
		                console.error("댓글 삭제 실패:", error);
		                alert("댓글 삭제에 실패했습니다.");
		            }
		        });
		    }
		});

// 초기 댓글 로드
loadReplies();
});