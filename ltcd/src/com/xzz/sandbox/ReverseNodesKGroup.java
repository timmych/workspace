package com.xzz.sandbox;

import com.xzz.data.ListNode;

public class ReverseNodesKGroup {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode node = new ListNode(1);
        node.append(2).append(3).append(4).append(5);
        System.out.println(new ReverseNodesKGroup().reverseKGroup(node, 3));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || k <= 1){
            return head;
        }

        ListNode ptr = head;
        ListNode prevTail = null;
        int count = 0;
        while(ptr != null){
            count = 0;
            ListNode tmp = ptr;
            while(++count < k && tmp != null){
                tmp = tmp.next;
            }
            if(tmp == null){ //no need to reverse                
                return head;
            }
            
            count = 0;
            ListNode cur = ptr.next;
            ListNode prev = ptr;
            while(cur != null && ++count < k){
                ListNode tmp2 = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp2;
            }
            if(ptr == head){
                head = prev;
            }
            ptr.next = cur;
            if(prevTail != null){
                prevTail.next = prev;
            }
            prevTail = ptr;
            ptr = cur;
        }
        return head;
    }
}
