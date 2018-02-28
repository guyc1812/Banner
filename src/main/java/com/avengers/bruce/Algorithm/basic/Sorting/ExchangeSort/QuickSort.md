# Quick Sort

* **Stability**
    
    YES when `if (a[j] < pivot)` <br>
    NO  when `if (a[j] <= pivot)`

* **Complexity**

    Average: O(nlog(n))<br>
    Best:    O(nlog(n))<br>
    Worst:   O(n^2)
    
* **Demonstration**

    ```bash
    initial array :                 [1, 3, 9, 10, 2, 7, 8, 6 ]
    partition round 1 from 0 to 7 : [1, 3, 2, 6,  9, 7, 8, 10]  pivot : 6
    partition round 2 from 0 to 2 : [1, 2, 3, 6,  9, 7, 8, 10]  pivot : 2
    partition round 3 from 4 to 7 : [1, 2, 3, 6,  9, 7, 8, 10]  pivot : 10
    partition round 4 from 4 to 6 : [1, 2, 3, 6,  7, 8, 9, 10]  pivot : 8
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
    private static void quicksort(int[] a, int start, int end) {
    
        if (start >= end) return;

        int q = partition(a, start, end);
        quicksort(a, start, q - 1);
        quicksort(a, q + 1, end);

    }
    ```
        
    ```java
    private static int partition(int[] a, int start, int end) {
    
        int pivot = a[end];
        int i = start - 1;        // i marks the position of the number which is greater than pivot

        for (int j = start; j <= end - 1; j++) {
            if (a[j] <= pivot) {  // find number which is less than pivot from left to right
                if (j != i + 1) {
                    swap(a, ++i, j);
                } else {
                    i++;
                }
            }
        }

        swap(a, i + 1, end);
        
        return i + 1;

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