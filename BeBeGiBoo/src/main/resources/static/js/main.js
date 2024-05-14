


document.addEventListener("DOMContentLoaded", function () {
    const options = {
      root: null,
      rootMargin: "0px",
      threshold: 0.4
    };
  
    // IMAGE ANIMATION
  
    let revealCallback = (entries) => {
      entries.forEach((entry) => {
        let container = entry.target;
  
        if (entry.isIntersecting) {
          container.classList.add("animating");
          return;
        }
  
        if (entry.boundingClientRect.top > 0) {
          container.classList.remove("animating");
        }
      });
    };
  
    let revealObserver = new IntersectionObserver(revealCallback, options);
  
    document.querySelectorAll(".reveal").forEach((reveal) => {
      revealObserver.observe(reveal);
    });
  
    // TEXT ANIMATION
  
    let fadeupCallback = (entries) => {
      entries.forEach((entry) => {
        let container = entry.target;
        container.classList.add("not-fading-up");
  
        if (entry.isIntersecting) {
          container.classList.add("fading-up");
          return;
        }
  
        if (entry.boundingClientRect.top > 0) {
          container.classList.remove("fading-up");
        }
      });
    };
  
    let fadeupObserver = new IntersectionObserver(fadeupCallback, options);
  
    document.querySelectorAll(".fadeup").forEach((fadeup) => {
      fadeupObserver.observe(fadeup);
    });
  });
  




document.querySelector("#top-button").addEventListener("click", () => {

    window.scrollTo({top:0, behavior: 'smooth'});
});


const container1 = document.querySelector("#container1");
const container2 = document.querySelector("#container2");
const container3 = document.querySelector("#container3");
const container4 = document.querySelector("#container4");


container1.addEventListener("click", () => {

    window.scrollTo({top:3900, behavior: 'smooth'});
});

container2.addEventListener("click", () => {

    window.scrollTo({top:4400, behavior: 'smooth'});
});

container3.addEventListener("click", () => {

    window.scrollTo({top:4900, behavior: 'smooth'});
});

container4.addEventListener("click", () => {

    window.scrollTo({top:5500, behavior: 'smooth'});
});



const showBox = document.querySelectorAll(".showBox");
const screenH = window.innerHeight/3*2;
const retVal = ele => ele.getBoundingClientRect().top;

const showTit = x => {
    let xval = retVal(x);
    if (xval < screenH && xval > 0) {
        x.classList.add("on");
    }
};

window.addEventListener("scroll", () => {
    for (let x of showBox) showTit(x);
});

/* FAQ 게시판 이동 */
document.getElementById('faqBoardBtn').addEventListener('click', ()=> {
  location.href = '/faqBoard/faqBoard';
}); 

/* 후기 인증 게시판 이동 */
document.getElementById('reviewBtn').addEventListener('click', ()=> {
  location.href = '/review';
});




const donateThings = document.querySelector("#donateThingss");
let i = 1;

function donateThingsFuntion() {
  donateThings.innerHTML = "";

    fetch("/acceptor/selectproductList")
    .then(resp => resp.json())
    .then(productList => {

      console.log(productList);

        //const productList = JSON.parse(result);
        

        if(productList == null) {
            productList.innerText = "기부물품이 존재하지 않습니다.";
        } else {
            productList.forEach( (product) => {

                
                let arr = [ product.recordDate,
                    product.productName];

                    const infoBox = document.createElement("div");
                    infoBox.classList.add("img-wrapper");


                    const productInfo = document.createElement("div");
                    productInfo.classList.add("productInfo");

                    const donateDate = document.createElement("div");
                    donateDate.innerText = "기부날짜";
                    donateDate.classList.add("donateDate");
                    productInfo.append(donateDate);

                    for(let key of arr){
                    const div = document.createElement("div");
                    div.style.textAlign = "center";
                    div.style.fontSize = "20px";
                    div.style.fontWeight = "bold";
                    div.style.marginBottom = "80px";
                    productInfo.style.backgroundImage = `url("/images/layette-${i}.jpg")`;
                    productInfo.style.backgroundSize = "cover";
                    productInfo.style.backgroundRepeat = "no-repeat";
                    if(i == 10) {
                      i = 1;
                    }else {
                      i++;
                    }
                    div.innerText = key;
                    productInfo.append(div);
                    donateThings.append(productInfo);
                };
              });
            };
      });
};

donateThingsFuntion();

