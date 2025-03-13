//새로고침 방지//Dom 요소 연결
const screen = document.getElementById("screen");
// querySelector: 태그 하나만 가지고 와서 변수에 담음
// querySelectorAll: 해당 모든 태그를 리스트형식으로 가져옴
const buttons = document.querySelectorAll("button");

// 연산자 구별 정규식
const operatorRegex = /^(\d+|\*\*|[+\-*/])$/;
// 숫자 구별 정규식
const numberRegex = /[0-9]/g;

// input에 숫자, 연산자 추가 함수
function appendToScreen(value){
    screen.value += value;
}

// 화면 초기화 함수
function clearScreen(){
    screen.value = "";
}

// 연산 수행 함수
function calculate(operator,numbers){
    // numbers에 저장된 배열 데이터를 숫자화
    // num1, num2 차례로 저장
    const [num1,num2] = numbers.map(Number);
    
    switch(operator){
        case "+":
            return num1 + num2;
        case "-":
            return num1 - num2;
        case "*":
            return num1 * num2;
        case "/":
            return num2 !== 0 ? num1 / num2 : "Error";å
        default:
            return "";
    }
}

// 버튼 클릭시 동작 처리
function handleButtonClick(event){
    //새로고침 방지
    event.preventDefault();

    const buttonText = event.target.innerText;

    if(numberRegex.test(buttonText) == true){
        appendToScreen(buttonText);
    } else if(operatorRegex.test(buttonText) == true) {
        appendToScreen(buttonText);
    }
}

// 버튼 클릭 이벤트 리스너 등록 함수
function initializeButtonListeners(){
    buttons.forEach((button)=>{
        button.addEventListener("click",handleButtonClick);
    })
}

//"=" 버튼 클식 시 계산 결과 화면 표시
function handleResultClick(){
    const screenValue = screen.value;

    if(screenValue.includes("+")){
        //+ 일때 양쪽의 수를 num1, num2에 저장
        const [num1, num2] = screenValue.split("+");
        screen.value = calculate("+", [num1, num2]);
    } else if(screenValue.includes("-")){
        const [num1, num2] = screenValue.split("-");
        screen.value = calculate("-", [num1, num2]);
    }else if(screenValue.includes("*")){
        //+ 일때 양쪽의 수를 num1, num2에 저장
        const [num1, num2] = screenValue.split("*");
        screen.value = calculate("*", [num1, num2]);
    }else if(screenValue.includes("/")){
        //+ 일때 양쪽의 수를 num1, num2에 저장
        const [num1, num2] = screenValue.split("/");
        screen.value = calculate("/", [num1, num2]);
    }
}

// 초기화 버튼 클릭시 화면 초기화
document.getElementById("resetButton").addEventListener("click",clearScreen);

// = 버튼으로 계산 실행
document.getElementById("result").addEventListener("click", handleResultClick);

// 계산기 실행
initializeButtonListeners();