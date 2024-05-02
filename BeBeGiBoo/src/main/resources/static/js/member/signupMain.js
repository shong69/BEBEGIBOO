/* *************MAIN************** */

/* 체크박스 하나만 선택하기 */

const checkboxes = document.querySelectorAll('.selectOne');

checkboxes.forEach(checkbox => {
    checkbox.addEventListener('change', function() {
        checkboxes.forEach(cb => {
            if (cb !== this) {
                cb.checked = false;
            }
        });
    });
}); 


/* 제출하기 버튼 클릭시 이동 */ 
const submitBtn = document.getElementById('submitBtn');
const donatorCheckbox = document.getElementById('donator');
const acceptorCheckbox = document.getElementById('acceptor');



document.getElementById('submitBtn').addEventListener('click', e => {

    e.preventDefault(); 

    let authorityValue;

    if (donatorCheckbox.checked) {
        authorityValue = 1;
    } else if (acceptorCheckbox.checked) {
        authorityValue = 2;
    }

    console.log("선택된 authority 값:", authorityValue);

    if (authorityValue) {

        const authority = {
            authority : authorityValue
        }; 

        fetch("/member/signup/signupForm",{
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(authority)
        })
        .then(resp => resp.text())
        .then( result => {

            console.log(result);    
            location.href = "/member/signup/signupTerm";
        });
    } else {
        alert('기부자 또는 피기부자 중 최소 한 가지를 선택해야 합니다.');
    }
});