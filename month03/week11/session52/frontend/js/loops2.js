// 1
const japaneseElements = document.querySelectorAll(".japanese");
console.log(japaneseElements);

for(let i = 0; i<japaneseElements.length; i++){
    console.log(japaneseElements[i]);
    const element = japaneseElements[i];
    element.style.backgroundColor = "white";
    element.style.color = "gray";
    element.style.borderRadius = "30%";
    element.style.height = "80px";
    element.style.width = "80px";
    element.style.marginBotton = "10px";
    element.style.textAlign = "center";
}
// 2
const italianElement = document.querySelector(".italian");
const italianFoods = ["pizza","pasta","spagetti","carbonara","lasagne"];

for(let i = 0; i<5; i++){
    // italianElement.innerHTML += `<li>${italianFoods[i]}</li>`;
    const liElement = `<li class="italianfoods">${italianFoods[i]}</li>`;
    italianElement.innerHTML+=liElement;
} 
