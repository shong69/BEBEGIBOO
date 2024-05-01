/* 회원 가입 유효성 검사 */


const checkObj = {
    "authority" : false,
    "memberId" : false, 
    "memberPw" : false, 
    "memberPwConfirm" : false, 
    "memberName" : false, 
    "memberBirth" : false, 
    "phone" : false, 
    "email" : false, 
    "authKey" : false,
    "authKey" : false,
    "address" : false
}; 


/* 아이디 유효성 검사 */

const memberId = document.querySelector("#memberId"); 
const idMessage = document.querySelector("#idMessage"); 

// 입력하지 않은 경우 
memberId.addEventListener("input", (e) => {

    if(memberId.value.length === 0) {
    if(memberId.value.length === 0) {
        idMessage.innerText = "아이디를 입력해주세요"
        idMessage.classList.add("error"); 
        idMessage.classList.remove("confirm"); 
        checkObj.memberId = false; 
        return; 
    }

    // 아이디 정규식 : 영어, 숫자, 특수문자(-,_) 6~10글자 이내
    const regExp = /^[a-zA-Z0-9_-]{6,10}$/; 

    // 유효하지 않은 경우 
    if( !regExp.test(memberId.value) ) {
        idMessage.innerText = "영어, 숫자, 특수문자(-,_) 6~10글자 이내로 작성해주세요."
        idMessage.classList.add("error"); 
        idMessage.classList.remove("confirm"); 
        checkObj.memberId = false;
        return; 
    }

    const inputId = e.target.value;   
    console.log(inputId); 

    // 유효한 경우 중복 검사 
    fetch("/member/checkId?memberId=" + inputId)
    .then(resp => resp.text())
    .then(result => {
    const inputId = e.target.value;   
    console.log(inputId); 

    // 유효한 경우 중복 검사 
    fetch("/member/checkId?memberId=" + inputId)
    .then(resp => resp.text())
    .then(result => {

    if(result == 1) {
        idMessage.innerText = "이미 사용중인 아이디입니다."; 
        idMessage.classList.add("error"); 
        idMessage.classList.remove("confirm"); 
        checkObj.memberId = false; 
        return; 
    }
    if(result == 1) {
        idMessage.innerText = "이미 사용중인 아이디입니다."; 
        idMessage.classList.add("error"); 
        idMessage.classList.remove("confirm"); 
        checkObj.memberId = false; 
        return; 
    }

    idMessage.innerText = "사용 가능한 아이디입니다~!!"; 
    idMessage.classList.add("confirm"); 
    idMessage.classList.remove("error"); 
    checkObj.memberId = true; 

    }); 
    idMessage.innerText = "사용 가능한 아이디입니다~!!"; 
    idMessage.classList.add("confirm"); 
    idMessage.classList.remove("error"); 
    checkObj.memberId = true; 

    }); 



}); 




/* 비밀번호 유효성 검사 */

const memberPw = document.querySelector("#memberPw"); 
const memberPwConfirm = document.querySelector("#memberPwConfirm"); 
const pwMessage = document.querySelector("#pwMessage"); 

// 비밀번호, 비밀번호 확인이 같은지 검사
const checkPw = () => {

    // 같은 경우 
    if(memberPw.value === memberPwConfirm.value) {
        pwMessage.innerText = "비밀번호가 일치합니다."; 
        pwMessage.classList.add("confirm"); 
        pwMessage.classList.remove("error"); 
        checkObj.memberPwConfirm = true; 
        return; 
    }
    // 같지 않은 경우 
    pwMessage.innerText = "비밀번호가 일치하지 않습니다"; 
    pwMessage.classList.add('error'); 
    pwMessage.classList.remove('confirm');
    checkObj.memberPwConfirm = false; 
}

// 비밀번호 유효성 검사 
memberPw.addEventListener("input", e => {

    const inputPw = e.target.value; 

    if(inputPw.trim().length === 0) {
        pwMessage.innerText = "영어, 숫자, 특수문자(-,_)8~12글자 이내로 입력해주세요."; 
        pwMessage.classList.remove('confirm', 'error'); 
        checkObj.memberPw = false; 
        memberPw.value = ""; 
        return; 
    }

    // 비밀번호 정규식 
    const regExp = /^[a-zA-Z0-9_-]{8,12}$/; 

    // 유효하지 않은 경우 
    if( !regExp.test(inputPw) ) {
        pwMessage.innerText = "비밀번호가 유효하지 않습니다"; 
        pwMessage.classList.add('error'); 
        pwMessage.classList.remove('confirm'); 
        checkObj.memberPw = false; 
        return; 
    }

    // 유효한 경우 
    pwMessage.innerText = "유효한 비밀번호입니다"; 
    pwMessage.classList.add('confirm'); 
    pwMessage.classList.remove('error'); 
    checkObj.memberPw = true; 

    // 비밀번호 확인란에 작성되어있다면 비밀번호 입력란 값과 비교 
    if(memberPwConfirm.value.length > 0) {
        checkPw(); 
    }

}); 

// 비밀번호 확인 유효성 검사 
memberPwConfirm.addEventListener("input", () => {
    
    // 비밀번호가 유효한 경우 
    if(checkObj.memberPw) {
        checkPw(); // 비교 
        return; 
    }

    checkObj.memberPwConfirm = false; 
}); 


/* 이름 유효성 검사 */
const memberName = document.querySelector("#memberName"); 
const nameMessage = document.querySelector("#nameMessage"); 

memberName.addEventListener("input", e => {

    const inputName = e.target.value; 

    // 입력되지 않은 경우 
    if(inputName.trim().length === 0) {
        nameMessage.innerText = "한글, 영어로만 입력해주세요"; 
        nameMessage.classList.remove('confirm', 'error'); 
        checkObj.memberName = false; 
        memberName.value = ""; 
        return; 
    }

    // 이름 정규식
    const regExp = /^[가-힣a-zA-Z]{1,15}$/; 
    
    // 유효하지 않은 경우 
    if( !regExp.test(inputName) ) {
        nameMessage.innerText = "이름이 유효하지 않습니다"; 
        nameMessage.classList.add('error'); 
        nameMessage.classList.remove('confirm'); 
        checkObj.memberName = false; 
        return; 
    }

    // 유효한 경우 
    nameMessage.innerText = ""; 
    nameMessage.classList.add('confirm'); 
    nameMessage.classList.remove('error'); 
    checkObj.memberName = true; 
    
}); 


/* 생년월일 유효성 검사 */
const memberBirth = document.querySelector("#memberBirth"); 
const birthMessage = document.querySelector("#birthMessage"); 

memberBirth.addEventListener("input", e => {

    const inputBirth = e.target.value; 

     // 입력되지 않은 경우 
     if(inputBirth.trim().length === 0) {
        birthMessage.innerText = "생년월일 8자리 '-' 없이 입력해주세요"; 
        birthMessage.classList.remove('confirm', 'error'); 
        checkObj.memberBirth = false; 
        memberBirth.value = ""; 
        return; 
    }

    // 생일 정규식
    const regExp = /^\d{8}$/; 
    
    // 유효하지 않은 경우 
    if( !regExp.test(inputBirth) ) {
        birthMessage.innerText = "생년월일 8자리 '-' 없이 입력해주세요"; 
        birthMessage.classList.add('error'); 
        birthMessage.classList.remove('confirm'); 
        checkObj.memberBirth = false; 
        return; 
    }

    // 유효한 경우 
    birthMessage.innerText = ""; 
    birthMessage.classList.add('confirm'); 
    birthMessage.classList.remove('error'); 
    checkObj.memberBirth = true; 


}); 


/* 핸드폰 번호 유효성 검사 */
const phone = document.querySelector("#phone"); 
const phoneMessage = document.querySelector("#phoneMessage"); 

phone.addEventListener("input", e => {

    const inputPhone = e.target.value; 

     // 입력되지 않은 경우 
     if(inputPhone.trim().length === 0) {
        phoneMessage.innerText = "핸드폰번호 '-'포함해서 입력해주세요"; 
        phoneMessage.classList.remove('confirm', 'error'); 
        checkObj.phone = false; 
        phone.value = ""; 
        return; 
    }

    // 핸드폰번호 정규식
    const regExp = /^(010|011|016|017|018|019)-\d{3,4}-\d{4}$/; 
    
    // 유효하지 않은 경우 
    if( !regExp.test(inputPhone) ) {
        phoneMessage.innerText = "핸드폰번호 '-'포함해서 입력해주세요"; 
        phoneMessage.classList.add('error'); 
        phoneMessage.classList.remove('confirm'); 
        checkObj.phone = false; 
        return; 
    }

    // 유효한 경우 
    phoneMessage.innerText = ""; 
    phoneMessage.classList.add('confirm'); 
    phoneMessage.classList.remove('error'); 
    checkObj.phone = true; 

}); 


/* 이메일 인증 유효성 검사 */
const email = document.querySelector("#email");
const emailMessage = document.querySelector("#emailMessage");

email.addEventListener("input", e => {

    // 이메일 인증 후 이메일이 변경된 경우 
    checkObj.authKey = false;
    document.querySelector("#authKeyMessage").innerText = "";  

    // 작성된 이메일 
    const inputEmail = e.target.value;

    if(inputEmail.trim().length === 0) {
        emailMessage.innerText = "메일을 받을 수 있는 이메일을 입력해주세요"; 
        emailMessage.classList.remove('confirm', 'error'); 
        checkObj.email = false;
        // 띄어쓰기가 있을 경우 없애줌  
        email.value = ""; 
        return; 
    }

    // 이메일 정규 표현식 
    const regExp = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    // 정규식과 일치하지 않을 경우 
    if( !regExp.test(inputEmail)){
        emailMessage.innerText = "알맞은 이메일 형식으로 작성해주세요";
        emailMessage.classList.add('error'); 
        emailMessage.classList.remove('confirm'); 
        checkObj.email = false;
        return;
    }

    // 유효한 경우 중복검사 수행 
    fetch("/member/checkEmail?email=" + inputEmail)
    .then( resp => resp.text() )
    .then( count => {

        if(count == 1 ){ 
            emailMessage.innerText = "이미 사용중인 이메일 입니다.";
            emailMessage.classList.add('error');
            emailMessage.classList.remove('confirm');
            checkObj.email = false; 
            return;
        }   

        // 중복 x 경우
        emailMessage.innerText = "사용 가능한 이메일 입니다";
        emailMessage.classList.add('confirm');
        emailMessage.classList.remove('error');
        checkObj.email = true;
    })
    .catch(error => {       
        console.log(error); 
    }); 


}); 


/* 이메일 인증 보내기 */
const sendEmailBtn = document.querySelector("#sendEmailBtn"); 
const authKey = document.querySelector("#authKey"); 
const checkAuthKeyBtn = document.querySelector("#checkAuthKeyBtn");
const authKeyMessage = document.querySelector("#authKeyMessage"); 

let authTimer; // 타이머 역할, setInterval을 저장할 변수 
const initMin = 4; // 타이머 초기값 (분)
const initSec = 59; // 타이머 초기값 (초)
const initTime = "05:00"; 

// 실제 줄어드는 시간 저장 변수
let min = initMin;
let sec = initSec;

// 인증메일 버튼 클릭시 
sendEmailBtn.addEventListener("click", () => {

    checkObj.authKey = false; 
    authKeyMessage.innerText = ""; 

    if(!checkObj.email) {
        emailMessage.innerText = "유효한 이메일이 아닙니다"; 
        return; 
    }

    // 숫자 초기화 
    min = initMin;
    sec = initSec;
    
    clearInterval(authTimer); 

    // 메일 보내기 
    fetch("email/signup", {
        method : "POST", 
        headers : {"Content-Type" : "application/json"},
        body : email.value
    })
    .then( resp => resp.text() )
    .then( result => {
        if(result == 1) {
            emailMessage.innerText("인증 번호 발송 성공"); 
        } else {
            emailMessage.innerText("인증 번호 발송 실패"); 
        }
    }); 

    // 타이머 시작 
    authKeyMessage.innerText = initTime; 
    authKeyMessage.classList.remove('confirm', 'error'); 

    alert("인증번호가 발송되었습니다"); 

    authTimer = setInterval( ()=> {

        authKeyMessage.innerText = `${addZero(min)}:${addZero(sec)}`;

        if(min == 0 && sec == 0) {
            checkObj.authKey = false; 
            clearInterval(authTimer); 
            authKeyMessage.classList.add('error'); 
            authKeyMessage.classList.remove('confirm'); 
            return; 
        }

        if(sec == 0) {
            sec = 60; 
            min--; 
        }
        sec--; 

    }, 1000); 

}); 

function addZero(number){
    if(number < 10) return "0" + number;
    else            return number;
}

/* 인증번호 확인 버튼 클릭시 */
checkAuthKeyBtn.addEventListener("click", () => {
    if( min === 0 && sec === 0) { // 타이머가 00:00인 경우
        alert("인증번호 입력 제한시간을 초과하였습니다!");
        return;
    }

    if(authKey.value.length < 6 ) { 
        alert("인증번호를 정확히 입력해 주세요");
        return;
    }

    // 입력받은 이메일, 인증번호로 객체 생성
    const obj = {
        "email" : memberEmail.value,
        "authKey" : authKey.value
    };

    fetch("/email/checkAuthKey",{
        method : "POST",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    })
    .then(resp => resp.text())
    .then(result => {
        if(result == 0 ){
            alert("인증번호가 일치하지 않습니다!");
            checkObj.authKey = false;
            return;
        }
        clearInterval(authTimer); 

        authKeyMessage.innerText = "인증 되었습니다.";
        authKeyMessage.classList.remove("error");
        authKeyMessage.classList.add("confirm");

        checkObj.authKey = true; 
     })
});


























