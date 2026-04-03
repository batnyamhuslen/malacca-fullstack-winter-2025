const URL = "https://pokeapi.co/api/v2/pokemon";
const NAMEURL = `https://pokeapi.co/api/v2/pokemon/{name}`;
const pokemonContainer = document.getElementById("pokemon-container");

async function fetchPokemon(pokemonUrl) {
    const response = await fetch(pokemonUrl);
    const fetchedData = await response.json();
    const results = fetchedData.results;
    
    for (let i = 0; i<results.length; i++){
        const pokemonDetailsUrl = results[i].url;
        const pokemonDetailResponse = await fetch(pokemonDetailsUrl);
        const pokemonDetailData = await pokemonDetailResponse.json();
        console.log(pokemonDetailData);
        renderPokemon(pokemonDetailData);
    }
}
async function fetchPokemonDetail(pokemonName) {
    const response = await fetch(pokemonName);
    const fetchedData = await response.json();
    const results = fetchedData.results;

}

fetchPokemon(URL);
fetchPokemonDetail(NAMEURL);

function renderPokemon(pokemon){
    const pokemonCard = document.createElement("div");
    pokemonCard.className = "pokemon-card";

    const pokemonTitle = document.createElement("h3");
    pokemonTitle.className = "pokemon-title";
    pokemonTitle.textContent = pokemon.name;

    const pokemonImage = document.createElement("img");
    pokemonImage.className = "pokemon-image";
    pokemonImage.style.width = "200px";
    pokemonImage.src = pokemon.sprites.other["official-artwork"].front_shiny;

    const pokemonId = document.createElement("p");
    pokemonId.className = "pokemon-id";
    pokemonId.textContent =     
    

    pokemonCard.appendChild(pokemonTitle);
    pokemonCard.appendChild(pokemonImage);
    pokemonContainer.appendChild(pokemonCard);
}
