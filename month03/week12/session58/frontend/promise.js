console.log("javascript promise");
const myState = false;
const myPromise = new Promise((resolve, reject) => {
    if (myState) {
        resolve("success");
    } else {
        reject("error");
    }
});


myPromise
    .then((data) => {
        console.log(data);
    }).catch((error) => {
        console.log(error);
    });
console.log(myPromise);
// ex1 ===================================================================
const myState2 = false;
const myColor = new Promise((resolve, reject) => {
    if (myState2) {
        resolve("green");
    } else {
        reject("red");
    }
});

myColor
    .then((data) => {
        console.log(data);
    }).catch((error) => {
        console.log(error);
    });
console.log(myColor);
// ex2 ====================================================================
const delayedReward = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("42");
    }, 500);
});

delayedReward.then((data) => console.log(data));
// ex3 =====================================================================
const number = 15;
const guestNumber = new Promise((resolve, reject) => {
    setTimeout(() => {
        if (number > 10) {

            resolve("success!");
        } else if (number < 10) {
            reject("number too small");
        }
    }, 1000);

});

guestNumber
    .then((data) => {
        console.trace(data);
    }).catch((error) => {
        console.warn(error);
    });
console.log(guestNumber);
// ex4 ======================================================================
const numbers = Math.random();
const flipcoin = new Promise((resolve, reject) => {
    setTimeout(() => {
        if (numbers > 0.5) {
            resolve("head!");
        } else {
            reject("tails");
        }
    }, 1500);
});

flipcoin.then((data) => {
    console.log(data);
}).catch((error) => {
    console.warn(error);
});

