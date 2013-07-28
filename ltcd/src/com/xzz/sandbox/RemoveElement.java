package com.xzz.sandbox;

public class RemoveElement {

    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int pos = 0;
        int head = 0;
        while(head < A.length){
            if(A[head] == elem){
                head++;
            }else{
                A[pos++] = A[head++];
            }
        }
        return pos;
    }
}
