# Coin Change

* **Question**

    Given a number of dollars **n**, <br>
    and a list of dollar values for **m** distinct coins, **C = {c1, c2, ..., Cm-1}**, <br>
    find and print the number of different ways you can make change for **n** dollars <br>
    if each coin is available in an infinite quantity.<br>
    
* **Example**

    For **n=4** and **C = {1,2,3}** there are four solutions:
    
    1.{1,1,1,1}<br>
    2.{1,1,2}<br>
    3.{2,2}<br>
    4.{1,3}
    
    So the solution is **4**
    
* **Demonstration**

    |coin\money|   j   | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
    |:--------:|:-----:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:| 
    |  i       |   0   | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0  |
    |  2       |   0   | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1 | 0 | 1  |
    |  5       |   0   | 0 | 1 | 0 | 1 | 1 | 1 | 1 | 1 | 1 | 2  |
    |  3       |   0   | 0 | 1 | 1 | 1 | 2 | 2 | 2 | 3 | 3 | 4  |
    |  6       |   0   | 0 | 1 | 1 | 1 | 2 | 5 | 2 | 4 | 4 | 5  |
    
* **Solution**

    ```javascript
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
    //   [ [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ],
    //     [ 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 ],
    //     [ 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 2 ],
    //     [ 0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4 ],
    //     [ 0, 0, 1, 1, 1, 2, 5, 2, 4, 4, 5 ] ]
    ```