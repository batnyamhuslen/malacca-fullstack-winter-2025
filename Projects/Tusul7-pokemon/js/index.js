// const URL = "https://pokeapi.co/api/v2/pokemon?limit=100";
// const NAMEURL = `https://pokeapi.co/api/v2/pokemon/{name}`;
// const pokemonContainer = document.getElementById("pokemon-container");

// async function fetchPokemon(pokemonUrl) {
//     const response = await fetch(pokemonUrl);
//     const fetchedData = await response.json();
//     const results = fetchedData.results;
    
//     for (let i = 0; i<results.length; i++){
//         const pokemonDetailsUrl = results[i].url;
//         const pokemonDetailResponse = await fetch(pokemonDetailsUrl);
//         const pokemonDetailData = await pokemonDetailResponse.json();
//         console.log(pokemonDetailData);
//         renderPokemon(pokemonDetailData);
//     }
// }
// async function fetchPokemonDetail(pokemonName) {
//     const response = await fetch(pokemonName);
//     const fetchedData = await response.json();
//     const results = fetchedData.results;

// }

// fetchPokemon(URL);
// fetchPokemonDetail(NAMEURL);

// function renderPokemon(pokemon){
//     const pokemonCard = document.createElement("div");
//     pokemonCard.className = "pokemon-card";

//     const pokemonTitle = document.createElement("h3");
//     pokemonTitle.className = "pokemon-title";
//     pokemonTitle.textContent = pokemon.name;

//     const pokemonImage = document.createElement("img");
//     pokemonImage.className = "pokemon-image";
//     pokemonImage.style.width = "200px";
//     pokemonImage.src = pokemon.sprites.other["official-artwork"].front_shiny;

//     const pokemonId = document.createElement("p");
//     pokemonId.className = "pokemon-id";
//     pokemonId.textContent =     
    

//     pokemonCard.appendChild(pokemonTitle);
//     pokemonCard.appendChild(pokemonImage);
//     pokemonContainer.appendChild(pokemonCard);
// }

/**
 * POKEDEX PROJECT - ALL-IN-ONE
 */

const state = {
    POKEMON_DETAILS: [],
    CURRENT_SEARCH: '',
    CURRENT_SORT: 'id-asc',
    SELECTED_TYPES: []
};

const TYPE_ICONS = {
    fire: 'assets/icons/fire.svg',
    water: 'assets/icons/water.svg',
    grass: 'assets/icons/grass.svg',
    poison: 'assets/icons/poison.svg',
    flying: 'assets/icons/flying.svg',
    bug: 'assets/icons/bug.svg',
    normal: 'assets/icons/normal.svg',
    rock: 'assets/icons/rock.svg',
    ground: 'assets/icons/ground.svg',
    fighting: 'assets/icons/fighting.svg',
    ghost: 'assets/icons/ghost.svg',
    psychic: 'assets/icons/psychic.svg',
    ice: 'assets/icons/ice.svg',
    dragon: 'assets/icons/dragon.svg',
    dark: 'assets/icons/dark.svg',
    fairy: 'assets/icons/fairy.svg',
    electric: 'assets/icons/elec.svg',
    steel: 'assets/icons/steel.svg'
};

const TYPE_STYLES = {
    fire: { tag: '#FF6464', bg: '#EB6C6C' },
    bug: { tag: '#C9FF84', bg: '#91AC22' },
    water: { tag: '#9FF3FF', bg: '#009ACB' },
    flying: { tag: 'linear-gradient(to right, #CBE9FF , #2299EE)', bg: '#2299EE' },
    poison: { tag: '#D89CFD', bg: '#7D00CB' },
    normal: { tag: '#CBCBCB', bg: '#B6B6B6' },
    rock: { tag: '#CFC06F', bg: '#857D57' },
    ground: { tag: '#FFBF72', bg: '#A77437' },
    fighting: { tag: '#FF699F', bg: '#8A114E' },
    ghost: { tag: '#B592FF', bg: '#6D2BF1' },
    psychic: { tag: '#FF5E60', bg: '#C4484A' },
    ice: { tag: '#AEFFF4', bg: '#3A9D90' },
    dragon: { tag: '#87C5FF', bg: '#1268BB' },
    dark: { tag: '#8F8F8F', bg: '#373737' },
    fairy: { tag: '#FFA2E3', bg: '#C01A8D' },
    electric: { tag: '#FFFA86', bg: '#B7B117' },
    steel: { tag: '#A4FFE9', bg: '#4B8F85' },
    grass: { tag: '#80E177', bg: '#1EBA11' }
};


const main = document.getElementById('main');

