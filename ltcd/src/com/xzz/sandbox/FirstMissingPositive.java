package com.xzz.sandbox;

public class FirstMissingPositive {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{
                3,4,1,-1,5
        }));
    }

    public int firstMissingPositive(int[] A) {
        for (int i = 0; i < A.length; ++i) {

            while (A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && (A[A[i] - 1] != A[i])) {
                int tmp = A[i];
                A[i] = A[tmp - 1];
                A[tmp - 1] = tmp;
            }
        }
        
        for(int i = 0; i < A.length; ++i){
            if(A[i] != i + 1){
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
