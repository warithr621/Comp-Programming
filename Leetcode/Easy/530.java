// https://leetcode.com/problems/minimum-absolute-difference-in-bst/?envType=study-plan-v2&envId=top-interview-150

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
    public int getMinimumDifference(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> al = new ArrayList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            al.add(cur.val);
            if (cur.left != null) q.add(cur.left);
            if (cur.right != null) q.add(cur.right);
        }
        Collections.sort(al);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < al.size(); i++) {
            ans = Math.min(ans, al.get(i) - al.get(i-1));
        }
        return ans;
    }
}