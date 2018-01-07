package com.avengers.bruce.Algorithm.leetCode.No1_TwoSum;

public class Solution {

    private static int[] twoSum(int[] nums, int target) {


        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
        }

        throw new IllegalArgumentException("No two sum solution");

    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] expect = {0, 1};
        int[] result = twoSum(nums, target);

    }
}
