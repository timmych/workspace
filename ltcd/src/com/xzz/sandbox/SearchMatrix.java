package com.xzz.sandbox;

public class SearchMatrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recSearchMatrix(matrix, target, 0, matrix.length - 1);
    }
    
    
    public boolean recSearchMatrix(int[][] matrix, int target, int r1, int r2){
        if(r1 > r2){
            return false;
        }
        if(r1 == r2){
            for(int i = 0; i < matrix[0].length; ++i){
                if(matrix[r1][i] == target){
                    return true;
                }
            }
            return false;
        }
        if(target < matrix[r1][0] || target > matrix[r2][matrix[0].length - 1]){
            return false;
        }
        int mid = (r1 + r2 + 1) / 2;
        int midValue = matrix[mid][0];
        if(target < midValue){
            return recSearchMatrix(matrix, target, r1, mid - 1);
        }
        else{
            return recSearchMatrix(matrix, target, mid, r2);
        }
    }
}
