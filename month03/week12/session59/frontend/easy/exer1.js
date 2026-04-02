const car = {
  make: "Toyota",
  model: "Prius",
  year: 2022,
  color: "цагаан",
  price: 45000000
};
console.log(car);
console.log(car.year);

const car2 = {
    mileage:15000,
};

const combinedObject = {...car,...car2};
console.log(combinedObject);

car.color="har";

console.log(car);

delete car.mileage;

console.log(car);