const scores = [45, 72, 88, 55, 91, 63, 84, 39, 77, 95];

const max = scores.filter(x=>x>70);
console.log(max);

const min = scores.filter(x=>x<60);
console.log(min);

const total = max.length + min.length === 10;
console.log(total); 

