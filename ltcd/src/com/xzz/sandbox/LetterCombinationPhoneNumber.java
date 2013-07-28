package com.xzz.sandbox;

import java.util.ArrayList;

public class LetterCombinationPhoneNumber {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new LetterCombinationPhoneNumber().letterCombinations("23"));
    }
    
    public ArrayList<String> letterCombinations(String digits) {
        return letterCombinations(digits, 0);
    }
    public ArrayList<String> letterCombinations(String digits, int startIndex) {
        ArrayList<String> comb = new ArrayList<String>();
        if(startIndex == digits.length()){
            comb.add("");
            return comb;
        }
        
        char[] tc = translate(digits.charAt(startIndex));
        ArrayList<String> subcomb = letterCombinations(digits, startIndex + 1);
        
        
        for(char c : tc){
            for(String sub : subcomb){
                comb.add(c + sub);
            }
        }
        
        return comb;
    }
    
    public char[] translate(char c){
        if(c > '9' || c <= '1'){
            return new char[]{};
        }
        
        int offset = (c - '2') * 3;
        if(c >= '8'){
            offset++;
        }
        
        if(offset < 0){
            return new char[]{};
        }
        
        if(c == '7' || c == '9'){
            return new char[]{ (char) ('a' + offset), 
                    (char) ('a' + offset + 1), 
                    (char) ('a' + offset + 2),
                    (char) ('a' + offset + 3)};
        }
        return new char[]{ (char) ('a' + offset), 
                (char) ('a' + offset + 1), 
                (char) ('a' + offset + 2)};
    }
}
