const colorInput = document.getElementById("color-input");
const boxesDiv = document.getElementById("boxes"); 

const colorsContainer = [];

function addDiv() {
    const selectedColor = colorInput.value; 
    colorsContainer.push(selectedColor);
    renderColors();
}

function renderColors() {
    boxesDiv.innerHTML = "";
    for (let i = 0; i < colorsContainer.length; i++) {
        const div = document.createElement("div");
        div.style.width = "10px";
        div.style.height = "10px";
        div.style.borderRadius = "30px";
        div.style.backgroundColor = colorsContainer[i]; 
        boxesDiv.appendChild(div);
    }
}
colorInput.addEventListener("input", addDiv);
