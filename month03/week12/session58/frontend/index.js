console.log("object destructuring");

const product = {
    id: 5,
    name: "smart phone",
    price: 500000,
    category:"electronics",
    inStock:true,
};
console.log(product.id);
console.log(product.name);
console.log(product.category);

const {id,name,price,category,inStock} = product;
console.log(id);

const user = {
    id:4,
    name: "kangaikhuu",
    age:43
}

const{id:userId, name:userName, age} = user;
console.log(userId);
console.log(userName); 