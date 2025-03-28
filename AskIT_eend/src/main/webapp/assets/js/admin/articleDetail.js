document.addEventListener("DOMContentLoaded", function () {
    const articleBotCate = document.getElementById("articleBotCate").value;
    const articleTagName = document.getElementById("articleTagName").value;

    console.log("articleBotCate:", articleBotCate);
    console.log("articleTagName:", articleTagName);

    // 하위 카테고리 버튼 자동 선택
    const categoryButtons = document.querySelectorAll('.category-btn');
    categoryButtons.forEach(button => {
        if (button.textContent.trim().toLowerCase() === articleBotCate.toLowerCase()) {
            button.classList.add("ask-select"); // 선택된 상태로 설정
            button.style.color = "#ffffff"; 
            button.style.backgroundColor = "#d96073";
        } else {
            button.classList.remove("ask-select");
            button.style.color = "#333333"; 
            button.style.backgroundColor = "#dddddd";
        }
    });

    // 태그 버튼 자동 선택
    const tags = document.querySelectorAll('.ask-tag-btn');
    tags.forEach(button => {
        if (button.textContent.trim().toLowerCase() === articleTagName.toLowerCase()) {
            button.classList.add("selected"); // 선택된 태그로 설정
            button.style.color = "#ffffff"; 
            button.style.backgroundColor = "#d96073";
        } else {
            button.classList.remove("selected");
            button.style.color = "#d96073"; 
            button.style.backgroundColor = "#ffffff";
        }
    });


  // 버튼 클릭 시 선택 상태 변경 (기존 기능 유지)
  categoryButtons.forEach(button => {
    button.addEventListener('click', function () {
      categoryButtons.forEach(btn => {
        btn.classList.remove("ask-select");
        btn.style.color = "#333333"; 
        btn.style.backgroundColor = "#dddddd";
      });

      button.classList.add("ask-select");
      button.style.color = "#ffffff"; 
      button.style.backgroundColor = "#d96073";
    });
  });

  tags.forEach(button => {
    button.addEventListener('click', function () {
      tags.forEach(btn => {
        btn.classList.remove("selected");
        btn.style.color = "#d96073"; 
        btn.style.backgroundColor = "#ffffff";
      });

      button.classList.add("selected");
      button.style.color = "#ffffff"; 
      button.style.backgroundColor = "#d96073";
    });
  });
  //수정
  document.getElementById('articleSave').addEventListener('click', function() {
	const form = document.getElementById('articleEdit');
	let botcate = document.querySelector('.ask-select')?.textContent || '';
	let tag = document.querySelector('.selected')?.textContent || '';
	let title = document.querySelector('.ask-text-title')?.value || '';
	let text = document.querySelector('.ask-text-textbody')?.value || '';
	console.log(botcate);
	console.log(tag);
	console.log(title);
	console.log(text);
	document.getElementById('updateBotcate').value = botcate;
	document.getElementById('updateTagName').value = tag;
	document.getElementById('updateTitle').value = title;
	document.getElementById('updateText').value = text;
  
	let checkConfirm = confirm('해당게시글을 수정하시겠습니까?');
	if(checkConfirm) {
			form.submit();
		}
		else {
			return;
		}
});
  
  //삭제
  document.getElementById('articleDelete').addEventListener('click', function() {
	const form = document.getElementById('deleteForm');
	let checkConfirm = confirm('해당게시글을 삭제하시겠습니까?');
	if(checkConfirm) {
		form.submit();
	}
	else {
		return;
	}
  });
  
  //댓글 삭제
  document.getElementById('commentDelete').addEventListener('click', function() {
	const form = document.getElementById('deleteCommentsForm');
	document.getElementById('commentNum').value = document.getElementById('commentNums').value; 
  	let checkConfirm = confirm('해당 댓글을 삭제하시겠습니까?');
  	if(checkConfirm) {
  		form.submit();
  	}
  	else {
  		return;
  	}
    });
	});
 
  
/*  function setBotCate(botcate) {
	document.getElementById('articleBotCate').value = botcate;
	console.log(botcate);
  }
  
  function setTag(tag) {
	document.getElementById('articleTagName').value = tag;
	console.log(tag);
  }*/
  

