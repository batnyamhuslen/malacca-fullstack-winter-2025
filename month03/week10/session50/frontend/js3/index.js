// TODO: document дээр keydown event listener нэм
document.addEventListener("keydown", function(e) {

  // TODO: #key-box-ийн innerHTML-г шинэчил
  // Харуулах мэдээлэл: e.key, e.code, e.shiftKey, e.ctrlKey
  // Template literal ашиглан HTML үүсгэ
  const keyName = e.key === " " ? "Space" : e.key;

  document.querySelector("#key-box").innerHTML = `
     <p><strong>Key:</strong> ${keyName}</p>
     <p><strong>Code:</strong> ${e.code}</p>
    <p><strong>Shift:</strong> ${e.shiftKey}</p>
    <p><strong>Ctrl:</strong> ${e.ctrlKey}</p>
  `;
});