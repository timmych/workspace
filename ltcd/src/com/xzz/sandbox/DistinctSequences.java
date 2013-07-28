package com.xzz.sandbox;

public class DistinctSequences {
    public int numDistinct(String S, String T) {
        int [][] cache = new int[S.length() + 1][T.length() +1];
        for(int s = 0; s <= S.length(); ++s){
            cache[s][T.length()] = 1;
        }
        for(int t = 0; t < T.length(); ++t){
            cache[S.length()][t] = 0;
        }
        for(int s = S.length() -1 ;s >= 0; --s){
            for(int t = T.length() - 1; t >= 0; --t){
                cache[s][t] = S.charAt(s) == T.charAt(t) ? 
                    cache[s+1][t+1] + cache[s+1][t]
                    : cache[s+1][t];
            }
        }
        return cache[0][0];
//        return recNumDistinct(S, 0, T, 0);
    }
    
    
    public int recNumDistinct(String S, int s, String T, int t){
        if(t == T.length()){
            return 1;
        }
        if(s == S.length()){
            return 0;
        }
        if(S.length() - s < T.length() - t){
            return 0;
        }
        if(S.charAt(s) == T.charAt(t)){
            return recNumDistinct(S, s+1, T, t+1) + recNumDistinct(S, s+1, T, t);
        }
        return recNumDistinct(S, s+1, T, t);
    }
}