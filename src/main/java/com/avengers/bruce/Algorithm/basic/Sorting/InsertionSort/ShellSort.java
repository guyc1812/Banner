package com.avengers.bruce.Algorithm.basic.Sorting.InsertionSort;

import java.util.Arrays;

public class ShellSort {

    private static void shellSort(int[] arr) {

        int time = 1;

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

                System.out.println("round "+ time++ +" : "+Arrays.toString(arr)+"  key : "+key+"  gap : "+gap);

            }

        }

    }

    public static void main(String[] args) {

        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};

        shellSort(array);

        System.out.println(Arrays.toString(array));

    }


}
