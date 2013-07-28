/**
 * 
 */
package com.xzz.sandbox;

/**
 * @author xiaozhec
 * 
 */
public class InterleavingString {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        //System.out.println(Double.valueOf("a"));
        
        // TODO Auto-generated method stub
        //"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"
        System.out.println(new InterleavingString().isInterleaveNonRec("aabaac", "aadaaeaaf", "aadaaeaabaafaac"));
                //"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa", "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab", "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"));
    }
    
    public boolean isInterleaveNonRec(String s1, String s2, String s3){
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] flags = new boolean[s1.length() + 1][s2.length() + 1];
        flags[0][0] = true;
        for(int i1 = 0; i1 <= s1.length(); ++i1){
            for(int i2 = 0; i2 <= s2.length(); ++i2){
                if(i1 == 0 && i2 == 0){
                    flags[i1][i2] = true;
                }else{
                    if(i1 > 0 && flags[i1 - 1][i2] && s3.charAt(i1 + i2 - 1) == s1.charAt(i1 - 1)){
                        flags[i1][i2] = true;
                    }else if(i2 > 0 && flags[i1][i2 - 1] && s3.charAt(i1 + i2 - 1) == s2.charAt(i2 - 1)){
                        flags[i1][i2] = true;
                    }else{
                        flags[i1][i2] = false;
                    }
                }
            }
        }
        return flags[s1.length()][s2.length()];
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        
        if (s3.length() != s1.length() + s2.length())
            return false;
        
        this.cache = new Boolean[s1.length() + 1][s2.length() + 1];
        return recIsInterleave(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }
    
    private Boolean[][] cache;

    private boolean recIsInterleave(char[] str, char[] str2, char[] str3, int i, int i2, int i3) {
        if (i3 == str3.length) {
            return true;
        }
        if (i >= str.length && i2 >= str2.length) {
            return false;
        }
//        if(cache[i][i2] != null){
//            return cache[i][i2];
//        }
        if (i < str.length && str[i] == str3[i3] && recIsInterleave(str, str2, str3, i + 1, i2, i3 + 1)) {
            cache[i][i2] = true;
            return true;
        }
        if (i2 < str2.length && str2[i2] == str3[i3] && recIsInterleave(str, str2, str3, i, i2 + 1, i3 + 1)) {
            cache[i][i2] = true;
            return true;
        }
        return false;
    }
}
