package com.avengers.bruce.Algorithm.basic.DC.OrderStatistic.RandomPivot;

import java.util.Arrays;

public class OrderStatistic {

    static public int partition(int[] arr, int from, int to) {

        int pivot = arr[from];

        int l = from;
        int r = to;

        while (l < r) {

            while (l < r && arr[r] >= pivot) --r;
            arr[l] = arr[r];

            while (l < r && arr[l] <= pivot) ++l;
            arr[r] = arr[l];

        }

        arr[l] = pivot;
        return l;

    }

    static public int select(int[] arr, int from, int to, int k) {

        if (from == to) return arr[from];

        // position of pivot
        int q = partition(arr, from, to);

        // compare with the k
        int i = q - from + 1;

        int result;

        if (k == i) {
            result = arr[q];
        } else if (k < i) {
            result = select(arr, from, q - 1, k);
        } else {
            result = select(arr, q + 1, to, k - i);
        }

        System.out.println(Arrays.toString(arr));
        return result;

    }

}
