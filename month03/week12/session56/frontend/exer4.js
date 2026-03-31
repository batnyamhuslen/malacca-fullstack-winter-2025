const numbers = [3, 7, 12, 5, 19, 8, 14, 1, 22, 16];

const even = numbers.filter(x => x % 2 == 0);

console.log(even);

const mn = numbers.filter(x => x>10);

console.log(mn);

const middle = numbers.filter(x=> x>5 && x<10);

console.log(middle);

