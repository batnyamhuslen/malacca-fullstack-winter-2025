const gridContainer = document.getElementById("grid-container");
const loadingMsg = document.getElementById("loading-msg");
const scrollAnchor = document.getElementById("scroll-anchor");

let isFetching = false;
let itemCount = 0;

function loadItems() {
    if (isFetching) {
        return;
    }

    isFetching = true;
    loadingMsg.style.display = "block";

    setTimeout(() => {
        for (let i = 0; i < 5; i++) {
            itemCount++;

            const card = document.createElement("div");
            card.className = "card";

            card.innerHTML = `
                <div class="card-number">#${itemCount}</div>
                <div class="card-label">static Note</div>
            `;

            gridContainer.insertBefore(card, scrollAnchor);
        }

        isFetching = false;
        loadingMsg.style.display = "none";

        if (document.documentElement.scrollHeight <= window.innerHeight) {
            loadItems();
        }
    }, 500);
}

window.addEventListener("scroll", () => {
    const scrollHeight = document.documentElement.scrollHeight;
    const scrollTop = window.scrollY;
    const clientHeight = window.innerHeight;

    if (scrollTop + clientHeight >= scrollHeight - 100) {
        loadItems();
    }
});
loadItems();