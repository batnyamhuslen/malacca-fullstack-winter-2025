const postList = document.getElementById('postList');
    const countEl = document.getElementById('count');
    const filterBtn = document.getElementById('filterBtn');
    const userIdSelect = document.getElementById('userId');

    async function fetchPosts(userId = 1) {
      try {
        const response = await fetch("https://jsonplaceholder.typicode.com/posts");
        const posts = await response.json();


        const filtered = posts.filter(post => post.userId === Number(userId));

        // title-ийг truncate хийж, li үүсгэх
        const html = filtered
          .map(post => `<li>${post.title.slice(0, 50)}${post.title.length > 50 ? '...' : ''}</li>`)
          .join('');

        postList.innerHTML = html;

        // Тоолуур
        countEl.textContent = `${filtered.length} пост олдлоо`;
      } catch (error) {
        console.error("Алдаа гарлаа:", error);
        countEl.textContent = "Постууд татагдсангүй";
      }
    }

    // Анх ачааллахад userId=1
    fetchPosts();

    // Товч дээр дарахад filter хийх
    filterBtn.addEventListener('click', () => {
      const userId = userIdSelect.value;
      fetchPosts(userId);
    });