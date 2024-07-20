// https://leetcode.com/problems/number-of-good-leaf-nodes-pairs/?envType=daily-question&envId=2024-07-18

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

import java.util.*;

class Solution {

    static void traverse(TreeNode cur, TreeNode prev, 
        Map<TreeNode, List<TreeNode>> adj, Set<TreeNode> leaves) {
        if (cur == null) return;
        if (cur.left == null && cur.right == null) leaves.add(cur);
        if (prev != null) {
            adj.computeIfAbsent(prev, k -> new ArrayList<TreeNode>());
            adj.get(prev).add(cur);
            adj.computeIfAbsent(cur, k -> new ArrayList<TreeNode>());
            adj.get(cur).add(prev);
        }
        traverse(cur.left, cur, adj, leaves);
        traverse(cur.right, cur, adj, leaves);
    }

    public int countPairs(TreeNode root, int distance) {
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();
        Set<TreeNode> leaves = new HashSet<>();
        traverse(root, null, adj, leaves);
        int ans = 0;
        for (TreeNode leaf : leaves) {
            Queue<TreeNode> q = new LinkedList<>();
            Set<TreeNode> vis = new HashSet<>();
            q.add(leaf); vis.add(leaf);
            for (int i = 0; i <= distance; i++) {
                int sz = q.size();
                for (int j = 0; j < sz; j++) {
                    TreeNode cur = q.poll();
                    if (leaves.contains(cur) && cur != leaf) ++ans;
                    if (adj.containsKey(cur)) for (TreeNode dest : adj.get(cur)) {
                        // you would think every node with have adj
                        // but you can have test cases with 1 node...
                        if (!vis.contains(dest)) {
                            q.add(dest);
                            vis.add(dest);
                        }
                    }
                }
            }
        }
        return ans >> 1;
    }   
}