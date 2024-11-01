// https://leetcode.com/problems/cousins-in-binary-tree-ii/description/?envType=daily-question&envId=2024-10-23

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
    public TreeNode replaceValueInTree(TreeNode root) {
        List<Integer> depths = new ArrayList<>();
        Queue<State> q = new LinkedList<>();
        q.add(new State(root));
        while (!q.isEmpty()) {
            State st = q.poll();
            if (st.cur == null)
                continue;
            if (depths.size() == st.depth)
                depths.add(st.cur.val);
            else
                depths.set(st.depth, depths.get(st.depth) + st.cur.val);
            q.add(new State(st.cur.left, st.depth + 1));
            q.add(new State(st.cur.right, st.depth + 1));
        }
        System.out.println(depths);

        
        q.add(new State(root));
        root.val = 0;
        while (!q.isEmpty()) {
            int lvlSize = q.size();
            int d = q.peek().depth;
            for (int i = 0; i < lvlSize; i++) {
                TreeNode cur = q.poll().cur;
                int sibling = (cur.left != null ? cur.left.val : 0) + (cur.right != null ? cur.right.val : 0);
                if (cur.left != null) {
                    cur.left.val = depths.get(d+1) - sibling;
                    q.add(new State(cur.left, d + 1));
                }
                if (cur.right != null) {
                    cur.right.val = depths.get(d+1) - sibling;
                    q.add(new State(cur.right, d + 1));
                }
            }
        }
        return root;
    }
}

class State {
    TreeNode cur;
    int depth;
    State(TreeNode t) {
        cur = t;
        depth = 0;
    }
    State(TreeNode t, int d) {
        cur = t;
        depth = d;
    }
}