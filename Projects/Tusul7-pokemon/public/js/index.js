const state = {
    POKEMON_DETAILS: [],
    CURRENT_SEARCH: '',
    CURRENT_SORT: 'id-asc',
    SELECTED_TYPES: [],
    ITEMS_PER_PAGE: 16,
    CURRENT_PAGE: 0,
    TOTAL_POKEMON: 0,
    IS_LOADING: false,
    FILTERED_LIST: [],
    OBSERVER: null
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
const modal = document.getElementById('pokemonModal');
const modalBody = document.getElementById('modalBody');
const closeBtn = document.getElementById('closeModal');
const searchInput = document.getElementById('searchInput');

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
        tag.innerHTML = `<img class="type-icon" src="${TYPE_ICONS[type]}"><span>${type}</span>`;
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

    // Apply search filter
    if (state.CURRENT_SEARCH) {
        const search = state.CURRENT_SEARCH.toLowerCase();
        list = list.filter(p =>
            p.name.toLowerCase().includes(search) ||
            p.id.toString().includes(search)
        );
    }

    // Apply type filters
    if (state.SELECTED_TYPES.length) {
        list = list.filter(p =>
            p.types.some(t => state.SELECTED_TYPES.includes(t.type.name))
        );
    }

    // Apply sorting
    switch (state.CURRENT_SORT) {
        case 'id-desc':
            list.sort((a, b) => b.id - a.id);
            break;
        case 'az':
            list.sort((a, b) => a.name.localeCompare(b.name));
            break;
        case 'za':
            list.sort((a, b) => b.name.localeCompare(a.name));
            break;
        default:
            list.sort((a, b) => a.id - b.id);
    }

    // Reset pagination and state
    state.CURRENT_PAGE = 0;
    state.IS_LOADING = false;
    state.FILTERED_LIST = list;

    renderPage();
}

function renderPage() {
    const start = state.CURRENT_PAGE * state.ITEMS_PER_PAGE;
    const end = start + state.ITEMS_PER_PAGE;
    const pageItems = state.FILTERED_LIST.slice(start, end);

    pageItems.forEach(p => main.appendChild(createCard(p)));

    // Add loading indicator if there are more items
    if (end < state.FILTERED_LIST.length) {
        const loadingDiv = document.createElement('div');
        loadingDiv.id = 'loading-indicator';
        loadingDiv.className = 'loading-indicator';
        loadingDiv.innerHTML = '<img src="assets/img/loader.svg" alt="Loading..." class="loader-img">';
        main.appendChild(loadingDiv);
        
        // Observe the new loader
        if (state.OBSERVER) {
            state.OBSERVER.observe(loadingDiv);
        }
    }
}

function renderStats(stats) {
    return `<div class="stats">${stats.map(s => `
        <div class="stat">
            <span>${s.stat.name.toUpperCase()}</span>
            <span class="value">${s.base_stat}</span>
            <div class="bar"><div class="fill" style="width:${s.base_stat}%"></div></div>
        </div>`).join('')}</div>`;
}

