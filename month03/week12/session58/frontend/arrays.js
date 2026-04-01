const colors = ["red", "green","blue","orange"];

const [first,second] = colors;
console.log(first);
console.log(second);

const[,,third] = colors;
console.log(third);

const [head, ...tail]=colors;
console.log(head);
console.log(tail);
// 
let a = 5;
let b = 6;
let a2 = a;
let b2 = b;
// switch
let a1 = 2, b1= 3;
[a1,b1]= [b1,a1];
console.log(a1,b1);

const arr1 = [1,2,3];
const arr2 = [4,5,6];
let combinedArray = [arr1 +"," + arr2];
console.log(typeof(combinedArray));
combinedArray = [...arr1, ...arr2];
console.log(combinedArray);
