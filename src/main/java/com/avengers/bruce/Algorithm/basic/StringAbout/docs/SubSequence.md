# SubSequence

* **Demonstration**

    ![image](https://oss.guyuchen.com/deadpool/images/lcs.gif)

* **Solution**
    
    ```java
    private static int[][] lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];

        // str1 -> column, str2 -> row
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c;
    }
    ```
    
    ```java
    private static void getLCS(int[][] c, char[] x, char[] y, int i, int j, StringBuilder sb) {

        if (i != 0 && j != 0) {
            if (x[i - 1] == y[j - 1]) {
                sb.append(x[i - 1]);
                getLCS(c, x, y, i - 1, j - 1, sb);
            } else if (c[i - 1][j] >= c[i][j - 1]) {
                getLCS(c, x, y, i - 1, j, sb);
            } else {
                getLCS(c, x, y, i, j - 1, sb);
            }
        } else {
            sb.reverse();
        }

    }
    ```
    
* **Test**
    
    ```java
    public static void main(String[] args) {
    
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";

        int[][] c = lcs(str1, str2);
        Matrix.print(c);
        // 0 0 0 0 0 0 0
        // 0 0 0 0 1 1 1
        // 0 1 1 1 1 2 2
        // 0 1 1 2 2 2 2
        // 0 1 1 2 2 3 3
        // 0 1 2 2 2 3 3
        // 0 1 2 2 3 3 4
        // 0 1 2 2 3 4 4

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = str1.length();
        int len2 = str2.length();

        StringBuilder lcs = new StringBuilder();
        getLCS(c, arr1, arr2, len1, len2, lcs);

        System.out.println(lcs);
        // BCBA

    }
    ```