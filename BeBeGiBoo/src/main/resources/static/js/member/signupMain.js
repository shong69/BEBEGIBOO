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



/*
document.getElementById('submitBtn').addEventListener('click', e => {

    e.preventDefault(); 

    if ( !(donatorCheckbox.checked || acceptorCheckbox.checked)){
  
        alert('기부자 또는 피기부자 중 최소 한 가지를 선택해야 합니다.');
        return; 
    } 

    let authorityValue = donatorCheckbox.checked ? 1 : 2;

    fetch('/member/signup/signupMain', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ authority: authorityValue })
    })
    .then(resp => {
        if (resp.ok) {
            return resp.text();
        } else {
            throw new Error('서버 오류');
        }
    })
    .then(data => {
        // 리다이렉트
        window.location.href = "/member/signup/signupTerm?authority=" + authorityValue;
    })
    .catch(error => {
        console.error('에러:', error);
        alert('서버 오류가 발생했습니다.');
    });
    



});   */


document.getElementById('submitBtn').addEventListener('click', e => {
    e.preventDefault();

    let authorityValue;
    const donatorCheckbox = document.getElementById('donator');
    const acceptorCheckbox = document.getElementById('acceptor');

    if (donatorCheckbox.checked) {
        authorityValue = 1;
    } else if (acceptorCheckbox.checked) {
        authorityValue = 2;
    } else {
        alert('기부자 또는 피기부자 중 최소 한 가지를 선택해야 합니다.');
        return;
    }

    fetch('/member/signup/signMain', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({ authority: authorityValue })
    })
    .then(resp => resp.text())
    .then(result => {

        if(result === "1") {
            location.href = "/member/signup/signupTerm?authority=1";  
        } else if(result === "2") {
            location.href = "member/signup/signupTerm?authority=2"; 
        } else {
            console.log("result"); 
        }
    })
    .catch(error => {
        console.error('Error:', error);
    });
});