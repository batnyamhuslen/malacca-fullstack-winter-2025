const books = [
    { title: "Хоёрдугаар зууны залуус", author: "Д.Нацагдорж", pages: 250 },
    { title: "JavaScript: Мэдэх ёстой бүх зүйл", author: "Д.Флэнаган", pages: 1096 },
    { title: "Clean Code", author: "Роберт Мартин", pages: 431 },
    { title: "Алгоритм ба өгөгдлийн бүтэц", author: "С.Скиена", pages: 730 }
];

const a = books.find(x=> x.pages>400);
console.log(a);

const b = books.find(x=> x.title= "Роберт Мартин");
console.log(b);

const c = books.some(x=> x.pages>1000);
console.log(c);
const d = books.every(x=> x.pages>500);
console.log(d);