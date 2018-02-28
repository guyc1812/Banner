package com.avengers.bruce.Algorithm.basic.Sorting.ExchangeSort;

import java.util.Arrays;
import java.util.LinkedList;

public class NonRecursiveQuickSort {

    static int time = 1;

    private static void quickSort(int[] a, int start, int end) {
        LinkedList<Integer> stack = new LinkedList<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }

    private static int partition(int[] a, int start, int end) {

        int s = start;
        int e = end;

        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot)
                end--;
            a[start] = a[end];
            while (start < end && a[start] <= pivot)
                start++;
            a[end] = a[start];
        }
        a[start] = pivot;

        System.out.println("partition round "+ time++ +" from "+s+" to "+e+" : "+Arrays.toString(a)+"  pivot : "+pivot);

        return start;
    }

    public static void main(String[] args) {

        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};

        quickSort(array,0,7);

        System.out.println(Arrays.toString(array));

    }
}
