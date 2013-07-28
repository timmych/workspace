package com.xzz.sandbox;

public class NumsDecodings {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s== null || s.length() == 0){
            return 0;
        }
        int[] cache = new int[s.length()];
        cache[0] = s.charAt(0) == '0' ? 0 : 1;
        //cache[1] = isValid(s.charAt(0), s.charAt(1)) ? 2 : 1;
        for(int i = 1; i < s.length(); ++i){
            cache[i] = 0;
            if(isValid(s.charAt(i - 1), s.charAt(i))){
                if(i > 1){
                    cache[i] += cache[i - 2];
                }else{
                    cache[i] += 1;
                }
            }
            if(s.charAt(i) != '0'){
                cache[i] += cache[i - 1];
            }
        }
        return cache[s.length() - 1];
    }
    
    private boolean isValid(char c1, char c2){
        if(c1 == '0'){
            return false;
        }
        if(c1 == '1'){
            return true;
        }
        if(c1 == '2' && c2 < '7'){
            return true;
        }
        return false;
    }
}
