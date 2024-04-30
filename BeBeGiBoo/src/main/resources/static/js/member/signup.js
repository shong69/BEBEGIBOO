/* 회원 가입 유효성 검사 */


const checkObj = {
    "memberId" : false, 
    "memberPw" : false, 
    "memberPwConfirm" : false, 
    "memberName" : false, 
    "memberBirth" : false, 
    "phone" : false, 
    "email" : false, 
    "address" : false
}; 


/* 아이디 유효성 검사 */

const memberId = document.querySelector("#memberId"); 
const idMessage = document.querySelector("#idMessage"); 

// 입력하지 않은 경우 
memberId.addEventListener("input", (e) => {

    if(memberId.ariaValueMax.length === 0) {
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

    // 유효한 경우 
    idMessage.innerText = "사용 가능한 아이디입니다~!!"
    idMessage.classList.add("confirm"); 
    idMessage.classList.remove("error"); 
    checkObj.memberId = true; 

    const inputId = e.target.value; 
    
    // 중복 검사 
    fetch("/member/checkId?memberId=" + inputId )
    .then( resp => resp.text() )
    .then( result => {

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

}); 


