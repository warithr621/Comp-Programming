// https://leetcode.com/problems/copy-list-with-random-pointer/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        ArrayList<Node> ans = new ArrayList<>();
        Node iter = head;
        int idx = 0;
        Map<Node, Integer> mapping = new HashMap<>();
        while (iter != null) {
            ans.add(new Node(iter.val));
            mapping.put(iter, idx);
            iter = iter.next;
            idx++;
        }
        iter = head;
        idx = 0;
        int counter = 0;
        while (iter != null) {
            Node dest = iter.random;
            if (dest != null) {
                ans.get(idx).random = ans.get(mapping.get(dest));
            }
            iter = iter.next;
            idx++;
        }
        for (int i = 1; i < ans.size(); i++) {
            ans.get(i-1).next = ans.get(i);
        }
        return ans.get(0);
    }
}