function createCard(data) {
    const card = document.createElement('div');
    card.className = 'pokemon-card';
    card.style.background = TYPE_STYLES[data.types[0].type.name]?.bg || '#B6B6B6';

    const header = document.createElement('div');
    header.className = 'card-header';
    header.innerHTML = `
        <h2>${data.name}</h2>
        <span class="pokemon-id">#${data.id.toString().padStart(3, '0')}</span>
    `;

    const imageWrapper = document.createElement('div');
    imageWrapper.className = 'image-wrapper';
    imageWrapper.innerHTML = `<img src="${data.sprites.other['official-artwork'].front_default}">`;

    const typesWrapper = document.createElement('div');
    typesWrapper.className = 'types';

    data.types.forEach(t => {
        const type = t.type.name;
        const tag = document.createElement('span');
        tag.className = 'type';
        tag.dataset.type = type;
        tag.style.background = 'rgba(255,255,255,0.35)';
        tag.style.backdropFilter = 'blur(4px)';
        tag.innerHTML = `
            <img class="type-icon" src="${TYPE_ICONS[type]}">
            <span>${type}</span>
        `;
        typesWrapper.appendChild(tag);
    });

    const extraIcon = document.createElement('img');
    extraIcon.src = './assets/img/Group_239.svg';
    extraIcon.className = 'extra-icon';
    extraIcon.style.position = 'absolute';
    extraIcon.style.bottom = '-10px';
    extraIcon.style.left = '-10px';
    extraIcon.style.width = '90px';
    extraIcon.style.height = '90px';

    card.appendChild(extraIcon);

    card.addEventListener('mouseenter', () => {
        card.querySelectorAll('.type').forEach(t => {
            const type = t.dataset.type;
            t.style.background = TYPE_STYLES[type]?.tag || '#CBCBCB';
            t.style.backdropFilter = 'none';
        });
    });

    card.addEventListener('mouseleave', () => {
        card.querySelectorAll('.type').forEach(t => {
            t.style.background = 'rgba(255,255,255,0.35)';
            t.style.backdropFilter = 'blur(4px)';
        });
    });

    card.addEventListener('click', () => openModal(data));
    card.append(header, imageWrapper, typesWrapper);
    return card;
}

function render() {
    if (!main) return;
    main.innerHTML = '';
    let list = [...state.POKEMON_DETAILS];

    if (state.CURRENT_SEARCH) {
        list = list.filter(p =>
            p.name.includes(state.CURRENT_SEARCH) ||
            p.id.toString().includes(state.CURRENT_SEARCH)
        );
    }

    if (state.SELECTED_TYPES.length) {
        list = list.filter(p =>
            p.types.some(t => state.SELECTED_TYPES.includes(t.type.name))
        );
    }

    switch (state.CURRENT_SORT) {
        case 'id-desc': list.sort((a, b) => b.id - a.id); break;
        case 'az': list.sort((a, b) => a.name.localeCompare(b.name)); break;
        case 'za': list.sort((a, b) => b.name.localeCompare(a.name)); break;
        default: list.sort((a, b) => a.id - b.id);
    }

    list.forEach(p => main.appendChild(createCard(p)));
}

const modal = document.getElementById('pokemonModal');
const modalBody = document.getElementById('modalBody');
const closeBtn = document.getElementById('closeModal');

