package com.avengers.bruce.Algorithm.basic.DP.CoinChange;

import com.avengers.bruce.Algorithm.util.Matrix;

import java.util.Arrays;

public class Solution {

    private static long change2(int[] coins, int money) {

        long[] DP = new long[money + 1];    // O(N) space.
        DP[0] = (long) 1;                   // n == 0 case.

        for (int coin : coins) {
            for (int j = coin; j < DP.length; j++) {
                DP[j] += DP[j - coin];      // The only tricky step.
            }
        }
        System.out.println(Arrays.toString(DP));
        return DP[money];
    }

    private static long change1(int[] coins, int money) {

        long[][] dp = new long[coins.length + 1][money + 1];

        for (int i = 1; i < coins.length + 1; i++) {
            dp[i][0] = 1;                   // first column equals 1
            int coin = coins[i - 1];
            for (int j = 1; j < money + 1; j++) {
                if(j - coin<0){             // coin > j
                    dp[i][j] += dp[i - 1][j];
                }else {
                    dp[i][j] += dp[i - 1][j] + dp[i][j - coin];
                }
            }
        }
        Matrix.print(dp);
        return dp[coins.length][money];
    }

    public static void main(String[] args) {

        int[] coins = {2, 5, 3, 6};
        int money = 10;

        long r1 = change1(coins, money);
        // 0 0 0 0 0 0 0 0 0 0 0
        // 1 0 1 0 1 0 1 0 1 0 1
        // 1 0 1 0 1 1 1 1 1 1 2
        // 1 0 1 1 1 2 2 2 3 3 4
        // 1 0 1 1 1 2 3 2 4 4 5
        System.out.println(r1); // 5

        long r2 = change2(coins, money);
        //[1,0,1,1,1,2,3,2,4,4,5]
        System.out.println(r2); // 5

        int[] coins1 = {2, 5, 10, 50};
        int money1 = 500;

        long r3 = change2(coins1, money1);
        System.out.println(r3); // 5236

    }

}
