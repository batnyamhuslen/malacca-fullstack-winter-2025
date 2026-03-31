const items = [
    { name: "Утас",     price: 500000  },
    { name: "Зурагт",   price: 1200000 },
    { name: "Тоглоом",  price: 45000   },
    { name: "Дэвтэр",   price: 3500    },
    { name: "Харандаа", price: 1500    }
];

items.forEach((item,i)=>{
    console.log(`${i + 1}. ${item.name}: ₮${item.price}`);
});
