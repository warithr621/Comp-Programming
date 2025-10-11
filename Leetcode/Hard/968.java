// https://leetcode.com/problems/binary-tree-cameras/description/

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

    int ans;
    Set<TreeNode> nodes;

    public int minCameraCover(TreeNode root) {
        ans = 0;
        nodes = new HashSet<>();
        nodes.add(null);
        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);

            if ((parent == null && !nodes.contains(node)) ||
                (!nodes.contains(node.left) || !nodes.contains(node.right))) {
                    ++ans;
                    nodes.add(node);
                    nodes.add(parent);
                    nodes.add(node.left);
                    nodes.add(node.right);
            }
        }
    }
}