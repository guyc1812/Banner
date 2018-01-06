package com.avengers.bruce.algorithm.basic.Sorting.SelectionSort;

import java.util.Arrays;

public class HeapSort {

    //http://www.cnblogs.com/MOBIN/p/5374217.html

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void heapSort(int[] arr) {

        int len = arr.length;

        // Build heap
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapAdjust(arr, i, len);
        }
        // Sort
        for (int i = len - 1; i >= 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }

    }

    private static void heapAdjust(int[] arr, int i, int len) {

        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int cur = i;

        if (left < len && arr[left] > arr[cur]) {
            cur = left;
        }
        if (right < len && arr[right] > arr[cur]) {
            cur = right;
        }

        if (cur != i) {
            swap(arr, i, cur);
            heapAdjust(arr, cur, len);
        }

    }

    public static void main(String[] args) {

        int[] array = {3, 9, 10, 2, 7, 8, 6};

        heapSort(array);

        System.out.println(Arrays.toString(array));

    }

}
