console.log('javascript function');

let showMe = 10;
document.getElementById('show-me').textContent = 10;
var pElement = document.getElementById('show-me');
console.log(pElement);
pElement.textContent = showMe;
pElement.style.textAlign = 'center';
pElement.style.background = 'blue';
pElement.style.fontSize = '24px';
pElement.style.color = 'red';

//black button
const buttonElement = document.getElementById('Click-me');
buttonElement.style.color ='white';
buttonElement.style.background = "black";
buttonElement.addEventListener('click',function(){
    alert('Button clicked');
});

//function
function addTwo(a,b){
    console.log(a+b);
}
//function call
addTwo(5,6);
addTwo(10,-5);

//function
function returnTwoNumber(a,b){
    return a + b; 
}
//function call
console.log(returnTwoNumber(5,6));


//exercises
const button2 = document.getElementById('Add');
button2.style.color ='white';
button2.style.background = "black";
function addThree(a,b,c){
    console.log(a+b+c);
}
addThree(13,12,11);
addThree(5,6,7);

function minusTwo(a,b){
    return a-b;
}
buttonElement.addEventListener('click',function(){
    alert(minusTwo(13,3));
});

buttonElement.addEventListener('click',function(){
    alert(minusTwo(8,4));
});


//function declaration
function printhellow(){
    alert(printhellow);
    console.log('hello world')
}

//function expression
//anonymous function
const myFunction = function(){
    console.log('this is my function expression');
}
myFunction();


const myArrowFunction = () => {
    console.log('this is my arrow function expression');
}

myArrowFunction();

//Exercises
const addFour = function(a,b,c,d){
    console.log(a+b+c+d);
}
addFour(1,2,3,4);

const multiplyTwo = (a,b) =>{
    console.log(a * b);
}
multiplyTwo(2,2);







