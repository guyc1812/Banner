let test = [1,3,2,6,1,2];
let target = 3;

let pair = 0;

for (let i = 0; i < test.length; i++) {
    for (let j = i + 1; j < test.length; j++) {
        if (test[i] + test[j] === target) {
            pair++;
        }
    }
}

console.log(pair);