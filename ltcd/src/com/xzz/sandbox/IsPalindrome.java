package com.xzz.sandbox;

public class IsPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((new IsPalindrome()).isPalindrome("..A man, a plan, a canal: Panama()"));
	}
	
	private boolean isAlphaNum(char c){
		return Character.isDigit(c) || Character.isLetter(c);
	}

    public boolean isPalindrome(String s) {
    	s = s.toLowerCase();
    	char[] chs = s.toCharArray();
    	int head = 0, tail = chs.length - 1;
    	while(head < tail){
    		while(head < chs.length && !isAlphaNum(chs[head])){
    			head++;
    		}
    		while(tail >= 0 && !isAlphaNum(chs[tail])){
    			tail--;
    		}
    		if(head >= tail){
    			break;
    		}
    		if(chs[head++] != chs[tail--]){
    			return false;
    		}
    	}
    	return true;
    }
}
