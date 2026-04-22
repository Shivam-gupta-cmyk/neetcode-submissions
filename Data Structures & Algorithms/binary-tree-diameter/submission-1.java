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
    int ans = 0;
    public int height(TreeNode root){
        if(root==null) return 0;
        int leftHeight = height(root.left);
        int rightHeight =  height(root.right);
        ans= Math.max(leftHeight+rightHeight+1,ans);
        return Math.max(leftHeight,rightHeight)+1;
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int val = height(root);
        return ans-1;

    }
}
