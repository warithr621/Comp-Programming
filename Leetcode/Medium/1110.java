// https://leetcode.com/problems/delete-nodes-and-return-forest/?envType=daily-question&envId=2024-07-17

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> del = new HashSet<>();
        for (int x : to_delete) del.add(x);
        List<TreeNode> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left != null) {
                q.add(cur.left);
                if (del.contains(cur.left.val)) cur.left = null;
            }
            if (cur.right != null) {
                q.add(cur.right);
                if (del.contains(cur.right.val)) cur.right = null;
            }
            if (del.contains(cur.val)) {
                if (cur.left != null) ans.add(cur.left);
                if (cur.right != null) ans.add(cur.right);
            }
        }
        if (!del.contains(root.val)) ans.add(root);
        return ans;
    }
}