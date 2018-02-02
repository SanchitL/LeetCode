package com.luthra.solutions;

public class PalindromeNumber {
    public static boolean isPalindrome(int num) {
        // Revert half the digits and compare
        // A negative number cannot be a palindrome
        if (num < 0 || (num != 0 && num%10 == 0)) return false;
        int reversed = 0;
        while (num > reversed) {
            reversed = reversed*10 + num%10;
            num = num / 10;
        }
        return (reversed == num || reversed/10 == num);
    }
}