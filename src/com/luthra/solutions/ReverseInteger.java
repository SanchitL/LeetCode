package com.luthra.solutions;

// Completed solution for ReverseInteger
public class ReverseInteger {

    public static int reverseInteger(int integer) {
        int base = 10;
        int result = 0;
       
        if (integer < 10 && integer > -10) {
            return integer;
        }

        int state = Math.abs(integer);
        if (state < 0 && state == integer) return 0;
        for (int i = 0; i <= (int) Math.log10(Math.abs(integer)); i++) {

            int remainder = state % base;
            // Eliminate overflow
            if (result != 0 && Integer.MAX_VALUE / result <= base) {
                if (Integer.MAX_VALUE / result == base && Integer.MAX_VALUE % result < remainder) {
                    return 0;
                } else if (Integer.MAX_VALUE / result < base) {
                    return 0;
                }
            }
            result *= base;
            result += remainder;
            state = state / base;
        }

        result = integer > 0 ? result : -1*result;

        return result;
    }
}