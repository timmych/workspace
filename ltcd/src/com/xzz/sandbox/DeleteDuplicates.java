package com.xzz.sandbox;

import com.xzz.data.ListNode;

public class DeleteDuplicates {
    
    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.append(1).append(2).append(3).append(3);
        
        System.out.println(new DeleteDuplicates().deleteDuplicates2(node));
    }
    
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null){
            return head;
        }
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return head;
    }
    
    
    public ListNode deleteDuplicates2(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null){
            return null;
        }
        
        Integer sameVal = null;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        
        ListNode prev = newHead;
        ListNode cur = head;
        
        while(cur != null){
            if((prev == newHead || prev.val != cur.val) 
                && (cur.next == null || cur.val != cur.next.val)
                && !new Integer(cur.val).equals(sameVal)){
                    //this one should be kept
                    prev = cur;
                    cur = cur.next;
                    sameVal = null;
                }else{
                    //this one should be removed
                    sameVal = cur.val;
                    prev.next = cur.next;
                    cur = prev.next;
                }
        }
        return newHead.next;
    }
}
