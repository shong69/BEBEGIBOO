document.addEventListener("DOMContentLoaded", function() {
    const slider = document.querySelector('.slides');
    let currentIndex = 0;
    const slideCount = slider.children.length;
    const slideWidth = 1857;
    const slideInterval = 3500;

    setInterval(function() {
        currentIndex = (currentIndex + 1) % slideCount;
        slider.style.transform = `translateX(-${currentIndex * slideWidth}px)`;
    }, slideInterval);
});




document.querySelector("#top-button").addEventListener("click", () => {

    window.scrollTo({top:0, behavior: 'smooth'});
});


const container1 = document.querySelector("#container1");
const container2 = document.querySelector("#container2");
const container3 = document.querySelector("#container3");
const container4 = document.querySelector("#container4");


container1.addEventListener("click", () => {

    window.scrollTo({top:2300, behavior: 'smooth'});
});

container2.addEventListener("click", () => {

    window.scrollTo({top:2900, behavior: 'smooth'});
});

container3.addEventListener("click", () => {

    window.scrollTo({top:3600, behavior: 'smooth'});
});

container4.addEventListener("click", () => {

    window.scrollTo({top:4700, behavior: 'smooth'});
});