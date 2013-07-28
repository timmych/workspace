package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Triangle().minimumTotal(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
                )));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0){
            return 0;
        }
        int[] buffer = new int[size];
        int[] tmp = new int[size];
        buffer[0] = triangle.get(0).get(0);
        for(int i = 1; i < size; ++i){
            for(int j = 0; j <= i; ++j){
                
                int left = (j >= 1) ? buffer[j-1] : Integer.MAX_VALUE;
                int right = (i - 1 >= j) ? buffer[j] : Integer.MAX_VALUE;
                tmp[j] = Math.min(left, right) + triangle.get(i).get(j);
            }
            for(int j = 0; j <= i; ++j){
                buffer[j] = tmp[j];
            }
        }
        int minPath = Integer.MAX_VALUE;
        for(int m : buffer){
            if(m < minPath){
                minPath = m;
            }
        }
        return minPath;
    }
}
