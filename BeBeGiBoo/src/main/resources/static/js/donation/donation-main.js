const slides = document.querySelectorAll(".donation-container");
const donationBoxUp14 = document.querySelectorAll(".donation-box-up14");
const donationBoxUnder14 = document.querySelectorAll(".donation-box-under14");
const title = document.querySelector("#donation-title");
const things = document.getElementsByName("count-thing");
const thingsContent = document.getElementsByName("content-thing");
const thingsType = document.getElementsByName("thing-type");
const thingsValue = document.getElementsByName("count-thing-value");

const startButton = document.querySelector("button");


titleObjUnder14 = ["신청자 나이 선택",
            "14세 미만 법정대리인(보호자) 동의",
            "유아용품 종류 선택",
            "유아용품 이름 입력",
            "박스수량 선택",
            "배송정보 입력",
            "결제수단 선택"];

titleObjUp14 = ["신청자 나이 선택",
            "유아용품 종류 선택",
            "유아용품 이름 입력",
            "박스수량 선택",
            "배송정보 입력",
            "결제수단 선택"];

/* 나이선택칸 */
const under14 = document.querySelector("#option1");
const up14 = document.querySelector("#option2");

const parentsAgree = document.querySelector("#parentsAgree");





startButton.addEventListener("click", () => {
    slides[0].style.display = 'none';
    slides[1].style.display = 'flex';
});

const previousButton = document.querySelector("#previous");
const nextButton = document.querySelector("#next");
const submitButton = document.querySelector("#submit");

previousButton.addEventListener("click", ()=>{
    nextButton.style.display = 'flex';
    submitButton.style.display = 'none';

    if(document.querySelector("#option1").checked){
        for(let i = 0; i < donationBoxUnder14.length; i++){
            
            if(donationBoxUnder14[i].style.display != 'none'){
                donationBoxUnder14[i].style.display = 'none';
                donationBoxUnder14[i-1].style.display = 'flex';
                title.innerText = titleObjUnder14[i-1];
                break;
            }
        }
    } else if(document.querySelector("#option2").checked){
        for(let i = 0; i < donationBoxUp14.length; i++){
            
            if(donationBoxUp14[i].style.display != 'none'){
                donationBoxUp14[i].style.display = 'none';
                donationBoxUp14[i-1].style.display = 'flex';
                title.innerText = titleObjUp14[i-1];
                break;
            }
        }
    }
});




nextButton.addEventListener("click", e=>{


    /* 나이선택칸 */
    if(!document.querySelector("#option1").checked && !document.querySelector("#option2").checked) {
        alert("나이 유형을 선택해주세요");
        e.preventDefault();
    }

    /* 내용입력칸 */
    for(let i = 0; i < thingsType.length; i ++) {

        if(!thingsType[i].checked) {
            thingsContent[i].style.display = 'none';
        } else {
            thingsContent[i].style.display = 'block';
        }
    }

    /* 타입체크칸 */
    for(let i = 0; i < thingsType.length; i ++) {

        if(!thingsType[i].checked) {
            things[i].style.display = 'none';
        } else {
            things[i].style.display = 'block';
        }
    }


    /* 가격칸 */
    let countValue = 0;
    for(let i = 0; i < thingsValue.length; i ++) {
        let pay = parseInt(thingsValue[i].value) * 5000;
        countValue += pay;
    }

    const total = document.querySelector("#total");
    total.innerText = countValue;







    /* 페이지 넘어가기 */


    if(document.querySelector("#option1").checked){
        for(let i = 0; i < donationBoxUnder14.length; i++){
            
            if(donationBoxUnder14[i].style.display != 'none'){
                donationBoxUnder14[i].style.display = 'none';
                donationBoxUnder14[i+1].style.display = 'flex';
                title.innerText = titleObjUnder14[i+1];

                if(i == 5) {
                    nextButton.style.display = 'none';
                    submitButton.style.display = 'flex';
                }else {
                    nextButton.style.display = 'flex';
                    submitButton.style.display = 'none';
                }
                break;
            }
        }
    } else if(document.querySelector("#option2").checked){
        for(let i = 0; i < donationBoxUp14.length; i++){
            
            if(donationBoxUp14[i].style.display != 'none'){
                donationBoxUp14[i].style.display = 'none';
                donationBoxUp14[i+1].style.display = 'flex';
                title.innerText = titleObjUp14[i+1];

                if(i == 4) {
                    nextButton.style.display = 'none';
                    submitButton.style.display = 'flex';
                }else {
                    nextButton.style.display = 'flex';
                    submitButton.style.display = 'none';
                }
                break;
            }
        }
    }


});


/* 다음 주소 API 활용 */
function DaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById("mainAddress").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}

// 주소 검색 버튼 클릭 시
document.querySelector("#searchAddress").addEventListener("click", DaumPostcode);







submitButton.addEventListener("click", e => {
    var payment = document.querySelector("#payment");
    
    const obj = {
        "name" : document.querySelector("#name").value,
        "phone" : document.querySelector("#phone").value,
        "phone2" : document.querySelector("#phone2").value,
        "address" : document.querySelector("#postcode").value + " " + document.querySelector("#mainAddress").value + " " + document.querySelector("#detailAddress").value,
        "date" : document.querySelector("#date").value,
        "memo" : document.querySelector("#memo").value,
        "total" : document.querySelector("#total").innerText,
        "payment" :  payment.options[payment.selectedIndex].value
    }

    console.log(obj);
    
    fetch("/donation/complete", {
        method: "PUT",
        headers : {"Content-Type" : "application/json"},
        body : JSON.stringify(obj)
    })
    .then(resp => resp.text())
    .then(temp => {
        if(temp > 0) {
            alert("기부 신청이 완료되었습니다");
            
        } else {
            alert("기부 신청이 완료되지 않았습니다");
            e.preventDefault();
        }
    });
});
