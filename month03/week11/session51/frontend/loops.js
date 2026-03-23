console.log("JS ARRAY DATASTRUCTURE");

const a = [1, 6, 7];
console.log(a[0]);
console.log(a[2]);

let i = 0;

while (i < 3) {
    console.log(a[i]);
    i++;
}

const myFavoriteFoods = [];
const foodFormElement = document.querySelector("#food-form");
foodFormElement.addEventListener("submit", (e) => {
    e.preventDefault();
    const input = e.target.elements[0].value; 
    console.log(input);
    myFavoriteFoods.push(input);
    console.log(myFavoriteFoods);
    e.target.elements[0].value = ""; 
});

const displayFoods = (foodList) => {
    let i = 0;
    let displayElements = "";

    while (i < foodList.length) {
        const liElement = `<li>${foodList[i]}</li>`;
        displayElements += liElement;
        i++;
    }

    const foodsDisplayElement = document.querySelector("#foods-display");
    foodsDisplayElement.innerHTML = displayElements;
};