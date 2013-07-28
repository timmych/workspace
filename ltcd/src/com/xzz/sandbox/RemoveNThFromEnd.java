package com.xzz.sandbox;

import com.xzz.data.ListNode;

public class RemoveNThFromEnd {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n <= 0){
            return head;
        }
        ListNode ptr = head;
        int i = 0;
        for(;i < n && ptr != null; ++i){
            ptr = ptr.next;
        }
        if(i < n){
            return head;
        }
        if(ptr == null){
            return head.next;
        }
        ListNode h2 = head;
        while(ptr.next != null){
            ptr = ptr.next;
            h2 = h2.next;
        }
        h2.next = h2.next.next;
        return head;
    }
}
