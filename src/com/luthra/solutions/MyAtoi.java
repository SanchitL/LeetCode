package com.luthra.solutions;

import java.util.Map;
import java.util.HashMap;

public class MyAtoi {

    private static Map<String, Integer> stringsToInteger = new HashMap<>();

    public static int atoi(String str) {
        populateMap();
        // boolean isPositive = true;
        boolean numFound = false;
        String resultString = "";

        for (char c : str.toCharArray()) {
            if (isNum(c)) {
                numFound = true;
                resultString += c;
            } else if ((c == '-' || c == '+') && !numFound) {
                numFound = true;
                resultString += c;
            } else if (c != ' ') {
                break;
            } else if (c == ' ' && numFound) {
                break;
            }
        }

        if (resultString.length() == 0) return 0;

        int sign = resultString.charAt(0) == '-' ? -1 : 1;
        int result = 0;
        for (char c : resultString.toCharArray()) {
            if (isNum(c)) {
                int toAdd = stringsToInteger.get(String.valueOf(c));
                // Eliminate overlfow
                if (sign == 1) {
                    if (result != 0 && Integer.MAX_VALUE / result <= 10) {
                        if (Integer.MAX_VALUE / result == 10 && Integer.MAX_VALUE % result < toAdd) {
                            return Integer.MAX_VALUE;
                        } else if (Integer.MAX_VALUE / result < 10) {
                            return Integer.MAX_VALUE;
                        }
                    }
                } else {
                    if ((result != 0 && result != -1) && Integer.MIN_VALUE / result <= 10) {
                        if (Integer.MIN_VALUE / result == 10 && Integer.MIN_VALUE % result > (sign*toAdd)) {
                            return Integer.MIN_VALUE;
                        } else if (Integer.MIN_VALUE / result < 10) {
                            return Integer.MIN_VALUE;
                        }
                    }
                }
                result = (result*10) + (sign*toAdd);
            }
        }

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

    private static void populateMap () {
        if (stringsToInteger.isEmpty()) {
            stringsToInteger.put("0", 0);
            stringsToInteger.put("1", 1);
            stringsToInteger.put("2", 2);
            stringsToInteger.put("3", 3);
            stringsToInteger.put("4", 4);
            stringsToInteger.put("5", 5);
            stringsToInteger.put("6", 6);
            stringsToInteger.put("7", 7);
            stringsToInteger.put("8", 8);
            stringsToInteger.put("9", 9);
        }
    }
}