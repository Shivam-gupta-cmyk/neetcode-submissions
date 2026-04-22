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

    public boolean isTreeSame(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null) return true;
        if(root==null || subRoot==null) return false;
        boolean isLeftTreeSame = isTreeSame(root.left,subRoot.left);
        boolean isRightTreeSame = isTreeSame(root.right,subRoot.right);
        if(isLeftTreeSame && isRightTreeSame && root.val==subRoot.val) return true;
        return false;
    } 
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null) return true;
        if(root==null ||subRoot==null) return false;
        boolean leftTreeSame = isSubtree(root.left,subRoot);
        boolean rightTreeSame = isSubtree(root.right,subRoot);
        if(leftTreeSame || rightTreeSame || isTreeSame(root,subRoot)) return true;
        return false;
    }
}
