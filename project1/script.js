// html 태그와 연결
const wrapperBox = document.getElementById("wrapper");
const inputFieldGroup = document.getElementsByClassName("inputGroup");
const allInputs = document.querySelector("input");
const userNickname = document.getElementById("nickname");
const userEmail = document.getElementById("email");
const userPassword = document.getElementById("password");
const confirmPassword = document.getElementById("confirmPassword");
const userPhone = document.getElementById("phone");
const registrationForm = document.getElementById("registrationForm");

const updateHelperText = (input, message, isValid)=>{
    const inputGroup = input.parentElement; // input 태그의 부모 태그에 접근

    // heperText(알림)
    const helperText = inputGroup.getElementsByClassName("helperText")[0];
    
    // 유효한 경우 알림 안뜨게
    if(isValid){
        inputGroup.classList.remove("invalid");
        inputGroup.classList.add("valid");
        helperText.style.visibility = "hidden";
    }else {
        inputGroup.classList.remove("valid");
        inputGroup.classList.add("invalid");
        helperText.style.visibility = "visible";
        helperText.innerText = message;
    }
};

// 닉네임 유효성 검사(비어있는지 확인)
const checkEmptyInput = (input) => {
    //trim: 인풋 입력칸에 입력한 문자열 중 띄어쓰기를 없애는 기능
    // === 3개는 값의 타입까지 엄격하게 비교
    if(input.value.trim() === ''){
        updateHelperText(input,'값을 입력해주세요.',false);
        return false;
    }
    else {
        //입력이 있으면 도움말을 지움
        updateHelperText(input, "", true);
        return true;
    }
}

// 이메일 유효성 검사(형식이 올바른지)
const validateEmailFormat = (input) =>{
    // 이메일 정규식
    const emailPattern = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
    if(emailPattern.test(input.value)){
        updateHelperText(input, "", true);
        return true;
    } else {
        updateHelperText(input, "유효한 이메일 주소를 입력하세요.", false);
        return false;
    }
}

// 비밀번호 유효성 검사
const checkPasswordStrength = (input)=>{
    const strongPattern = /^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,16}$/;
    
    // 그냥 input값을 넘겨줄 경우 html형식. .value 해줘야함
    if(strongPattern.test(input.value)){
        updateHelperText(input, "", true);
        return true;
    } else {
        updateHelperText(input, "비밀번호는 8자 이상이어야하며, 대문자, 소문자, 특수문자를 포함하여야 합니다.", false);
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

// 전화번호 유효성 검사
const validatePhoneNumber = (input) => {
    const phonePattern = /^(01[016789]{1})-?[0-9]{3,4}-?[0-9]{4}$/;

    if(phonePattern.test(input.value.trim())){
        updateHelperText(input, "", true);
        return true;
    } else {
        updateHelperText(input, "유효한 전화번호를 입력해주세요.(예: 010-1234-1234)", false);
        return false;
    }
}

// 전체 유효성 체크 함수
const validForm = () => {
    const isNicknameValid = checkEmptyInput(userNickname); // 맞으면 true, 틀리면 false
    const isEmailValid = validateEmailFormat(userEmail);
    const isPasswordStrong = checkPasswordStrength(userPassword);
    const isPasswordMatch = validatePasswordMatch(userPassword, confirmPassword); // 두 비밀번호를 비교
    const isPhoneValid = validatePhoneNumber(userPhone);

    // 모든 검사에서 통과하는지 검사
    return isNicknameValid && isEmailValid && isPasswordStrong && isPasswordMatch && isPhoneValid;
}

// submit이라는 이벤트가 들어왔을 때 유효한지 콘솔에서 확인
registrationForm.addEventListener('submit',(event)=>{
    // event: submit하면 실행되는 기능
    // submit누르면 기본 동작: 새로고침 -> 이걸 막아주는 것이 preventDefault
    event.preventDefault();

    if(validForm()){
        console.log("모든 필드가 유효합니다.");
    } else {
        console.log("유효성 검사 실패");
    }
    console.log(event);
})

// 각 input을 입력할 때 유효성에 따라 동시에 테두리 색깔이나 일림이 뜨게 설정
document.querySelectorAll("input").forEach(input =>{
    input.addEventListener("input",() =>{
        switch(input.id){
            case 'nickname':
                checkEmptyInput(input);
                break;
            case 'email':
                validateEmailFormat(input);
                break;
            case 'password':
                checkPasswordStrength(userPassword);
                break;
            case 'confirmPassword':
                validatePasswordMatch(userPassword, confirmPassword);
                break;
            case 'phone':
                validatePhoneNumber(input);
                break;
        }
    })
})