package com.luthra.solutions;

public class AddOne {
    public static int[] addOne (int[] nums) {
        int[] result = nums.clone();
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i]++;
            if (result[i] == 10) {
                if (i == 0) {
                    result[0] = 0;
                    result = extendList(result);
                    break;
                } else {
                    result[i] = 0;
                }
            } else {
                break;
            }
        }

        return result;
    }

    private static int[] extendList(int[] nums) {
        int[] extended =new int[nums.length + 1];
        extended[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            extended[i+1] = nums[i];
        }
        return extended;
    }
}