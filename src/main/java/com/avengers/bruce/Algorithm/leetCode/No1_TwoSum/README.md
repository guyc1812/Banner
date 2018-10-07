# [1. Two Sum](https://leetcode.com/problems/two-sum)

* **Question**

    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    
* **Example**
    
    Given nums = [2, 7, 11, 15], target = 9,
    
    Because nums[0] + nums[1] = 2 + 7 = 9,
    
    return [0, 1].
    
* **Solution**

    ```java
    private static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++)
                if ((numbers[i] + numbers[j])%target == 0) {
                    return new int[]{i, j};
                }
        }
        throw new IllegalArgumentException("No solution");
    }
    ```

* **Test**

    ```java
    public static void main(String[] args) {
        int target = 9;
        int[] numbers = {2, 7, 11, 15};
        int[] result = twoSum(numbers, target);
        System.out.println(Arrays.toString(result));
        // [0, 1]
    }
    ```