package com.foo.bar.data;

/**
* TreeNode
*/
public class TreeNode <T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public T val;
	
	public TreeNode (T t){
		this.val = t;
	}
	
	public TreeNode<T> left;
	public TreeNode<T> right;
}
