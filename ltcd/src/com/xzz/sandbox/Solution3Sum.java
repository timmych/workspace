/**
 * 
 */
package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author xiaozhec
 * 
 */
public class Solution3Sum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		long time0 = System.currentTimeMillis();

		ArrayList<ArrayList<Integer>> retval = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(num);
		HashSet<Integer> sumSet = new HashSet<Integer>();
		
		for (int i = 0; i < num.length; ++i) {
			if(i > 0 && num[i] != num[i-1]){
				sumSet.clear();
			}
			int expectedSum = -num[i];
			int head = i + 1;
			int tail = num.length - 1;
			while (head < tail) {
				if (num[head] + num[tail] == expectedSum) {
					if(!sumSet.contains(num[head])){
						retval.add(new ArrayList<Integer>(Arrays.asList(num[i], num[head], num[tail])));
						sumSet.add(num[head]);
					}
					head++;
				} else if (num[head] + num[tail] < expectedSum) {
					head++;
				} else {
					tail--;
				}
			}
		}
		System.out.printf("threeSum taking time %d ms\r\n", System.currentTimeMillis() - time0);
		return retval;
	}

	public ArrayList<ArrayList<Integer>> threeSumTooSlow(int[] num) {
		// Start typing your Java solution below
		// DO NOT write main() function
		long time0 = System.currentTimeMillis();
		ArrayList<ArrayList<Integer>> retval = new ArrayList<ArrayList<Integer>>();
		Set<String> sumSet = new HashSet<String>();
		Arrays.sort(num);
		for (int i = 0; i < num.length; ++i) {
			for (int j = i + 1; j < num.length - 1; ++j) {
				int expected = -num[i] - num[j];
				if (num[j + 1] > expected || num[num.length - 1] < expected) {
					continue;
				}
				int head = j + 1;
				int tail = num.length - 1;
				while (head <= tail) {
					int k = (head + tail) / 2;
					if (num[k] == expected) {
						String dupKey = String.format("%d,%d,%d", num[i],
						num[j], num[k]);
						if (!sumSet.contains(dupKey)) {
						retval.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[k])));
						sumSet.add(dupKey);
						}
						break;
					}
					if (num[k] < expected) {
						head = k + 1;
					} else {
						tail = k - 1;
					}
				}
			}
		}
		System.out.printf("threeSumTooSlow taking time %d ms\r\n", System.currentTimeMillis() - time0);
		return retval;
	}

	public static void main(String[] args) {
		Solution3Sum s = new Solution3Sum();
		ArrayList<ArrayList<Integer>> retval = s.threeSum(new int[] { -12, 12, -5, -4, -12, 11, 9, -11, 13, 1, 12, -1,
				8, 1, -9, -11, -13, -4, 10, -9, -6, -11, 1, -15, -3, 4, 0, -15, 3, 6, -4, 7, 3, -2, 10, -2, -6, 4, 2,
				-7, 12, -1, 7, 6, 7, 6, 2, 10, -13, -3, 8, -12, 2, -5, -12, 6, 6, -5, 6, -5, -14, 9, 9, -4, -8, 4, 2,
				-7, -15, -11, -7, 12, -4, 8, -5, -12, -1, 12, 5, 1, -5, -1, 5, 12, 9, 0, 3, 0, 3, -14, 2, -4, 2, -4, 0,
				1, 7, -13, 9, -1, 13, -12, -11, -6, 11, -1, -10, -5, -3, 10, 3, 7, -6, -15, -4, 10, 1, 14, -12 });
		ArrayList<ArrayList<Integer>> retval2 = s
				.threeSumTooSlow(new int[] { -12, 12, -5, -4, -12, 11, 9, -11, 13, 1, 12, -1, 8, 1, -9, -11, -13, -4,
						10, -9, -6, -11, 1, -15, -3, 4, 0, -15, 3, 6, -4, 7, 3, -2, 10, -2, -6, 4, 2, -7, 12, -1, 7, 6,
						7, 6, 2, 10, -13, -3, 8, -12, 2, -5, -12, 6, 6, -5, 6, -5, -14, 9, 9, -4, -8, 4, 2, -7, -15,
						-11, -7, 12, -4, 8, -5, -12, -1, 12, 5, 1, -5, -1, 5, 12, 9, 0, 3, 0, 3, -14, 2, -4, 2, -4, 0,
						1, 7, -13, 9, -1, 13, -12, -11, -6, 11, -1, -10, -5, -3, 10, 3, 7, -6, -15, -4, 10, 1, 14, -12 });
		System.out.printf("%d:%d", retval.size(), retval2.size());
		// for (ArrayList<Integer> lst : retval) {
		// for (Integer i : lst) {
		// System.out.print(i + " ");
		// }
		// System.out.println();
		// }
	}
}
