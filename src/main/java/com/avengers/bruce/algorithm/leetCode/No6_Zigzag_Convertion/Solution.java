package com.avengers.bruce.algorithm.leetCode.No6_Zigzag_Convertion;

public class Solution {

    private static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        } else {
            int column = s.length();

            char[][] z = new char[numRows][column];

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {

                int baseCol = (i / (2 * numRows - 2)) * (numRows - 1);
                int extra = i % (2 * numRows - 2);

                if (extra < numRows) {
                    z[extra][baseCol] = s.charAt(i);
                } else {
                    z[2 * numRows - 2 - extra][baseCol + extra - numRows + 1] = s.charAt(i);
                }

            }

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < column; j++) {
                    if (z[i][j] != '\0') {
                        sb.append(z[i][j]);
                    }
                }
            }

            return sb.toString();

        }


    }

    public static void main(String[] arg) {
        String str = "PAYPALISHIRING";
        int numRows = 2;
        String output = convert(str, numRows);
        System.out.print(output);
        //PAHNAPLSIIGYIR
    }

}
