# 7. Reverse Integer

* **Question**

    Given a 32-bit signed integer, reverse digits of an integer.
    
    **Note**:<br>
    Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
    
* **Example**
    
    Input: 123<br>
    Output:  321
    
    Input: -123<br>
    Output: -321
    
    Input: 120<br>
    Output: 21
    
* **Solution**

    ```java
    private static int reverse(int x) {

        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
          
            // check overflow
            if ((newResult - tail) / 10 != result) return 0;
                
            result = newResult;
            x = x / 10;
        }

        return result;

    }
    ```

* **Test**

    ```java
    public static void main(String[] args) {

        int result = reverse(1534236469);
        System.out.println(result);
        // 0

        int result2 = reverse(1534236461);
        System.out.println(result2);
        // 1646324351
      
    }
    ```