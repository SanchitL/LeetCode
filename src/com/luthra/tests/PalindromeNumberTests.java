package com.luthra.tests;

import org.junit.*;
import com.luthra.solutions.PalindromeNumber;

public class PalindromeNumberTests {
    @Test
    public void TestBasicIdentification () {
        Assert.assertTrue(PalindromeNumber.isPalindrome(121));
        Assert.assertFalse(PalindromeNumber.isPalindrome(123));
        Assert.assertTrue(PalindromeNumber.isPalindrome(0));
    }
    
    @Test
    public void TestNegative () {
        Assert.assertFalse(PalindromeNumber.isPalindrome(-120));
    }

    @Test
    public void TestMultiplesofTen () {
        Assert.assertFalse(PalindromeNumber.isPalindrome(54350));
        Assert.assertFalse(PalindromeNumber.isPalindrome(10));
        Assert.assertFalse(PalindromeNumber.isPalindrome(450));
    }
}