package com.xzz.sandbox;

public class Atoi {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Character.MAX_VALUE);
        System.out.println(new Atoi().atoi("-2147483649"));
    }
    public int atoi(String str) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(str == null){
            return 0;
        }
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        boolean isNegative = false;
        int index = 0;
        if(str.charAt(0) == '-' || str.charAt(0) == '+'){
            isNegative = (str.charAt(0) == '-');
            ++index;
        }
        long val = 0;
        for(; index < str.length(); ++index){
            char c = str.charAt(index);
            if(c >= '0' && c <= '9'){
                val = val*10 + (c - '0');
            }else{
                break;
            }
        }
        if(!isNegative && val > (long)Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(isNegative && val > (long)Integer.MAX_VALUE + 1){
            return Integer.MIN_VALUE;
        }
        return isNegative ? (int)(-val) : (int)val;
    }
}