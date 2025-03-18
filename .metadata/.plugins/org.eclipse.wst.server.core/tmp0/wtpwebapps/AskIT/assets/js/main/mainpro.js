// 문제 데이터
const quizInfo = [
{
infoQuestion: "번지(address)로 지정된 저장위치(storage location)의 내용이 실제 번지가 되는 주소지정번지는?",
infoChoice: ["간접지정방식", "완전지정방식", "절대지정방식", "상대지정방식"],
infoAnswer: "간접지정방식",
infoDesc: "번지의 번지가 실제 주소가 된다고 하니 2번 참조되는 것을 <br>의미 합니다. 즉시주소 지정방식 - 메모리 참조횟수 0<br>직접주소 지정방식 - 메모리 참조횟수 1<br>간접주소 지정방식 - 메모리 참조횟수 2<br>그러므로 간접주소 지정방식."
},
{
infoQuestion: "다음 중 프로그래밍 언어가 아닌 것은?",
infoChoice: ["1. Java", "2. Python", "3. HTML", "4. C++"],
infoAnswer: "3. HTML",
infoDesc: "HTML은 마크업 언어이며 프로그래밍 언어가 아닙니다."
},
{
infoQuestion: "JK플립플롭(flip flop)에서 보수가 출력되기 위한 J, K의 입력상태는??",
infoChoice: ["J=1, K=0", "J=0, K=1", "J=1, K=1", "J=0, K=0"],
infoAnswer: "J=1, K=1",
infoDesc: "J K<br>0 0 - 기존값유지<br>0 1 - 0<br>1 0 - 1<br>1 1 - 반전(=보수)"
},
{
infoQuestion: "2진수 (10001010)를 2의 보수로 옳게 표현한 것은?",
infoChoice: ["01110101", "01110110", "10001011", "10000110"],
infoAnswer: "01110110",
infoDesc: "10001010 을 1의 보수로 바꿉니다 : 0은 1로, 1은 0으로 변경하면됩니다. 01110101 로 바꿔 1보수에 +1을 해주면 2의 보수가 됩니다. 01110110 이 답입니다. 간단하게 바꾸는 방법은 문제의 2진수에서 오른쪽에서 부터 처음 1이 나올때까지는 그대로 적고 나머지는 반대로 바꾸면 됩니다."
},
{
infoQuestion: "다음이 설명하고 있는 데이터 입출력 방식은?<br>- 데이터의 입출력 전송이 CPU를 통하지 않고, 입출력 장치와 기억 장치 간에 직접 데이터를 주고받는다.<br>- CPU와 주변 장치간의 속도차를 줄일 수 있다.",
infoChoice: ["DCA", "DMA", "Multiplexer", "Channel"],
infoAnswer: "DMA",
infoDesc: "DMA(Direct Memory Access) : CPU 관여 없이 주기억장치와 보조기억장치(주변장치) 사이에 데이터를 전송하는 방식"
}
];

// 문제풀기 버튼 클릭 시 모달 열기 (랜덤 문제)
document.getElementById('check-answer-btn').addEventListener('click', function() {
    quizCount = Math.floor(Math.random() * quizInfo.length); // 랜덤 문제 선택
    updateQuiz(quizCount);
    quizModal.style.display = 'flex';
});

// 요소 선택
const quizModal = document.getElementById("quiz-modal");
const quizQuestion = document.querySelector(".main-pro-modal-question");
const quizChoices = document.querySelector(".main-pro-quiz-options");
const answerDropdown = document.getElementById("pro-answer-dropdown");
const checkAnswerBtn = document.getElementById("show-answer-btn");
const closeQuizModal = document.getElementById("close-quiz-modal");

// 문제 업데이트 함수
const updateQuiz = (index) => {
    const currentQuiz = quizInfo[index];

    quizQuestion.innerHTML = `Q. ${currentQuiz.infoQuestion}`;

    quizChoices.innerHTML = currentQuiz.infoChoice.map((choice, i) => `
        <label>
            <input type="radio" name="quiz-option" value="${choice}">
            ${choice}
        </label><br>
    `).join("");

    answerDropdown.style.display = "none";
};

// 정답 확인 버튼 클릭 시
checkAnswerBtn.addEventListener("click", () => {
    const selectedOption = document.querySelector("input[name='quiz-option']:checked");

    if (selectedOption) {
        const userAnswer = selectedOption.value;
        const correctAnswer = quizInfo[quizCount].infoAnswer;

        if (userAnswer === correctAnswer) {
            answerDropdown.innerHTML = `<strong>정답: ${correctAnswer}</strong>`;
        } else {
            answerDropdown.innerHTML = `<strong>오답입니다.</strong> 선택한 답: ${userAnswer}`;
        }

        answerDropdown.style.display = "block";
    } else {
        alert("정답을 선택해주세요!");
    }
});

// 모달 닫기 버튼 클릭 시 초기화
closeQuizModal.addEventListener("click", () => {
    quizModal.style.display = "none";
    quizChoices.innerHTML = "";
});