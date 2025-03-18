/*선택한 카테고리가 선택되면 하위 태그네임에 required 속성이 적용되는 부분*/
document.addEventListener("DOMContentLoaded", function () {
    const qualRadio = document.getElementById("qual"); // '자격증' 버튼
    const devRadio = document.getElementById("dev"); // '개발' 버튼
    const secRadio = document.getElementById("sec"); // '보안' 버튼
    const formGroup = document.querySelector(".form-group"); // 파일 업로드 div

    const tagDevInputs = document.querySelectorAll(".tagDev input");
    const tagSecInputs = document.querySelectorAll(".tagSec input");
    const tagQualInputs = document.querySelectorAll(".tagQual input");

    //특정 그룹의 required 속성을 추가/제거하는 함수
    function toggleRequired(inputs, shouldBeRequired) {
        inputs.forEach((input) => {
            if (shouldBeRequired) {
                input.setAttribute("required", "true");
            } else {
                input.removeAttribute("required");
            }
        });
    }

    //모든 태그 그룹의 required 초기화
    function resetRequired() {
        toggleRequired(tagDevInputs, false);
        toggleRequired(tagSecInputs, false);
        toggleRequired(tagQualInputs, false);
    }

    //'자격증' 버튼 클릭 시 파일 업로드 영역 표시 & 자격증 태그 required 설정
    qualRadio.addEventListener("change", function () {
        if (qualRadio.checked) {
            formGroup.style.display = "block"; // 파일 업로드 보이기
            resetRequired();
            toggleRequired(tagQualInputs, true); // 자격증 태그 required 추가
        }
    });

    //'개발' 버튼 클릭 시 개발 태그 required 추가
    devRadio.addEventListener("change", function () {
        if (devRadio.checked) {
            formGroup.style.display = "none"; // 파일 업로드 숨기기
            resetRequired();
            toggleRequired(tagDevInputs, true); // 개발 태그 required 추가
        }
    });

    //'보안' 버튼 클릭 시 보안 태그 required 추가
    secRadio.addEventListener("change", function () {
        if (secRadio.checked) {
            formGroup.style.display = "none"; // 파일 업로드 숨기기
            resetRequired();
            toggleRequired(tagSecInputs, true); // 보안 태그 required 추가
        }
    });

    //다른 카테고리를 선택하면 파일 업로드 숨김 처리 (기존 코드 유지)
    document.querySelectorAll("input[name='topCate']").forEach((radio) => {
        radio.addEventListener("change", function () {
            if (!qualRadio.checked) {
                formGroup.style.display = "none"; // 숨김 처리
            }
        });
    });
});



// 파일 유효성 검사 함수
function validateFile(fileName) {
  const allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
  return allowedExtensions.exec(attachedFileName);
}


let $fileInput = $('#file');
let $fileList = $('.file-list');
let $cnt = $('.cnt');
let cnt = 0;

console.log($fileInput);


// 첨부파일 미리보기 처리
$fileInput.on('change', function(){
   let files = this.files;
   console.log(files);
   
   //파일을 변경하면 원래 선택된 파일의 미리보기를 사라지게 처리
   $fileList.html('');

   //1개를 넘기면 초기화 처리, 파일 업로드 갯수 바꾸고 싶다면 숫자 바꾸면 된다
   //dt는 아래에서 설명
   if(files.length > 1){
      let dt = new DataTransfer();
      this.files= dt.files;
      console.log(files);
      alert("파일은 최대 1개까지만 첨부 가능합니다.")
      $cnt.text(files.length);
      return;
   }
   
   for(let i=0; i <files.length; i++){
      let src = URL.createObjectURL(files[i]);
      console.log(files[i].name);
      console.log('-------');
      $fileList.append(`<li>
         <div class="show-img-box">
            <img src=${src}>
         </div>
         <div class="btn-box">
            <button type='button' class='img-cancel-btn' data-name='${files[i].name}'>삭제</button>
         </div>
      </li>`);
   }
   
   $cnt.text(files.length);
   
   //첨부파일 삭제 버튼 처리 - 여긴 없음
   //클릭 이벤트가 페이지 로딩시 걸리는것이 아니라 이미지가 생성되면 걸려야하므로
   //미리보기 이미지를 생성하는 함수에서 작성한다.
   let $cancelBtns = $('.img-cancel-btn');
   console.log($cancelBtns);
   $cancelBtns.on('click', function() {
      //버튼의 부모의 부모를 삭제
      //console.log($(this).parent().parent())
      $(this).parent().parent().remove();
      
      //위 처리는 단순히 화면에서 미리보기를 지운것이고 input에 files 프로퍼티에는 
      //여전히 파일이 남아있다. 이렇게되면 서버로 해당파일이 전송된다.
      //console.log($fileInput);
      //console.log($fileInput[0].files);
      
      //그러므로 실제 데이터를 지우는 처리를 해준다.
      //jquery의 data()는 data- 속성 값을 가져온다.
      let fileName = $(this).data('name');
      
      let files = $fileInput[0].files;
      
      // files 프로퍼티에 저장할 files객체를 만들기 위해 DataTransfer를 사용한다.
      // files 프로퍼티의 타입은 FileList타입인데 이 파일리스트를 만들기 위한 
      //유일한 방법이 DataTransfer를 이용하는 것이다.
      let dt = new DataTransfer();
      
      for(let i=0; i<files.length; i++){
         if(files[i].name !== fileName){
            dt.items.add(files[i]);
         }
      }
      
      //우리가 만든 files를 실제 첨부파일로 저장한다.
      $fileInput[0].files = dt.files;
      console.log($fileInput[0].files);

      $cnt.text($fileInput[0].files.length);
   });   
});



