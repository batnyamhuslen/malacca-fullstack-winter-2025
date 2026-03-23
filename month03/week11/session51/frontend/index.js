let a1 = true;
let b3 = false;
console.log(true || false);
console.log(a1 || b1);
console.log("Not logical operator");

console.log(!true);
console.log(!false);

const a2 = true;
const b2 = false;
const c2 = true;
const d2 = true;
const e2 = false;

const result2 = ((a2 && b2) || c2 && (d2 && !e2));

// 1

const formElement = document.querySelector("#election");
const electionDisplay = document.querySelector("#election-display");

formElement.addEventListener("submit", function (e) {
    e.preventDefault();
    const ageInput = document.querySelector("#age");
    console.log(ageInput);
    const citizenInput = document.querySelector("#citizenship");
    if (parseInt(ageInput.value) > 18 && citizenInput.value === "mongolian") {
        electionDisplay.textContent = "ELIGIBLE";
    } else {
        electionDisplay.textContent = "NOT ELIGIBLE";
    }
});

// 2

const seasons = document.querySelector("#seasons");
const seasonDisplay = document.querySelector("#season-display");
seasons.addEventListener("change", function (e) {
    console.log(e.target.value);
    const choice = e.target.value;

    switch (choice) {
        case "summer":
            seasonDisplay.style.backgroundColor = "green";
            seasonDisplay.style.color = "white";
            seasonDisplay.textContent = "summer.";
            break;
        case "winter":
            seasonDisplay.style.backgroundColor = "blue";
            seasonDisplay.style.color = "white";
            seasonDisplay.textContent = "winter.";
            break;
        case "spring":
            seasonDisplay.style.backgroundColor = "brown";
            seasonDisplay.style.color = "white";
            seasonDisplay.textContent = "spring.";
            break;
        case "autumn":
            seasonDisplay.style.backgroundColor = "yellow";
            seasonDisplay.style.color = "white";
            seasonDisplay.textContent = "autumn.";
            break;
        default:
            seasonDisplay.textContent = "undefined season.";
    }
});
