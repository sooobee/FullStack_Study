const wrapperBox = document.getElementById("wrapper");
// console.log(wrapperBox); html과 연결 확인
const inputFieldGroup = document.getElementsByClassName("inputGroup");
const allInputs = document.querySelector("input");
const userNickname = document.getElementById("nickname");
const userEmail = document.getElementById("email");
const userPassword = document.getElementById("userPassword");
const confirmPassword = document.getElementById("confirmPassword");
const userPhone = document.getElementById("phone");
const registrationForm = document.getElementById("registrationForm");

const updateHelperText = (input, message, isValid)=>{
    const inputGroup = input.parentElement;
    // input 태그의 부모 태그에 접근
    const helperText = inputGroup.getElementsByClassName("helperText")[0];
    // 알림 안뜨게
    if(isValid == true){
        inputGroup.classList.remove("invalid");
        inputGroup.classList.add("valid");
        helperText.style.visibility = "hidden";
    }
    // 알림보이게
    if(isValid == false){
        inputGroup.classList.remove("valid");
        inputGroup.classList.add("invalid");
        helperText.style.visibility = "visible";
        helperText.innerText = message;
    }
};




