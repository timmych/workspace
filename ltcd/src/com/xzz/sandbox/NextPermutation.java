package com.xzz.sandbox;

import java.util.Arrays;

public class NextPermutation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = new int[]{4,3,2,1};
        new NextPermutation().nextPermutation(test);
        System.out.println(Arrays.toString(test));
    }

    public void nextPermutation(int[] num){
        for(int i = num.length - 2; i >= 0; --i){
            for(int k = num.length - 1; k > i; --k){
                if(num[i] < num[k]){
                    int tmp = num[i];
                    num[i] = num[k];
                    num[k] = tmp;
                    
                    //sort from i + 1 to right most
                    sort(num, i+1);
                    return;
                }
            }
        }
        sort(num, 0);
    }

    private void sort(int[] num, int start) {
        for(int i = start + 1; i < num.length; ++i){
            for(int k = i; k >= start + 1; --k){
                if(num[k] < num[k - 1]){
                    int tmp = num[k];
                    num[k] = num[k-1];
                    num[k-1] = tmp;
                }
            }
        }
    }
}
