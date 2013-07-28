package com.xzz.sandbox;

import java.util.ArrayList;

public class SpiralMatrix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new SpiralMatrix().spiralOrder(new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        }));
    }
//dy = 2
//dx = 0
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> route = new ArrayList<Integer>();
        
        int dx = matrix.length - 1;
        
        if(dx < 0){
            return route;
        }
        int dy = matrix[0].length;
        int total = dx*dy + dy;
        int dir = 0;//left
        
        int curx = 0;
        int cury = -1;
        
        while(route.size() < total){
            
            switch(dir){
            case 1:
                for(int i = 0; i < dx; ++i){
                    route.add(matrix[++curx][cury]);
                }
                dx--;
                break;
            case 0:
                for(int i = 0; i < dy; ++i){
                    route.add(matrix[curx][++cury]);
                }
                dy--;
                break;
                
            case 3:
                for(int i = 0; i < dx; ++i){
                    route.add(matrix[--curx][cury]);
                }
                dx--;
                break;
            case 2:
                for(int i = 0; i < dy; ++i){
                    route.add(matrix[curx][--cury]);
                }
                dy--;
                break;
            }
            
            dir = (dir + 1) % 4;
        }
        return route;
    }
}
