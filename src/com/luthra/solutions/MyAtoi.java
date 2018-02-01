package com.luthra.solutions;

public class MyAtoi {

    public static int atoi(String str) {
        // boolean isPositive = true;
        boolean firstIsNum = false;
        String resultString = "";

        for (char c : str.toCharArray()) {
            if (isNum(c)) {
                resultString += c;
            }
        }

        if (resultString.equals("")) return 0;

        int result = new Integer(resultString).intValue();

        return result;
    }
    
    private static boolean isNum(char c) {
        char[] nums  = {'0','1','2','3','4','5','6','7','8','9'};
        for (char num : nums) {
            if (num == c) {
                return true;
            }
        }
        return false;
    }
}