/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root.val==p.val || root.val==q.val) return root;
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree= lowestCommonAncestor(root.right,p,q);
        if(leftTree==null) return rightTree;
        if(rightTree==null) return leftTree;
        return root;
    }
}
