const btn = document.querySelector("#faq-btn");
const content = document.querySelector("#faq-content");

btn.addEventListener("click", function(){

    // toggle class
    content.classList.toggle("visible");

    // change arrow
    if(content.classList.contains("visible")){
        btn.textContent = "FAQ: JavaScript хэл гэж юу вэ? ▲";
    } else {
        btn.textContent = "FAQ: JavaScript хэл гэж юу вэ? ▼";
    }

});