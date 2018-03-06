package com.avengers.bruce.Algorithm.basic.DataStructure.Graph.code;

public class Graph {

    private int      vexSize;   //size of vertexes
    private char[]   vertexes;  //name set of vertexes
    private char[][] edges;     //edges
    private int[][]  matrix;    //matrix of graph

    public Graph(char[] vertexes, char[][] edges) {
        this.vexSize = vertexes.length;
        this.vertexes = vertexes;
        this.edges = edges;
        matrix = new int[vexSize][vexSize];
    }

    public void genDigraph() {
        for (char[] c : edges) {
            int p1 = position(c[0]);
            int p2 = position(c[1]);
            int w = Integer.parseInt(String.valueOf(c[2]));
            matrix[p1][p2] = w;
        }
    }

    public void genUnDigraph() {
        for (char[] c : edges) {
            int p1 = position(c[0]);
            int p2 = position(c[1]);
            int w = Integer.parseInt(String.valueOf(c[2]));
            matrix[p1][p2] = w;
            matrix[p2][p1] = w;     // symmetrical
        }
    }

    public void print() {
        System.out.println("\n");
        System.out.print("*\t");
        for (char v : vertexes) {
            System.out.print(v + "\t");
        }
        System.out.println("\n");
        int i = 0;
        for (int[] m : matrix) {
            System.out.print(vertexes[i++] + "\t");
            for (int j = 0; j < vexSize; j++) {
                System.out.print(m[j] + "\t");
            }
            System.out.println("\n");
        }
    }


    private int position(char ch) {
        return ch - 65;
    }


}