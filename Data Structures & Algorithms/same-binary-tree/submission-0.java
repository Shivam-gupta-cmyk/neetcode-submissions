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

//  1   1
//  2   2 
//  3   3

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q== null) return false;
        boolean isLeftTreeSame = isSameTree(p.left,q.left);
        boolean isRightTreeSame = isSameTree(p.right,q.right);

        if(!isLeftTreeSame || !isRightTreeSame) return false;
        else if(p.val==q.val)return true;
        else return false;

    }
}
