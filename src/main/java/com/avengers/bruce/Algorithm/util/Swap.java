package com.avengers.bruce.Algorithm.util;

import com.avengers.bruce.Algorithm.basic.DataStructure.List.code.ListNode;

public class Swap {

    public static void run(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void run(int i, int j) {
        System.out.println("i before: " + i);
        System.out.println("j before: " + j);
        int temp = i;
        i = j;
        j = temp;
        System.out.println("i after: " + i);
        System.out.println("j after: " + j);
    }

    public static void run(ListNode i, ListNode j) {
        System.out.println("i before: " + i.toString());
        System.out.println("j before: " + j.toString());
        ListNode temp = i;
        i = j;
        j = temp;
        System.out.println("i after: " + i.toString());
        System.out.println("j after: " + j.toString());
    }

}
