package com.avengers.bruce.Algorithm.basic.DC.OrderStatistic;

import com.avengers.bruce.Algorithm.basic.DC.OrderStatistic.RandomPivot.OrderStatistic;

import java.util.Arrays;

public class Main {

    public static void main(String[] args){


        int[] arr = {
            80, 1 , 17, 51, 57,
            49, 35, 11, 25, 37,
            14, 3 , 2 , 13, 52,
            12, 6 , 29, 32, 54,
            50, 16, 22, 23, 30
        };

        //2 , 3 , 5 , 6 , 7 , 8 , 11, 12, 13, 14, 16, 17, 22,
        //23, 25, 29, 32, 33, 35, 37, 49, 51, 52, 54, 57

        int K = 7;

        System.out.println(OrderStatistic.select(arr,0,arr.length-1,K));
        System.out.println(Arrays.toString(arr));

        //[7, 5, 6, 2, 3, 8, 11, 12, 25, 23, 14, 22, 16, 13, 17, 29, 32, 33, 35, 54, 51, 52, 57, 49, 37]
        // 5,12,16,33,51

        //0-9
        //[7, 12, 5, 6, 2, 8, 11, 3, 14, 13, 16]

        System.out.println(com.avengers.bruce.Algorithm.basic.DC.OrderStatistic.BFPRT.OrderStatistic.BFPTR(arr,0,arr.length-1,K));
        System.out.println(Arrays.toString(arr));



    }

}
