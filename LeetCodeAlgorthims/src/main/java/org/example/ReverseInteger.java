package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseInteger {
    public static void main(String[] args) {
        int a=123;
        System.out.println(reverse(a));
    }
    public static int reverse(int x) {
        int result = 0;
        int sign = (x < 0) ? -1 : 1;
        x = Math.abs(x);
        if(x==Integer.MAX_VALUE || x==Integer.MIN_VALUE) return 0;

        while (x != 0) {
            int digit = x % 10;
            x /= 10;

            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            result = result * 10 + digit;
        }

        return result * sign;
    }
}
