const scores = [75, 82, 91, 68, 95, 77, 88];
sum=0;
scores.forEach((i)=>{
    sum+=i;
    // console.log(i);
    if(i>80){
        console.log(i);
    }
});
console.log(sum);
