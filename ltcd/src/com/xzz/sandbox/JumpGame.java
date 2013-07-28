package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

public class JumpGame {

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(new int[] {2,3,1,1,4} ));
        System.out.println(new JumpGame().canJump(new int[] {3,2,1,0,4} ));
        
        System.out.println(new JumpGame().minJump(new int[] {2,3,1,1,4} ));
        System.out.println(new JumpGame().minJump(new int[] {3,2,1,0,4} ));
    }
    
    public boolean canJump(int[] A) {
        boolean[] reachable = new boolean[A.length];
        reachable[A.length - 1] = true;
        for(int i = A.length - 1; i >= 0; --i){
            if(reachable[i]){
                for(int dist = 1; dist <= i; ++dist){
                    if(A[i - dist] >= dist){
                        reachable[i - dist] = true;
                        if(i == dist){
                            return true;
                        }
                    }
                }
            }
        }
        return reachable[0];
    }

    public int minJump(int[] A){
        if(A.length <= 1){
            return 0;
        }
        List<Integer> q = new ArrayList<Integer>();
        boolean[] reached = new boolean[A.length];
        int curDist = 0;
        q.add(A.length - 1);
        while(q.size() > 0){
            curDist++;
            List<Integer> nextPos = new ArrayList<Integer>();
            
            for(Integer cur : q){
                for(int dist = 1; cur >= dist; ++dist){
                    int pos = cur - dist; 
                    if( !reached[pos] && A[pos] >= dist ){
                        reached[pos] = true;
                        nextPos.add(pos);
                        if(pos == 0){
                            return curDist;
                        }
                    }
                }
            }
            
            q = nextPos;
        }
        return -1;
    }
}
