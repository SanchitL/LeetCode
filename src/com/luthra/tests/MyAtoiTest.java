package com.luthra.tests;

import org.junit.*;
import com.luthra.solutions.MyAtoi;

public class MyAtoiTest {
    @Test
    public void TestBasicConversion () {
        Assert.assertEquals(12345, MyAtoi.atoi("12345"));
        Assert.assertEquals(0, MyAtoi.atoi("noNums"));
        Assert.assertEquals(12345, MyAtoi.atoi("12345"));
    }

    @Test
    public void TestSignDetection () {
        Assert.assertEquals(-1, MyAtoi.atoi("-1"));
        Assert.assertEquals(-1, MyAtoi.atoi("  -1"));

    }

    @Test
    public void TestOverlfow () {
        Assert.assertEquals(2147483647, MyAtoi.atoi("2147483647"));
        Assert.assertEquals(2147483647, MyAtoi.atoi("2147483648"));
        Assert.assertEquals(-2147483647, MyAtoi.atoi("-2147483647"));
        Assert.assertEquals(-2147483648, MyAtoi.atoi("-2147483648"));
        Assert.assertEquals(-2147483648, MyAtoi.atoi("-2147483650"));
    }

    @Test
    public void TestStartEndDetection () {
        Assert.assertEquals(10, MyAtoi.atoi("   010"));
        Assert.assertEquals(0, MyAtoi.atoi("+-2"));
        Assert.assertEquals(2, MyAtoi.atoi("+2"));
        Assert.assertEquals(-2, MyAtoi.atoi("-2"));
        Assert.assertEquals(0, MyAtoi.atoi("  b10"));
    }
}