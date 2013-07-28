package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(candidates);
        ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
        recComb(candidates, 0, target, retVal, new ArrayList<Integer>());
        return retVal;
    }
    
    public void recComb(int[] candidates, int pos, int target, 
        ArrayList<ArrayList<Integer>> retVal, ArrayList<Integer> lst){
        if(target == 0){
            retVal.add(new ArrayList<Integer>(lst));
            return;
        }
        if(pos >= candidates.length || candidates[pos] > target){
            return;
        }
        recComb(candidates, pos+1, target, retVal, lst);
        for(int i = 1; i <= target / candidates[pos]; ++i){
            lst.add(candidates[pos]);
            recComb(candidates, pos+1, target - candidates[pos]*i, retVal, lst);
        }
        for(int i = 0; i < target / candidates[pos]; ++i){
            lst.remove(lst.size() - 1);
        }
    }
}
