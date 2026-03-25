console.log("callback function, arrow function");

const elementOne = document.getElementsByClassName("one")[0];
console.log(elementOne);
const elementTwo = document.getElementsByClassName("two")[0];
console.log(elementTwo);
const elementThree = document.getElementsByClassName("three")[0];
console.log(elementThree);
// =======================================================================================
//function declaratiom
function add(a,b){
    return a+b;
}

elementOne.textContent = add(5,6);
elementTwo.textContent = add(8,1);
elementThree.textContent = add(-1,6);

//function expression
const multiply = function(a,b){
    return a*b;
} 

//function arrow 
const divide = (a,b)=>{
    return a/b;
}
// function call
console.log(multiply(5,6));
console.log(divide(10,5));
console.log(add(5,6));

// ======================================================================================

const double = (x)=>{
    return 2 * x;
}
console.log(double(4));

const greeting = ()=>{
    return "hello";
}
// implisit function
const square = (x)=> x*x;
console.log(square(5));
const sum = (a,b)=> a+b;
console.log(sum(5,10));

const colors = ["red","green", "blue"];

const addToList = (text)=>{
    const li= document.createElement("li");
    li.textContent = text;
    document.querySelector("#list").appendChild(li);
}

const btn1 = document.querySelector(".btn1");

let i = 0; 
btn1.addEventListener("click", () => {
    document.body.style.color = colors[i];
    addToList(colors[i]);
    i++; 
});
