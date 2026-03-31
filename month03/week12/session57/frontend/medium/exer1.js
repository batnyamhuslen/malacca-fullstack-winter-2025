const employees = [
    { name: "Болд",  dept: "IT",      salary: 2500000 },
    { name: "Оюун",  dept: "Санхүү",  salary: 2000000 },
    { name: "Бат",   dept: "IT",      salary: 3000000 },
    { name: "Ану",   dept: "HR",      salary: 1800000 },
    { name: "Тэмүр", dept: "IT",      salary: 2800000 },
    { name: "Сарнай",dept: "Санхүү",  salary: 2200000 }
];
let it = employees.filter(x=>x.dept === "IT").map(x=>x.name);
console.log(it);

let it2 = employees.map(x=>x.name);
console.log(it2);

const salary = employees.filter(x=>x.salary >= 2500000);
console.log(salary);

cosnt = niit = employees.reduce((sum,employe)=>sum+employe.salary,0);
console.log(niit);