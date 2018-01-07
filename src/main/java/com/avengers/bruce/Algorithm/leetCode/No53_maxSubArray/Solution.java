package com.avengers.bruce.Algorithm.leetCode.No53_maxSubArray;

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

        return max;

    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, -3, -2, 5, 1};
        int result = maxSubArray(a);
        System.out.println(result);

    }

}
