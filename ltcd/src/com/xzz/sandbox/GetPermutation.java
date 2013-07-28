package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new GetPermutation().getPermutation(9, 100));
    }

    public String getPermutation(int n, int k) {
        if(n <= 0){
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        long[] total = new long[n + 1];
        total[0] = 1;
        //total 0:1 1:1 2:2 3:6 4:12
        int i = 1;
        for(; i <= n; ++i){
            total[i] = i * total[i - 1];
            if(total[i] >= k){
                break;
            }
        }
        
        List<Integer> lst = new ArrayList<Integer>();
        for(int j = 1; j <= n; ++j){
            if(j <= n - i){
                sb.append(j);
            }else{
                lst.add(j);
            }
        }
        
        int remain = k - 1;
        for(int j = i; j > 0; --j){
            int cur = (int)((long)remain / total[j - 1]);
            remain = (int)((long)remain % total[j - 1]);
            sb.append(lst.get(cur));
            lst.remove(cur);
        }
        
        return sb.toString();
    }
}
