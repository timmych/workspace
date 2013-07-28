package com.xzz.sandbox;

import com.xzz.data.ListNode;

public class ReverseLinkedListII {
    /**
     * Definition for singly-linked list. public class ListNode { int val;
     * ListNode next; ListNode(int x) { val = x; next = null; } }
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (m == n) {
            return head;
        }
        int pos = 1;
        ListNode prevCur = null;// head
        ListNode cur = head;
        ListNode p1 = null;
        boolean rev = false;
        while (cur != null) {
            if (pos == m + 1) {
                rev = true;
            }
            if (rev) {
                ListNode tmp = cur.next;
                cur.next = prevCur;
                prevCur = cur;
                cur = tmp;

                if (pos == n) {
                    if (p1 != null) {
                        ListNode tmp2 = p1.next;
                        p1.next = prevCur;

                        tmp2.next = cur;
                        return head;
                    } else {
                        head.next = cur;
                        return prevCur;
                    }
                }
                pos++;
            } else {
                if (pos == m) {
                    p1 = prevCur;
                }

                prevCur = cur;
                cur = cur.next;
                pos++;
            }
        }
        return head;
    }
}
