package com.xzz.sandbox;

import com.xzz.util.Timing;

public class EditDistance {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Timing t = new Timing();
        t.reset();
        System.out.println(new EditDistance().minDistance("dinitrophenylhydrazine", "acetylphenylhydrazine"));
        t.check("");
    }
    
    private Integer[][] cache;
    
    public int minDistance(String word1, String word2){
        cache = new Integer[word1.length()][word2.length()];
        return recMinDistance(word1.toCharArray(), 0, word2.toCharArray(), 0);
    }

    private int recMinDistance(char[] source, int pos1, char[] target, int pos2) {
        if(pos1 == source.length || pos2 == target.length){
            return source.length - pos1 + target.length - pos2;
        }
        
        if(cache[pos1][pos2] != null){
            return cache[pos1][pos2];
        }
        
        if(source[pos1] == target[pos2]){
            int retval = recMinDistance(source, pos1+1, target, pos2 + 1);
            cache[pos1][pos2] = retval;
            return retval;
        }
        //remove one
        int ret1 = recMinDistance(source, pos1 + 1, target, pos2) + 1;
        //insert one
        int ret2 = recMinDistance(source, pos1, target, pos2 + 1) + 1;
        //replace one
        int ret3 = recMinDistance(source, pos1 + 1, target, pos2 + 1) + 1;
        int retval =  Math.min(ret1,  Math.min(ret2, ret3));
        cache[pos1][pos2] = retval;
        return retval;
    }

}
