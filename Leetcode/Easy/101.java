// https://leetcode.com/problems/symmetric-tree/description/?envType=study-plan-v2&envId=top-interview-150

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

    static boolean equal(TreeNode x, TreeNode y) {
        if ((x == null) ^ (y == null)) return false;
        if (x == null && y == null) return true;
        if (x.val != y.val) return false;
        return equal(x.left, y.right) && equal(x.right, y.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if ((root.left == null) ^ (root.right == null)) return false;
        if (root.left != null) return equal(root.left, root.right);
        return true;
    }
}