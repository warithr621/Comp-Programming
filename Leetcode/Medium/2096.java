// https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another/description/?envType=daily-question&envId=2024-07-16

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

    public static TreeNode LCA(TreeNode root, int x, int y) {
        if (root == null || root.val == x || root.val == y) {
            return root;
        }
        TreeNode l = LCA(root.left, x, y);
        TreeNode r = LCA(root.right, x, y);
        if (l == null) return r;
        if (r == null) return l;
        return root;
    }

    public static boolean dfs(TreeNode root, int x, StringBuilder path, boolean rev) {
        if (root == null) return false;
        if (root.val == x) return true;

        path.append(rev ? 'U' : 'L');
        if (dfs(root.left, x, path, rev)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append(rev ? 'U' : 'R');
        if (dfs(root.right, x, path, rev)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        root = LCA(root, startValue, destValue);
        StringBuilder pathFrom = new StringBuilder();
        StringBuilder pathTo = new StringBuilder();
        dfs(root, startValue, pathFrom, true);
        dfs(root, destValue, pathTo, false);
        return pathFrom.toString() + pathTo.toString();
    }

}