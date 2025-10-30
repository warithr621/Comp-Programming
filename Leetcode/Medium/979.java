// https://leetcode.com/problems/distribute-coins-in-binary-tree/description/

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

    private int ans;

    public int distributeCoins(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int dfs(TreeNode cur) {
        if (cur == null) return 0;
        int l = dfs(cur.left), r = dfs(cur.right);
        ans += Math.abs(l) + Math.abs(r);
        return (cur.val - 1) + l + r;
    }
}