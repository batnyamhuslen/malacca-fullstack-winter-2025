// script.js
const playBtn = document.getElementById('play-btn');
const statusText = document.getElementById('status-text');

let isSearching = false;

playBtn.addEventListener('click', () => {
    if (!isSearching) {
        // Start Searching
        isSearching = true;
        playBtn.innerText = "CANCEL SEARCH";
        playBtn.classList.add('searching');
        statusText.innerText = "Searching for Match...";
        statusText.style.color = "#ff9d00";
        
        console.log("Connecting to CS2 Servers...");
    } else {
        // Stop Searching
        isSearching = false;
        playBtn.innerText = "START MATCH";
        playBtn.classList.remove('searching');
        statusText.innerText = "In Lobby";
        statusText.style.color = "white";
    }
});