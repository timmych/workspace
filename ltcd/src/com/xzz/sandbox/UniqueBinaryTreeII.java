package com.xzz.sandbox;

import java.util.ArrayList;
import java.util.List;

import com.xzz.data.TreeNode;

public class UniqueBinaryTreeII {

    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function

        return generateTrees(1, n);
    }

    public ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();

        if (start == end) {
            trees.add(new TreeNode(start));
            return trees;
        }
        if (start > end) {
            trees.add(null);
            return trees;
        }

        for (int i = start; i <= end; ++i) {

            List<TreeNode> lefts = generateTrees(start, i - 1);
            List<TreeNode> rights = generateTrees(i + 1, end);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;// copyTree(left);
                    root.right = right;// copyTree(right);
                    trees.add(root);
                }
            }
        }
        return trees;
    }

    public TreeNode copyTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = new TreeNode(root.val);
        node.left = copyTree(root.left);
        node.right = copyTree(root.right);
        return node;
    }

    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return numTrees(1, n);
    }
    
    public int numTrees(int start, int end){
        if(start >= end){
            return 1;
        }
        int num = 0;
        for(int root = start; root <= end; ++root){
            num += numTrees(start, root - 1) * numTrees(root + 1, end);
        }
        return num;
    }
}
