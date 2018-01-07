package com.avengers.bruce.Algorithm.basic.Sorting;

import java.util.Arrays;


public class MergeSort {

    private static void sort(int[] array, int start, int end) {

        if (start >= end || array == null) return;

        int mid = (start + end) / 2;

        sort(array, start, mid);
        sort(array, mid + 1, end);

        merge(array, start, mid, end);

    }

    private static void merge(int[] array, int start, int mid, int end) {

        int[] tmp = new int[end - start + 1];

        for (int i = start, j = mid + 1, k = 0; i <= mid || j <= end; k++) {

            int lCur = Integer.MAX_VALUE;
            int rCur = Integer.MAX_VALUE;

            if (i <= mid) {
                lCur = array[i];
            }
            if (j <= end) {
                rCur = array[j];
            }

            if (lCur < rCur) {
                tmp[k] = lCur;
                i++;
            } else {
                tmp[k] = rCur;
                j++;
            }

        }

        System.arraycopy(tmp, 0, array, start, tmp.length);

    }


    public static void main(String[] args) {

        int[] array = {3, 9, 10, 2, 7, 8, 6};

        sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));

    }


}
