let test = ["eat", "tea", "tan", "ate", "nat", "bat"];
let tmp = {};
for (let s of test) {
    let tmpArrs = s.split("");
    tmpArrs.sort();
    let parsed = tmpArrs.join("");
    if (tmp[`${parsed}`]) {
        tmp[`${parsed}`].push(s);
    } else {
        tmp[`${parsed}`] = Array(s);
    }
}
let result = [];
for (let o in tmp) {
    result.push(tmp[o]);
}

console.log(result);