package com.xzz.sandbox;

import java.util.ArrayList;

import com.xzz.data.TreeNode;

public class PathSum {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new PathSum().hasPathSum(
                TreeNode.parseTree(new Integer[]{
                        5,4,8,11,null,13,4,7,2,null,null,null,1
                }), 22));
        System.out.println(new PathSum().pathSum(
                TreeNode.parseTree(new Integer[]{
                        5,4,8,11,null,13,4,7,2,null,null,null,1
                }), 22));
    }

    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return sum == root.val;
        }
        
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val); 
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum){
        ArrayList<ArrayList<Integer>> retVal = new ArrayList<ArrayList<Integer>>();
        
        recPathSum(root, sum, retVal, new ArrayList<Integer>());
        return retVal;
    }


    private void recPathSum(TreeNode root, int sum, ArrayList<ArrayList<Integer>> retVal,
            ArrayList<Integer> route) {
        if(root == null){
            return;
        }
        route.add(root.val);
        if(root.left == null && root.right == null){
            if(sum == root.val){
                retVal.add(new ArrayList<Integer>(route));
            }
        }else{
            recPathSum(root.left, sum - root.val, retVal, route);
            recPathSum(root.right, sum - root.val, retVal, route);
        }
        route.remove(route.size() - 1);
    }
}
