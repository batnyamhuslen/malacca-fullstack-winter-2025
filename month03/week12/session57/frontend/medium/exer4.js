const products = [
    { name: "Утас", price: 500000, inStock: true },
    { name: "Цамц", price: 25000, inStock: true },
    { name: "Зурагт", price: 1200000, inStock: false },
    { name: "Гутал", price: 60000, inStock: true },
    { name: "Компьютер", price: 2000000, inStock: true }
];

const productList = document.getElementById("product-list");

const productCards = products
  .map(product => `
    <div class="card">
        <h3>${product.name}</h3>
        <p class="price">${product.price.toLocaleString()}₮</p>
        <p>${product.inStock ? "Бэлэн" : "Хоосон"}</p>
    </div>
  `)
  .join('');

productList.innerHTML = productCards;

