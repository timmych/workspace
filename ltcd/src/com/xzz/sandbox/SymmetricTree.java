package com.xzz.sandbox;

import com.xzz.data.TreeNode;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				new SymmetricTree().isSymmetric(TreeNode.parseTree(new Integer[]{1,2,2,3,4,4,3})));
		System.out.println(
				new SymmetricTree().isSymmetric(TreeNode.parseTree(new Integer[]{1,2,2,3,4,null,3})));
	}

    public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	if(root == null){
    		return true;
    	}
        return recIsSymmetric(root.left, root.right);
    }

	private boolean recIsSymmetric(TreeNode left, TreeNode right) {
		if(right == null || left == null){
			return right == left;
		}
		if(left.val != right.val){
			return false;
		}
		return recIsSymmetric(left.left, right.right) && recIsSymmetric(left.right, right.left);
    }
}
