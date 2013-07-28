package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new Anagrams().anagrams(new String[]{
                "abcb", "added", "bcba", "cbca", "acbb"
        }));
    }

    public ArrayList<String> anagrams(String[] strs) {
        Map<String, Integer> strMap = new HashMap<String, Integer>();
        ArrayList<String> retVal = new ArrayList<String>();
        boolean[] flags = new boolean[strs.length];
        for(int index = 0; index < strs.length; ++index){
            String encodedS = encode(strs[index]);
            if(strMap.containsKey(encodedS)){
                Integer i = strMap.get(encodedS);
                if(i != null){
                    flags[i] = true;
                    strMap.put(encodedS, null);
                }
                flags[index] = true;
            }else{
                strMap.put(encodedS, index);
            }
        }
        for(int index = 0; index < strs.length; ++index){
            if(flags[index]){
                retVal.add(strs[index]);
            }
        }
        return retVal;
    }

    private String encode(String s) {
        int[] chs = new int[26];
        for(char c : s.toCharArray()){
            chs[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; ++i) {
            if(chs[i] > 0){
                sb.append(chs[i]);
                sb.append((char)('a' + i));
            }
        }
        return sb.toString();
    }
}
