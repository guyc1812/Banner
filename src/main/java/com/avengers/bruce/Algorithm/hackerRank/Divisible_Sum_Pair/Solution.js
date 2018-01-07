let test = [1, 1, 1];
let target = 2;

let pair = 0;

for (let i = 0; i < test.length; i++) {
    for (let j = i + 1; j < test.length; j++) {
        if (test[i] + test[j] === target) {
            pair++;
        }
    }
}

console.log(pair);