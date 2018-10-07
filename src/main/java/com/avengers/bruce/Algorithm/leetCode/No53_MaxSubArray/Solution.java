package com.avengers.bruce.Algorithm.leetCode.No53_MaxSubArray;

import java.util.Arrays;

public class Solution {

    private static int maxSubArray(int[] a) {

        int[] dp = new int[a.length];
        dp[0] = a[0];
        int max = 0;

        for (int i = 1; i < a.length; i++) {

            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + a[i];
            } else {
                dp[i] = a[i];
            }

            max = Math.max(max, dp[i]);

        }

        System.out.println(Arrays.toString(dp));

        return max;

    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, -3, -2, 5, 1};
        // int[] dp = {1, 3, 6, 3, 1, 6, 7}
        int result1 = maxSubArray(a1);
        System.out.println(result1);    // 7
        int[] a2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        // int[] dp = {-2, 1, -2, 4, 3, 5, 6, 1, 5}
        int result2 = maxSubArray(a2);  // 6
        System.out.println(result2);
    }

}
