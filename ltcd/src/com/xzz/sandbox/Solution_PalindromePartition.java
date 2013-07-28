/**
 * 
 */
package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaozhec
 *
 */
public class Solution_PalindromePartition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new Solution_PalindromePartition().partition("aab") );
//		for(List<String> p : partitions){
//			System.out.println(p);
//		}
	}

    public ArrayList<ArrayList<String>> partition(String s) {
    	//boolean[][] flag = new boolean[s.length()][s.length()];
    	ArrayList<ArrayList<Integer>> poses = new ArrayList<ArrayList<Integer>>(s.length());
    	for(int i = 0; i < s.length(); ++i){
    		poses.add(new ArrayList<Integer>());
    	}
    	char[] ch = s.toCharArray();
    	for(int i = 0; i < s.length(); ++i){
    		for(int j = i; j < s.length(); ++j){
    			if(isPalindrome(ch, i, j)){
    		//		flag[i][j] = true;
    				poses.get(i).add(j);
    			}
    		}
    	}
    	ArrayList<ArrayList<String>> retVal = new ArrayList<ArrayList<String>>();
    	recPartition(s, 0, poses, new ArrayList<Integer>(), retVal);
    	return retVal;
    }

	private void recPartition(String s, int i,
			ArrayList<ArrayList<Integer>> poses, ArrayList<Integer> route,
			ArrayList<ArrayList<String>> retVal) {
		if(i == s.length()){
			ArrayList<String> ret = new ArrayList<String>();
			
			for(int k = 0; k < route.size(); ++k){
				if(k == route.size() - 1){
					ret.add(s.substring(route.get(k), s.length()));
				}else{
					ret.add(s.substring(route.get(k), route.get(k + 1)));
				}
			}
			retVal.add(ret);
			return;
		}
		route.add(i);
		for(Integer pos : poses.get(i)){
			recPartition(s, pos + 1, poses, route, retVal);
		}
		route.remove(route.size() - 1);
	}

	private boolean isPalindrome(char[] ch, int i, int j) {
		if(i == j){
			return true;
		}
		while(i < j){
			if(ch[i++] != ch[j--]){
				return false;
			}
		}
		return true;
	}
}
