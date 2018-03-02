# SubString

* **Demonstration**

    |   | yj| B | D | C | A | B | C | B | A |
    |:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
    | Xi| 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
    | A | 0 | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 1 |
    | B | 0 | 1 | 0 | 0 | 0 | 2 | 0 | 1 | 0 |
    | C | 0 | 0 | 0 | 1 | 0 | 0 | 3 | 0 | 0 |
    | B | 0 | 1 | 0 | 0 | 0 | 1 | 0 | 4 | 0 |
    | A | 0 | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 5 |
    | D | 0 | 0 | 1 | 0 | 0 | 0 | 0 | 0 | 0 |
    | A | 0 | 0 | 0 | 0 | 1 | 0 | 0 | 0 | 1 |
    | B | 0 | 1 | 0 | 0 | 0 | 2 | 0 | 1 | 0 |
   

* **Solution**
    
    ```java
    private static String lcs(String str1, String str2) {
            
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1 + 1][len2 + 1];
    
        int maxNum = 0;
        int maxIndex = 0;
    
        // str1 -> column, str2 -> row
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
    
                    //mark maxLength and index
                    if (c[i][j] > maxNum) {
                        maxNum = c[i][j];
                        maxIndex = i;
                    }
    
                } else {
                    c[i][j] = 0;
                }
            }
        }
      
        Matrix.print(c);
    
        return str1.substring(maxIndex - maxNum, maxIndex);
    }
    ```
    
* **Test**
    
    ```java
    public static void main(String[] args) {
    
        String str1 = "ABCBADAB";
        String str2 = "BDCABCBA";
    
        String LCS = lcs(str1, str2);
        // 0 0 0 0 0 0 0 0 0 
        // 0 0 0 0 1 0 0 0 1 
        // 0 1 0 0 0 2 0 1 0 
        // 0 0 0 1 0 0 3 0 0 
        // 0 1 0 0 0 1 0 4 0 
        // 0 0 0 0 1 0 0 0 5 
        // 0 0 1 0 0 0 0 0 0 
        // 0 0 0 0 1 0 0 0 1 
        // 0 1 0 0 0 2 0 1 0
    
        System.out.println(LCS);
        // ABCBA
    
    }
    ```