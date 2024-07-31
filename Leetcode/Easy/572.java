// https://leetcode.com/problems/subtree-of-another-tree/

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

    static boolean equal(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.val != b.val) return false;
        return equal(a.left, b.left) && equal(a.right, b.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean sub = false;
        if (root.val == subRoot.val) sub |= equal(root, subRoot);
        return sub || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}