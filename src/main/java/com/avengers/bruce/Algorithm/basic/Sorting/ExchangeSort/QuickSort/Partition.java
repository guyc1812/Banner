package com.avengers.bruce.Algorithm.basic.Sorting.ExchangeSort.QuickSort;

import com.avengers.bruce.Algorithm.util.Swap;

import java.util.Arrays;

public class Partition {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static public int way1(int[] a, int start, int end) {

        int pivot = a[end];
        int i = start - 1;    // i marks the position of the number which is greater than pivot

        for (int j = start; j <= end - 1; j++) {

            if (a[j] <= pivot) {  // find number which is less than pivot from left to right
                if (j != i + 1) {
                    swap(a, ++i, j);
                } else {
                    i++;
                }
            }

        }

        Swap.run(a, i + 1, end);

        return i + 1;

    }

    static public int way2(int[] a, int start, int end) {

        int l = start;
        int r = end;

        int pivot = a[start];

        while (l < r) {

            while (l < r && a[r] >= pivot) r--;
            a[l] = a[r];

            while (l < r && a[l] <= pivot) l++;
            a[r] = a[l];

        }

        a[l] = pivot;

        return l;

    }
}
