// https://leetcode.com/problems/balance-a-binary-search-tree/description/

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

    public TreeNode construct(TreeNode cur, List<Integer> nodes, int L, int R) {
        if (L > R) return null;
        int M = (L + R) / 2;
        TreeNode left = construct(cur, nodes, L, M - 1);
        TreeNode right = construct(cur, nodes, M + 1, R);
        TreeNode node = new TreeNode(nodes.get(M), left, right);
        return node;
    }

    public void inorder(TreeNode cur, List<Integer> nodes) {
        if (cur == null) return;
        inorder(cur.left, nodes);
        nodes.add(cur.val);
        inorder(cur.right, nodes);
    }

    public TreeNode balanceBST(TreeNode root) {
        // why are we doing leetcode in 314h
        // also note a root MUST exist
        List<Integer> nodes = new ArrayList<>();
        inorder(root, nodes);
        // System.out.println(nodes);
        TreeNode ans = new TreeNode();
        return construct(ans, nodes, 0, nodes.size() - 1);
    }
}