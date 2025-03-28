// 전체 선택 체크박스 처리
function toggleSelectAll() {
    const selectAll = document.getElementById('selectAll');
    const checkboxes = document.querySelectorAll('.item-checkbox');
    checkboxes.forEach(checkbox => checkbox.checked = selectAll.checked);
}

// 개별 체크박스를 변경할 때 selectAll 체크박스 상태 업데이트
function updateSelectAll() {
    const selectAll = document.getElementById('selectAll');
    const checkboxes = document.querySelectorAll('.item-checkbox');
    const allChecked = Array.from(checkboxes).every(checkbox => checkbox.checked);
    selectAll.checked = allChecked;
}

// 개별 체크박스 상태 변경 시 업데이트
document.querySelectorAll('.item-checkbox').forEach(checkbox => {
    checkbox.addEventListener('change', updateSelectAll);
});

// 수정 버튼 클릭 시
function submitEditForm() {
	var contextPath = "${pageContext.request.contextPath}";
	const selectedUsers = document.querySelectorAll('.item-checkbox:checked');
	    if (selectedUsers.length === 0) {
	        alert("삭제할 게시글을 선택해주세요.");
	        return;
	    }
		if (selectedUsers.length === 1) {
		        var confirmEdit = confirm("해당 목록을 수정하시겠습니까?");
		if (confirmEdit) {
			const articleNum = selectedUsers[0].closest('.askqualList').querySelector('.articleNum').value;
			console.log(articleNum);
			location.href = `./articleDetail.ad?articleNum=` + articleNum;
		    }
		    } 
		else {
			alert("수정할 항목을 하나만 선택해주세요.");
		}
}


// 삭제 폼 전송
function submitDeleteForm() {
	document.getElementById('articleTopcate').value = document.getElementById('articleTopCate').value;
		document.getElementById('articleBotcate').value = document.getElementById('articleBotCate').value;
    const form = document.getElementById('deleteForm');
    const selectedUsers = document.querySelectorAll('.item-checkbox:checked');
    if (selectedUsers.length === 0) {
        alert("삭제할 게시글을 선택해주세요.");
        return;
    }

    let userIdsInput = document.getElementById("articleNums");
	userIdsInput.value = Array.from(selectedUsers).map(user => 
	    user.closest('.askqualList').querySelector('.articleNum').value
	).join(",");

    const confirmDelete = confirm("선택한 게시글을 삭제하시겠습니까?");
    if (confirmDelete) {
        form.submit();
    } else {
        return; // 사용자가 취소하면 아무 일도 일어나지 않음
    }
}

