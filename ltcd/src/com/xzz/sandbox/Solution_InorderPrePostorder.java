/**
 * 
 */
package com.xzz.sandbox;

//import junit.framework.Assert;

import com.xzz.data.TreeNode;

/**
 * @author xiaozhec
 * 
 */
public class Solution_InorderPrePostorder {
	public TreeNode buildTreePost(int[] inorder, int[] postorder) {
		return recBuildTreePost(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode recBuildTreePost(int[] inorder, int i1, int j1, int[] postorder, int i2, int j2) {
		// Assert.assertEquals(j1 - i1, j2 - i2);

		if (i1 == j1) {
			return new TreeNode(inorder[i1]);
		} else if (i1 > j1) {
			return null;
		}
		int mid = postorder[j2];
		for (int i = i1; i <= j1; ++i) {
			if (inorder[i] == mid) {
				TreeNode root = new TreeNode(mid);
				root.left = recBuildTreePost(inorder, i1, i - 1, postorder, i2, i2 + i - 1 - i1);
				root.right = recBuildTreePost(inorder, i + 1, j1, postorder, i2 + i - i1, j2 - 1);
				return root;
			}
		}
		return null;
	}

	public TreeNode buildTreePre(int[] preorder, int[] inorder) {
		return recBuildTreePre(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}

	private TreeNode recBuildTreePre(int[] inorder, int i1, int j1, int[] preorder, int i2, int j2) {
		// Assert.assertEquals(j1 - i1, j2 - i2);

		if (i1 == j1) {
			return new TreeNode(inorder[i1]);
		} else if (i1 > j1) {
			return null;
		}
		int mid = preorder[i2];
		for (int i = i1; i <= j1; ++i) {
			if (inorder[i] == mid) {
				TreeNode root = new TreeNode(mid);
				root.left = recBuildTreePre(inorder, i1, i - 1, preorder, i2 + 1, i2 + i - i1);
				root.right = recBuildTreePre(inorder, i + 1, j1, preorder, i2 + i - i1 + 1, j2);
				return root;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TreeNode.printTreeInOrder(new Solution_InorderPrePostorder().buildTreePost(new int[] { 4, 2, 5, 1, 3 }, new int[] { 4, 5, 2, 3, 1 }));
		TreeNode.printTreeInOrder(new Solution_InorderPrePostorder().buildTreePre(new int[]{1, 2, 4, 5, 3}, new int[] { 4, 2, 5, 1, 3 }));
	}
}
