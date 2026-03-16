let firstname = "Alice";
let lastname = "kim";
let age = 22;

console.log(firstname + " "+ lastname + "is " + age + "years old.");

function isEven(n) {
  return n % 2 === 0;
}
for (let i = 1; i <= 10; i++) {
    if (isEven(i)) {
        System.out.println(i + " is even");
    }
}



function sum(numbers){
    let total = 0;
    for (const n of numbers){
        total+=n;
    }
    return total;
}

const nums = [1,2,3,4,5];

function sum(arr) {
  return arr.reduce((total, num) => total + num, 0);
}

console.log("Sum: " + sum(nums));



function findMax(numbers) {
    if (numbers.length === 0) return undefined;

    let max = numbers[0];

    for (let i = 1; i < numbers.length; i++) {
        if (numbers[i] > max) {
            max = numbers[i];
        }
    }

    return max;
}

console.log(findMax([3, 7, 1, 9, 4]));  