async function openModal(pokemon) {
    const primaryType = pokemon.types?.[0]?.type.name || 'normal';
    const bgStyle = TYPE_STYLES[primaryType]?.bg || '#B6B6B6';

    modalBody.innerHTML = `
        <div class="modal-header">
            <div class="modal-pokemon-card" style="background: ${bgStyle};">
                <div class="modal-left">
                    <div class="modal-image-wrapper">
                        <img src="${pokemon.sprites.other['official-artwork'].front_default || pokemon.sprites.front_default}" alt="${pokemon.name}">
                    </div>
                </div>
                <div class="modal-right">
                    <div class="modal-card-header">
                        <h2>${pokemon.name}</h2>
                        <span class="modal-pokemon-id">#${pokemon.id.toString().padStart(3, '0')}</span>
                    </div>
                    <div class="modal-types">
                        ${pokemon.types.map(t => {
                            const type = t.type.name;
                            const icon = TYPE_ICONS[type] ? `<img class="type-icon" src="${TYPE_ICONS[type]}">` : '';
                            const badgeBg = TYPE_STYLES[type]?.tag || 'rgba(255,255,255,0.25)';
                            return `<span class="modal-type" style="background: ${badgeBg};">${icon}<span>${type}</span></span>`;
                        }).join(' ')}
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-bar">
            <button class="tab-button active" data-tab="about">About</button>
            <button class="tab-button" data-tab="stats">Stats</button>
            <button class="tab-button" data-tab="evolution">Evolution</button>
        </div>
        <div class="tab-content">
            <div class="tab-panel" data-panel="about">
                <div class="meta about-panel">
                    <p><b>Species:</b> ${pokemon.species ? pokemon.species.name[0].toUpperCase() + pokemon.species.name.slice(1) : 'Unknown'}</p>
                    <p><b>Height:</b> ${pokemon.height}</p>
                    <p><b>Weight:</b> ${pokemon.weight}</p>
                    <p><b>Abilities:</b> ${pokemon.abilities.map(a => a.ability.name).join(', ')}</p>
                </div>
            </div>
            <div class="tab-panel" data-panel="stats" style="display:none;">
                ${renderStats(pokemon.stats)}
            </div>
            <div class="tab-panel" data-panel="evolution" style="display:none;">
                <div class="evolution-grid" id="evoGrid">
                    <div class="evo-items"><img src="assets/img/loader.svg" alt="Loading..."></div>
                </div>
            </div>
        </div>
    `;
    modal.classList.add('open');


    const tabButtons = modalBody.querySelectorAll('.tab-button');
    const tabPanels = modalBody.querySelectorAll('.tab-panel');
    tabButtons.forEach(btn => {
        btn.addEventListener('click', () => {
            tabButtons.forEach(b => b.classList.remove('active'));
            btn.classList.add('active');
            const tab = btn.dataset.tab;
            tabPanels.forEach(p => p.style.display = (p.dataset.panel === tab) ? 'block' : 'none');
        });
    });


    try {
        if (pokemon.species?.url) {
            const speciesRes = await fetch(pokemon.species.url).then(r => r.json());
            const evoRes = await fetch(speciesRes.evolution_chain.url).then(r => r.json());
            const speciesList = [];
            (function traverse(node) {
                if (node?.species) speciesList.push(node.species);
                node.evolves_to?.forEach(child => traverse(child));
            })(evoRes.chain);

            const evoDetails = await Promise.all(
                speciesList.map(s => fetch(`https://pokeapi.co/api/v2/pokemon/${s.name}`).then(r => r.json()).catch(() => null))
            );

            const evoGrid = document.getElementById('evoGrid');
            if (evoGrid) {
                evoGrid.innerHTML = evoDetails.map(d => {
                    if (!d) return '';
                    const img = d.sprites?.other?.['official-artwork']?.front_default || d.sprites?.front_default || '';
                    return `
                        <div class="evo-item" style="cursor:pointer">
                            <img src="${img}" alt="${d.name}">
                            <div class="evo-name">${d.name.toUpperCase()}</div>
                            <div class="evo-id">#${d.id.toString().padStart(3, '0')}</div>
                        </div>`;
                }).join('');

                evoGrid.querySelectorAll('.evo-item').forEach((item, i) => {
                    item.addEventListener('click', () => openModal(evoDetails[i]));
                });
            }
        }
    } catch (err) { console.error(err); }
}

function renderStats(stats) {
    return `<div class="stats">${stats.map(s => `
        <div class="stat">
            <span>${s.stat.name.toUpperCase()}</span>
            <span class="value">${s.base_stat}</span>
            <div class="bar"><div class="fill" style="width:${s.base_stat}%"></div></div>
        </div>`).join('')}</div>`;
}

function initFilters() {
    const searchInput = document.getElementById('searchInput');
    const sortDropdown = document.getElementById('sortDropdown');
    const filterPanel = document.getElementById('filterPanel');

    searchInput?.addEventListener('input', e => {
        state.CURRENT_SEARCH = e.target.value.toLowerCase().trim();
        render();
    });

    sortDropdown?.querySelectorAll('li').forEach(option => {
        option.addEventListener('click', () => {
            state.CURRENT_SORT = option.dataset.value;
            document.getElementById('sortLabel').textContent = option.textContent;
            sortDropdown.classList.remove('open');
            render();
        });
    });

    sortDropdown?.querySelector('.dropdown-toggle')?.addEventListener('click', e => {
        e.stopPropagation();
        sortDropdown.classList.toggle('open');
    });

    document.getElementById('filterBtn')?.addEventListener('click', e => {
        e.stopPropagation();
        filterPanel.classList.toggle('open');
    });

    document.getElementById('applyFilters')?.addEventListener('click', () => {
        state.SELECTED_TYPES = [...document.querySelectorAll('.filter-group input:checked')].map(i => i.value);
        filterPanel.classList.remove('open');
        render();
    });

    document.getElementById('resetFilters')?.addEventListener('click', () => {
        document.querySelectorAll('.filter-group input').forEach(cb => cb.checked = false);
        state.SELECTED_TYPES = [];
        render();
    });
}

function loadPokemons() {
    fetch('https://pokeapi.co/api/v2/pokemon?offset=0&limit=1000')
        .then(res => res.json())
        .then(data => {
            Promise.all(data.results.map(p => fetch(p.url).then(res => res.json())))
                .then(results => {
                    state.POKEMON_DETAILS = results;
                    render();
                });
        });
}


document.addEventListener('DOMContentLoaded', () => {
    // Header logic
    const header = document.getElementById('header');
    if (header) {
        const wrapper = document.createElement('div');
        wrapper.className = 'header-icons';
        wrapper.innerHTML = `<img src="assets/img/Pokedex-logo.svg">`;
        header.prepend(wrapper);
    }

  
    closeBtn?.addEventListener('click', () => modal.classList.remove('open'));
    window.addEventListener('click', (e) => {
        if (e.target === modal) modal.classList.remove('open');
        if (!e.target.closest('#sortDropdown')) document.getElementById('sortDropdown')?.classList.remove('open');
    });

    initFilters();
    loadPokemons();
});