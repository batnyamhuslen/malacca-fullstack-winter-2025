// TODO: form дээр submit event listener нэм
document.querySelector("#quick-form").addEventListener("submit", function(e) {

  // TODO: e.preventDefault() дуудаж хуудас дахин ачаалагдахаас зогсоо
e.preventDefault(); 
  // TODO: #name-input-ийн утгыг авч .trim() хий
const input = document.querySelector("#name-input");
const name = input.value.trim();
  // TODO: Хоосон байвал #greeting-д анхааруулга харуул (улаан өнгөтэй)
if (name === "") {
    greeting.innerHTML = "Нэрээ оруулна уу!";
    greeting.style.color = "red";
  } else {
    // Мэндчилгээ харуулах
    greeting.innerHTML = `Сайн байна уу, <strong>${name}</strong>!`;
    greeting.style.color = "black";
  }

  input.value ="";

});