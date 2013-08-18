package com.foo.bar.sandbox;

import com.foo.bar.data.TreeNode;

public class LowestCommonAncestor<T> {

    public class Result {
        public boolean found1;
        public boolean found2;
        public TreeNode<T> node;

        public Result(boolean found1, boolean found2, TreeNode<T> node) {
            this.found1 = found1;
            this.found2 = found2;
            this.node = node;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        LowestCommonAncestor<String> lca = new LowestCommonAncestor<String>();
        TreeNode<String> strTree = XmlNodeToTree
                .getStringTree("<a>A<b>B<d>D<d1>d1</d1><d2>d2</d2></d><e>e<e1>e1</e1><e2>e2</e2></e></b><c>C</c></a>");
        TreeNode<String> d2 = strTree.left.left.right;
        TreeNode<String> e1 = strTree.left.right.left;
        TreeNode<String> c = strTree.right;
        System.out.println(lca.getLCA(strTree,
                e1, d2).val);
        System.out.println(lca.getLCA(strTree,
                e1, c).val);
        
        TreeNode<Integer> intTree = XmlNodeToTree.convertToIntTree(XmlNodeToTree.getStringTree(
                "<a>4<b>2<b1>1</b1><b2>3</b2></b><c>5<c1>4</c1><c2>6</c2></c></a>"));
        //System.out.println(new LowestCommonAncestor);
        System.out.println(lca.getBSTLCA(intTree, intTree.left.left, intTree.right.right).val);
    }
    
    public TreeNode<Integer> getBSTLCA(TreeNode<Integer> root, 
            TreeNode<Integer> a, TreeNode<Integer> b){
        if(a.val > b.val){
            return getBSTLCARec(root, a, b);
        }else{
            return getBSTLCARec(root, b, a);
        }
    }
    
    public TreeNode<Integer> getBSTLCARec(TreeNode<Integer> root, 
            TreeNode<Integer> big, TreeNode<Integer> small){
        if(root == null){
            return null;
        }
        if(root == big || root == small){
            return root;
        }
        if(root.val > big.val){
            return getBSTLCARec(root.left, big, small);
        }else if(root.val < big.val && root.val > small.val){
            return root;
        }else{
            return getBSTLCARec(root.right, big, small);
        }
    }

    public TreeNode<T> getLCA(TreeNode<T> root, TreeNode<T> node1,
            TreeNode<T> node2) {
        Result res = search(root, node1, node2);
        return res.found1 && res.found2 ? res.node : null;
    }

    private Result search(TreeNode<T> root, TreeNode<T> node1, TreeNode<T> node2) {
        if (root == null) {
            return new Result(false, false, null);
        }
        if (root == node1) {
            return new Result(true, false, root);
        }
        if (root == node2) {
            return new Result(false, true, root);
        }
        Result left = search(root.left, node1, node2);
        if (left.found1 && left.found2) {
            return left;
        }
        Result right = search(root.right, node1, node2);
        if (right.found1 && right.found2) {
            return right;
        }

        return new Result(left.found1 || right.found1, left.found2
                || right.found2, root);
    }

}
