const API_URL = 'https://jsonplaceholder.typicode.com/posts';
const postsContainer = document.getElementById('posts');
const userFilter = document.getElementById('userFilter');
const searchInput = document.getElementById('searchInput');
const countEl = document.getElementById('count');

let posts = [];

async function fetchPosts() {
    try {
        const res = await fetch(API_URL);
        posts = await res.json();
        renderUserFilter();
        renderPosts(posts);
    } catch (err) {
        console.error('Fetch error:', err);
        postsContainer.innerHTML = '<p>Алдаа гарлаа. Постыг ачаалж чадсангүй.</p>';
    }
}

function renderUserFilter() {
    let options = '<option value="">Бүгд</option>';
    for (let i = 1; i <= 10; i++) {
        options += `<option value="${i}">User ${i}</option>`;
    }
    userFilter.innerHTML = options;
}

function renderPosts(list) {
    if (!list.length) {
        postsContainer.innerHTML = '<p>Пост олдсонгүй.</p>';
    } else {
        postsContainer.innerHTML = list
            .map(
                (post) => `
      <div class="post">
        <h3>${post.title}</h3>
        <p>${post.body}</p>
        <small>User: ${post.userId}</small>
      </div>
    `
            )
            .join('');
    }
    countEl.textContent = list.length;
}


function filterPosts() {
    const searchTerm = searchInput.value.toLowerCase();
    const userId = userFilter.value;

    const filtered = posts.filter((post) => {
        const matchesSearch = post.title.toLowerCase().includes(searchTerm);
        const matchesUser = userId ? post.userId === +userId : true;
        return matchesSearch && matchesUser;
    });

    renderPosts(filtered);
}

searchInput.addEventListener('input', filterPosts);
userFilter.addEventListener('change', filterPosts);

fetchPosts();