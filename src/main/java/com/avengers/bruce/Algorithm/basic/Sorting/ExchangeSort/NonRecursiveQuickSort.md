# Quick Sort non Recursive

* **Stability**
    
    NO

* **Complexity**

    O(nlog(n))
    
* **Demonstration**

    ```bash
    init array :                    [1, 3, 9, 10, 2, 7, 8, 6 ]
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
        LinkedList<Integer> stack = new LinkedList<>();
        if (start < end) {
            stack.push(end);
            stack.push(start);
            while (!stack.isEmpty()) {
                int l = stack.pop();
                int r = stack.pop();
                int index = partition(a, l, r);
                if (l < index - 1) {
                    stack.push(index - 1);
                    stack.push(l);
                }
                if (r > index + 1) {
                    stack.push(r);
                    stack.push(index + 1);
                }
            }
        }
    }
    ```
    
    ```java
    private static int partition(int[] a, int start, int end) {

        int pivot = a[start];
        while (start < end) {
            while (start < end && a[end] >= pivot)
                end--;
            a[start] = a[end];
            while (start < end && a[start] <= pivot)
                start++;
            a[end] = a[start];
        }
        a[start] = pivot;

        return start;
      
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