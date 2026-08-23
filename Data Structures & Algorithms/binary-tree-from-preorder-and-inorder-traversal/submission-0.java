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
    int pi=0;
    int ii=0;
    private TreeNode dfs(int [] preorder,int[] inorder, int limit){
        if(pi>=preorder.length) return null;
        if(inorder[ii]==limit){
            ii++;
            return null;
        }
        TreeNode root=new TreeNode(preorder[pi++]);
        root.left=dfs(preorder,inorder,root.val);
        root.right=dfs(preorder,inorder,limit);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder,inorder,Integer.MAX_VALUE);
    }
}
