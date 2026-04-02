async function fetchUsers() {
  const userList = document.getElementById("user-list");

  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/users");

    if (!res.ok) {
      throw new Error("Серверээс өгөгдөл авч чадсангүй");
    }

    const users = await res.json();

    const userCards = users.map(user => `
      <div class="user-card">
        <div class="user-name">${user.name}</div>
        <div class="user-email">${user.email}</div>
        <div>📍 ${user.address.city}</div>
      </div>
    `).join("");

    userList.innerHTML = userCards;

  } catch (error) {
    userList.innerHTML = `<p style="color:red; text-align:center;">Алдаа гарлаа: ${error.message}</p>`;
    console.error("Fetch алдаа:", error);
  }
}

fetchUsers();