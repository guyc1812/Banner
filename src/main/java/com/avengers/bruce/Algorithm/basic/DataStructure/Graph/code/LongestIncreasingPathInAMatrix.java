package com.avengers.bruce.Algorithm.basic.DataStructure.Graph.code;

import com.avengers.bruce.Algorithm.util.Matrix;

public class LongestIncreasingPathInAMatrix {

    static private int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        if(m < 1) return 0;

        int[][] maxILen = new int[m][n];
        int max = 1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max, maxDFS(i,j,matrix,maxILen));
            }
        }

        Matrix.print(maxILen);
        return max;
    }

    static private int maxDFS(int i,int j,int[][]matrix,int[][] maxILen){

        int m = matrix.length;
        int n = matrix[0].length;

        if(maxILen[i][j] != 0) return maxILen[i][j];

        int max = 1;
        if(i+1 <  m && matrix[i+1][j] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i+1,j,matrix,maxILen));
        if(i-1 >= 0 && matrix[i-1][j] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i-1,j,matrix,maxILen));
        if(j+1 <  n && matrix[i][j+1] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i,j+1,matrix,maxILen));
        if(j-1 >= 0 && matrix[i][j-1] > matrix[i][j]) max = Math.max(max, 1 + maxDFS(i,j-1,matrix,maxILen));

        maxILen[i][j] = max;
        return max;

    }

    public static void main(String[] args){

        int[][] nums1 = {
            {9,9,4},
            {6,6,8},
            {2,1,1}
        };
        System.out.println(longestIncreasingPath(nums1));

        // 1 1 2
        // 2 2 1
        // 3 4 2

        // 4

        int[][] nums2 = {
            {3,4,5},
            {3,2,6},
            {2,2,1}
        };
        System.out.println(longestIncreasingPath(nums2));

        // 4 3 2
        // 1 4 1
        // 2 1 2

        // 4

    }
}
