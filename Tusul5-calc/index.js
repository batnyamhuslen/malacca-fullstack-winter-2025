let curr = '0';
let prev = '';
let op = undefined;
let result = 0;
const currTxt = document.getElementById('top-display');
const prevTxt = document.getElementById('botton-display');
const addButton = document.getElementById('add');

addButton.addEventListener('click', function(){
    // todo +
    op = "+";
    if (op !== "="){
        result = curr + prev;
        
    } elseif ()

})

document.querySelectorAll('.mode-btn').forEach(btn=>{
    btn.addEventListener('click',() => {
        document.documentElement.setAttribute('data-theme', btn.dataset.theme);
    })
})

function uptade() {
    currTxt.innerText = curr;
    if (curr.length > 10) {
        currTxt.style.fontSize = '1.5rem';
    } else if (curr.length > 6) {
        currTxt.style.fontSize = '2rem';
    } else {
        currTxt.style.fontSize = '3rem';
    }

    if (op) {
        let sym = op === '*' ? 'x' : (op === "/" ? '÷' : op);
        prevTxt.innerText = '';
    } else {
        prevTxt.innerText = '';
    }
}

function addNum(n) {
    if (n === '.' && curr.includes('.')) return;
    if (curr === '0' && n !== '.') curr = n;
    else curr += n;
    uptade();
}

// function setOp(o) {
//     if (curr === '') return;
//     if (prev !== '') calculate();
//     op = o;
//     prev = curr;
//     curr = '0';
//     if (op === '='){
//         if (op === '+'){
            
//         } else if {
            

//     }
//     uptade();
// }

// function calculate() {
//     let res;
//     const p = parseFloat(prev);
//     const c = parseFloat(curr);
// }



