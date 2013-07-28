package com.xzz.data;

public class ListNode {
    @Override
    public String toString() {
        return  val + ", " + next;
    }

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }
    
    public ListNode append(int y){
        ListNode last = this;
        while(last.next != null){
            last = last.next;
        }
        last.next = new ListNode(y);
        return last.next;
    }
}
