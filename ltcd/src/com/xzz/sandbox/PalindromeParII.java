package com.xzz.sandbox;

import java.util.ArrayList;

import com.xzz.util.Timing;

public class PalindromeParII {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        System.out
//                .println(new PalindromeParII()
//                        .minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
//        
        System.out.println(new PalindromeParII().partition("aab"));
        
    }
    
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<String>> lst = new ArrayList<ArrayList<String>>();
        if (s == null) {
            return lst;
        }
        // palin[a][b] ===> [a, b) is palindrome or not
        boolean[][] palin = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            palin[i][i] = true;
            if (i < s.length()) {
                palin[i][i + 1] = true;
            }
        }
        for (int len = 2; len <= s.length(); ++len) {
            for (int start = 0; start <= s.length() - len; ++start) {
                palin[start][start + len] = palin[start + 1][start + len - 1]
                        && (s.charAt(start) == s.charAt(start + len - 1));
            }
        }
        
        recPartition(palin, s, 0, s.length() - 1, lst, new ArrayList<String>());
        return lst;
    }

    private void recPartition(boolean[][] palin, String s, int start, int end,
            ArrayList<ArrayList<String>> lst, ArrayList<String> arrayList) {
        if(start > end) {
            lst.add(new ArrayList<String>(arrayList));
            return;
        }
        for(int cut = start + 1; cut <= end + 1; ++cut){
            if(palin[start][cut]) {
                arrayList.add(s.substring(start, cut));
                recPartition(palin, s, cut, end, lst, arrayList);
                arrayList.remove(arrayList.size() - 1);
            }
        }
    }

    public int minCut(String s) {
        Timing t = new Timing();
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null || s.length() < 2) {
            return 0;
        }
        t.reset();
        // palin[a][b] ===> [a, b) is palindrome or not
        boolean[][] palin = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i <= s.length(); ++i) {
            palin[i][i] = true;
            if (i < s.length()) {
                palin[i][i + 1] = true;
            }
        }
        for (int len = 2; len <= s.length(); ++len) {
            for (int start = 0; start <= s.length() - len; ++start) {
                palin[start][start + len] = palin[start + 1][start + len - 1]
                        && (s.charAt(start) == s.charAt(start + len - 1));
            }
        }
        t.check("palin done");
        //return getMinCutRec(palin, 0, s.length() - 1);
        int[] mincut = new int[s.length()];
        for(int start = 0; start < s.length(); ++start) {
            mincut[start] = palin[start][s.length()] ? 0 : s.length() - start - 1;
        }
        for(int start = s.length() - 2; start >= 0; --start) {
            for(int cut = start + 1; cut < s.length(); ++ cut) {
                //start..cut -1; cut...s.lengt()-1
                if(palin[start][cut] && mincut[cut] + 1 < mincut[start]) {
                    mincut[start] = mincut[cut] + 1;
                }
            }
        }
        t.check("mincut done");
        return mincut[0];
    }

    private int getMinCutRec(boolean[][] palin, int p0, int p1) {
        if(palin[p0][p1 + 1]){
            return 0;
        }
        int cut = Integer.MAX_VALUE;
        for(int c = p0 + 1; c <= p1; ++c){
            int newcut = getMinCutRec(palin, p0, c - 1) + getMinCutRec(palin, c, p1) + 1;
            if(newcut < cut) {
                cut = newcut;
            }
            if(newcut == 1) {
                break;
            }
        }
        return cut;
    }
}
