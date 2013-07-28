package com.xzz.sandbox;

import com.xzz.data.ListNode;
import com.xzz.data.TreeNode;

public class ConvertSortedListToBST {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        ListNode root = new ListNode(1);
        root.append(2).append(3).append(4).append(5).append(6);
        TreeNode node = new ConvertSortedListToBST().sortedListToBST(root);
        TreeNode.printTreeInOrder(node);
    }

    /**
     * Definition for singly-linked list. public class ListNode { int val;
     * ListNode next; ListNode(int x) { val = x; next = null; } }
     */
    /**
     * Definition for binary tree public class TreeNode { int val; TreeNode
     * left; TreeNode right; TreeNode(int x) { val = x; } }
     */
    public TreeNode sortedListToBST(ListNode head) {
        return recSortListToBST(head, null);
    }
    
    public TreeNode recSortListToBST(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        while(ptr2 != tail){
            ptr2 = ptr2.next;
            if(ptr2 == tail){
                break;
            }
            ptr2 = ptr2.next;
            ptr1 = ptr1.next;
        }
        TreeNode root = new TreeNode(ptr1.val);
        root.left = recSortListToBST(head, ptr1);
        if(ptr1 != null){
            root.right = recSortListToBST(ptr1.next, tail);
        }
        return root;
    }
}