// 파일 선택 이벤트
document.getElementById('file').addEventListener('change', function(event) {
    const fileInput = event.target;
    const fileList = fileInput.files;
    const fileCount = fileList.length;

    // 파일 개수 표시 업데이트
    const countElement = document.querySelector('.cnt');
    countElement.textContent = `${fileCount}/1`;

    // 파일 리스트 초기화
    const fileListContainer = document.querySelector('.file-list');
    fileListContainer.innerHTML = '';

    // 파일이 하나 이상 선택되었을 경우, 미리보기 생성
    if (fileCount > 0) {
        const file = fileList[0];
        const reader = new FileReader();

        // 파일 읽기 완료 시 미리보기 이미지 표시
        reader.onload = function(e) {
            const imgElement = document.createElement('img');
            imgElement.src = e.target.result;
            imgElement.alt = '미리보기 이미지';
            imgElement.classList.add('preview-img');

            // 미리보기 이미지를 리스트에 추가
            const li = document.createElement('li');
            li.appendChild(imgElement);

            // 삭제 버튼 추가
            const deleteButton = document.createElement('button');
            deleteButton.textContent = '삭제';
            deleteButton.classList.add('delete-btn');
            deleteButton.addEventListener('click', function() {
                fileListContainer.removeChild(li);
                fileInput.value = ''; // 파일 입력 초기화
                updateFileCount();
            });
            li.appendChild(deleteButton);

            fileListContainer.appendChild(li);
        };

        // 파일 읽기 시작
        reader.readAsDataURL(file);
    }

    // 파일 개수 업데이트 함수
    function updateFileCount() {
        const newFileCount = fileInput.files.length;
        countElement.textContent = `${newFileCount}/1`;
    }
});

// 파일 개수 제한 (최대 1개)
document.getElementById('file').addEventListener('change', function() {
    const fileInput = event.target;
    const fileList = fileInput.files;
    if (fileList.length > 1) {
        alert('최대 1개의 파일만 업로드 가능합니다.');
        fileInput.value = ''; // 두 번째 파일부터 제거
    }
});

//기존 이미지 업로드 부분
/*$(document).ready(function () {
    let $fileInput = $('#file'); // 파일 선택 input
    let $fileList = $('.file-list'); // 이미지 미리보기 리스트
    let $cnt = $('.cnt'); // 업로드 개수 표시
    
    // 파일 선택 이벤트
    $fileInput.on('change', function () {
        let files = this.files;

        // 파일 개수 제한 (1개)
        if (files.length > 1) {
            alert("파일은 최대 1개까지만 첨부 가능합니다.");
            resetFileInput($fileInput);
            return;
        }

        // 기존 이미지 제거 후 새 이미지 추가
        $fileList.html('');
        if (files.length > 0) {
            let src = URL.createObjectURL(files[0]);

            $fileList.append(`
                <li>
                    <div class="show-img-box">
                        <img src="${src}" alt="미리보기 이미지">
                    </div>
                    <div class="btn-box">
                        <button type="button" class="img-cancel-btn" data-name="${files[0].name}">삭제</button>
                    </div>
                </li>
            `);
        }

        // 파일 개수 업데이트
        $cnt.text(files.length + "1");

        // 삭제 버튼 이벤트 추가
        $('.img-cancel-btn').on('click', function () {
            resetFileInput($fileInput);
        });
    });

    // 파일 선택 초기화 함수
    function resetFileInput($input) {
        $input.val(''); // 파일 선택 초기화
        $fileList.html(''); // 미리보기 제거
        $cnt.text('0/1'); // 파일 개수 업데이트
    }
});*/

//새 업로드 부분
// 파일 선택 후 미리보기 및 업로드 갯수 표시
/*document.getElementById('file').addEventListener('change', function(event) {
    const fileInput = event.target;
    const fileList = fileInput.files;
    const fileCount = fileList.length;

    // '이미지 업로드(0/1)' 부분을 '이미지 업로드(1/1)'로 변경
    const countElement = document.querySelector('.cnt');
    countElement.textContent = fileCount;

    // 파일이 하나 이상 선택되었을 경우, 미리보기 생성
    const fileListContainer = document.querySelector('.file-list');
    fileListContainer.innerHTML = ''; // 기존 미리보기 내용 제거

    if (fileCount > 0) {
        const file = fileList[0]; // 첫 번째 파일만 미리보기
        const reader = new FileReader();

        // 파일 읽기 완료 시 미리보기 이미지 표시
        reader.onload = function(e) {
            const imgElement = document.createElement('img');
            imgElement.src = e.target.result;
            imgElement.alt = 'Uploaded Image';
            imgElement.classList.add('preview-img');

            // 미리보기 이미지를 리스트에 추가
            const li = document.createElement('li');
            li.appendChild(imgElement);
            fileListContainer.appendChild(li);
        };

        // 파일 읽기 시작
        reader.readAsDataURL(file);
    }
});

// 파일 업로드 시 제한: 최대 1개 이미지
document.getElementById('file').addEventListener('change', function(event) {
    const fileInput = event.target;
    const fileCount = fileInput.files.length;

    // 파일이 1개 이상일 경우, 두 번째 파일부터는 자동으로 선택되지 않게 처리
    if (fileCount > 1) {
        alert('최대 1개의 파일만 업로드 가능합니다.');
        fileInput.value = ''; // 파일 선택 초기화
        return;
    }
});*/



// 취소 버튼 처리 - 여긴 없음
/*$cancel = $('.cancel-btn');

$cancel.on('click', () => {
   window.location.href = '/board/boardListOk.bo';
});*/

