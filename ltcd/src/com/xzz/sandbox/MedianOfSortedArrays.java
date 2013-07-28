package com.xzz.sandbox;

public class MedianOfSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return findMedian(B);
        }
        if(B == null || B.length == 0){
            return findMedian(A);
        }
        if(A.length < B.length){
            int[] t = A;
            A = B;
            B = t;
        }
        
        int low = 0;
        int high = A.length - 1;
        
        while(true){
            int mid = (low + high + 1) / 2;
            int pivot = A[mid];
            
            int b1 = 0;
            int b2 = B.length - 1;
            int bmid = (b1 + b2 + 1)/2;
            while(b1 < b2){
                bmid = (b1 + b2 + 1) / 2;
                if(pivot == B[bmid]){
                    break;
                }
                if(bmid == 0){
                    break;
                }
                if(B[bmid - 1] < pivot && B[bmid] > pivot){
                    break;
                }
                if(pivot > B[bmid]){
                    b1 = bmid;
                }else{
                    b2 = bmid - 1;
                }
            }
        }
        
        
    }
    
    public double findMedian(int[] B){
        if(B == null || B.length == 0){
            return 0;
        }
        if(B.length % 2 == 0){
            return (B[B.length / 2] + B[B.length / 2 - 1]) / 2.0;
        }
        return B[B.length / 2];
    }
}
