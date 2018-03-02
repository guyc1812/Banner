# 6. ZigZag Conversion

* **Question**

    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:<br> 
    (you may want to display this pattern in a fixed font for better legibility)
    
    ```bash
    P   A   H   N
    A P L S I I G
    Y   I   R
    ```
    
    And then read line by line: "PAHNAPLSIIGYIR"<br>
    
* **Example**

    convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".


* **Demonstration**

    ```bash
     ---                 
      |  P       A       H       N 
      n  A   P   L   S   I   I   G 
      |  Y       I       R         
     --- |2n-2|            
    ```
    
* **Solution**

    ```java
    private static String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        } else {
            
            int column = s.length();
            char[][] z = new char[numRows][column];
            
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {

                int baseCol = (i / (2 * numRows - 2)) * (numRows - 1);
                int extra = i % (2 * numRows - 2);

                if (extra < numRows) {
                    z[extra][baseCol] = s.charAt(i);
                } else {
                    z[2 * numRows - 2 - extra][baseCol + extra - numRows + 1] = s.charAt(i);
                }

            }

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < column; j++) {
                    if (z[i][j] != '\0') {
                        sb.append(z[i][j]);
                    }
                }
            }

            return sb.toString();

        }

    }
    ```

* **Test**

    ```java
    public static void main(String[] arg) {
        String str = "PAYPALISHIRING";
        int numRows = 3;
        String output = convert(str, numRows);
        System.out.print(output);
        //PAHNAPLSIIGYIR
    }
    ```