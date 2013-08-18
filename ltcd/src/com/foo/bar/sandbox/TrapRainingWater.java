package com.foo.bar.sandbox;

public class TrapRainingWater {
	
	public static void main(String[] args){
		System.out.println(new TrapRainingWater().trap(new int[]{
			0,1,0,2,1,0,1,3,2,1,2,1	
		}));
	}
	
    public int trap(int[] A) {
    	if(A.length <= 1){
    		return 0;
    	}
//    	int[] B = new int[A.length];
        int[] seq = new int[A.length];
        for(int i = 0; i < seq.length; ++i){
        	seq[i] = i;
  //      	B[i] = A[i];
        }
        //sort desc
        for(int i = 0; i < A.length - 1; ++i){
        	for(int j = i + 1; j >= 1; --j ){
        		if(A[seq[j]] > A[seq[j-1]]){
        			int teq = seq[j - 1];
        			seq[j - 1] = seq[j];
        			seq[j] = teq;
        		}
        	}
        }
        int area = 0;
        int lastPos = seq[0];
        boolean[] counted = new boolean[A.length];
        for(int k = 1; k < A.length; ++k){
        
        	if(counted[seq[k]]){
        		continue;
        	}
        	
        
        	//left and right pos
        	int left = Math.min(seq[k], lastPos);
        	int right = Math.max(seq[k], lastPos);
        	
        	int height = Math.min(A[left], A[right]);
        	
        	for(int p = left + 1; p < right; ++p){
        		if(counted[p]){
        			continue;
        		}
        		counted[p] = true;
        		area += Math.max(0, height - A[p]);
        	}
        	lastPos = seq[k];
        }
        return area;
    }
}
