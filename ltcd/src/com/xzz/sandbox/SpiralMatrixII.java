package com.xzz.sandbox;

import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII {

    public class Solution {
        public int[][] generateMatrix(int n) {
            // Start typing your Java solution below
            // DO NOT write main() function
            
            int dir = 0;
            int len2 = n*2;
            int[][] matrix = new int[n][n];
            
            int total = n*n;
            int i = 1;
            
            int x = -1;
            int y = 0;
            while(i <= total){
                for(int k = 0; k < len2/2; ++k){
                    switch(dir){
                        case 0: x++;break;
                        case 1: y++;break;
                        case 2: x--;break;
                        case 3: y--;break;
                    }
                    
                    matrix[y][x] = i++;          
                }
                len2--;
                dir = (dir + 1) % 4;
            }
            return matrix;
        }
    }
}
