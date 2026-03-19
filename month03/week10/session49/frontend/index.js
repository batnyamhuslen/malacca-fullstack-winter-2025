const текст = document.querySelector("#my-textarea");
const лавлах = document.querySelector("#char-info");


текст.addEventListener("input", function(e){
    const урт = this.value.length;
    const үлдсэн = 150 - урт;
    лавлах.textContent = `${урт} /150 (үлдсэн:${үлдсэн})`;

    if(урт>130){
        лавлах.style.color= "red";
    }else{
        лавлах.style.color= "white";
    }
});

