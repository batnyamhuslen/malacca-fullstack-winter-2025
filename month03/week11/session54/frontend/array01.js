console.log("array and araay methods");

const fruits = [];

function addFruits() {
    const fruitInput = document.getElementById("fruit-input");
    const fruitValue = fruitInput.value.trim();

    if (fruitValue === "") {
        alert("Please enter a fruit name!");
        return;
    }

    fruits.push(fruitValue);
    console.log(fruits);
    
    fruitInput.value = "";
    renderFruits();       
}

function renderFruits(){
    const fruitsDiv = document.getElementById("fruits");
    fruitsDiv.innerHTML = "";
    for(let i = 0; i<fruits.length; i++){
        const fruitElement = document.createElement ("p");
        fruitElement.className = "fruit";
        fruitElement.textContent=fruits[i];
        fruitsDiv.appendChild(fruitElement);
    }
}

const fruitButton = document.getElementById("add-fruit-button");
fruitButton.addEventListener("click", addFruits);