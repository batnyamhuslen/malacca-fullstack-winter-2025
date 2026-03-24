console.log("JS get elements by class name");

const numberElements = document.getElementsByClassName("numbers");

for (let i = 0; i < numberElements.length; i++) {
    console.log(numberElements[i].innerHTML);
}

const mongolianNaadam = ["bukh", "sur kharvaa", "morin uraldaan"];
const naadam = document.querySelector("#naadam");
console.log(naadam);

for (let i = 0; i < mongolianNaadam.length; i++) {
    naadam.children[0].innerHTML += `<li>${mongolianNaadam[i]}</li>` 
}
