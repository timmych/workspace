package com.foo.bar.sandbox;

import java.util.Arrays;

public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s1 == null || s2 == null){
            return false;
        }
        if(s1.length() != s2.length()){
            return false;
        }
        
        if(s1.equals(s2)){
            return true;
        }
        String[][] sign1 = getSignature(s1);
        String[][] sign2 = getSignature(s2);
//        for(int div = 0; div < s1.length(); ++div){
            if(isScramble(s1.toCharArray(), 0, s1.length() -1 , s2.toCharArray(), 0
            , s2.length() - 1, sign1, sign2)){
                return true;
            }
  //      }
        return false;
    }
    
    public String[][] getSignature(String s){
        String[][] retval = new String[s.length()][s.length()];
        for(int i = 0; i < s.length(); ++i){
            for(int j = i; j < s.length(); ++j){
                char[] chs = s.substring(i, j+1).toCharArray();
                Arrays.sort(chs);
                retval[i][j] = new String(chs);
                retval[j][i] = retval[i][j];
            }
        }
        return retval;
    }
    
    public boolean isScramble(char[] s1, int start, int end, char[] s2, 
    int start2, int end2, String[][] sign1, String[][] sign2){
        if(start == end && s1[start] == s2[start2]){
            return true;
        }
        if(!sign1[start][end].equals(sign2[start2][end2])){
            return false;
        }
        for(int div = start; div < end; ++ div){
            if(isScramble(s1, start, div, s2, start2, start2 + div - start, sign1, sign2) &&
            isScramble(s1, div + 1, end, s2, start2 + div + 1 - start, end2, sign1, sign2)){
                return true;
            }
            int mid = end2 - div + start;
            if(isScramble(s1, start, div, s2, mid, end2, sign1, sign2) && 
            isScramble(s1, div + 1, end, s2, start2, mid - 1, sign1, sign2)){
                return true;
            } 
        }
        return false;
    }
}
