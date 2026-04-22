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


    public int countGoodNodes(TreeNode root, int initialValue){
        if(root==null) return 0;
        int res = root.val>=initialValue?1:0;
        res+=countGoodNodes(root.left,Math.max(initialValue,root.val));
        res+=countGoodNodes(root.right,Math.max(initialValue,root.val));
        return res;
    }
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        return countGoodNodes(root,-100);

    }
}
