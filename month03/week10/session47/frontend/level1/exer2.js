const items = document.querySelectorAll("#color-list li ");
const selected = document.querySelector("#selected");

items.forEach(function(item) {
    item.addEventListener("click", function() {
        items.forEach(function(el) {
            el.style.background = "";
        });
        items.style.background = "#b3d9ff";
       selected.textContent = item.textContent;
    });
});