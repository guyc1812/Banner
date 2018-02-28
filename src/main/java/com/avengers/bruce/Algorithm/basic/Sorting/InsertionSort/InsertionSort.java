package com.avengers.bruce.Algorithm.basic.Sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

    private static void insertionSort(int[] array) {

        int time = 1;

        for (int i = 1; i < array.length; i++) {

            int key = array[i];

            for (int j = i - 1; j >= 0; j--) {
                if (key < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = key;
                }
            }

            System.out.println("round "+ time++ +" : "+Arrays.toString(array)+"  key : "+key);

        }

    }


    public static void main(String[] args) {

        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};

        insertionSort(array);

        System.out.println(Arrays.toString(array));

    }


}
