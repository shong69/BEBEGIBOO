const insertBtn = document.querySelector("#insertBtn");

if(insertBtn != null){
    insertBtn.addEventListener("click", ()=>{
        location.href = `/review/insert`;
    });
}