package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_Triage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Solution_Triage().minimumTotal(Arrays.asList(
				Arrays.asList(2),
				Arrays.asList(3,4),
				Arrays.asList(6,5,7),
				Arrays.asList(4,1,8,3)
				)));
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		for(int r = 0; r < triangle.size(); ++r){
			if(r == 0){
				if(triangle.size() == 1){
					return triangle.get(0).get(0);
				}
				continue;
			}
			List<Integer> row = triangle.get(r);
			for(int i = 0; i < row.size(); ++i){
				if(i == 0){
					row.set(i, triangle.get(r - 1).get(i) + row.get(i)); 
				}else if(i == row.size() - 1){
					row.set(i, triangle.get(r - 1).get(i - 1) + row.get(i));
				}else{
					row.set(i, Math.min(triangle.get(r - 1).get(i) + row.get(i), 
							triangle.get(r - 1).get(i - 1) + row.get(i)));
				}
			}
			if(r == triangle.size() - 1){
				int retVal = Integer.MAX_VALUE;
				for(Integer sum : row){
					if(sum < retVal){
						retVal = sum;
					}
				}
				return retVal;
			}
		}		
		return -1;
	}
}
