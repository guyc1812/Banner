package com.avengers.bruce.Algorithm.basic.DataStructure.Graph.code;


public class Test {

    public static void main(String args[]){

        char[] vertexes = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
                {'A', 'C', '8'},
                {'A', 'D', '8'},
                {'A', 'F', '8'},
                {'B', 'C', '8'},
                {'C', 'D', '8'},
                {'E', 'G', '8'},
                {'D', 'G', '8'},
                {'I', 'J', '8'},
                {'J', 'G', '8'}
        };

        Graph graph = new Graph(vertexes,edges);
        graph.print();
        graph.genDigraph();
        graph.print();
        graph.genUnDigraph();
        graph.print();

    }
}
