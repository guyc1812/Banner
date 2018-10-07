# [4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays)

* **Question**

    There are two sorted arrays **nums1** and **nums2** of size m and n respectively.
    
    Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
    
* **Example**
    
    nums1 = [1, 3]<br>
    nums2 = [2]<br>
    The median is 2.0
    
    nums1 = [1, 2]<br>
    nums2 = [3, 4]<br>
    The median is (2 + 3)/2 = 2.5
    
* **Solution**

    ```java
    private double findMedianSortedArrays(int[] A, int[] B) {
    
        int al = A.length;
        int bl = B.length;

        if (al > bl) { // to ensure al<=bl
            int[] temp = A;
            A = B;
            B = temp;
            int tmp = al;
            al = bl;
            bl = tmp;
        }

        int iMin = 0, iMax = al, halfLen = (al + bl + 1) / 2;

        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = iMin + 1; // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = iMax - 1; // i is too big
            } else { // i is perfect
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j - 1];
                } else if (j == 0) {
                    maxLeft = A[i - 1];
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1]);
                }
                if ((al + bl) % 2 == 1) {
                    return maxLeft;
                }

                int minRight = 0;
                if (i == al) {
                    minRight = B[j];
                } else if (j == bl) {
                    minRight = A[i];
                } else {
                    minRight = Math.min(B[j], A[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    ```

* **Test**

    ```java
    public static void main(String[] args) {
        int[] A = {3, 5, 6, 7, 8, 13};
        int[] B = {2, 3, 5, 19};
        double result = new Solution().findMedianSortedArrays(A, B);
        System.out.println(result);   // 5.5
    }
    ```