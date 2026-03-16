
function absolute(n){
    return n < 0 ? -n : n;
}

function max(a,b){
    if(a<b){
        return b;
    }else 
        return a;
}

const isBetween = (n,min,max)=>{
    return n >= min && n <= max;
}
console.log(absolute(-7));
console.log(max(3,5));
console.log(isBetween(4,1,10));