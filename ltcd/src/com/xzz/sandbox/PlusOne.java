package com.xzz.sandbox;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = digits.length - 1;
        while(i >= 0 && digits[i] == 9){
            i--;
        }
        if(i < 0){
            int[] retval = new int[digits.length + 1];
            retval[0] = 1;
            return retval;
        }

        digits[i]++;
        for(int k = i + 1; k < digits.length ; ++k){
            digits[k] = 0;
        }
        return digits;
    }
}
