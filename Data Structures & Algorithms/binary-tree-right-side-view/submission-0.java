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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ansList = new ArrayList<>();
        Queue<TreeNode> treeQueue= new ArrayDeque<>();
        if(root==null) return ansList;
        treeQueue.offer(root);
        TreeNode dummyNode= new TreeNode (-1100,null,null);
        treeQueue.offer(dummyNode);
        while(!treeQueue.isEmpty()){
            if(treeQueue.peek().val!=-1100){
                TreeNode topNode  = null;
                while(treeQueue.size()>0 && treeQueue.peek().val!=-1100){
                    topNode = treeQueue.poll();
                    if(topNode.left!=null)treeQueue.offer(topNode.left);
                    if(topNode.right!=null)treeQueue.offer(topNode.right);
                }  
                ansList.add(topNode.val);    
            }
            treeQueue.poll();
            if(treeQueue.size()>0) treeQueue.add(dummyNode);
        }
        return ansList;
    }
}