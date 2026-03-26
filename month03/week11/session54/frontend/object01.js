console.log("js objects");

const user = {
    name: "bat-erdene",
    username: "Bataa",
    role: "lead developer",
    avatar: "https://api.dicebear.com/9.x/avataaars/svg?seed=Bat"
}

document.getElementById("user-name").textContent = user.name;
document.getElementById("username-name").textContent = user.username;
document.getElementById("user-role").textContent = user.role;
document.getElementById("user-img").src = user.avatar;

const products = [
    { name: "laptop", price: 2500, "in-stock": true },
    { name: "mouse", price: 50, "in-stock": false },
    { name: "keyboard", price: 120, "in-stock": true },
]
const container = document.getElementById("products");

for (let i = 0; i < products.length; i++) {
    const product = products[i];

    const card = document.createElement("div");
    card.classList.add("card");

    if (product["in-stock"]) {
        card.classList.add("available");
    } else {
        card.classList.add("sold-out");
    }
    const h3 = document.createElement("h3");
    const price = document.createElement("p");
    const inStock = document.createElement("span");

    h3.textContent = product.name;
    price.textContent = product.price;

    inStock.textContent = products["in-stock"] ? "in stock" : "out of stock";

    card.appendChild(h3);
    card.appendChild(price);
    card.appendChild(inStock);
    container.appendChild(card);
}

