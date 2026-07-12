// https://leetcode.com/problems/binary-tree-level-order-traversal/

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode tn = q.poll();
                row.add(tn.val);
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
            }
            ans.add(row);
        }
        return ans;
    }
}