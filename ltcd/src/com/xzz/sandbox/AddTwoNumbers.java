package com.xzz.sandbox;

import com.xzz.data.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        int sum = (l1.val + l2.val);
        ListNode retval = new ListNode(sum % 10);
        ListNode cur = retval;
        int carry = sum / 10;
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null){
            int l1val = l1 == null ? 0 : l1.val;
            int l2val = l2 == null ? 0 : l2.val;
            int s = l1val + l2val + carry;
            cur.next = new ListNode(s % 10);
            carry = s / 10;
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;                
            }
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
            cur = cur.next;
        }
        cur.next = null;
        return retval;
    }
}
