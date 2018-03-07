package com.avengers.bruce.Algorithm.basic.DC.OrderStatistic.BFPRT;

import com.avengers.bruce.Algorithm.util.Swap;

import java.util.Arrays;

public class OrderStatistic {


    static public int BFPTR(int arr[], int from, int to, int k) {

        findMid(arr, from, to);             //find median as pivot
        int q = partition(arr, from, to);   //position of pivot in sorted array

        // compare with the k
        int i = q - from + 1;

        int result;

        if (k == i) {
            result = arr[q];
        } else if (k < i) {
            result = BFPTR(arr, from, q - 1, k);
        } else {
            result = BFPTR(arr, q + 1, to, k - i);
        }

        System.out.println(Arrays.toString(arr));
        return result;

    }

    static private void findMid(int arr[], int from, int to) {

        int p = to - from + 1;
        int q = p / 5;
        int remainder = p - q * 5;

        //swap all the median to the beginning of the array
        //this is for partition -> pick 'from' as pivot
        int t = from;

        if (p < 6) {    //from 0 to 5
            insertionSort(arr, from, to);   //sort
            // median is at position(from + (p-1)/2)
            // then swap it to the first place
            Swap.run(arr, t, from + (p - 1) / 2);
            return;
        } else {
            // each group contains five elements
            // find median of every group
            // swap them to the beginning of the array
            for (int i = 0; i < q; i++) {
                insertionSort(arr, from + 5 * i, from + i * 5 + 4);
                Swap.run(arr, t, from + i * 5 + 2);
                t++;
            }
            // handle the remainder
            if (remainder > 0) {
                insertionSort(arr, from + 5 * q, from + 5 * q + remainder - 1);
                Swap.run(arr, t, from + q * 5 + remainder / 2);
                t++;
            }
        }
        //recursive call
        findMid(arr, from, t - 1);
    }

    static private int partition(int arr[], int from, int to) {

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

    //[l,r]
    private static void insertionSort(int[] array, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int key = array[i];
            for (int j = i - 1; j >= l; j--) {
                if (key < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = key;
                }
            }
        }
    }

}
