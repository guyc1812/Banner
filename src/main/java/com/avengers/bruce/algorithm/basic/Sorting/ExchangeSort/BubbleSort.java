package com.avengers.bruce.algorithm.basic.Sorting.ExchangeSort;


import java.util.Arrays;

public class BubbleSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void bubbleSort(int a[]) {

        int len = a.length;
        int exchange;

        for (int i = 0; i < len - 1; i++) {

            exchange = 0;

            for (int j = len - 1; j > i; j--) {

                if (a[j] > a[j - 1]) {
                    swap(a, j, j - 1);
                    exchange = 1;
                }
            }

            if (exchange == 0) return;
        }
    }

    public static void main(String[] args) {

        int[] array = {3, 9, 10, 2, 7, 8, 6};

        bubbleSort(array);

        System.out.println(Arrays.toString(array));

    }

}
