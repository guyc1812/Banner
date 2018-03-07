package com.avengers.bruce.Algorithm.basic.DataStructure.Graph.code;

import java.util.LinkedList;

public class DFS {

    public static void dfsNonRecursive(Graph g) {

        //initiate the visited array -> all false
        int vexSize = g.getVexSize();
        boolean[] visited = new boolean[vexSize];
        for (int i = 0; i < vexSize; i++) visited[i] = false;

        //use stack to simulate recursion
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < vexSize; i++) {
            if (!visited[i]) {
                stack.push(i); //start with node 0
                while (!stack.isEmpty()) {
                    //traverse at node 'cur'
                    int cur = stack.pop();
                    if (!visited[cur]) {
                        visit(g, visited, cur);
                        //find all nodes connected to node cur but not be visited
                        for (int j = 0; j < g.getVexSize(); j++) {
                            if (g.getMatrix()[cur][j] >= 1 && !visited[j]) {
                                //go deep
                                stack.push(j);
                            }
                        }
                    }
                }
            System.out.print("END\n");
            }
        }

    }

    public static void dfsRecursive(Graph g) {

        // initiate the visited array -> all false
        int vexSize = g.getVexSize();
        boolean[] visited = new boolean[vexSize];
        for (int i = 0; i < vexSize; i++) visited[i] = false;

        // traverse all nodes if not be visited
        for (int i = 0; i < vexSize; i++) {
            if (!visited[i]) {
                traverse(g, visited, i);
                // if g is a connected graph, traverse once is enough
            }
        }
        System.out.print("END\n");
    }

    private static void traverse(Graph g, boolean[] visited, int i) {
        //visit node i
        visit(g, visited, i);
        //find all nodes connected to node i but not be visited
        for (int j = 0; j < g.getVexSize(); j++) {
            if (g.getMatrix()[i][j] >= 1 && !visited[j]) {
                //go deep
                traverse(g, visited, j);
            }
        }
    }

    private static void visit(Graph g, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(g.getVertexes()[i] + " -> "); //visit
    }

}
