package com.avengers.bruce.Algorithm.leetCode.No5_Longest_Palindromic_Substring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        // aabbbaac

        while ((line = in.readLine()) != null) {
            String ret = new Solution().longestPalindrome(line);
            System.out.print((ret));
            // aabbbaa
        }
    }

    private String longestPalindrome(String s) {

        if(s.length()<2) return s;

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // palindrome length is odd
            int len2 = expandAroundCenter(s, i, i + 1);     // palindrome length is even
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
