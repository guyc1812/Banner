package com.avengers.bruce.Algorithm.leetCode.No3_Longest_Substring_Without_Repeating_Characters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        // abcabcbb

        while ((line = in.readLine()) != null) {
            int ret = new Solution().lengthOfLongestSubstring(line);
            System.out.print(ret);
            // 3
        }
    }

    private int lengthOfLongestSubstring(String s) {

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                ans = Math.max(ans, j - i);
                j++;
            } else {
                // if contains, remove elements until the repeat one
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;

    }
}
