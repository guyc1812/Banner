# DFS (Depth First Search)

## **Graph Shape**
    
```bash
            B
            |
    F - A - C
        |   |
        D --|
        |
    E - G - J - I
        |
        H
        |
        K 
```

## **UnDirected Graph Matrix (Symmetry)**

```bash
*	A	B	C	D	E	F	G	H	I	J	K

A	0	0	1	1	0	1	0	0	0	0	0

B	0	0	1	0	0	0	0	0	0	0	0

C	1	1	0	1	0	0	0	0	0	0	0

D	1	0	1	0	0	0	1	0	0	0	0

E	0	0	0	0	0	0	1	0	0	0	0

F	1	0	0	0	0	0	0	0	0	0	0

G	0	0	0	1	1	0	0	1	0	1	0

H	0	0	0	0	0	0	1	0	0	0	1

I	0	0	0	0	0	0	0	0	0	1	0

J	0	0	0	0	0	0	1	0	1	0	0

K	0	0	0	0	0	0	0	1	0	0	0
```
    
## DFS Algorithm

* **Non Recursive way (use stack)**

    ```java
    public static void dfsNonRecursive(Graph g) {

        //initiate the visited array -> all false
        int vexSize = g.getVexSize();
        boolean[] visited = new boolean[vexSize];
        for (int i = 0; i < vexSize; i++) visited[i] = false;

        //use stack to simulate recursion
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = 0; i < vexSize; i++) {
            if (!visited[i]) {
                stack.push(i);    //start with node 0
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
    ```

    ```java
    private static void visit(Graph g, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(g.getVertexes()[i] + " -> "); //visit
    }
    ```

* **Recursive way**

    ```java
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
    ```

    ```java
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
    ```

    ```java
    private static void visit(Graph g, boolean[] visited, int i) {
        visited[i] = true;
        System.out.print(g.getVertexes()[i] + " -> "); //visit
    }
    ```

* **DFS Test**
    
    ```java
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
      
    }
    ```

    ```bash
    DFS by stack way:
    A -> F -> D -> G -> J -> I -> H -> K -> E -> C -> B -> END
    
    DFS by recursive way:
    A -> C -> B -> D -> G -> E -> H -> K -> J -> I -> F -> END
    ```
