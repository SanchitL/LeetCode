package com.luthra.tests;

import org.junit.*;
import com.luthra.solutions.AddOne;

public class AddOneTest {
    @Test
    public void TestNoCarry () {
        int[] toAdd = {2};
        int[] actual = AddOne.addOne(toAdd);
        int[] expected = {3};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestCarryNoExtend () {
        int[] toAdd = {2, 9};
        int[] actual = AddOne.addOne(toAdd);
        int[] expected = {3, 0};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestCarryAndExtend () {
        int[] toAdd = {9};
        int[] actual = AddOne.addOne(toAdd);
        int[] expected = {1, 0};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestChainedCarry () {
        int[] toAdd = {9,9,9,9};
        int[] actual = AddOne.addOne(toAdd);
        int[] expected = {1,0,0,0,0};
        Assert.assertArrayEquals(expected, actual);
    }
}