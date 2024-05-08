/* 생년월일 유효성 검사 */

const memberBirth = document.querySelector("#memberBirth"); 
const formMessage = document.querySelector("#formMessage"); 

memberBirth.addEventListener("input", e => {

    const inputBirth = e.target.value; 

     // 입력되지 않은 경우 
     if(inputBirth.trim().length === 0) {
        formMessage.innerText = "생년월일 8자리 '-' 없이 입력해주세요"; 
        formMessage.classList.remove('confirm', 'error'); 
        memberBirth.value = ""; 
        return; 
    }

    // 생일 정규식
    const regExp = /^\d{8}$/; 
    
    // 유효하지 않은 경우 
    if( !regExp.test(inputBirth) ) {
        formMessage.innerText = "생년월일 8자리 '-' 없이 입력해주세요"; 
        formMessage.classList.add('error'); 
        formMessage.classList.remove('confirm'); 
        return; 
    }

    // 유효한 경우 
    formMessage.innerText = ""; 
    formMessage.classList.add('confirm'); 
    formMessage.classList.remove('error'); 


}); 



/* 핸드폰 번호 유효성 검사 */

const phone = document.querySelector("#phone"); 

phone.addEventListener("input", e => {

    const inputPhone = e.target.value; 

     // 입력되지 않은 경우 
     if(inputPhone.trim().length === 0) {
        formMessage.innerText = "핸드폰번호 '-'포함해서 입력해주세요"; 
        formMessage.classList.remove('confirm', 'error'); 
        phone.value = ""; 
        return; 
    }

    // 핸드폰번호 정규식
    const regExp = /^(010|011|016|017|018|019)-\d{3,4}-\d{4}$/; 
    
    // 유효하지 않은 경우 
    if( !regExp.test(inputPhone) ) {
        formMessage.innerText = "핸드폰번호 '-'포함해서 입력해주세요"; 
        formMessage.classList.add('error'); 
        formMessage.classList.remove('confirm'); 
        return; 
    }

    // 유효한 경우 
    formMessage.innerText = ""; 
    formMessage.classList.add('confirm'); 
    formMessage.classList.remove('error'); 

}); 




/* 다음 주소 API 활용 */

function DaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {

            var addr = ''; 

            if (data.userSelectedType === 'R') { 
                addr = data.roadAddress;
            } else { 
                addr = data.jibunAddress;
            }

   
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("mainAddress").value = addr;

            document.getElementById("detailAddress").focus();
        }
    }).open();
}

document.querySelector("#searchBtn").addEventListener("click", DaumPostcode);


/* 모달 */

const openBtn = document.getElementById('openBtn');
const openBtn2 = document.getElementById('openBtn2');
const closeBtn = document.getElementById('closeBtn');
const closeBtn2 = document.getElementById('closeBtn2');
const modal = document.getElementById('modal');

openBtn.addEventListener('click', () => {
  modal.classList.remove('hidden');
});
openBtn2.addEventListener('click', () => {
  modal.classList.remove('hidden');
});

closeBtn.addEventListener('click', () => {
  modal.classList.add('hidden');
});
closeBtn2.addEventListener('click', () => {
  modal.classList.add('hidden');
});



/* 제출하기 버튼 클릭시 */
/*
const certificationForm = document.querySelector("#certificationForm"); 

certificationForm.addEventListener("click", e=> {


}); */

