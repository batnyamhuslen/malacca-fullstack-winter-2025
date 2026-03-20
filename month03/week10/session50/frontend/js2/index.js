// TODO: 3 хувьсагч тодорхойл
const ner = "huslen";
const megejil = "hugjuulegch";
const hool = "huushur";

// TODO: template literal ашиглан HTML карт үүсгэж
//       document.querySelector("#profile-card").innerHTML-д тавь
// Шаардлага:
// - Нэрийг h2 тагт харуул
// - Мэргэжил, хоолны мэдээлэл харуул
// - Дор хаяж нэг inline style нэмж тохируулга хий
const card=`
<div>
    <h2 style="color:gray">${ner}</h2>
    <p>${megejil}</p>
    <p>${hool}</p>
</div>
`;

document.querySelector("#profile-card").innerHTML = card;