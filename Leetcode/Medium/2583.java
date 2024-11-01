// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/?envType=daily-question&envId=2024-10-22

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();
        Queue<TreeNode[]> q = new LinkedList<>();
        q.add(new TreeNode[]{root, new TreeNode(0)});
        while (!q.isEmpty()) {
            TreeNode[] tmp = q.poll();
            TreeNode cur = tmp[0];
            int depth = tmp[1].val;
            if (sums.size() == depth)
                sums.add( (long) cur.val );
            else
                sums.set(depth, sums.get(depth) + cur.val);
            if (cur.left != null)
                q.add(new TreeNode[]{cur.left, new TreeNode(depth+1)});
            if (cur.right != null)
                q.add(new TreeNode[]{cur.right, new TreeNode(depth+1)});
        }
        Collections.sort(sums, Collections.reverseOrder());
        if (k > sums.size())
            return -1;
        return sums.get(--k);
    }
}