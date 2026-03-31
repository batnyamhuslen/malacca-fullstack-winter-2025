const dom = document.getElementsByClassName("dom");
const temps = [0, 10, 20, 30, 37, 100];
const fahr = temps.map((x)=>{
    return x*temps.length + 32;
});
console.log(fahr);

const students = ["болд", "оюун", "бат", "ану"];
const upper = students.map(x=>x.toUpperCase());
console.log(upper);


