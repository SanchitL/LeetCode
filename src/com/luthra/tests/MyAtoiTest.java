package com.luthra.tests;

import org.junit.*;
import com.luthra.solutions.MyAtoi;

public class MyAtoiTest {
    @Test
    public void TemporaryTest () {
        Assert.assertEquals(12345, MyAtoi.atoi("12345"));
        Assert.assertEquals(0, MyAtoi.atoi(" r t y y"));
        
        try {
            Assert.assertEquals(-2147483648, MyAtoi.atoi("-2147483648"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}