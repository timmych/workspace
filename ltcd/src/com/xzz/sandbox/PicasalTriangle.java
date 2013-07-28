package com.xzz.sandbox;

import java.util.ArrayList;

public class PicasalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main(ArrayList<E>n
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0){
            return ret;
        }
        ret.add(new ArrayList<Integer>());
        ret.get(0).add(1);
        for(int row = 1; row < numRows; ++row){
            ArrayList<Integer> cur = new ArrayList<Integer>();
            int count = row + 1;
            for(int i = 0; i < count; ++i){
                if(i == 0){
                    cur.add(ret.get(row - 1).get(i));
                }else if(i == count - 1){
                    cur.add(ret.get(row - 1).get(i - 1));
                }else{
                    cur.add(ret.get(row - 1).get(i)
                    + ret.get(row - 1).get(i - 1));
                }
            }
            ret.add(cur);
        }
        return ret;
    }
}
