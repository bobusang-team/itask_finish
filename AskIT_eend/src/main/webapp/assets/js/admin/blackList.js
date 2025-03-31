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

// 취소 폼 전송
function submitDeleteForm() {
    const form = document.getElementById('deleteForm');
    const selectedUsers = document.querySelectorAll('.item-checkbox:checked');
    
    if (selectedUsers.length === 0) {
        alert("취소할 대상을 선택해주세요.");
        return;
    }

    // 선택된 사용자 아이디들을 input hidden으로 추가
    let userIdsInput = document.getElementById("blackListNum");
    
    // 선택된 users로부터 blackListNum 값 가져오기
    let selectedUserIds = Array.from(selectedUsers).map(user => {
        // closest로 가장 가까운 .memColumn 찾고, 그 안의 .blackListNum value 추출
        let blackListNum = user.closest('.memColumn').querySelector('.blackListNum').value;
        return blackListNum; // 해당 ID를 반환
    });

    userIdsInput.value = selectedUserIds.join(","); // 값들 ,로 구분하여 input에 설정
    
    console.log("선택된 사용자 ID들:", userIdsInput.value);  // 디버깅: 어떤 값들이 선택되었는지 확인

    const confirmDelete = confirm("선택한 사용자를 취소하시겠습니까?");
    if (confirmDelete) {
        form.submit();  // 확인 후 폼 전송
    } else {
        return;
    }
}

// 변경 폼 전송
function submitUpdateBlackForm() {
	const form = document.getElementById('submitUpdateBlackForm');
    const selectedUser = document.querySelectorAll('.item-checkbox:checked');
    if (selectedUser.length === 0) {
        alert("변경할 대상을 선택해주세요.");
        return;
    }
	
	if (selectedUser.length !== 1) {
	       alert("한명의 회원만 선택해주세요");
	       return;
	   }

    // 선택된 사용자 아이디들을 input hidden으로 추가
	const userId = selectedUser[0].closest('.memColumn').querySelector('.userId').innerText;
	
    // 아이디가 잘 선택되었는지 확인
    console.log(userId);
	
	document.getElementById('blackListIds').value = userId;
    // 기간 입력
    var period = prompt("변경할 블랙리스트 기간(일)을 입력해주세요:");
    console.log('period:', period);  // 기간 값 확인
    if (period != null && !isNaN(period)) {
        document.getElementById("blacklistPeriod").value = period;
        console.log('blacklistPeriod value:', document.getElementById("blacklistPeriod").value);  // 기간 값 확인
        form.submit();
    } else {
        alert("유효한 숫자를 입력해주세요.");
    }
}