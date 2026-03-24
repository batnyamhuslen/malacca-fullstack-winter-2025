// 1
const loop1 = document.querySelector("#loop01");
var i = 0;
var word = "";
while (i<3) {
    word += `<div>hellow </div>`;
    i++;
}
loop1.innerHTML =word;

// 2
const loop2 = document.querySelector("#loop02");
var i2 = 10;
var word2 = "";
while (i2 <=20) {
    if (i2 === 13) {
        i2++;
        continue;
    }
    word2 += `<div>${i2}</div>`
    i2++;
}
loop2.innerHTML = word2;

