package com.avengers.bruce.Algorithm.util;

public class Power {

    public static int power(int i, int j) {

        if (j == 0) return 1;

        int y = power(i, j / 2);
        y = y * y;
        if (j % 2 != 0) {
            y = i * y;
        }
        return y;
    }

    public static int sqrt(int x) {

        if (x <= 1) return x;

        int l = 1, r = x;

        while (l <= r) {
            int m = l + ((r - l) >> 1);
            if (m <= x / m && (m + 1) > x / (m + 1)) {
                return m;
            }
            if ((m + 1) <= x / (m + 1)) {
                l = m + 1;
            }
            if (m > x / m) {
                r = m - 1;
            }
        }

        throw null;
    }

}
