const prices = [100, 250, 80, 320, 150];

const prices2 = prices.map((x)=>{
    return x * 1.1;
});

console.log(prices2);

const formattedPrices = prices.map(price => `₮${price}`);
console.log(formattedPrices);

