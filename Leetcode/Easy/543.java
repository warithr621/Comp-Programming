// https://leetcode.com/problems/diameter-of-binary-tree/

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

    static int res;

    public int diameterOfBinaryTree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    static int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left), r = dfs(root.right);
        res = Math.max(res, l + r);
        return 1 + Math.max(l, r);
    }

}