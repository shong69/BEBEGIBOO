const memberName = document.querySelector("#memberName");
const phoneNum = document.querySelector("#phoneNum");
const email =  document.querySelector("#email");

//라디오 버튼 클릭 시 input 영역 나타나도록

const phoneArea = document.querySelector("#phoneArea");
const emailArea = document.querySelector("#emailArea");

const IdCheckObj = {
    "memberPhone"   : false,
    "memberEmail"   : false
}



phoneNum.addEventListener("change", ()=>{
    if(phoneArea.style.display == "none"){
        phoneArea.style.display = "block";
        IdCheckObj.memberPhone=true;

    }
    if(emailArea.style.display == "block"){
        emailArea.value = "";
        emailArea.style.display = "none";
        IdCheckObj.memberEmail = false;

    }
    
});
email.addEventListener("change", ()=>{
    if(emailArea.style.display == "none"){
        emailArea.style.display = "block"
        IdCheckObj.memberEmail = true;

    }
    if(phoneArea.style.display == "block"){
        phoneArea.value = "";
        phoneArea.style.display = "none";
        IdCheckObj.memberPhone= false;
        
    }
});





//checked ==true면 유효성 검사 + Db 확인 + smtp 

//이메일 인증 -> 이메일로 아이디 보내주기 + alert(이메일로 회원 정보가 발송되었습니다)
//휴대폰 인증 -> alert(휴대폰으로 회원 정보가 발송되었습니다)
//이름, input 영역 값 넘기기POST -> 잘못 입력하면 alert하기 


const findBtn = document.querySelector("#findBtn");

findBtn.addEventListener("click", e=>{

    if(IdCheckObj.memberPhone){ //휴대폰에 체크한 경우
        
        //DB 확인 -> 비동기
        fetch("/inquiry/phoneInquiry?phoneNum="+phoneArea.value)
        .then(resp => resp.text())
        .then(result=>{
            if(result == 0){
                alert(); //휴대폰 번호 Db에 없는 경우
                return;
            }

        })
        .catch(err=>console.log(err));




    }else if(IdCheckObj.memberEmail){ //이메일에 체크한 경우
        console.log(emailArea.value);

        //db 확인
        fetch("/inquiry/emailInquiry?email="+emailArea)
        .then(resp => resp.text())
        .then(result =>{

            if(result == 0){
                alert(); //이메일 DB에 없는 경우
                return;
            }
                //이메일이 DB에 존재하는 경우  
            console.log("이메일 확인 성공"); 

        })
        .catch(err=> console.log(err));
        

        //smtp 하기 비동기
        fetch("/inquiry/sendEmail",{
            method: "POST",
            headers : {"Content-Type" : "application/json"},
            body : emailArea.value
        })
        .then(resp => resp.text())
        .then(resul =>{
            if(result == 1){
                alert(); //이메일로 아이디 보냈어요
            }
        });


    }else{
        alert("정보를 입력해 주세요");
        return;
    }

});