const result = document.getElementById('result');
const myForm = document.querySelector('#my-form');

console.log(myForm);

const firstName = document.querySelector('#first-name');
const lastName = document.querySelector('#last-name');
const email = document.querySelector('#email');

myForm.addEventListener('submit', (e) => {
    e.preventDefault();
    result.innerHTML= `
    <div class="info">
         <h3>${firstName.value}</h3>
         <h4>${lastName.value}</h4>
         <p>${email}</p>
    </div>
    `;
    firstName.value= '';
    lastName.value= '';
    email.value= '';
});

const japaneseFood = document.querySelector('.Japanese');
console.log(japaneseFood);

