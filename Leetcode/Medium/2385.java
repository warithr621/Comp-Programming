// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/

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
    public int amountOfTime(TreeNode root, int start) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 100005; i++) {
            adj.add(new ArrayList<>());
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tn = q.poll();
            if (tn.left != null) {
                q.add(tn.left);
                adj.get(tn.val).add(tn.left.val);
                adj.get(tn.left.val).add(tn.val);
            }
            if (tn.right != null) {
                q.add(tn.right);
                adj.get(tn.val).add(tn.right.val);
                adj.get(tn.right.val).add(tn.val);
            }
        }

        int ans = 0;
        int[] dist = new int[100005];
        Queue<int[]> bfs = new LinkedList<>();
        bfs.add(new int[]{start, -1, 0});
        while (!bfs.isEmpty()) {
            int[] arr = bfs.poll();
            dist[arr[0]] = arr[2];
            ans = Math.max(ans, arr[2]);
            for (int dest : adj.get(arr[0])) {
                if (dest != arr[1]) {
                    bfs.add(new int[]{dest, arr[0], arr[2]+1});
                }
            }
        }
        
        return ans;
    }
}