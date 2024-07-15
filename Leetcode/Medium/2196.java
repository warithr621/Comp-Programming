// https://leetcode.com/problems/create-binary-tree-from-descriptions/?envType=daily-question&envId=2024-07-15

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
    public TreeNode createBinaryTree(int[][] descriptions) {
        int MAXN = (int) (1e5) + 5;
        int[][] edge = new int[2][MAXN];
        HashSet<Integer> children = new HashSet<>();
        int root = 0; // out of all parents, which one is NOT a child?
        for (int[] arr : descriptions) {
            edge[arr[2] ^ 1][arr[0]] = arr[1];
            // edge[0] contains left children, edge[1] right
            children.add(arr[1]);
        }
        for (int[] arr : descriptions) {
            if (!children.contains(arr[0])) root = arr[0];
        }
        TreeNode ans = recur(root, edge);
        return ans;
    }
    
    public static TreeNode recur(int root, int[][] edges) {
        // System.out.println("%d %d %d".formatted(root, edges[0][root], edges[1][root]));
        TreeNode ret = new TreeNode(root);
        if (edges[0][root] != 0) ret.left = recur(edges[0][root], edges);
        if (edges[1][root] != 0) ret.right = recur(edges[1][root], edges);
        return ret;
    }
}