/**
 * 
 */
package com.xzz.sandbox;

/**
 * @author xiaozhec
 * 
 */
public class SolutionAddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((new SolutionAddBinary()).addBinary("1", "1"));
	}

	public String addBinary(String a, String b) {
		// Start typing your Java solution below
		// DO NOT write main() function
		char[] aChs = a.toCharArray();
		char[] bChs = b.toCharArray();
		int len = Math.max(a.length(), b.length());
		char[] chs = new char[len];
		
		boolean carryOver = false;
		for (int i = 1; i <= len; ++i) {
			int ia = a.length() - i;
			int ib = b.length() - i;
			int iLen = len - i;
			
			char ach = ia >= 0 ? aChs[ia] : '0';
			char bch = ib >= 0 ? bChs[ib] : '0';

			int sum = 0;
			if (ach == '1') {
				sum++;
			}
			if (bch == '1') {
				sum++;
			}
			if (carryOver) {
				sum++;
			}
			switch (sum) {
			case 0:
				carryOver = false;
				chs[iLen] = '0';
				break;
			case 1:
				carryOver = false;
				chs[iLen] = '1';
				break;
			case 2:
				carryOver = true;
				chs[iLen] = '0';
				break;
			case 3:
				carryOver = true;
				chs[iLen] = '1';
				break;
			default:
				//log error
			}
		}
		
		String tmp = new String(chs);
		return carryOver ? "1" + tmp : tmp;
	}
}
