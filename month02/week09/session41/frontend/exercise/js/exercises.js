const inputOne = document.getElementById('number-one');
const inputTwo = document.getElementById('number-two');
const addButton = document.getElementById('add-number');
const addButton2 = document.getElementById('subtract-number');
const addButton3 = document.getElementById('multiply');
const addButton4 = document.getElementById('divide');


const addTwoNumbers = (a, b)  => {
    const resultElement = document.getElementById('result');
    resultElement.textContent = parseInt(a) + parseInt(b);
}
const subtractTwoNumbers = (a, b) => {
    const resultElement = document.getElementById('result');
    resultElement.textContent = parseInt(a) - parseInt(b);
}
const multuplyTwoNumbers = (a, b) => {
    const resultElement = document.getElementById('result');
    resultElement.textContent = parseInt(a) * parseInt(b);
}
const divideTwoNumbers = (a, b) => {
    const resultElement = document.getElementById('result');
    resultElement.textContent = parseInt(a) / parseInt(b);
}


addButton.addEventListener('click', () =>{
    const inputOneValue = inputOne.value;
    const inputTwoValue = inputTwo.value;
    addTwoNumbers(inputOneValue,inputTwoValue);
});

addButton2.addEventListener('click',()=>{
    const inputOneValue = inputOne.value;
    const inputTwoValue = inputTwo.value;
    subtractTwoNumbers(inputOneValue,inputTwoValue);
})
addButton3.addEventListener('click',()=>{
    const inputOneValue = inputOne.value;
    const inputTwoValue = inputTwo.value;
    multuplyTwoNumbers(inputOneValue,inputTwoValue);
})
addButton4.addEventListener('click',()=>{
    const inputOneValue = inputOne.value;
    const inputTwoValue = inputTwo.value;
    divideTwoNumbers(inputOneValue,inputTwoValue);
})

