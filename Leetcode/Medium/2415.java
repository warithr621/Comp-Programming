// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/description/?envType=daily-question&envId=2024-12-20

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

    public static void recur(TreeNode L, TreeNode R, boolean odd) {
        if (L == null) return;
        if (odd) {
            int tmp = L.val;
            L.val = R.val;
            R.val = tmp;
        }
        recur(L.left, R.right, !odd);
        recur(L.right, R.left, !odd);
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) return root;
        recur(root.left, root.right, true);
        return root;
    }
}