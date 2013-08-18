package com.foo.bar.sandbox;

import com.foo.bar.data.TreeNode;

public class TreeStuff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode<String> strTree = XmlNodeToTree
				.getStringTree("<a>8<b>4<d>2<d1>d1</d1><d2>d2</d2></d><e>e<e1>e1</e1><e2>e2<e22>e22</e22></e2></e></b>"
						+ "<c>C<c1>c1</c1></c></a>");
		
		System.out.println(new TreeStuff().isBalanced(strTree));
	}

	public class BSTInfo {
		public boolean isBST;
		public int max;
		public int min;

		public BSTInfo(boolean isBST, int max, int min) {
			this.isBST = isBST;
			this.max = max;
			this.min = min;
		}
	}

	public class Balance {
		public Balance(boolean isBalanced, int height) {
			this.isBalanced = isBalanced;
			this.height = height;
		}

		public boolean isBalanced;
		public int height;
	}

	public boolean isBST(TreeNode<Integer> root) {
		if(root == null){
			return false;
		}
		return getBSTInfo(root).isBST;
	}
	
	

	private BSTInfo getBSTInfo(TreeNode<Integer> root) {
		if(root.left == null && root.right == null){
			return new BSTInfo(true, root.val, root.val);
		}
		int curMax = root.val;
		int curMin = root.val;
		if(root.left != null){
			BSTInfo left = getBSTInfo(root.left);
			if(!left.isBST || left.max > root.val){
				return new BSTInfo(false, -1, -1);
			}
			curMin = left.min;
		}
		if(root.right != null){
			BSTInfo right = getBSTInfo(root.right);
			if(!right.isBST || right.min < root.val){
				return new BSTInfo(false, -1, -1);
			}
			curMax = right.max;
		}
		return new BSTInfo(true, curMax, curMin);
	}



	public boolean isBalanced(TreeNode<String> root) {
		if (root == null) {
			return false;
		}
		return getBalance(root).isBalanced;
	}

	private Balance getBalance(TreeNode<String> node) {
		if (node == null) {
			return new Balance(true, 0);
		}
		Balance lb = getBalance(node.left);
		if (!lb.isBalanced) {
			return new Balance(false, -1);
		}

		Balance rb = getBalance(node.right);
		if (!rb.isBalanced) {
			return new Balance(false, -1);
		}

		if (Math.abs(rb.height - lb.height) > 1) {
			return new Balance(false, -1);
		}
		return new Balance(true, Math.max(rb.height, lb.height) + 1);
		// if(Math.abs(Math.min(lb.leftHeight, lb.rightHeight)
		// - Math.max(lb.leftHeight, lb.rightHeight)))

	}
}
