package com.xzz.sandbox;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(new int[]{
				//100, 4, 200, 1, 3, 2
				0,3,7,2,5,8,4,6,0,1
		}));
	}

	public int longestConsecutive(int[] num) {
		//100,4,200,1,3,2
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i : num){
			
			if(map.containsKey(i)){
				continue;
			}
			
			//itself
			map.put(i, 1);
			
			int leftPos = 0;
			//check left
			if(map.containsKey(i - 1)){
				//i is consecutive right to an existing array
				int oldLen = map.get(i - 1);
				leftPos = i - oldLen;
				map.put(i, oldLen + 1);
				map.put(leftPos, oldLen + 1);
			}
			
			//check right
			if(map.containsKey(i + 1)){
				//i is consecutive left to an existing array
				int oldLen = map.get(i + 1);
				int newLen = map.get(i) + oldLen;
				map.put(i, newLen);
				map.put(i + oldLen, newLen);
				if(map.containsKey(i - 1)){
					map.put(leftPos, newLen);
				}
			}
		}
		
		
		return Collections.max(map.values());
    }
}
