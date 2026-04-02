const books = [
    { id: 1, title: "Монгол нууц товчоо",    author: "Тодорхойгүй", pages: 350, price: 25000 },
    { id: 2, title: "Жавхлант монгол",         author: "С.Нацагдорж", pages: 280, price: 18000 },
    { id: 3, title: "Цогт тайж",               author: "Б.Ринчен",    pages: 420, price: 32000 },
    { id: 4, title: "JavaScript: The Good Parts",author: "D.Crockford",pages: 176, price: 45000 }
];

books.forEach(x=>{console.log(x.title,x.author);});
const shortBooks = books.filter(x => x.pages < 300);
console.log(shortBooks);

const titlePrice = books.map(x=>console.log(x.title+"- " +x.price));
const totalPrice = books.reduce((sum, { price }) => sum + price, 0);
console.log(totalPrice);

