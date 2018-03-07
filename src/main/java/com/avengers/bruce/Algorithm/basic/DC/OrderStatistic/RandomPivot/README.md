# OrderStatistic

## Question

Top kth element

## Solution by Random Pivot Algorithm

然后在上面得到的高区间或者低区间里进行递归求取，直到找到第i小的元素。

Random Pivot 算法步骤如下：

1. 选取主元:以快速排序为模型：随机选取一个主元
1. 以主元为分界点，把数组划分为两部分，A[p...q-1]的元素比A[q]小，A[q+1...r]的元素比A[q]大。
1. 判断主元的位置与k的大小，有选择的对左边或右边递归。

**平均复杂度为O(n)，最坏时间复杂度为O(n^2)**

## Code

* **Partition**

    ```java
    static public int partition(int[] arr, int from, int to) {
    
        int pivot = arr[from];    //pick 'from' as pivot
            
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
    
* **Select**

    ```java
    static public int select(int[] arr, int from, int to, int k) {
    
        if (from == to) return arr[from];
    
        // position of pivot
        int q = partition(arr, from, to);
    
        // compare with the k
        int i = q - from + 1;
    
        int result;
    
        if (k == i) {
            result = arr[q];
        } else if (k < i) {
            result = select(arr, from, q - 1, k);
        } else {
            result = select(arr, q + 1, to, k - i);
        }
    
        return result;
    
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
        
        System.out.println(OrderStatistic.select(arr,0,arr.length-1,K));
        System.out.println(Arrays.toString(arr));

    }
    ```
    
    ```bash
    13
    [12, 1, 3, 11, 6, 2, 13, 16, 22, 17, 14, 23, 25, 29, 30, 52, 37, 35, 32, 54, 50, 49, 57, 51, 80]
    ```