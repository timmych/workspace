package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import com.xzz.data.ListNode;

public class MergeKSortedList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ListNode list1 = new ListNode(1);
        list1.append(3).append(5).append(7);
        ListNode list2 = new ListNode(2);
        list2.append(4).append(6);
        ListNode list3 = new ListNode(0);
        System.out.println(new MergeKSortedList().mergeKLists(new ArrayList<ListNode>()));
    }

    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists.size() == 0){
            return null;
        }
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode arg0, ListNode arg1) {
                return arg0.val < arg1.val ? -1 : (arg0.val == arg1.val ? 0 : 1);
            }
        });
        for (ListNode n : lists) {
            if (n != null) {
                q.add(n);
            }
        }
        if(q.size() == 0){
            return null;
        }
        ListNode retval = q.poll();
        ListNode last = retval;
        safeAdd(q, retval.next);
        while(q.size() > 0){
            ListNode cur = q.poll();
            last.next = cur;
            last = cur;
            safeAdd(q, cur.next);
        }
        last.next = null;
        return retval;
    }

    private void safeAdd(PriorityQueue<ListNode> q, ListNode next) {
        if(next == null){
            return;
        }
        q.add(next);
    }
}
