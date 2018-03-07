package com.avengers.bruce.Algorithm.basic.DataStructure.Graph.code;


public class Test {

    public static void main(String args[]){

        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
                {'A', 'C', '1'},
                {'A', 'D', '1'},
                {'A', 'F', '1'},
                {'B', 'C', '1'},
                {'C', 'D', '1'},
                {'E', 'G', '1'},
                {'D', 'G', '1'},
                {'I', 'J', '1'},
                {'J', 'G', '1'},
                {'H', 'G', '1'},
                {'H', 'K', '1'}
        };

        Graph graph = new Graph(vertexes,edges);
        graph.genUnDigraph();

        System.out.println("DFS by stack way:");
        DFS.dfsNonRecursive(graph);
        System.out.println("DFS by recursive way:");
        DFS.dfsRecursive(graph);

        System.out.println("BFS:");
        BFS.bfsNonRecursive(graph);

    }
}
