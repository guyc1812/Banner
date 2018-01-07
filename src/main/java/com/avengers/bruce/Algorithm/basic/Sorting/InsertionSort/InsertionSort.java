package com.avengers.bruce.Algorithm.basic.Sorting.InsertionSort;

import java.util.Arrays;

public class InsertionSort {

    private static void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            int key = array[i];

            for (int j = i - 1; j >= 0; j--) {

                if (array[j] > key) {

                    array[j + 1] = array[j];
                    array[j] = key;

                }

            }

        }

    }


    public static void main(String[] args) {

        int[] array = {3, 9, 10, 2, 7, 8, 6};

        sort(array);

        System.out.println(Arrays.toString(array));

    }


}
