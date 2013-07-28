package com.xzz.sandbox;

public class SetZeroes {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        boolean[] columns = new boolean[matrix[0].length];
        boolean[] rows = new boolean[matrix.length];
        
        for(int r = 0; r < matrix.length; ++r){
            for(int c = 0; c < matrix[0].length; ++c){
                if(matrix[r][c] == 0){
                    columns[c] = true;
                    rows[r] = true;
                }
            }
        }
        
        for(int r = 0 ; r < rows.length; ++r){
            if(rows[r]){
                for(int c = 0; c < columns.length; ++c){
                    matrix[r][c] = 0;
                }
            }
        }
        for(int c = 0; c < columns.length; ++c){
            if(columns[c]){
                for(int r = 0; r < rows.length; ++r){
                    matrix[r][c] = 0;
                }
            }   
        }
    }
}
