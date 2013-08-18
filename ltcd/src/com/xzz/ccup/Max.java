package com.xzz.ccup;

import junit.framework.Assert;

public class Max {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for(int i = -10; i < 10; ++i){
            for(int j = -10; j < 10; ++j){
                Assert.assertTrue(max(i, j) >= i && max(i, j) >= j);
            }
        }

    }

    private static int max(int i, int j) {
        // TODO Auto-generated method stub
        int k = i - j;
        return i - ((k>>31) & 1) * (i - j);
    }

}