async function openModal(pokemon) {
    const primaryType = pokemon.types?.[0]?.type.name || 'normal';
    const bgStyle = TYPE_STYLES[primaryType]?.bg || '#B6B6B6';

    modalBody.innerHTML = `
        <div class="modal-header">
            <div class="modal-pokemon-card" style="background: ${bgStyle};">
               <img id="group" src="./assets/img/Group_239.svg" alt="zurag">
                <div class="modal-left">
                    <div class="modal-image-wrapper">
                        <img id="modal-img" src="${pokemon.sprites.other['official-artwork'].front_default || pokemon.sprites.front_default}" alt="${pokemon.name}">
                    </div>
                </div>
                <div class="modal-right">
                    <div class="modal-card-header">
                        <h2>${pokemon.name}</h2>
                        <span class="modal-pokemon-id">#${pokemon.id.toString().padStart(3, '0')}</span>
                    </div>
                    <br>
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
                    <div class="evo-items"><img src="assets/img/loader.svg" alt="Loading..." class="loader-img"></div>
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

function setupInfiniteScroll() {
    // Disconnect old observer if it exists
    if (state.OBSERVER) {
        state.OBSERVER.disconnect();
        state.OBSERVER = null;
    }

    const observerOptions = {
        root: null,
        rootMargin: '100px',
        threshold: 0
    };

    const observer = new IntersectionObserver((entries) => {
        entries.forEach(entry => {
            if (entry.isIntersecting && !state.IS_LOADING) {
                const nextPage = state.CURRENT_PAGE + 1;
                const start = nextPage * state.ITEMS_PER_PAGE;

                if (start < state.FILTERED_LIST.length) {
                    state.IS_LOADING = true;
                    state.CURRENT_PAGE = nextPage;

                    setTimeout(() => {
                        const newPageItems = state.FILTERED_LIST.slice(
                            start,
                            start + state.ITEMS_PER_PAGE
                        );

                        newPageItems.forEach(p => main.appendChild(createCard(p)));

                        const oldLoader = document.getElementById('loading-indicator');
                        if (oldLoader) oldLoader.remove();

                        // Add new loader if there are more items
                        if ((start + state.ITEMS_PER_PAGE) < state.FILTERED_LIST.length) {
                            const loadingDiv = document.createElement('div');
                            loadingDiv.id = 'loading-indicator';
                            loadingDiv.className = 'loading-indicator';
                            loadingDiv.innerHTML = '<img src="assets/img/loader.svg" alt="Loading..." class="loader-img">';
                            main.appendChild(loadingDiv);

                            observer.observe(loadingDiv);
                        }

                        state.IS_LOADING = false;
                    }, 1000);
                }
            }
        });
    }, observerOptions);

    state.OBSERVER = observer;

    const initialLoader = document.getElementById('loading-indicator');
    if (initialLoader) {
        observer.observe(initialLoader);
    }
}

function initFilters() {
    document.getElementById('searchBtn')?.addEventListener('click', () => {
        state.CURRENT_SEARCH = searchInput.value.toLowerCase().trim();
        render();
        setupInfiniteScroll();
    });

    searchInput?.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') {
            state.CURRENT_SEARCH = searchInput.value.toLowerCase().trim();
            render();
            setupInfiniteScroll();
        }
    });

    const sortDropdown = document.getElementById('sortDropdown');
    sortDropdown?.addEventListener('change', () => {
        state.CURRENT_SORT = sortDropdown.value;
        render();
        setupInfiniteScroll();
    });

    const filterPanel = document.getElementById('filterPanel');
    document.getElementById('filterBtn')?.addEventListener('click', e => {
        e.stopPropagation();
        filterPanel.classList.toggle('open');
    });

    document.getElementById('applyFilters')?.addEventListener('click', () => {
        state.SELECTED_TYPES = [...document.querySelectorAll('.filter-group input:checked')].map(i => i.value);
        filterPanel.classList.remove('open');
        render();
        setupInfiniteScroll();
    });

    document.getElementById('resetFilters')?.addEventListener('click', () => {
        document.querySelectorAll('.filter-group input').forEach(cb => cb.checked = false);
        state.SELECTED_TYPES = [];
        render();
        setupInfiniteScroll();
    });

    document.getElementById('closeFilter')?.addEventListener('click', () => filterPanel.classList.remove('open'));
}

function loadPokemons() {
    fetch('https://pokeapi.co/api/v2/pokemon?offset=0&limit=10000')
        .then(res => res.json())
        .then(data => {
            state.TOTAL_POKEMON = data.count;
            Promise.all(data.results.map(p => fetch(p.url).then(res => res.json())))
                .then(results => {
                    state.POKEMON_DETAILS = results;
                    render();
                    setupInfiniteScroll();
                });
        });
}

document.addEventListener('DOMContentLoaded', () => {
    const header = document.getElementById('header');
    if (header) {
        const wrapper = document.createElement('div');
        wrapper.className = 'header-icons';
        wrapper.innerHTML = `<img src="assets/img/Pokedex-logo.svg" alt="Pokedex Logo">`;
        header.prepend(wrapper);
    }

    closeBtn?.addEventListener('click', () => modal.classList.remove('open'));

    window.addEventListener('click', (e) => {
        if (e.target === modal) modal.classList.remove('open');
    });

    initFilters();
    loadPokemons();
});