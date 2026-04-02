const baseConfig = {
    host:    "localhost",
    port:    3000,
    debug:   false
};

const productionConfig = {
    ...baseConfig,
    port: 8080,
    debug: false
};
console.log(productionConfig);

const developmentConfig = {
    ...productionConfig,
    debug:true,
};
console.log(developmentConfig);
console.log(baseConfig);

const fruits = ["алим", "жүрж", "тавгар лийр"];
const veggies = ["сонгино", "лооль", "өргөст хэмх"];

const summed = [...fruits,...veggies];
console.log(summed);