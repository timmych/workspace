package com.xzz.sandbox;

import java.util.Stack;

public class LongestValidParentheses {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new LongestValidParentheses().longestValidParentheses("()"));
    }
    
    public int longestValidParentheses(String s){
        Stack<Integer> stk = new Stack<Integer>();
        int[] buf = new int[s.length()];
        for(int i = 0; i < buf.length; ++i){
            buf[i] = -1;
        }
        int maxLen = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                stk.push(i);
            }else{
                if(stk.size() == 0){
                    //discard a useless ')' and reset count
                }else{
                    int head = stk.pop();
                    buf[i] = head;
                }
            }
        }
        
        for(int i = s.length() - 1; i >= 0; --i){
            if(buf[i] >= 0){
                int curLen = 0;
                int next = i;
                while(next >=0 && buf[next] >= 0){
                    curLen += (next - buf[next] + 1);
                    next = buf[next] - 1;//find connected valid sequence
                }
                if(curLen > maxLen){
                    maxLen = curLen;
                }
            }
        }
        
        return maxLen;
    }

    public int longestValidParenthesesNoStack(String s) {
        
        int maxLen = 0;
        int curLen = 0;
        int curVal = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '('){
                curVal++;
            }else{
                curVal--;
            }
            if(curVal < 0){
                curVal = 0;
                curLen = 0;
            }else{
                curLen++;
                if(curVal == 0){
                    if(curLen > maxLen){
                        maxLen = curLen;
                    }
                }
            }
        }
        return maxLen;
    }
}
