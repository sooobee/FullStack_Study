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
    
    // 유효한 경우 알림 안뜨게
    if(isValid == true){
        inputGroup.classList.remove("invalid");
        inputGroup.classList.add("valid");
        helperText.style.visibility = "hidden";
    }
    // 유효하지 않은 경우 알림보이게
    if(isValid == false){
        inputGroup.classList.remove("valid");
        inputGroup.classList.add("invalid");
        helperText.style.visibility = "visible";
        helperText.innerText = message;
    }
};

// 입력 필드가 비어있는지 확인하는 함수
const checkEmptyInput = (input) => {
    //trim: 인풋 입력칸에 입력한 문자열 중 띄어쓰기를 없애는 기능
    if(input.value.trim() === ''){
        updateHelperText(input,'값을 입력해주세요.',false);
        return false;
    }
    else {
        //입력이 있으면 도움말을 지움
        updateHelperText(input, "", true);
    }
}

// 이메일 형식이 올바른지 확인하는 함수
// 이메일 주소가 규칙에 맞게 작성되었는지 확인
const validateEmailFormat = (input) =>{
    const emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    if(emailPattern.test(input.value.trim()) == true){
        updateHelperText(input, "", true);
        return true;
    } else {
        updateHelperText(input, "유효한 이메일 주소를 입력하세요.", false);
        return false;
    }
}

// 비밀번호 강도 설정
const checkPasswordStrength = (password)=>{
    const strongPattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
    
    // 정규식을 만족할 때
    if(strongPattern.test(password)){
        updateHelperText(password, "비밀번호 강도: 강함", true);
        return true;
    } else {
        updateHelperText(password, "비밀번호는 8자 이상이어야하며, 대문자, 소문자, 특수문자를 포함하여야 합니다.", false);
        return false;
    }
}

// 비밀번호 확인(동일한지)
const validatePasswordMatch = (passwordInput, confirmInput)=>{
    if(passwordInput.value !== confirmInput.value){
        updateHelperText(confirmInput, "비밀번호가 일치하지 않습니다.", false);
        return false;
    } else {
        updateHelperText(confirmInput, "",true);
        return true;
    }
}

// 전화번호가 올바른 형식인지 확인하는 함수
const validatePhoneNumber = (input) => {
    const phonePattern = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

    if(phonePattern.test(input.value.trim())){
        updateHelperText(input, "", false);
    } else {
        updateHelperText(input, "유효한 전화번호를 입력해주세요.(예: 010-1234-1234)", false);
        return false;
    }
}

