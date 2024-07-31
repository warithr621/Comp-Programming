// https://leetcode.com/problems/kth-smallest-element-in-a-bst/

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

    static void inorder(TreeNode cur, ArrayList<Integer> al) {
        if (cur == null) return;
        inorder(cur.left, al);
        al.add(cur.val);
        inorder(cur.right, al);
    }

    public int kthSmallest(TreeNode root, int k) {
        // since this is a BST, we can just do in-order traversal
        ArrayList<Integer> al = new ArrayList<>();
        inorder(root, al);
        return al.get(k-1);
    }
}