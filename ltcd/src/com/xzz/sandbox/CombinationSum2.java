package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum2 {
    public class Solution {
        public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
            // Start typing your Java solution below
            // DO NOT write main() function
            Arrays.sort(candidates);
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            
            for(int i = 0; i < candidates.length; ++i){
                if(i == 0 || candidates[i] != candidates[i - 1]){
                    tmp.add(candidates[i]);
                }
            }
            Integer[] newcan = tmp.toArray(new Integer[tmp.size()]);
            int[] count = new int[newcan.length];
            int pos = -1;
            for(int i = 0; i < candidates.length; ++i){
                if(i > 0 && candidates[i] == candidates[i - 1]){
                    count[pos]++;
                }else{
                    count[++pos] = 1;
                }
            }
            
            ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
            recComb(newcan, count, 0, target, retVal, new ArrayList<Integer>());
            return retVal;
        }
        
        public void recComb(Integer[] candidates, int[] count, int pos, int target, 
            ArrayList<ArrayList<Integer>> retVal, ArrayList<Integer> lst){
            if(target == 0){
                retVal.add(new ArrayList<Integer>(lst));
                return;
            }
            if(pos >= candidates.length || candidates[pos] > target){
                return;
            }
            recComb(candidates, count, pos+1, target, retVal, lst);
            for(int i = 1; i <= Math.min(target / candidates[pos], count[pos]); ++i){
                lst.add(candidates[pos]);
                recComb(candidates, count, pos+1, target - candidates[pos] * i, retVal, lst);
            }
            for(int i = 0; i < Math.min(target / candidates[pos], count[pos]); ++i){
                lst.remove(lst.size() - 1);
            }
        }
    }
}
