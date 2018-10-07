# [Lego Blocks](https://www.hackerrank.com/challenges/lego-blocks/problem)

* **Question**

    You have an infinite number of 4 types of lego blocks of sizes given as (depth x height x width):

    ```
    d	h	w
    1	1	1
    1	1	2
    1	1	3
    1	1	4
    ```

    Using these blocks, you want to make a wall of height *n* and width *m*. Features of the wall are:

    * The wall should not have any holes in it.
    * The wall you build should be one solid structure, so there should not be a straight vertical break across all rows of bricks.
    * The bricks must be laid horizontally.

    How many ways can the wall be built?

* **Example**

    the wall's height *n = 2* and its width *m = 3*. Here are some configurations:

    ![image](https://s3.amazonaws.com/hr-assets/0/1526322298-72d127a6f7-bricks.png)

    Here are some configurations:

    These are not all of the valid permutations.

    **Input Format**

    The first line contains the number of test cases *t*.

    Each of the next *t* lines contains two space-separated integers *n* and *m*.

    **Constraints**

    * *1 <= t <= 100*

    * *1 <= n,m <= 1000*

    **Output Format**

    Output one line for each test case containing the number of ways to build the wall. As the numbers can be very large, output the result modulo 1000000007.

    **Sample Input**

    ```
    4
    2 2
    3 2
    2 3
    4 4
    ```

    **Sample Output**

    ```
    3
    7
    9
    3375
    ```

    **Explanation**

    For the first case, we can have:

    ![image](https://s3.amazonaws.com/hr-assets/0/1526322982-b16b20303f-legosample.png)

    `3 mod (10^9 + 7) = 3`

    For the second case, each row of the wall can contain either two blocks of width 1, or one block of width 2. However, the wall where all rows contain two blocks of width 1 is not a solid one as it can be divided vertically. Thus, the number of ways is:

    `2 * 2 * 2 -1 = 7   and   7 mod (10^9 + 7) = 7`

* **Editorial**

    [Editorial by lydxlx](https://www.hackerrank.com/challenges/lego-blocks/editorial)

* **Solution**

    ```java

    ```