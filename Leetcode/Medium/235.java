// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // more 314H leetcode...
        while (true) {
            if (root.val == p.val || root.val == q.val) {
                return root;
            } else if ((root.val < p.val) ^ (root.val < q.val)) {
                // two different subtrees
                return root;
            } else if (root.val < p.val) {
                // right subtree
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }
}