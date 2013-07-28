/**
 * 
 */
package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Queue;

import com.xzz.util.Timing;

/**
 * @author xiaozhec
 * 
 */
public class Solution_PalindromePartitionII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Last executed input
		// fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi
		System.out
				.println(new Solution_PalindromePartitionII()
				.minCut("fifgbeajcacehiicccfecbfhhgfiiecdcjjffbghdidbhbdbfbfjccgbbdcjheccfbhafehieabbdfeigbiaggchaeghaijfbjhi"));
//						.minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		// for(List<String> p : partitions){
		// System.out.println(p);
		// }
	}

	private Timing tmg = new Timing();

	public int minCut(String s) {
		////tmg.reset();
		ArrayList<ArrayList<Integer>> poses = new ArrayList<ArrayList<Integer>>(
				s.length());
		for (int i = 0; i < s.length(); ++i) {
			poses.add(new ArrayList<Integer>());
		}

		boolean[][] flags = new boolean[s.length()][s.length()];
		char[] ch = s.toCharArray();
		for (int i = 0; i < s.length(); ++i) {
			for (int k = 0; k < s.length() - i; ++k) {
				if (i == 0) {
					flags[k][k] = true;// single always palindrome
				} else if (i == 1) {
					flags[k][k + i] = ch[k] == ch[k + i];
				} else {
					flags[k][k + i] = flags[k + 1][k + i - 1]
							&& (ch[k] == ch[k + i]);
				}
			}
		}
		// for(int j = s.length() - 1; j >= i; --j){
		// if(isPalindrome(ch, i, j)){
		// poses.get(i).add(j);
		// }
		// }

		for (int i = 0; i < s.length(); ++i) {
			for (int k = s.length() - 1; k >= 0; --k) {
				if (flags[i][k]) {
					poses.get(i).add(k);
				}
			}
		}

		//tmg.check("gencache");
		int retVal = recPartition(s.length(), poses);
		//tmg.check("partition");
		return retVal;
	}

	private int recPartition(int s, ArrayList<ArrayList<Integer>> poses) {
		s = s - 1;
		ArrayList<Integer> q = new ArrayList<Integer>();
		q.add(0);
		int round = 0;
		while (q.size() > 0) {
			ArrayList<Integer> tmp = new ArrayList<Integer>(q.size());
			for (Integer qq : q) {
				List<Integer> qqnext = poses.get(qq);
				for (Integer nextq : qqnext) {
					if (nextq == s) {
						return round;
					}
					if (!tmp.contains(nextq + 1)) {
						tmp.add(nextq + 1);
					}
				}
			}
			q = tmp;
			round++;
		}
		return round - 1;
	}

	private boolean isPalindrome(char[] ch, int i, int j) {
		if (i == j) {
			return true;
		}
		while (i < j) {
			if (ch[i++] != ch[j--]) {
				return false;
			}
		}
		return true;
	}
}
