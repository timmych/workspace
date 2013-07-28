package com.xzz.data;

public class Interval {

    public int start;
    public int end;

    Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval [start=" + start + ", end=" + end + "]";
    }

}
