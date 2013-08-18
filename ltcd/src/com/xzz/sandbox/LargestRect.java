package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestRect {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null || height.length == 0){
            return 0;
        }
        int maxArea = height[0];
        for(int i = 0; i < height.length; ++i){
            int maxHeight = height[i];
            for(int j = i; j < height.length; ++j){
                if(j > i){
                    maxHeight = Math.min(maxHeight, height[j]);
                }
                maxArea = Math.max(maxArea, maxHeight * (j - i + 1));
            }
        }
        return maxArea;
    }
    
    public int largestRectangleArea2(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(height == null || height.length == 0){
            return 0;
        }
        if(height.length == 1){
        	return height[0];
        }
        
        Stack<Integer> stk = new Stack<Integer>();
        //stk.push(0);
        int area = 0;
        int pos = 0;
        while(pos <= height.length){
        	if(pos < height.length && (stk.isEmpty() || height[pos] >= height[stk.peek()])){
        		stk.push(pos++);
        	}else{
        		int ht = pos == height.length ? 0 : height[pos];
        		while(!stk.isEmpty() && height[stk.peek()] >= ht){
        			int curPos = stk.pop();
        			int curHeight = height[curPos];
        			int curArea = stk.isEmpty() ? curHeight * pos : curHeight * (pos - stk.peek() - 1);
        			if(curArea > area){
        				area = curArea;
        			}
        		}
        		if(pos == height.length){
        			break;
        		}
        	}
        }
        return area;
    }
    

    public static void main(String[] args){
    	
    	int[] myints = new int[20000];
    	for(int i = 0;i < 20000; ++i){
    		myints[i] = i;
    	}
    	
    	System.out.println(new LargestRect().largestRectangleArea2(new int[]{2,1,2}));
    }
}
