const main = document.querySelector("#main");


main.innerHTML = `
    <div>
         <h2>templete literal</h2>
         <p class="text">this is a test</p>
    </div>
    `;

const textInput = document.querySelector("#text-input");
let writtenText= "";
textInput.addEventListener("keydown", function(e){
    console.log(e.key);
    writtenText= writtenText + e.key;
    document.querySelector("#key-display").innerHTML=`
     <div>Key: ${e.key}</div>
     <p>Written Text: ${writtenText}</p>
    `;
});

// exer3
const commentElement = document.querySelector("#comment");
const counterElement = document.querySelector("#current");

commentElement.addEventListener("keydown", (e)=> {
    console.log(e.target.value);
    const rest = e.target.value.length;
    counterElement.textContent = rest;

    if(rest > 250){
        counterElement.style.color = "red";
    }else if(rest > 200){
        counterElement.style.color = "orange";
    }else{
        counterElement.style.color = "black";
    }
});

// exer4
document.querySelector("#username").addEventListener("input", function(e){
    const error = document.querySelector("#username-error");
    if(e.target.value.length < 3){
        error.textContent = "At least 3 letters";
        error.style.color = "red";
    }else if (e.target.value.length>20){
        error.textContent = "max 20 letters";
        error.style.color = "red";
    }else{
        error.textContent = "Correct";
        error.style.color = "green";
    }
});

function passwordPower (text){
    if (text.length < 6){
        return "low"
    }
    const number = /\d/.test(text);
    const specialChars = /[!@#$%]/.test(text);

    if (text.length >= 8 && number && specialChars){
        return "powerful";
    }
    return "intermediate";
}

document.querySelector("#password").addEventListener("input", function(e){
    const secret = e.target.value;
    const level = passwordPower(secret);
    const strengthFill = document.querySelector("#strength-fill");
    strengthFill.style.height = "50px";
    console.log(strengthFill);

    if(level === "low"){
        strengthFill.style.width = "30%";
        strengthFill.style.backgroundColor = "#ff4444";
    }else if (level === "intermediate"){
        strengthFill.style.width = "65%";
        strengthFill.style.backgroundColor = "#ffaa00";
    }else if (level === "powerful"){
        strengthFill.style.width = "100%";
        strengthFill.style.backgroundColor = "#00aa44";
    }
});