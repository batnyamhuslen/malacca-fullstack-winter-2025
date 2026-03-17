const display = document.querySelector("#calc-display");
const buttons = document.querySelector("#calc-buttons");
let currentValue = "";

buttons.addEventListener("click", function(e) {
    
    if (e.target.tagName !== "BUTTON") {
        return;
    }

    if (e.target.id === "clear-btn") {
        currentValue = "";
        display.textContent = "0";
        return;
    }

    const value = e.target.dataset.val;
    currentValue += value;
    display.textContent = currentValue;
});