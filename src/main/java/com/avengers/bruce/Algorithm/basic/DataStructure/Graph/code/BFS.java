package com.avengers.bruce.Algorithm.basic.DataStructure.Graph.code;

import java.util.LinkedList;

public class BFS {

    public static void bfsNonRecursive(Graph g) {

        //initiate the visited array -> all false
        int vexSize = g.getVexSize();
        boolean[] visited = new boolean[vexSize];
        for (int i = 0; i < vexSize; i++) visited[i] = false;

        //use queue
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < vexSize; i++) {
            if (!visited[i]) {
                queue.addFirst(i);  //start with node 0
                while (!queue.isEmpty()) {
                    //traverse at node 'cur'
                    int cur = queue.removeFirst();
                    if (!visited[cur]) {
                        visit(g, visited, cur);
                        //find all nodes connected to node cur but not be visited
                        for (int j = 0; j < g.getVexSize(); j++) {
                            if (g.getMatrix()[cur][j] >= 1 && !visited[j]) {
                                //add all the connected but not be visited node to queue
                                queue.addLast(j);
                            }
                        }
                    }
                }
                System.out.print("END\n");
            }
        }

    }

    private static void visit(Graph g, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(g.getVertexes()[i] + " -> "); //visit
    }

}
