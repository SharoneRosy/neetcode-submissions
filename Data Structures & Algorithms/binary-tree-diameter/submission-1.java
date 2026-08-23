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
    int maxdia=0;
    public int diameterOfBinaryTree(TreeNode root) {
        solve(root);
        return maxdia;
    }
    public int solve(TreeNode root){
        if(root==null) return 0;
        int leftHeight=solve(root.left);
        int rightHeight=solve(root.right);
        maxdia=Math.max(maxdia,leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
