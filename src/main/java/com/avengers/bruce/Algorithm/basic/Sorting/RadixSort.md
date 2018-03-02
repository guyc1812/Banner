# Radix Sort

* **Stability**
    
    YES
    
* **Complexity**
    
    ```
    Average: O(nb)
    Best:    O(nb)
    Worst:   O(nb)
    
    b:bucket
    ```
    
* **Demonstration**

    ```bash
    initial : [170, 45, 75, 90, 802, 24, 2, 66]
    round 1 : [170, 90, 802, 2, 24, 45, 75, 66] exponent: 1
    round 2 : [802, 2, 24, 45, 66, 170, 75, 90] exponent: 10
    round 3 : [2, 24, 45, 66, 75, 90, 170, 802] exponent: 100
    ```
    
* **Implementation**

    ```java
    private static int getMax(int arr[], int n) {
        int max = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > max)
                max = arr[i];
        return max;
    }
    ```

    ```java
    private static void countSort(int arr[], int n, int exp) {

        int output[] = new int[n];                                                  //****   units digit
        int count[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};                               //****   [ 170 ,45  ,75  ,90  ,802 ,24  ,2   ,66  ]

        // count the times the numbers show up                                      //****    0   1   2   3   4   5   6   7   8   9
        for (int i = 0; i < n; i++) {                                               //****   |2  |0  |2  |0  |1  |2  |1  |0  |0  |0  |
            int index = (arr[i] / exp) % 10;                                        //****    170     802     24  45  66
            count[index]++;                                                         //****    90      2           75
        }                                                                           //****

        // for every single number, count the numbers that <= itself                //****    0   1   2   3   4   5   6   7   8   9
        for (int i = 1; i < 10; i++) {                                              //****   |2  |2  |4  |4  |5  |7  |8  |8  |8  |8  |
            count[i] += count[i - 1];                                               //****    170     802     24  45  66
        }                                                                           //****    90      2           75

        // Traversal the arr from the end, put the numbers in the right place       //****   [ 170 ,45  ,75  ,90  ,802 ,24  , 2  ,66  ]
        for (int i = n - 1; i >= 0; i--) {                                          //****      |    |    |    |    |    |    |    |
            int index = (arr[i] / exp) % 10;                                        //****      0    5    5    0    2    4    2    6
            output[count[index] - 1] = arr[i];                                      //****      |    |    |    |    |    |    |    |
            count[index]--;                                                         //****      1    6    7    2    3    5    4    8
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
    ```

    ```java
    private static void radixSort(int arr[], int n) {
        int m = getMax(arr, n);
        for (int exponent = 1; m / exponent > 0; exponent *= 10)
            countSort(arr, n, exponent);
    }
    ```
    
    ```java
    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixSort(arr, n);
        System.out.println(Arrays.toString(arr));
    }
  
    // [2, 24, 45, 66, 75, 90, 170, 802]
    
    ```
