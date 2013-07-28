package com.xzz.sandbox;

import java.util.HashMap;
import java.util.Map;


public class MinWindowSubstring {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MinWindowSubstring().minWindow("ADOBECODEBANC", "ABCD"));
    }
    
//    public String minWindow2(String S, String T){
//        Map<Character, Integer> tMap = new HashMap<Character, Integer>();
//        Map<Character, Integer> sMap = new HashMap<Character, Integer>();
//        for(char t : T.toCharArray()){
//            if(tMap.containsKey(t)){
//                tMap.put(t, 1);
//            }else{
//                tMap.put(t, tMap.get(t) + 1);
//            }
//        }
//        int head = 0;
//        int tail = 0;
//        while(tail )
//    }

    public String minWindow(String S, String T) {
        Integer[] map = new Integer[T.length()];
        int minWindowLength = S.length();
        int minPos = 0;
        int maxPos = -1;
        for(int i = 0 ; i < T.length(); ++i){
            map[i] = -1;
        }
        for(int spos = 0; spos < S.length(); ++spos){
            
            boolean hasFilled = false;
            
            int leftMost = S.length();
            int leftMostTIndex = -1;
            
            for(int tpos = 0; tpos < T.length(); ++tpos){
                //spos char can be used if needed
                if(T.charAt(tpos) == S.charAt(spos)){
                    //there is a unfilled char we need to fill it as first priority
                    if(map[tpos] == -1){
                        hasFilled = true;
                        map[tpos] = spos;
                        break;
                    }else{//there is a matching one but already filled, potential candidate for update
                        if(map[tpos] < leftMost){
                            leftMost = map[tpos];
                            leftMostTIndex = tpos;
                        }
                    }
                }
            }
            if(!hasFilled && leftMostTIndex >= 0){
                map[leftMostTIndex] = spos;
            }
            
            boolean hasUnfilled = false;
            int localMinPos = S.length();
            int localMaxPos = -1;
            for(int tpos = 0; tpos < T.length(); ++tpos){
                if(map[tpos] == -1){
                    hasUnfilled = true;
                    break;
                }
                if(map[tpos] > localMaxPos){
                    localMaxPos = map[tpos];
                }
                if(map[tpos] < localMinPos){
                    localMinPos = map[tpos];
                }
            }
            if(!hasUnfilled){
                if(localMaxPos - localMinPos < minWindowLength){
                    minWindowLength = localMaxPos - localMinPos;
                    minPos = localMinPos;
                    maxPos = localMaxPos;
                }
            }
        }
        
        return S.substring(minPos, maxPos + 1);
    }
}
