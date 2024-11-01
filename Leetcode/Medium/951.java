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

    public boolean check(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b != null && a.val == b.val) return true;
        return false;
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        Stack<TreeNode[]> st = new Stack<>();
        st.push(new TreeNode[]{root1, root2});
        while (!st.isEmpty()) {
            TreeNode[] cur = st.pop();
            TreeNode a = cur[0], b = cur[1];
            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;
            if (check(a.left, b.left) && check(a.right, b.right)) {
                // proceed as normal
                st.push(new TreeNode[]{a.left, b.left});
                st.push(new TreeNode[]{a.right, b.right});
            } else if (check(a.left, b.right) && check(a.right, b.left)) {
                // swap
                st.push(new TreeNode[]{a.left, b.right});
                st.push(new TreeNode[]{a.right, b.left});
            } else
                return false;
        }
        return true;
    }
}