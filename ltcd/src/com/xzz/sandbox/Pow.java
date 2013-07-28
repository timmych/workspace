package com.xzz.sandbox;

public class Pow {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Pow().pow(10.0, 2));
    }
    
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        double ret = 1;
        boolean negative = (n < 0);
        if(n == 0){
            return 1;
        }
        if(x == 0){
            return 0;
        }
        if(negative){
            n = -n;
        }
        
        int mask = 1<<30;
        
        for(int i = 0; i < 32; ++i){
            ret = ret*ret;
            if((mask & n) > 0){
                ret *= x;
            }
            mask >>= 1;
        }
        
        return negative ? 1/ret : ret;
    }

}
