package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.xzz.data.Interval;

public class MergeInterval {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new MergeInterval().merge(
                Arrays.asList(new Interval(1, 3), new Interval(2, 6), new Interval(8 , 10), 
                        new Interval(15, 18))));
    }

    public ArrayList<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){

            @Override
            public int compare(Interval arg0, Interval arg1) {
                return arg0.start < arg1.start ? -1 : (
                        arg0.start == arg1.start ? 0 : 1 );
            }
            
        });
        
        ArrayList<Interval> retval = new ArrayList<Interval>();
        
        for(Interval i : intervals){
            if(retval.size() > 0){
                Interval last = retval.get(retval.size() - 1);
                if(last.start <= i.end && i.start <= last.end){
                    last.start = Math.min(last.start, i.start);
                    last.end = Math.max(last.end, i.end);
                    continue;
                }
            }
            retval.add(i);
        }
        return retval;
    }
}
