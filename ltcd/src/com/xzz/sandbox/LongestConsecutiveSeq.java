package com.xzz.sandbox;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestConsecutiveSeq().longestConsecutive(new int[]{ 0 , -1}));
	}
	
	public int longestConsecutive(int[] num) {
        Map<Integer, Boolean> set = new HashMap<Integer, Boolean>();
        
        for(int i : num){
            set.put(i, false);
        }
        int len = 0;
        
        for(int i : set.keySet()){
        	if(set.get(i)){
        		continue;
        	}
        	int low = i - 1;
        	while(set.containsKey(low)){
        		set.put(low, true);
        		low--;
        	}
        	int high = i + 1;
        	while(set.containsKey(high)){
      			set.put(high, true);
      			high++;
        	}
        	len = Math.max(high - low - 1, len);
        }
        
        return len;
    }

}
