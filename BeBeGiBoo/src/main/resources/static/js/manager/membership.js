const tbody = document.getElementById("membershipBoard");
const popup = document.querySelector(".popup-layer");

function selectMember() {
    tbody.innerHTML = "";
    
    fetch("/manager/selectMemberList")
    .then(resp => resp.text())
    .then(result => {

        const memberList = JSON.parse(result);
        

        if(memberList == null) {
            memberList.innerText = "회원이 존재하지 않습니다.";
        } else {
            memberList.forEach( (member) => {
                let arr = [member.memberNo,
                            member.memberId,
                            member.memberName,
                            member.enrollDate];

                const tr = document.createElement("tr");
                for(let key of arr){
                    const td = document.createElement("td");
                    td.innerText = key;
                    tr.append(td);
                    tr.classList.add("text");
                }
                const buttonTd = document.createElement("td");
                const button = document.createElement("button");
                button.innerText = "수정";
                button.classList.add("managerButton");
                tr.append(buttonTd);
                buttonTd.append(button);
                tbody.append(tr);

                button.addEventListener("click", () => {

                    const name = document.querySelector("#name");
                    const email = document.querySelector("#email");
                    const phone = document.querySelector("#phone");
                    const address = document.querySelector("#address");
                    const del = document.querySelector("#del");
                    const authority = document.querySelector("#authority");

                    popup.style.display = 'flex';

                    name.value = member.memberName;
                    email.value = member.email;
                    phone.value = member.phone;
                    address.value = member.address;
                    del.value = member.memberDelFl;
                    authority.value = member.authority;

                });
            });
        }
    });
    
};


selectMember();


const popupClose = document.querySelector(".popup-close");

popupClose.addEventListener("click", () => {

    if(confirm("취소하시겠습니까?")) {
        popup.style.display = 'none';
    }
});


const updateButton = document.querySelector("#updateButton");

updateButton.addEventListener("click", () => {



});



