package com.foo.bar.sandbox;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class RotateListRight {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
		 }
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        
        if(head == null){
            return null;
        }
        
        ListNode ptr = head;
        ListNode tail = head;
        int len = 0;
        while(ptr != null){
            tail = ptr;
            ptr = ptr.next;
            len++;
        }
        
        n %= len;
        
        if(n == 0){
            return head;
        }
        
        ListNode prev = null;
        ptr = head;
        for(int i = 0; i < len - n; ++i){
            prev = ptr;
            ptr = ptr.next;
        }
        
        prev.next = null;
        tail.next = head;
        return ptr;
    }
}