package com.luthra.tests;

import org.junit.Assert;
import org.junit.Test;
import com.luthra.solutions.ReverseInteger;

public class ReverseIntegerTest {

    @Test
    public void TestSingleDigit () {

        int[] actuals = {ReverseInteger.reverseInteger(0), 
                         ReverseInteger.reverseInteger(-9), 
                         ReverseInteger.reverseInteger(9)};
        int[] expecteds = {0, -9, 9};

        Assert.assertArrayEquals("Error Single Digit", expecteds, actuals);
    }

    @Test
    public void TestTrailingZeros () {
        int[] actuals = {
            ReverseInteger.reverseInteger(10),
            ReverseInteger.reverseInteger(-10),
            ReverseInteger.reverseInteger(100),
            ReverseInteger.reverseInteger(120)
        };

        int[] expecteds = {1, -1, 1, 21};
        Assert.assertArrayEquals("Error trailing Zeros", expecteds, actuals);
    }

    @Test
    public void TestOverflowEdgeCases () {
        int[] actuals = {
            ReverseInteger.reverseInteger(1534236469),
            ReverseInteger.reverseInteger(2147483412),
            ReverseInteger.reverseInteger(-2147483648)
        };

        int[] expecteds = {0, 2143847412, 0};
        Assert.assertArrayEquals("Error overflow", expecteds, actuals);
    }
}