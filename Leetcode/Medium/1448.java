// https://leetcode.com/problems/count-good-nodes-in-binary-tree/

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

    public int dfs(TreeNode root, int mx) {
        if (root == null) return 0;
        mx = Math.max(mx, root.val);
        int ans = (root.val == mx ? 1 : 0);
        return ans + dfs(root.left, mx) + dfs(root.right, mx);
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
}