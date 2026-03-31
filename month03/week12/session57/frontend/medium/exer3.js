const ages = [22, 18, 35, 15, 28, 19, 14];
const age30 = ages.some(x=>x>30);
console.log(age30);
const age18 = ages.every(x=>x<18);
console.log(age18);
const age13 = ages.some(x=>x<13);
console.log(age13);

const prices = [15000, 28000, 7500, 42000, 11000, 33000, 6500];
const niit = prices.reduce(sum=>sum+prices.length);
console.log(niit);
const maxPrice = prices.reduce((max, current) => {
  return current > max ? current : max;
}, prices[0]);
console.log(maxPrice);