const tbody = document.getElementById("donationThingsBoard");
const donationThings = document.getElementById("donationThings");

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
                            ];

                const tr = document.createElement("tr");
                tr.classList.add("shadow");
                for(let key of arr){
                    const td = document.createElement("td");
                    td.innerText = key;
                    tr.append(td);
                    tr.classList.add("text");
                }
                const buttonTd = document.createElement("td");
                const button = document.createElement("button");
                button.innerText = "기부내역 보러가기>>";
                button.classList.add("managerButton");
                tr.append(buttonTd);
                buttonTd.append(button);
                tbody.append(tr);


                button.addEventListener("click", () => {

                    tbody.style.transform = "translateX(-400px)";
                    donationThings.style.transform = "translateX(-400px)";
                    donationThings.style.visibility = 'visible';
                    tr.style.backgroundColor = "rgb(208, 227, 241)";

                    fetch("/manager/selectDonationThings", {
                        method : "POST",
                        headers : {"Content-Type" : "application/json"},
                        body : JSON.stringify(member.memberNo)
                    })
                    .then(resp => resp.text())
                    .then(result => {
                        const donationThingsList = JSON.parse(result);

                        console.log(donationThingsList);

                        donationThingsList.forEach( (product) => {
                            if(product.acceptorNo == 0) {
                                product.acceptorNo = "피기부자 없음";
                            }

                            let arr = [product.recordNo,
                                product.recordDate,
                                product.acceptorNo];

                            console.log(product.recordNo, product.recordDate, product.acceptorNo);

                            const tr = document.createElement("tr");
                            tr.classList.add("shadow");
                            for(let key of arr){
                                const td = document.createElement("td");
                                td.innerText = key;
                                tr.append(td);
                                tr.classList.add("text");
                            }
                            donationThings.append(tr);
                        });
                    });

                });
            });
        }
    });
    
};


selectMember();


