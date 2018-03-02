package com.avengers.bruce.Algorithm.basic.DP.CoinChange;

/*****
 * Created by apple on 2017/10/26.
 */
public class Solution {

    private static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long) 1;    // n == 0 case.
        for (int coin : coins) {
            for (int j = coin; j < DP.length; j++) {
                // The only tricky step.
                DP[j] += DP[j - coin];
            }
        }
        return DP[money];
    }

    private static long makeChange2(int[] coins, int money) {

        long[][] dp = new long[coins.length + 1][money + 1];

        for (int i = 1; i < coins.length + 1; i++) {
            dp[i][coins[i - 1]] = dp[i - 1][coins[i - 1]] + 1;
            for (int j = 1; j < money + 1; j++) {
                dp[i][j] += dp[i - 1][j] + dp[i][(j - coins[i - 1]) >= 0 ? (j - coins[i - 1]) : 0];
            }
        }

        for (int k = 0; k < coins.length + 1; k++) {
            for (int l = 0; l < money + 1; l++) {
                System.out.print(dp[k][l] + " ");
            }
            System.out.println();
        }

        return dp[coins.length][money];

    }

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 6};
        int v = 10;

        int[] b = {2, 5, 10, 50};
        int v2 = 500;

        long r1 = makeChange(b, v2);
        long r2 = makeChange2(a, v);
        System.out.println(r1);
        System.out.println(r2);
    }

}
