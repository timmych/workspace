package com.xzz.sandbox;

import com.xzz.data.ListNode;

public class ParitionList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

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
    public class Solution {
        public ListNode partition(ListNode head, int x) {
            // Start typing your Java solution below
            // DO NOT write main() function
            
            ListNode ptr = head;
            ListNode ptr2 = null;
            ListNode ptr2Prev = null;
            ListNode ptrPrev = null;
            while(true){
                while(ptr != null && ptr.val < x){
                    ptrPrev = ptr;
                    ptr = ptr.next;
                }
                if(ptr == null){
                    break;
                }
                
                ptr2 = ptr.next;
                ptr2Prev = ptr;
                
                while(ptr2 != null && ptr2.val >= x){
                    ptr2Prev = ptr2;
                    ptr2 = ptr2.next;
                }
                
                if(ptr2 == null){
                    break;
                }
                if(ptrPrev == null){
                    //head needs update
                    head = ptr2;
                }else{
                    ptrPrev.next = ptr2;
                }
                ptr2Prev.next = ptr2.next;
                ptr2.next = ptr;
                ptrPrev = ptr2;

            }
            return head;
        }
    }
}
