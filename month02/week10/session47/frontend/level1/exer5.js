const form = document.querySelector("#login");
const usernameInput = document.querySelector("#username");
const passwordInput = document.querySelector("#password");
const usernameError = document.querySelector("#username-error");
const passwordError = document.querySelector("#password-error");
const successMsg = document.querySelector("#success");

form.addEventListener("submit", function(e) {

   
    e.preventDefault();

  
    usernameError.textContent = "";
    passwordError.textContent = "";
    successMsg.style.display = "none";

    let isValid = true;

    if (usernameInput.value.trim() === "") {
        usernameError.textContent = "Username required!";
        isValid = false;
    }

    if (passwordInput.value.length < 6) {
        passwordError.textContent = "Password must be at least 6 characters!";
        isValid = false;
    }

    if (isValid) {
        successMsg.style.display = "block";
        form.reset();
    }
});