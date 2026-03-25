console.log("call back function");
const add = (a, b) => a + b;
const multiply = (a, b) => a * b

const outputElement = document.getElementById("output");
outputElement.addEventListener("click", () => console.log(add(4, 5)));

const btn1 = document.getElementById("btn1");
btn1.addEventListener("click", () => console.log(multiply(5, 6)));

const calc1 = document.getElementById("calc01");
const calc2 = document.getElementById("calc02");
const calc3 = document.getElementById("calc03");

const calc = (a, b, operation) => {
    switch (operation) {
        case '+': return a + b;
        case '-': return a - b;
        case '*': return a * b;
        case '/': return b !== 0 ? a / b : 'Error';
        default: return 'Invalid';
    }
}

let a = 2;
let b = 5;
calc1.textContent = calc(a, b, '+');
calc2.textContent = calc(a, b, '*');
calc3.textContent = calc(a, b, '-')