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