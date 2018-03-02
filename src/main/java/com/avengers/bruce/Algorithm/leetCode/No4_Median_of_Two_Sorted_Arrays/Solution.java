package com.avengers.bruce.Algorithm.leetCode.No4_Median_of_Two_Sorted_Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] A = {3, 5, 6, 7, 8, 13};
        int[] B = {2, 3, 5, 19};
        double result = new Solution().findMedianSortedArrays(A, B);
        System.out.println(result);
    }

    private double findMedianSortedArrays(int[] A, int[] B) {
        int al = A.length;
        int bl = B.length;

        if (al > bl) { // to ensure al<=bl
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = al;
            al = bl;
            bl = tmp;
        }

        int iMin = 0, iMax = al, halfLen = (al + bl + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((al + bl) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == al) {
                    minRight = B[j];
                } else if (j == bl) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
