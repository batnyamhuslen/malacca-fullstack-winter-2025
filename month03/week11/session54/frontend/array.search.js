const words = [
    "Lorem ipsum dolor sit amet consectetur adipisicing elit. Minus quam beatae libero eligendi enim praesentium reiciendis ratione possimus sit fugiat!",
    "Lorem ipsum dolor khuslen amet consectetur adipisicing elit. Minus quam beatae libero eligendi enim praesentium reiciendis ratione possimus sit fugiat!",
    "Lorem ipsum dolor ochiroo amet consectetur adipisicing elit. Minus quam beatae libero eligendi enim praesentium reiciendis ratione possimus sit fugiat!"
]
const searchResultDiv = document.getElementById("search-results");
const searchButton = document.getElementById("search-button");
const searchInput = document.getElementById("search-input");

for (let i = 0; i < words.length; i++) {
    const w = words[i];

    const h4Element = document.createElement("h4");
    h4Element.textContent = w;
    searchResultDiv.appendChild(h4Element);
}

function searchWord(word) {
    searchResultDiv.innerHTML = "";

    for (let i = 0; i < words.length; i++) {
        if (words[i].includes(word)) {
            const h4Element = document.createElement("h4");
            h4Element.textContent=words[i];
            searchResultDiv.appendChild(h4Element);
        }
    }
}

searchButton.addEventListener("click", () => {
    searchWord(searchInput.value);
});