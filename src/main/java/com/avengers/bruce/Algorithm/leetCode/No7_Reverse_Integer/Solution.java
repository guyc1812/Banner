package com.avengers.bruce.Algorithm.leetCode.No7_Reverse_Integer;

public class Solution {

    private static int reverse(int x) {

        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;

    }

    public static void main(String[] args) {

        int result = reverse(1534236469);
        System.out.println(result);
        // 0

        int result2 = reverse(1534236461);
        System.out.println(result2);
        // 1646324351
    }
}
