const nameInput = document.getElementById("name-input");
const greetBtn = document.getElementById("greet-btn");
const greeting = document.getElementById("greeting");
const nameError = document.getElementById("name-error");

greetBtn.addEventListener("click", () => {
  const name = nameInput.value.trim();

  if (name === "") {
    nameError.textContent = "Please enter your name";
    nameError.classList.remove("hidden");
    greeting.textContent = "";
  } else {
    nameError.classList.add("hidden");
    greeting.textContent = `Hello, ${name}!`;
  }
});