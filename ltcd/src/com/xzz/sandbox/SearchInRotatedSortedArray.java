package com.xzz.sandbox;

public class SearchInRotatedSortedArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{
                1, 3, 1, 1
        }, 3));
    }

    public int search(int[] A, int target) {
        if(A == null || A.length == 0){
            return -1;
        }
        int pivotPos = findPivot(A);
        System.out.println("pivot at: " + pivotPos);
        return findTarget(A, pivotPos, target);
    }

    private int findTarget(int[] a, int pivotPos, int target) {
        int low = 0;
        int high = a.length - 1;
        while(low < high){
            int mid = (low + high + 1)/2;
            int realMid = (mid + pivotPos) % a.length;
            if(a[realMid] == target){
                return realMid;
            }else if(a[realMid] > target){
                high = mid - 1;
                if(high < low){
                    high = low;
                }
            }else{
                low = mid + 1;
                if(low > high){
                    low = high;
                }
            }
        }
        int pos = (low + pivotPos) % a.length;
        if(a[pos] == target){
            return pos;
        }
        return -1;
    }

    private int findPivot(int[] a) {
        if(a == null || a.length == 0){
            return 0;
        }
        int low = 0;
        int high = a.length - 1;
        if(a[low] <= a[high]){
            return 0;
        }
        while(low < high){
            int mid = (low + high + 1)/2;
            if(a[mid - 1] > a[mid]){
                return mid;
            }
            if(mid < a.length - 1 && a[mid] > a[mid + 1]){
                return mid + 1;
            }
            if(a[low] > a[mid]){
                high = mid - 1;
                if(high < low){
                    high = low;
                }
            }else{
                low = mid + 1;
                if(low > high){
                    low = high;
                }
            }
        }
        return low;
    }
    
    
    public int search2(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return  -1;
        }
        int head = 0;
        int tail = A.length - 1;
        while(head < tail){
            int mid = (head + tail + 1) / 2;
            if(target == A[mid]){
                return mid;
            }
            boolean onLeft = true;
            if(A[head] < A[mid]){
                onLeft = (target < A[mid] && target >= A[head]);
            }else{
                onLeft = (target < A[mid] || target > A[tail]);
            }
            
            if(onLeft){
                tail = mid - 1;
                if(tail < head){
                    tail = head;
                }
            }else{
                head = mid + 1;
                if(head > tail){
                    head = tail;
                }
            }
        }
        if(A[head] == target){
            return head;
        }        
        return - 1;
    }
    
    public boolean search22(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(A == null || A.length == 0){
            return  false;
        }
        
        return recSearch(A, 0, A.length - 1, target);
    }
    
    public boolean recSearch(int[] A, int low, int high, int target){
        int mid = (low + high)/2;
        if(low == high){
            return A[low] == target;
        }
        
        if(A[mid] == target){
            return true;
        }
        
        if(A[low] < A[mid] && target >= A[low] && target < A[mid]){
            return recSearch(A, low, mid - 1, target);
        }else if(A[mid] < A[high] && target > A[mid] && target <= A[high]){
            return recSearch(A, mid + 1, high, target);
        } 
        
        return recSearch(A, low, Math.max(low, mid - 1), target) 
            || recSearch(A, Math.min(mid + 1, high), high, target);
    }
}
