package com.xzz.sort;

import java.util.Arrays;

public class FindDupCount {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new FindDupCount().findDupCount(Arrays.asList(1,1,2,3,4,4,4,4,5,5,5,6,7,8,9,9).toArray(new Integer[0]), 1));
        System.out.println(new FindDupCount().findDupCount(Arrays.asList(1,1,1,1,1,1,1,1,1,1,1).toArray(new Integer[0]), 0));
    }

    public <T extends Comparable<T>> int findDupCount(T[] elements, T target) {
        if (elements == null || elements.length == 0) {
            return 0;
        }
        int start = binarySearch(elements, target, true);
        int end = binarySearch(elements, target, false);
        if(start == -1 || end == -1){
            return 0;
        }else{
            return end - start + 1;
        }
    }

    public <T extends Comparable<T>> int binarySearch(T[] elements, T target,
            boolean start) {
        int head = 0;
        int tail = elements.length - 1;

        while (head <= tail) {
            if(head < 0 || tail >= elements.length){
                break;
            }
            int mid = (head + tail) / 2;
            int comp = elements[mid].compareTo(target);
            if (comp < 0) {
                head = mid + 1;
            } else if (comp > 0) {
                tail = mid - 1;
            } else {
                // comp == 0
                if (start)// we need to find the starting point where target
                          // gets bigger to target
                {
                    if (mid == 0 || elements[mid - 1].compareTo(target) < 0) {
                        return mid;
                    } else {
                        tail = mid - 1;
                    }
                } else {
                    if (mid == elements.length - 1
                            || elements[mid + 1].compareTo(target) > 0) {
                        return mid;
                    } else {
                        head = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
}
