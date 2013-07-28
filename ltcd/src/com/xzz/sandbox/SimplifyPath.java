package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new SimplifyPath().simplifyPath("/c/d/.././b/a/"));
    }

    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(path == null){
            return null;
        }
        String[] segStrs = split(path, '/');
        List<String> stk = new ArrayList<String>();
        for(String seg : segStrs){
            if(seg.equals("..")){
                if(stk.size() > 0){
                    stk.remove(stk.size() - 1);
                }
            }else if(seg.equals(".")){
                
            }else{
                stk.add(seg);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stk.size(); ++i){
            if(i > 0 || path.startsWith("/")){
                sb.append("/");
            }
            sb.append(stk.get(i));
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
    
    private static String[] split(String s, char sep){
        StringBuilder sb = new StringBuilder();
        List<String> retval = new ArrayList<String>();
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == sep){
                if(sb.length() > 0){
                    retval.add(sb.toString());
                    sb = new StringBuilder();
                }
            }else{
                sb.append(s.charAt(i));
            }
        }
        if(sb.length() > 0){
            retval.add(sb.toString());
        }
        return retval.toArray(new String[retval.size()]);
    }
}
