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

// 삭제 폼 전송
function submitDeleteForm() {
    const form = document.getElementById('deleteForm');
    const selectedUsers = document.querySelectorAll('.item-checkbox:checked');
    if (selectedUsers.length === 0) {
        alert("삭제할 대상을 선택해주세요.");
        return;
    }

    // 선택된 사용자 아이디들을 input hidden으로 추가
    let userIdsInput = document.getElementById("deleteUserIds");
    userIdsInput.value = Array.from(selectedUsers).map(user => 
        user.closest('.memColumn').querySelector('.userId').innerText
    ).join(",");

    const confirmDelete = confirm("선택한 사용자를 삭제하시겠습니까?");
    if (confirmDelete) {
        form.submit();
    } else {
        return; // 사용자가 취소하면 아무 일도 일어나지 않음
    }
}

// 블랙리스트 폼 전송
function submitBlacklistForm() {
    const form = document.getElementById('blacklistForm');
    const selectedUsers = document.querySelectorAll('.item-checkbox:checked');
    if (selectedUsers.length === 0) {
        alert("블랙리스트 추가할 대상을 선택해주세요.");
        return;
    }

    // 선택된 사용자 아이디와 이름 가져오기
    let userNick = Array.from(selectedUsers).map(user => 
        user.closest('.memColumn').querySelector('.userNick').innerText // 사용자 닉네임
    );
    let userId = Array.from(selectedUsers).map(user => 
        user.closest('.memColumn').querySelector('.userId').innerText // 사용자 아이디
    );

    const reason = prompt("블랙리스트 사유를 입력해주세요:");
    if (!reason) {
        alert("사유를 입력해야 합니다.");
        return;
    }

    const days = prompt("블랙리스트 기간(일)을 입력해주세요:");
    if (!days || isNaN(days) || days <= 0) {
        alert("올바른 기간을 입력해주세요.");
        return;
    }

    document.getElementById("blacklistReason").value = reason;
    document.getElementById("blacklistDays").value = days; 

    // 선택된 사용자 이름과 아이디를 input hidden으로 추가
    let userIdsInput = document.getElementById("blacklistUserIds"); 
    let userNamesInput = document.getElementById("blacklistUserNicks"); 

    userIdsInput.value = userId.join(",");
    userNamesInput.value = userNick.join(",");

    form.submit();
}

// 상세보기 폼 전송
function submitUserpageForm() {
    const form = document.getElementById('userpageForm');
    const selectedUser = document.querySelectorAll('.item-checkbox:checked');
    
    if (selectedUser.length === 0) {
        alert("상세하게 볼 회원을 선택해주세요.");
        return;
    }
    
    if (selectedUser.length !== 1) {
        alert("한명의 회원만 선택해주세요");
        return;
    }

    // 선택된 사용자 닉네임을 가져오기
    const userNick = selectedUser[0].closest('.memColumn').querySelector('.userNick').innerText;
	
    // 콘솔에 userNick 확인
    console.log(userNick);

    document.getElementById('userNick').value = userNick;
    
    // 콘솔에 값이 제대로 들어갔는지 확인
    console.log(document.getElementById('userNick').value);
    
    form.submit();
}


