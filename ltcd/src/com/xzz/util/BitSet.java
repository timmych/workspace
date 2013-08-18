package com.xzz.util;

public class BitSet {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        System.out.println(toString((byte)1));
        int bad = ((1 << 31) >> 1);
        System.out.println(toString(bad));
        System.out.println(toString(10));
        System.out.println(toString((byte)10));
//        System.out.println(toString((byte)12));
    }
    
    public static String toString(byte b){
        StringBuilder sb = new StringBuilder();
        long mask = 1 << 7;
        for(int i = 0; i < 8; ++i){
            sb.append((b & mask) != 0 ? '1' : '0');
            mask >>= 1;
        }
        return sb.toString();
    }
    
    public static String toString(int b){
        StringBuilder sb = new StringBuilder();
        long mask = ((long)1) << 31;
        for(int i = 0; i < 32; ++i){
            sb.append((b & mask) != 0 ? '1' : '0');
            mask >>= 1;
        }
        return sb.toString();
    }
}
