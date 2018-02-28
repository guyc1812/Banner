# Merge Sort

* **Stability**
    
    YES
    
* **Complexity**

    Average: O(nlog(n))<br>
    Best:    O(nlog(n))<br>
    Worst:   O(nlog(n))
    
* **Demonstration**

    ```bash
    initial : [1, 3, 9, 10, 2, 7, 8, 6 ]
    round 1 : [1, 3, 9, 10, 2, 7, 8, 6 ] start: 0  mid: 0  end: 1
    round 2 : [1, 3, 9, 10, 2, 7, 8, 6 ] start: 2  mid: 2  end: 3
    round 3 : [1, 3, 9, 10, 2, 7, 8, 6 ] start: 0  mid: 1  end: 3
    round 4 : [1, 3, 9, 10, 2, 7, 8, 6 ] start: 4  mid: 4  end: 5
    round 5 : [1, 3, 9, 10, 2, 7, 6, 8 ] start: 6  mid: 6  end: 7
    round 6 : [1, 3, 9, 10, 2, 6, 7, 8 ] start: 4  mid: 5  end: 7
    round 7 : [1, 2, 3, 6 , 7, 8, 9, 10] start: 0  mid: 3  end: 7
    ```
    
* **Implementation**

    ```java
    private static void mergeSort(int[] array, int start, int end) {
    
        if (start >= end || array == null) return;

        int mid = (start + end) / 2;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);

        merge(array, start, mid, end);

    }
    ```
    
    ```java
    private static void merge(int[] array, int start, int mid, int end) {

        int[] tmp = new int[end - start + 1];

        for (int i = start, j = mid + 1, k = 0; i <= mid || j <= end; k++) {

            int lCur = Integer.MAX_VALUE;
            int rCur = Integer.MAX_VALUE;

            if (i <= mid) {
                lCur = array[i];
            }
            if (j <= end) {
                rCur = array[j];
            }

            if (lCur < rCur) {
                tmp[k] = lCur;
                i++;
            } else {
                tmp[k] = rCur;
                j++;
            }

        }

        System.arraycopy(tmp, 0, array, start, tmp.length);

    }
    ```

    ```java
    public static void main(String[] args) {
        int[] array = {1, 3, 9, 10, 2, 7, 8, 6};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }
  
    // [1, 2, 3, 6, 7, 8, 9, 10]
    
    ```
