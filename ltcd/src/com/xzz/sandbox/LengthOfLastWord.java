package com.xzz.sandbox;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                for(int k = i - 1; k >= 0; k--){
                    if(s.charAt(k) == ' '){
                        return i - k;
                    }
                }
                return i + 1;
            }
        }
        return 0;
    }
}
