# OrderStatistic

## Question

Top kth element

## Solution by BFPRT Algorithm

BFPRT算法步骤如下：

1. 选取主元；
    1. 将n个元素划分为⌊n5⌋个组，每组5个元素，若有剩余，舍去；
    1. 使用插入排序找到⌊n5⌋个组中每一组的中位数；
    1. 对于上一步中找到的所有中位数，递归求出它们的中位数，作为主元；
1. 以主元为分界点，把小于主元的放在左边，大于主元的放在右边；
1. 判断主元的位置与k的大小，有选择的对左边或右边递归。

**最坏时间复杂度为O(n)**

![BFPRT](http://guyuchen.com/deadpool/images/BFPRT.png)

## Code

* **BFPTR**

    ```java
    static public int BFPTR(int arr[], int from, int to, int k) {
    
        findMid(arr, from, to);             //find median as pivot
        int q = partition(arr, from, to);   //position of pivot in sorted array

        // compare with the k
        int i = q - from + 1;

        int result;

        if (k == i) {
            result = arr[q];
        } else if (k < i) {
            result = BFPTR(arr, from, q - 1, k);
        } else {
            result = BFPTR(arr, q + 1, to, k - i);
        }

        System.out.println(Arrays.toString(arr));
        return result;
    
    }
    ```

* **Find median as pivot**

    1. find median of each group (group and sort)
    1. swap each median to the begining of array (for partition)
    1. find median of medians 
    1. swap the median to the first place of array (for partition)

    ```java
    static private void findMid(int arr[], int from, int to) {
    
        int p = to - from + 1;
        int q = p / 5;
        int remainder = p - q * 5;
    
        //swap all the median to the beginning of the array
        //this is for partition -> pick 'from' as pivot
        int t = from;
    
        if (p < 6) {    //from 0 to 5
            insertionSort(arr, from, to);   //sort
            // median is at position(from + (p-1)/2)
            // then swap it to the first place
            Swap.run(arr, t, from + (p - 1) / 2);
            return;
        } else {
            // each group contains five elements
            // find median of every group
            // swap them to the beginning of the array
            for (int i = 0; i < q; i++) {
                insertionSort(arr, from + 5 * i, from + i * 5 + 4);
                Swap.run(arr, t, from + i * 5 + 2);
                t++;
            }
            // handle the remainder
            if (remainder > 0) {
                insertionSort(arr, from + 5 * q, from + 5 * q + remainder - 1);
                Swap.run(arr, t, from + q * 5 + remainder / 2);
                t++;
            }
        }
        //recursive call
        findMid(arr, from, t - 1);
    }
    ```

* **Partition**
    
    ```java
    static private int partition(int arr[], int from, int to) {
    
        int pivot = arr[from];
    
        int l = from;
        int r = to;
    
        while (l < r) {
    
            while (l < r && arr[r] >= pivot) --r;
            arr[l] = arr[r];
    
            while (l < r && arr[l] <= pivot) ++l;
            arr[r] = arr[l];
    
        }
    
        arr[l] = pivot;
        return l;
    
    }
    ```
    
* **Insertion Sort**

    Sort each group

    ```java
    //[l,r]
    private static void insertionSort(int[] array, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            int key = array[i];
            for (int j = i - 1; j >= l; j--) {
                if (key < array[j]) {
                    array[j + 1] = array[j];
                    array[j] = key;
                }
            }
        }
    }
    ```
    
* **Test**

    ```java
    public static void main(String[] args){
    
        int[] arr = {
            80, 1 , 17, 51, 57,
            49, 35, 11, 25, 37,
            14, 3 , 2 , 13, 52,
            12, 6 , 29, 32, 54,
            50, 16, 22, 23, 30
        };
      
        int K = 7;
        
        System.out.println(OrderStatistic.BFPTR(arr,0,arr.length-1,K));
        System.out.println(Arrays.toString(arr));

    }
    ```
    
    ```bash
    13
    [2, 1, 3, 6, 11, 12, 13, 14, 17, 25, 23, 22, 16, 29, 52, 49, 37, 57, 32, 54, 51, 35, 80, 30, 50]
    ```



