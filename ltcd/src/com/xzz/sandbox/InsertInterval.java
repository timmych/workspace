package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.xzz.data.Interval;

public class InsertInterval {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // [1,2],[3,5],[6,7],[8,10],[12,16]

        System.out.println(new InsertInterval().insert(Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16)),
                new Interval(4, 9)));
        
        System.out.println(new InsertInterval().insert2(Arrays.asList(new Interval(1, 2), new Interval(3, 5), new Interval(6, 7), new Interval(8, 10), new Interval(12, 16)),
                new Interval(4, 9)));
    }
    
    public ArrayList<Interval> insert2(List<Interval> intervals, Interval newInterval){
        boolean usedInterval = false;
        Interval mergedInterval = newInterval;
        int i = 0;
        ArrayList<Interval> retval = new ArrayList<Interval>();
        for(; i < intervals.size(); ++i){
            if(canMerge(intervals.get(i), mergedInterval)){
                mergedInterval = new Interval(Math.min(intervals.get(i).start, mergedInterval.start),
                        Math.max(intervals.get(i).end, mergedInterval.end));
                if(!usedInterval){
                    retval.add(mergedInterval);
                    usedInterval = true;
                }else{
                    retval.set(retval.size() - 1, mergedInterval);
                }
            }else{
                if(!usedInterval){
                    if((i == 0 || intervals.get(i - 1).end < newInterval.start) 
                        && intervals.get(i).start > newInterval.end ){
                        retval.add(newInterval);
                    }
                }
                retval.add(intervals.get(i));
            }
        }
        if(!usedInterval){
            retval.add(newInterval);
        }
            
        return retval;
    }

    private boolean canMerge(Interval i, Interval mergedInterval) {
        return i.end >= mergedInterval.start && mergedInterval.end >= i.start;
    }

    public ArrayList<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int left = findInterval(intervals, newInterval.start);
        int right = findInterval(intervals, newInterval.end);

        if (intervals.get(right).start > newInterval.end) {
            right--;
        }

        ArrayList<Interval> lst = new ArrayList<Interval>();
        for (int i = 0; i < left; ++i) {
            lst.add(intervals.get(i));
        }

        if (newInterval.end < intervals.get(left).start) {
            lst.add(newInterval);
        } else {
            // has overlap
            newInterval.end = Math.max(intervals.get(right).end, newInterval.end);
            newInterval.start = Math.min(intervals.get(left).start, newInterval.start);
            lst.add(newInterval);
        }

        for (int i = right + 1; i < intervals.size(); ++i) {
            lst.add(intervals.get(i));
        }
        return lst;
    }

    public int findInterval(List<Interval> intervals, int pivot) {
        int high = intervals.size() - 1;
        int low = 0;

        while (low < high) {
            int mid = (low + high + 1) / 2;
            int startVal = mid > 0 ? intervals.get(mid - 1).end : intervals.get(mid).start;
            int endVal = intervals.get(mid).end;

            if (mid == 0 && startVal <= pivot && endVal >= pivot) {
                if (mid > 0 && startVal == pivot) {
                    return mid - 1;
                }
                return mid;
            }
            if (startVal > pivot) {
                high = mid - 1;
                if (high < low) {
                    high = low;
                }
            } else {
                low = mid + 1;
                if (low > high) {
                    low = high;
                }
            }
        }

        return low;
    }
}
