const fourStars = document.querySelector("#four-stars");
const a = ["⭐"]
var i = 0;
let stars = "";
while (i < 4) {
    stars += `<span>⭐</span>`;
    i++;
}
fourStars.innerHTML=stars;

const fiveCircle = document.querySelector("#five-circles");
let html = "";
for (let i = 1; i <= 5; i++) {
    html += `<div class="circle">Circle ${i}</div>`;
}
fiveCircle.innerHTML = html;