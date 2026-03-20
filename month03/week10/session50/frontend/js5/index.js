const биоТекст = document.querySelector("#bio-textarea");
const тоолуур = document.querySelector("#bio-counter");
const ЛИМИТ = 200;

биоТекст.addEventListener("input", function() {

  const урт = this.value.length;

  const үлдсэн = ЛИМИТ - урт;

  тоолуур.innerHTML = `${урт} / ${ЛИМИТ} (үлдсэн: ${үлдсэн})`;


  if (урт > 180) {
    тоолуур.style.color = "red";
  } else {
    toолуур.style.color = "gray";
  }

});