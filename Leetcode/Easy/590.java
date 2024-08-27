// https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-08-26

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {

    public void recurse(Node cur, List<Integer> arr) {
        if (cur == null) return;
        for (Node n : cur.children) {
            recurse(n, arr);
        }
        arr.add(cur.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        recurse(root, ans);
        return ans;
    }
}