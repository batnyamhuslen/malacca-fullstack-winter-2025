let curr = '0';
let prev = '';
let op = undefined;
const currTxt = document.getElementById('botton-display'); 
const prevTxt = document.getElementById('top-display');  
document.getElementById("num0").onclick = () => addNum("0");
document.getElementById("num1").onclick = () => addNum("1");
document.getElementById("num2").onclick = () => addNum("2");
document.getElementById("num3").onclick = () => addNum("3");
document.getElementById("num4").onclick = () => addNum("4");
document.getElementById("num5").onclick = () => addNum("5");
document.getElementById("num6").onclick = () => addNum("6");
document.getElementById("num7").onclick = () => addNum("7");
document.getElementById("num8").onclick = () => addNum("8");
document.getElementById("num9").onclick = () => addNum("9");
document.getElementById("dot").onclick = () => addNum(".");
document.getElementById("plus").onclick = () => setOp("+");
document.getElementById("minus").onclick = () => setOp("-");
document.getElementById("multiply").onclick = () => setOp("*");
document.getElementById("divide").onclick = () => setOp("/");
document.getElementById("percent").onclick = () => setOp("%");
document.getElementById("equals").onclick = calculate;
document.getElementById("ac").onclick = clearAll;
document.getElementById("c").onclick = backspace;  

function uptade() {
    currTxt.innerText = curr;

    if (op && op !== '=') {
        let sym = op === '*' ? '×' : (op === "/" ? '÷' : op);
        prevTxt.innerHTML = `${prev} <span class="operator-style">${sym}</span>`;
    } else {
        prevTxt.innerText = prev;
    }
    
    if (curr.length > 12) {
        currTxt.style.fontSize = '30px';
    } else {
        currTxt.style.fontSize = '58px';
    }
}

document.querySelectorAll('.mode-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        document.documentElement.setAttribute('data-theme', btn.dataset.theme);
        document.querySelectorAll('.mode-btn').forEach(b => b.classList.remove('active'));
        btn.classList.add('active');
    });
});

function addNum(n) {
    if (n === '.' && curr.includes('.')) return;
    if (curr === '0' && n !== '.') curr = n;
    else curr += n;
    uptade();
}

function setOp(o) {
    if (curr === '0' && prev === '') return;
    if (prev !== '') {
        calculate();
    }
    op = o;
    prev = curr;
    curr = '0';
    uptade();
}

function calculate() {
    let res;
    const p = parseFloat(prev);
    const c = parseFloat(curr);

    if (isNaN(p) || isNaN(c)) return;

    switch (op) {
        case '+': res = p + c; break;
        case '-': res = p - c; break;
        case '*': res = p * c; break;
        case '/': res = c === 0 ? "Error" : p / c; break;
        case '%': res = p % c; break;
        default: return;
    }

    curr = res.toString();
    op = undefined;
    prev = '';
    uptade();
}

function clearAll() {
    curr = '0';
    prev = '';
    op = undefined;
    uptade();
}

function backspace() {
    if (curr === '0') return;
    curr = curr.slice(0, -1);
    if (curr === '') curr = '0';
    uptade();
}
document.addEventListener("keydown", (e) => {
    const key = e.key;
    let btn;

    if (!isNaN(key)) {
        addNum(key);
        btn = document.getElementById("num" + key);
    }
    else if (key === ".") {
        addNum(".");
        btn = document.getElementById("dot");
    }
    else if (key === "+") {
        setOp("+");
        btn = document.getElementById("plus");
    }
    else if (key === "-") {
        setOp("-");
        btn = document.getElementById("minus");
    }
    else if (key === "*") {
        setOp("*");
        btn = document.getElementById("multiply");
    }
    else if (key === "/") {
        setOp("/");
        btn = document.getElementById("divide");
    }
    else if (key === "%") {
        setOp("%");
        btn = document.getElementById("percent");
    }
    else if (key === "Enter" || key === "=") {
        calculate();
        btn = document.getElementById("equals");
    }
    else if (key === "Backspace") {
        backspace();
        btn = document.getElementById("c");
    }
    else if (key === "A") {
        clearAll();
        btn = document.getElementById("ac");
    }
    if (btn) {
        btn.classList.add("active");
        setTimeout(() => btn.classList.remove("active"), 150);
    }
});

uptade();