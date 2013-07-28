package com.xzz.sandbox;

import java.util.ArrayList;

public class RestoreIPAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> lst = new ArrayList<String>();
        recRestore(lst, 0, s, 0, new ArrayList<Integer>());
        return lst;
    }
    
    public void recRestore(ArrayList<String> lst, int seg, String s, int pos,
        ArrayList<Integer> ips){
        int val = 0;
        int i = pos;
        
        if(seg == 4){
            if(pos == s.length()){
                lst.add(ips.get(0) + "." + ips.get(1) + "." + ips.get(2)
                    + "." + ips.get(3));
            }
            return;
        }
        
        if(pos < s.length() && s.charAt(pos) == '0'){
            ips.add(0);
            recRestore(lst, seg + 1, s, pos+1, ips);
            ips.remove(ips.size() - 1);
        }else{
        
            for(; i < s.length(); ++i){
                val = val*10 + (int)(s.charAt(i) - '0');
                if(val > 255){
                    --i;
                    break;
                }else{
                    ips.add(val);
                    recRestore(lst, seg + 1, s, i + 1, ips);
                    ips.remove(ips.size() - 1);
                }
            }
        }        
    }
}