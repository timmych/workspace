package com.xzz.sandbox;

import com.xzz.data.TreeNode;

public class ConvertSortedArrayToBST {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = new int[] { 1, 2, 3, 4, 5, 6 };
        TreeNode.printTreeInOrder(new ConvertSortedArrayToBST().sortedArrayToBST(num));
    }

    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return recSortedArrayToBST(num, 0, num.length);
    }

    public TreeNode recSortedArrayToBST(int[] num, int start, int end) {
        if (start >= end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = recSortedArrayToBST(num, start, mid);
        root.right = recSortedArrayToBST(num, mid + 1, end);
        return root;
    }
}
