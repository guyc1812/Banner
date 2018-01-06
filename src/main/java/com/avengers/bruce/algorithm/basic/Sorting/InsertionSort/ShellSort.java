package com.avengers.bruce.algorithm.basic.Sorting.InsertionSort;

import java.util.Arrays;

public class ShellSort {

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void shellSort(int[] arr) {


        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {

                // Insertion Sort
                int key = arr[i];

                for (int j = i - gap; j >= 0; j=j-gap) {

                    if (arr[j] > key) {

                        arr[j + gap] = arr[j];
                        arr[j] = key;

                    }

                }


            }

        }


    }

    public static void main(String[] args) {

        int[] array = {3, 9, 10, 2, 7, 8, 6};

        shellSort(array);

        System.out.println(Arrays.toString(array));

    }


}
