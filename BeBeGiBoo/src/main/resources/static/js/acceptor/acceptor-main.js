const horizontal = document.querySelector("#horizontal");

function selectProduct() {
    horizontal.innerHTML = "";

    fetch("/acceptor/selectproductList")
    .then(resp => resp.text())
    .then(result => {

        const productList = JSON.parse(result);
        

        if(productList == null) {
            productList.innerText = "기부물품이 존재하지 않습니다.";
        } else {
            productList.forEach( (product) => {
                let arr = [ product.recordDate,
                    product.memberId,
                    product.productName];

                    const infoBox = document.createElement("div");
                    infoBox.classList.add("img-wrapper");
                    infoBox.classList.add("slower");
                    infoBox.classList.add("vertical");

                    const productInfo = document.createElement("div");
                    productInfo.classList.add("productInfo");

                    for(let key of arr){
                    const div = document.createElement("div");
                    div.innerText = key;
                    productInfo.append(div);
                }

                const button = document.createElement("button");
                button.innerText = "신청하기";

                productInfo.append(button);

                infoBox.append(productInfo);
                horizontal.append(infoBox);
            });
        }
    });
}

selectProduct();