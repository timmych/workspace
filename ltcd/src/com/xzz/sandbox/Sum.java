package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Sum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Arrays.asList(2,1,3,4).equals(Arrays.asList(1,2,3,4)));
        int[] s = new int[]{ -1, 2,1,-4};
        System.out.println(new Sum().threeSumClosest(s, 1));
        
//        final int[] arr = new int[]{1,5,4,3,2};
//        Integer[] arr2 = new Integer[]{0, 1, 2, 3, 4};
//        Arrays.sort(arr2, new Comparator<Integer>(){
//
//            @Override
//            public int compare(Integer arg0, Integer arg1) {
//                // TODO Auto-generated method stub
//                return arr[arg0] < arr[arg1] ? -1 : 
//                    (arr[arg0] == arr[arg1] ? 0 : 1);
//            }
//            
//        });
//        System.out.println(Arrays.toString(arr2));
    }
    
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        final int[] nums = numbers;
        Integer[] idx = new Integer[numbers.length];
        for(int i = 0; i < idx.length; ++i){
            idx[i] = i;
        }
        
        Arrays.sort(idx, new Comparator<Integer>(){

            @Override
            public int compare(Integer arg0, Integer arg1) {
                // TODO Auto-generated method stub
                return nums[arg0] < nums[arg1] ? -1 : 
                    (nums[arg0] == nums[arg1] ? 0 : 1);
            }
            
        });
        int head = 0;
        int tail = numbers.length - 1;
        while(head < tail){
            int sum = numbers[idx[head]] + numbers[idx[tail]];
            if(sum == target){
                return idx[head] < idx[tail] ? new int[]{ idx[head] + 1, idx[tail] + 1}
                :  new int[]{ idx[tail] + 1, idx[head] + 1};
            }
            if(sum < target){
                head++;
            }else{
                tail--;
            }
        }
        return null;
    }
    
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Set<String> resultSet = new HashSet<String>();
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3){
            return lst;
        }
        for(int i = 0; i < num.length - 2; ++i){
            for(int j = i + 1; j < num.length - 1; ++j){
                int head = j + 1;
                int rem = -num[i] - num[j];
                if(rem < num[head] || rem > num[num.length - 1]){
                    continue;
                }
                int tail = num.length - 1;
                while(head <= tail){
                    int mid = (head + tail + 1) / 2;
                    if(num[mid] == rem){
                        ArrayList<Integer> l = new ArrayList<Integer>();
                        l.add(num[i]);
                        l.add(num[j]);
                        l.add(num[mid]);
                        String resultString = l.toString();
                        if(!resultSet.contains(resultString)){
                            resultSet.add(l.toString());
                            lst.add(l);
                        }
                        break;
                    }
                    if(head == tail){
                        break;
                    }
                    if(num[mid] < rem){
                        head = Math.min(tail, mid + 1);
                    }else{
                        tail = Math.max(head, mid - 1);
                    }
                }
            }
        }
        return lst;
    }
    
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num == null || num.length == 0){
            return 0;
        }
        if(num.length < 3){
            int sum = 0;
            for(int n : num){
                sum += n;
            }
            return sum;
        }
        
        Arrays.sort(num);
        int dist = Integer.MAX_VALUE;
        int closest = num[0] + num[1] + num[2];
        for(int i = 0; i < num.length; ++i){
            int t = target - num[i];
            int p1 = 0;
            int p2 = num.length - 1;
            while(p1 < p2){
                if(p1 == i){
                    p1++;
                }
                if(p2 == i){
                    p2--;
                }
                if(p1 >= p2){
                    break;
                }
                int sum12 = num[p1] + num[p2];
                int sum = num[i] + sum12;
                if(dist > Math.abs(sum - target)){
                    dist = Math.abs(sum - target);
                    closest = sum;
                }
                if(sum12 < t){
                    p1++;
                }else{
                    p2--;
                }
            }
        }
        return closest;
    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> lst = new ArrayList<ArrayList<Integer>>();
        
        if(num == null || num.length < 4){
            return lst;
        }
        
        Arrays.sort(num);
        
        for(int i = 0; i < num.length - 3; ++i){
            for(int j = i + 1; j < num.length -2; ++j){
                int k1 = j + 1;
                int k2 = num.length - 1;
                int t = target - num[i] - num[j];
                while(k1 < k2){
                    if(k1 == i || k1 == j){
                        k1++;
                    }
                    if(k2 == i || k2 == j){
                        k2--;
                    }
                    if(k1 >= k2){
                        break;
                    }
                    
                    int psum = num[k1] + num[k2];
                    
                    if(psum == t){
                        ArrayList<Integer> sol = new ArrayList<Integer>(Arrays.asList(
                            num[i], num[j], num[k1], num[k2]));
                        
                        if(lst.contains(sol)){
                            k1++;
                            continue;
                        }else{
                            lst.add(sol);
                            k1++;
                            continue;
                        }
                    }
                    if(psum < t){
                        k1++;
                    }else{
                        k2--;
                    }
                }
            }
        }
        return lst;
    }
}
