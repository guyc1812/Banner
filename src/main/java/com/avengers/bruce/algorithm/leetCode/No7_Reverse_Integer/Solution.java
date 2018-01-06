package com.avengers.bruce.algorithm.leetCode.No7_Reverse_Integer;

public class Solution {

    private static int reverse(int x) {

        // StringBuilder sb = new StringBuilder();
        //
        // try{
        //
        //     if(x>=0){
        //         sb.append(x).reverse();
        //     }else {
        //         sb.append("-");
        //         StringBuilder sbb = new StringBuilder();
        //         sb.append(sbb.append(-x).reverse().toString());
        //     }
        //
        //     return Integer.parseInt(sb.toString());
        //
        // }catch(Exception e){
        //     return 0;
        // }

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

    }
}
