package com.xzz.sandbox;

import java.util.Arrays;


public class SearchForRange {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new SearchForRange().searchRange(new int[]{ 1, 3 }, 1)));
    }
    
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Integer t = binarySearch(A, target);
        if(t == null){
            return new int[]{-1, -1};
        }
        return new int[]{
            binarySearchLow(A, 0, t, target),
            binarySearchHigh(A, t, A.length - 1, target)
        };
    }
    
    public Integer binarySearch(int[] A, int target){
        if(A == null || A.length == 0){
            return null;
        }
        if(A[A.length - 1] < target || A[0] > target){
            return null;
        }
        int low = 0;
        int high = A.length - 1;
        while(low < high){
            int mid = (low + high) / 2;
            if(A[mid] == target){
                return mid;
            }
            if(A[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        if(A[low] == target){
           return low; 
        }
        if(A[high] == target){
            return high;
        }
        return null;
    }
    
    public Integer binarySearchLow(int[] A, int low, int high, int target){
        if(high <= low){
            return low;
        }
        if(A[low] == target){
            return low;
        }
        if(A[high] < target){
            return high + 1;
        }
        while(low < high){
            int mid = (low + high) / 2;
            if(A[mid] < target && A[mid + 1] == target){
                return mid + 1;
            }
            if(A[mid + 1] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low + 1;
    }
    
    public Integer binarySearchHigh(int[] A, int low, int high, int target){
        if(low >= high){
            return high;
        }
        if(A[low] > target){
            return low - 1;
        }
        if(A[high] == target){
            return high;
        }
        while(low < high){
            int mid = (low + high) / 2;
            if(A[mid] == target && A[mid + 1] > target){
                return mid;
            }
            if(A[mid + 1] == target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
}
