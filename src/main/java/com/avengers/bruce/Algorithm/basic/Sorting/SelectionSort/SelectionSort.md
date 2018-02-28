# Selection Sort


* **Stability**
    
    NO
    
* **Complexity**

    Average: O(n^2)<br>
    Best:    O(n^2)<br>
    Worst:   O(n^2)

* **Demonstration**

    ```bash
    initial : [1 , 3, 9, 10, 2, 7, 8, 6]
    round 1 : [10, 3, 9, 1,  2, 7, 8, 6]
    round 2 : [10, 9, 3, 1,  2, 7, 8, 6]
    round 3 : [10, 9, 8, 1,  2, 7, 3, 6]
    round 4 : [10, 9, 8, 7,  2, 1, 3, 6]
    round 5 : [10, 9, 8, 7,  6, 1, 3, 2]
    round 6 : [10, 9, 8, 7,  6, 3, 1, 2]
    round 7 : [10, 9, 8, 7,  6, 3, 2, 1]
    round 8 : [10, 9, 8, 7,  6, 3, 2, 1]
    ``` 
    
* **Implementation**

    ```java
    private static void selectionSort(int a[]) {
    
        for (int pos = 0; pos < a.length; pos++) {
    
            int max = a[pos];
            int maxPos = pos;
    
            for (int j = pos + 1; j < a.length; j++) {
    
                if (a[j] > max) {
                    max = a[j];
                    maxPos = j;
                }
            }
    
            a[maxPos] = a[pos];
            a[pos] = max;
    
        }
    }
    ```
    
    ```java
    public static void main(String[] args) {
        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
  
    // [1, 2, 3, 6, 7, 8, 9, 10]
    
    ```