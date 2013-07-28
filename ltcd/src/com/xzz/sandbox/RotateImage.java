package com.xzz.sandbox;

public class RotateImage {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void rotate(int[][] matrix){
        int len = matrix.length;
        if(len == 0){
            return;
        }
        
        int margin = 0;
        while(true){
            int start = margin;
            int end = len - 1 - margin;
            if(start >= end){
                return;
            }
            for(int i = start; i < end; ++i){
                int tmp = matrix[margin][i];
                matrix[margin][i] = matrix[len - i - 1][margin];
                matrix[len - 1 - i][margin] = matrix[len - margin - 1][len - 1 - i];
                matrix[len - margin - 1][len - 1 - i] = matrix[i][len - margin - 1]; 
                matrix[i][len - margin - 1] = tmp;
            }
            margin++;
        }
    }
}
