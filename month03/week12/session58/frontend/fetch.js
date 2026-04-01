console.log("js fetch api");

const mainElement = document.getElementById("main");

const request = fetch("https://dummyjson.com/products");
const response = request.then((data) => data.json());
console.log(response);

response.then((data) => {
    console.log(data);
    const { products } = data;
    console.log(products);

    products.forEach((product) => {
        const productoo = document.createElement("div");
        productoo.classList.add("product-card");
        const img = document.createElement("img");
        img.src = product.thumbnail;
        const title = document.createElement("h2");
        title.textContent = product.title;
        const description = document.createElement("p");
        description.textContent = product.description;
        const price = document.createElement("h3");
        price.textContent = `$${product.price}`;

        productoo.appendChild(img);
        productoo.appendChild(title);
        productoo.appendChild(description);
        productoo.appendChild(price);

        mainElement.appendChild(productoo);
    });
});

