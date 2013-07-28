package com.xzz.sandbox;

public class LongestCommonPrefix {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs == null || strs.length == 0){
            return "";
        }
        int pos = 0;
        while(true){
            char c0;
            if(pos >= strs[0].length()){
                return strs[0].substring(0, pos);
            }else{
                c0 = strs[0].charAt(pos);
            }
            for(String s : strs){
                if(pos >= s.length() || s.charAt(pos) != c0){
                    return strs[0].substring(0, pos);
                }
            }
            pos++;
        }
    }
}
