# Quick Sort non Recursive

* **Stability**
    
    NO

* **Complexity**

    ```
    Average: O(nlog(n))
    Best:    O(nlog(n))
    Worst:   O(n^2) 
    ```
    
* **Demonstration**

    ```bash
    initial array :                 [1, 3, 9, 10, 2, 7, 8, 6 ]
    partition round 1 from 0 to 7 : [1, 3, 9, 10, 2, 7, 8, 6 ]  pivot : 1
    partition round 2 from 1 to 7 : [1, 2, 3, 10, 9, 7, 8, 6 ]  pivot : 3
    partition round 3 from 3 to 7 : [1, 2, 3, 6 , 9, 7, 8, 10]  pivot : 10
    partition round 4 from 3 to 6 : [1, 2, 3, 6 , 9, 7, 8, 10]  pivot : 6
    partition round 5 from 4 to 6 : [1, 2, 3, 6 , 8, 7, 9, 10]  pivot : 9
    partition round 6 from 4 to 5 : [1, 2, 3, 6 , 7, 8, 9, 10]  pivot : 8
    ``` 
    
* **Implementation**
    
    ```java
    private static void quickSort(int[] a, int start, int end) {
    
        //use stack to simulate recursion
        LinkedList<Integer> stack = new LinkedList<>();
        
        if (start < end) {
          
            stack.push(end);
            stack.push(start);
            
            while (!stack.isEmpty()) {
            
                int l = stack.pop();
                int r = stack.pop();
                
                //point od division
                int index = partition(a, l, r);
                
                if (l < index - 1) {  //left part
                    stack.push(index - 1);
                    stack.push(l);
                }
                
                if (r > index + 1) {  //right part
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }
    ```

    ```java
    public static void main(String[] args) {
        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};
        quicksort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
  
    // [1, 2, 3, 6, 7, 8, 9, 10]
  
    ```