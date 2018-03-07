package com.avengers.bruce.Algorithm.util;

public class Swap {

    public static void run(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
