# Graph Matrix

* **Graph.java**

    ```java
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
    }
    ```

* **Test**

    ```java
    public static void main(String args[]){
    
        char[] vertexes = {
                'A', 'B', 'C', 'D', 'E', 
                'F', 'G', 'H', 'I', 'J', 'K'
        };
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
        graph.print();        // All Zero
        graph.genDigraph();
        graph.print();
        graph.genUnDigraph();
        graph.print();
    }
    ```
    
    **Graph Shape**
    
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

    **Directed Graph Matrix**
    
    ```bash
    *	A	B	C	D	E	F	G	H	I	J	K
    
    A	0	0	1	1	0	1	0	0	0	0	0
    
    B	0	0	1	0	0	0	0	0	0	0	0
    
    C	0	0	0	1	0	0	0	0	0	0	0
    
    D	0	0	0	0	0	0	1	0	0	0	0
    
    E	0	0	0	0	0	0	1	0	0	0	0
    
    F	0	0	0	0	0	0	0	0	0	0	0
    
    G	0	0	0	0	0	0	0	0	0	0	0
    
    H	0	0	0	0	0	0	1	0	0	0	1
    
    I	0	0	0	0	0	0	0	0	0	1	0
    
    J	0	0	0	0	0	0	1	0	0	0	0
    
    K	0	0	0	0	0	0	0	0	0	0	0
    ```
    
    **UnDirected Graph Matrix (Symmetry)**
    
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
