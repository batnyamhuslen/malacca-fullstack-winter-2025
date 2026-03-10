const storeName = "iCode Cafe";
const items = ["Coffee", "Muffin", "Water"];
const prices = [4.5, 3.0, 1.5];

function printReceipt(storeName, items, prices) {
    console.log(storeName);
    let total = 0;
    for(let i =0; i<items.length; i++){
        console.log(items[i] + "-$"+prices[i]);
        total+=prices[i];
    }
    console.log("Total: $"+total);
}

printReceipt(storeName,items,prices);