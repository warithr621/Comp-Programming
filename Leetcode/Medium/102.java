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
        if (root == null) return new ArrayList<List<Integer>>();
        Queue<TreeNode[]> q = new LinkedList<>();
        // this is a really weird way to store the depths
        q.add(new TreeNode[]{root, new TreeNode(0)});
        int curdepth = 0;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        while (!q.isEmpty()) {
            TreeNode[] node = q.poll();
            if (node[0] == null) continue;
            if (node[1].val == curdepth) {
                cur.add(node[0].val);
            } else {
                ans.add(cur);
                cur = new ArrayList<>();
                cur.add(node[0].val);
                ++curdepth;
            }
            q.add(new TreeNode[]{node[0].left, new TreeNode(node[1].val + 1)});
            q.add(new TreeNode[]{node[0].right, new TreeNode(node[1].val + 1)});
        }
        if (cur.size() != 0) ans.add(cur);
        return ans;
    }
}