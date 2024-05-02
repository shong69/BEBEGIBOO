const slides = document.querySelectorAll(".donation-container");
const donationBoxUp14 = document.querySelectorAll(".donation-box-up14");
const donationBoxUnder14 = document.querySelectorAll(".donation-box-under14");
const title = document.querySelector("#donation-title");
const things = document.getElementsByName("count-thing");
const thingsType = document.getElementsByName("thing-type");
const thingsValue = document.getElementsByName("count-thing-value");

const startButton = document.querySelector("button");


titleObjUnder14 = ["신청자 나이 선택",
            "14세 미만 법정대리인(보호자) 동의",
            "유아용품 종류 선택",
            "박스수량 선택",
            "배송정보 입력",
            "결제수단 선택"];

titleObjUp14 = ["신청자 나이 선택",
            "유아용품 종류 선택",
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

previousButton.addEventListener("click", ()=>{

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
    console.log(countValue);

    const total = document.querySelector("#total");
    total.innerText = countValue;







    /* 페이지 넘어가기 */


    if(document.querySelector("#option1").checked){
        for(let i = 0; i < donationBoxUnder14.length; i++){
            
            if(donationBoxUnder14[i].style.display != 'none'){
                donationBoxUnder14[i].style.display = 'none';
                donationBoxUnder14[i+1].style.display = 'flex';
                title.innerText = titleObjUnder14[i+1];
                break;
            }
        }
    } else if(document.querySelector("#option2").checked){
        for(let i = 0; i < donationBoxUp14.length; i++){
            
            if(donationBoxUp14[i].style.display != 'none'){
                donationBoxUp14[i].style.display = 'none';
                donationBoxUp14[i+1].style.display = 'flex';
                title.innerText = titleObjUp14[i+1];
                break;
            }
        }
    }
    
});
