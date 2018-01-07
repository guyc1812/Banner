let coins = [2, 5, 3, 6];
let money = 10;


let dp = new Array(coins.length + 1).fill(0);
for (let o in dp) {
    dp[o] = new Array(money + 1).fill(0);
}


for (let i = 1; i < coins.length + 1; i++) {
    dp[i][coins[i - 1]] = dp[i - 1][coins[i - 1]] + 1;
    for (let j = 1; j < money + 1; j++) {
        dp[i][j] += dp[i - 1][j] + dp[i][(j - coins[i - 1]) >= 0 ? (j - coins[i - 1]) : 0];
    }
}

console.log(dp);