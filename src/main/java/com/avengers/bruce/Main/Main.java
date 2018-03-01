package com.avengers.bruce.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static private String mergeHelper(List<String> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        String left = mergeHelper(lists, start, mid);
        String right = mergeHelper(lists, mid + 1, end);

        System.out.println("left: "+left+" right: "+right);

        return left + right;
    }


    public static void main(String[] args) {

        String[] a = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
        List<String> l = new ArrayList<>(Arrays.asList(a));

        mergeHelper(l,0,8);

        // left: 0      right: 1
        // left: 01     right: 2
        // left: 3      right: 4
        // left: 012    right: 34
        // left: 5      right: 6
        // left: 7      right: 8
        // left: 56     right: 78
        // left: 01234  right: 5678



    }
}
