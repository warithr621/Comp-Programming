// https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/?envType=daily-question&envId=2024-12-25

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

    private void fill(TreeNode cur, List<Integer> rows, int depth) {
        if (cur == null) return;
        if (rows.size() < depth) {
            rows.add(cur.val);
        } else {
            rows.set(depth - 1, Math.max(rows.get(depth - 1), cur.val));
        }
        fill(cur.left, rows, depth + 1);
        fill(cur.right, rows, depth + 1);
    }

    public List<Integer> largestValues(TreeNode root) {
        // prob a better way (time/memory-wise) with LinkedList bcz of BFS processing? idk
        List<Integer> ans = new ArrayList<>();
        fill(root, ans, 1);
        return ans;
    }
}