package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{7, 1, 3,2,9}, 12)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] pos = new int[numbers.length];
        for(int i = 0;i < numbers.length; ++i){
            pos[i] = i + 1;
        }
        for(int i = 0; i < numbers.length; ++i){
            int minval = numbers[i];
            int minpos = i;
            for(int k = i + 1; k < numbers.length; ++k){
                if(numbers[k] < minval){
                    minval = numbers[k];
                    minpos = k;
                }
            }
            int tmp = numbers[i];
            numbers[i] = minval;
            numbers[minpos] = tmp;
            
            tmp = pos[i];
            pos[i] = pos[minpos];
            pos[minpos] = tmp;
        }
        
       // Arrays.sort(numbers);
        
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            int sum = numbers[head] + numbers[tail];
            if (sum == target) {
               return new int[]{ Math.min(pos[tail], pos[head]), Math.max(pos[tail], pos[head])};
            }
            if (sum < target) {
                head++;
            } else {
                tail--;
            }
        }
        return null;
    }

}
