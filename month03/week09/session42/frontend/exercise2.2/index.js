function wordCount (sentence){
    return sentence.split(" ").length;
}
function reverseWords(sentence){
    return sentence.split(" ").reverse().join(" ");
}

const isLongerThan = (str, length) => {
    return str.length > length;
}

console.log(wordCount("the quick brown fox"));  
console.log(reverseWords("hello world"));       
console.log(isLongerThan("JavaScript", 5));   
console.log(isLongerThan("hi", 5));              