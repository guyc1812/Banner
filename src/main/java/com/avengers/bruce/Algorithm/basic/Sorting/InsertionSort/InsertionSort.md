# Insertion Sort

* **Stability**
    
    YES

* **Complexity**

    Average: O(n^2)<br>
    Best:    O(n)<br>
    Worst:   O(n^2) 
    
* **Demonstration**

    ```bash
    initial : [1, 3, 9, 10, 2 , 7 , 8,  6 ]
    round 1 : [1, 3, 9, 10, 2 , 7 , 8,  6 ]  key : 3
    round 2 : [1, 3, 9, 10, 2 , 7 , 8,  6 ]  key : 9
    round 3 : [1, 3, 9, 10, 2 , 7 , 8,  6 ]  key : 10
    round 4 : [1, 2, 3, 9 , 10, 7 , 8,  6 ]  key : 2
    round 5 : [1, 2, 3, 7 , 9 , 10, 8,  6 ]  key : 7
    round 6 : [1, 2, 3, 7 , 8 , 9 , 10, 6 ]  key : 8
    round 7 : [1, 2, 3, 6 , 7 , 8 , 9 , 10]  key : 6
    ``` 
    
* **Implementation**
    
    ```java
    private static void insertionSort(int[] array) {
    
        for (int i = 1; i < array.length; i++) {

            int key = array[i];

            for (int j = i - 1; j >= 0; j--) {
                if (key < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = key;
                }
            }

        }

    }
    ```
    
    ```java
    public static void main(String[] args) {
        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
  
    // [1, 2, 3, 6, 7, 8, 9, 10]
  
    ```