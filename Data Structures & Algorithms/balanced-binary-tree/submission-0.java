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
   boolean ans = false;
    public int height(TreeNode root){
        if(root==null) return 0;
        int leftHeight= height(root.left);
        int rightHeight= height(root.right);
        if(Math.abs(leftHeight-rightHeight)>1) ans =true;
        if(ans) return -1;
        else return Math.max(leftHeight,rightHeight)+1;
    } 
    public boolean isBalanced(TreeNode root) {
        if(height(root)==-1) return false;
        return true;

    }
}
