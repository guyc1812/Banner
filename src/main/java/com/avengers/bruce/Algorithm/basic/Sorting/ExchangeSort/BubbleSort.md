# Bubble Sort

* **Stability**
    
    YES when `if (a[j] > a[j - 1])` <br>
    NO  when `if (a[j] >= a[j - 1])`

* **Complexity**

    ```
    Average: O(n^2)<br>
    Best:    O(n)<br>
    Worst:   O(n^2) 
    ```
    
    Case 1. O(n) (Best case)<br> 
    If the array is already sorted, and that means that no swap occurred and only 1 iteration of n elements.
       
    Case 2. O(n^2) (Worst case)<br> 
    If the array is already sorted but in descending order. <br> 
    This means that in the first iteration it would have to look at n elements, <br> 
    then after that it would look n - 1 elements.<br> 
    O = n + n - 1 + n - 2 ... + 1 = (n*(n + 1))/2 = O(n^2)
    
* **Demonstration**

    ```bash
    initial : [3,  9, 10, 2, 7, 8, 6]
    round 1 : [10, 3, 9 , 8, 2, 7, 6]
    round 2 : [10, 9, 3 , 8, 7, 2, 6]
    round 3 : [10, 9, 8 , 3, 7, 6, 2]
    round 4 : [10, 9, 8 , 7, 3, 6, 2]
    round 5 : [10, 9, 8 , 7, 6, 3, 2]
    ``` 
    
* **Implementation**
    
    ```java
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    ```
    
    ```java
    private static void bubbleSort(int a[]) {

        int len = a.length;
        boolean exchange;     // a flag to optimize bubble sort

        for (int i = 0; i < len - 1; i++) {
            exchange = false;
            for (int j = len - 1; j > i; j--) {
                if (a[j] > a[j - 1]) {    // if (a[j] >= a[j - 1]) => unstable
                    swap(a, j, j - 1);
                    exchange = true;
                }
            }
            if (!exchange) return;
        }
    }
    ```
        
    ```java
    public static void main(String[] args) {
        int[] array = {3, 9, 10, 2, 7, 8, 6};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    // [10, 9, 8, 7, 6, 3, 2]
  
    ```