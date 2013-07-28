package com.xzz.sandbox;

public class Sqrt {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Sqrt().sqrt(5));
    }

    public static final int MAX_INT_SQRT = 46340;
    
    public int sqrt(int s){
        int low = 0;
        int high = MAX_INT_SQRT;

        while(high > low){
           int med = (low + high) / 2;
           int prod = med*med;
           if(prod == s){
               return med;
           }else if(prod > s){
               high = med - 1;
           }else{
               low = med + 1;
           }
        }
        if(low*low > s){
            return low - 1;
        }
        return low;
    }
}
