const picker = document.querySelector("#colorPicker");
const preview = document.querySelector("#preview");
const colorCode = document.querySelector("#colorCode");

picker.addEventListener("input", function(e) {
    const color = e.target.value;

    preview.style.backgroundColor = color;

    colorCode.textContent = color;

    preview.textContent = color;
});