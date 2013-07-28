package com.xzz.sandbox;

import com.xzz.data.TreeNode;

public class ValidateBinarySearchTree {
    public class BSTInfo{
        public int max;
        public int min;
    }
    public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return isValidBST(root, new BSTInfo());
    }
    public boolean isValidBST(TreeNode root, BSTInfo info){
        if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            info.min = root.val;
            info.max = root.val;
            return true;
        }
        
        info.min = root.val;
        info.max = root.val;
        
        BSTInfo infoLeft = new BSTInfo();
        BSTInfo infoRight = new BSTInfo();
        if(root.left != null){
            if(!isValidBST(root.left, infoLeft)){
                return false;
            }
            if(infoLeft.max >= root.val){
                return false;
            }
            info.min = infoLeft.min;
        }
        
        if(root.right != null){
            if(!isValidBST(root.right, infoRight)){
                return false;
            }
            if(infoRight.min <= root.val){
                return false;
            }
            info.max = infoRight.max;
        }
        return true;
    }
}
