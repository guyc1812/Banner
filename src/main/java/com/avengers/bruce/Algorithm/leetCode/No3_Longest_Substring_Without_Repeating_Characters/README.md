# 3. Longest Substring Without Repeating Characters

* **Question**

    Given a string, find the length of the **longest substring** without repeating characters.
    
* **Example**
    
    Given "abcabcbb", the answer is "abc", which the length is 3.
    
    Given "bbbbb", the answer is "b", with the length of 1.
    
    Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
    
* **Solution**

    ```java
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
    ```

* **Test**

    ```java
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
    ```