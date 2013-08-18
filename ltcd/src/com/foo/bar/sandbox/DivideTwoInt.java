package com.foo.bar.sandbox;

public class DivideTwoInt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int divide(int dividend, int divisor) {
	        // Start typing your Java solution below
	        // DO NOT write main() function
	        if(divisor == 0 || dividend == 0){
	            return 0;
	        }
	        boolean positive = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
	            
	        long c = Math.abs((long)dividend);
	        long d = Math.abs((long)divisor);
	        
	        long upper = 0;
	        while(upper * d < c){
	            upper = upper == 0 ? 1 : upper*2;
	        }
	        if(upper*d == c){
	            return positive ? (int) upper : (int)(-upper);
	        }
	        long lower = upper / 2;
	        while(upper - lower > 1){
	            long mid = (upper + lower) / 2;
	            if(mid * d == c){
	                return positive ? (int) mid : (int)(-mid);
	            }
	            if(mid * d < c){
	                lower = mid;
	            }else{
	                upper = mid;
	            }
	        }
	        return positive ? (int)lower : (int)(-lower);
	    }
		
}
