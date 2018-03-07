# BFS (Breadth First Search)

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
    
## BFS Algorithm

* **Non Recursive way (use queue)**

    ```java
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

        System.out.println("BFS:");
        BFS.bfsNonRecursive(graph);
      
    }
    ```

    ```bash
    BFS:
    A -> C -> D -> F -> B -> G -> E -> H -> J -> K -> I -> END
    ```