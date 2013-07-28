package com.xzz.sandbox;

public class UniquePath {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new UniquePath().uniquePaths(3, 3));
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] data = new int[m][n];
        data[m - 1][n - 1] = 0;
        for (int mm = 0; mm < m - 1; mm++) {
            data[mm][n - 1] = 1;
        }
        for (int nn = 0; nn < n - 1; nn++) {
            data[m - 1][nn] = 1;
        }
        for (int mm = m - 2; mm >= 0; --mm) {
            for(int nn = n -2 ; nn >= 0; --nn){
                data[mm][nn] = data[mm + 1][nn] + data[mm][nn + 1];
            }
        }
        return data[0][0];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        
        int m = obstacleGrid.length;
        if (m == 0){
            return 0;
        }
        int n = obstacleGrid[0].length;
        
        int[][] data = new int[m][n];
        if(obstacleGrid[m - 1][n - 1] == 1){
            return 0;
        }
        
        data[m - 1][n - 1] = 1;
        for (int mm = m - 2; mm >= 0; mm--) {
            if(obstacleGrid[mm][n - 1] == 0){
                data[mm][n - 1] = data[mm + 1][n-1];    
            }else{
                data[mm][n - 1] = 0;
            }
            
        }
        for (int nn = n - 2; nn >= 0; nn--) {
            if(obstacleGrid[m - 1][nn] == 0){
                data[m - 1][nn] = data[m - 1][nn + 1];    
            }else{
                data[m - 1][nn] = 0;
            }
            
        }

        for (int mm = m - 2; mm >= 0; --mm) {
            for(int nn = n -2 ; nn >= 0; --nn){
                data[mm][nn] = (obstacleGrid[mm][nn] == 1) ? 0 : data[mm + 1][nn] + data[mm][nn + 1];
            }
        }
        return data[0][0];
        // DO NOT write main() function
        
    }
    
    
}
