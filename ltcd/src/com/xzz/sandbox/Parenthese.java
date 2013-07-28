package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parenthese {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> list = new ArrayList<String>();
        if(n == 0){
            return list;
        }
        gen(n, n, list, new char[n*2]);
        return list;
    }
    
    public void gen(int nl, int nr, List<String> lst, char[] chs){
        if(nl == 0 && nr == 0){
            lst.add(new String(chs));
        }
        if(nl > nr){
            return;
        }
        int curChar = chs.length - nl - nr;
        if(nl > 0){
            chs[curChar] = '(';
            gen(nl - 1, nr, lst, chs);
        }   
        if(nr > 0){
            chs[curChar] = ')';
            gen(nl, nr - 1, lst, chs);
        }
    }
    
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Character> stk = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(stk.size() > 0){
                char top = stk.peek();
                int code = match(top, c);
                if(code == 0){
                    stk.pop();
                    continue;
                }else if(code == 1){
                    stk.push(c);
                    continue;
                }else{
                    return false;
                }
            }
            stk.push(c);
        }
        return stk.size() == 0;
    }
    
    public int match(char top, char cur){
        
        if(cur == '{' || cur == '(' || cur == '['){
            return 1;
        }
        
        if((cur == '}' && top == '{') || (cur == ']' && top == '[') 
            || (cur == ')' && top == '(')){
                return 0;
            }
        return -1;
    }

}
