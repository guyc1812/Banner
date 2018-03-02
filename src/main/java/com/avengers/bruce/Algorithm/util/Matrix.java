package com.avengers.bruce.Algorithm.util;

public class Matrix {

    static public void print(int[][] matrix){

        int col = matrix[0].length;

        System.out.println("\n");

        for (int[] m : matrix) {
            for (int j = 0; j < col; j++) {
                System.out.print(m[j] + " ");
            }
            System.out.println("\n");
        }

    }

    static public void print(String[][] matrix){

        int col = matrix[0].length;

        System.out.println("\n");

        for (String[] m : matrix) {
            for (int j = 0; j < col; j++) {
                System.out.print(m[j] + " ");
            }
            System.out.println("\n");
        }

    }

    static public void print(long[][] matrix){

        int col = matrix[0].length;

        System.out.println("\n");

        for (long[] m : matrix) {
            for (int j = 0; j < col; j++) {
                System.out.print(m[j] + " ");
            }
            System.out.println("\n");
        }

    }


}
