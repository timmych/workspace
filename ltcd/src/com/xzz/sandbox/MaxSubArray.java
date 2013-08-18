package com.xzz.sandbox;

public class MaxSubArray {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return 0;
        }
        int cur = Math.max(0, A[0]);
        int maxSum = A[0];
        for(int i = 1; i < A.length; ++i){
            
            int a = A[i];
            if(a + cur > maxSum){
                maxSum = a + cur;
            }
            cur += a;
            cur = Math.max(0, cur);
        }
        return maxSum;
    }
}
