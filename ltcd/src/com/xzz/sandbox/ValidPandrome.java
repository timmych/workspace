package com.xzz.sandbox;

public class ValidPandrome {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s == null) {
            return false;
        }

        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            while (head < tail && !isAlpha(s.charAt(head))) {
                head++;
            }
            while (tail > head && !isAlpha(s.charAt(tail))) {
                tail--;
            }
            if (head >= tail) {
                return true;
            }
            if (Character.toLowerCase(s.charAt(head++)) != Character.toLowerCase(s.charAt(tail--))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlpha(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

}
