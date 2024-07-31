// https://leetcode.com/problems/sum-root-to-leaf-numbers/?envType=study-plan-v2&envId=top-interview-150

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

    public static int dfs(TreeNode cur, int path) {
        if (cur == null) return 0;
        int next = path * 10 + cur.val;
        if (cur.left == null && cur.right == null) return next;
        return dfs(cur.left, next) + dfs(cur.right, next);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}