# Shell Sort

* **Stability**
    
    NO

* **Complexity**

    ```
    Average: O(nlog(n)) ~ O(n^2)<br>
    Best:    O(n^1.3)<br>
    Worst:   O(n^2)    
    ```
    
* **Demonstration**

    ```bash
    initial :  [1, 3, 9, 10, 2, 7, 8, 6 ]
    round 1 :  [1, 3, 9, 10, 2, 7, 8, 6 ]  key : 2   gap : 4
    round 2 :  [1, 3, 9, 10, 2, 7, 8, 6 ]  key : 7   gap : 4
    round 3 :  [1, 3, 8, 10, 2, 7, 9, 6 ]  key : 8   gap : 4
    round 4 :  [1, 3, 8, 6 , 2, 7, 9, 10]  key : 6   gap : 4
    round 5 :  [1, 3, 8, 6 , 2, 7, 9, 10]  key : 8   gap : 2
    round 6 :  [1, 3, 8, 6 , 2, 7, 9, 10]  key : 6   gap : 2
    round 7 :  [1, 3, 2, 6 , 8, 7, 9, 10]  key : 2   gap : 2
    round 8 :  [1, 3, 2, 6 , 8, 7, 9, 10]  key : 7   gap : 2
    round 9 :  [1, 3, 2, 6 , 8, 7, 9, 10]  key : 9   gap : 2
    round 10 : [1, 3, 2, 6 , 8, 7, 9, 10]  key : 10  gap : 2
    round 11 : [1, 3, 2, 6 , 8, 7, 9, 10]  key : 3   gap : 1
    round 12 : [1, 2, 3, 6 , 8, 7, 9, 10]  key : 2   gap : 1
    round 13 : [1, 2, 3, 6 , 8, 7, 9, 10]  key : 6   gap : 1
    round 14 : [1, 2, 3, 6 , 8, 7, 9, 10]  key : 8   gap : 1
    round 15 : [1, 2, 3, 6 , 7, 8, 9, 10]  key : 7   gap : 1
    round 16 : [1, 2, 3, 6 , 7, 8, 9, 10]  key : 9   gap : 1
    round 17 : [1, 2, 3, 6 , 7, 8, 9, 10]  key : 10  gap : 1
    ``` 
    
* **Implementation**
    
    ```java
    private static void shellSort(int[] arr) {
    
        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // Insertion Sort
                int key = arr[i];
                for (int j = i - gap; j >= 0; j=j-gap) {
                    if (arr[j] > key) {
                        arr[j + gap] = arr[j];
                        arr[j] = key;
                    }
                }
            }
        }
      
    }
    ```
    
    ```java
    public static void main(String[] args) {
        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }
  
    // [1, 2, 3, 6, 7, 8, 9, 10]
  
    ```