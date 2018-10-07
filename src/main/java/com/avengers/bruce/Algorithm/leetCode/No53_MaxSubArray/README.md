# [53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray)

* **Question**

    Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
    
* **Example**
    
    Given the array [-2,1,-3,4,-1,2,1,-5,4],<br>
    The contiguous subarray [4,-1,2,1] has the largest sum = 6.
    
* **Demonstration**

    dp = [1, 3, 6, 3, 1, 6, 7]
    
* **Solution**

    ```java
    private static int maxSubArray(int[] a) {

        int[] dp = new int[a.length];
        dp[0] = a[0];
        int max = 0;

        for (int i = 1; i < a.length; i++) {

            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + a[i];
            } else {
                dp[i] = a[i];
            }

            max = Math.max(max, dp[i]);

        }

        return max;

    }
    ```

* **Test**

    ```java
    public static void main(String[] args) {
        int[] a = {1, 2, 3, -3, -2, 5, 1};
        int result = maxSubArray(a);
        System.out.println(result);
        // 7
    }
    ```