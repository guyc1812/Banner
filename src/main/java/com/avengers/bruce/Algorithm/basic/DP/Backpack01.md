# 0-1 Backpack Problem

* **Demonstration**

    | name | weight | value | n\m | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
    |:----:|:------:|:-----:|:---:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|
    | a    | 2      | 6     | n=1 | 0 | 6	| 6 | 6 | 6 | 6	 | 6  | 6  | 6	| 6	 |
    | b    | 2      | 3     | n=2 | 0 | 6	| 6 | 9 | 9 | 9	 | 9  | 9  | 9	| 9	 |
    | c    | 6      | 5     | n=3 | 0 | 6	| 6 | 9 | 9 | 9	 | 9  | 11 | 11	| 14 |	
    | d    | 5      | 4     | n=4 | 0 | 6	| 6 | 9 | 9 | 9	 | 10 | 11 | 13	| 14 |	
    | e    | 4      | 6     | n=5 | 0 | 6	| 6 | 9 | 9 | 12 | 12 | 15 | 15	| 15 |	
    
* **Solution**

    ```java
     /**
     * @param m 表示背包的最大容量  10
     * @param n 表示商品个数       5 
     * @param w 表示商品重量数组    2, 2, 6, 5, 4
     * @param p 表示商品价值数组    6, 3, 5, 4, 6
     */
    private static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c;
    }
    ```
    
* **Test**

    ```java
    public static void main(String[] args) {
        int m = 10;
        int n = 5;
        int w[] = {2, 2, 6, 5, 4};
        int p[] = {6, 3, 5, 4, 6};
        int c[][] = BackPack_Solution(m, n, w, p);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }
    }
      
    // 0   0   0   0   0   0   0   0   0   0   0	
    // 0   0   6   6   6   6   6   6   6   6   6	
    // 0   0   6   6   9   9   9   9   9   9   9	
    // 0   0   6   6   9   9   9   9   11  11  14	
    // 0   0   6   6   9   9   9   10  11  13  14	
    // 0   0   6   6   9   9   12  12  15  15  15	
    ```