// https://leetcode.com/problems/merge-k-sorted-lists/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
        for (ListNode element : lists) {
            if (element != null) pq.add(element);
        }
        while (!pq.isEmpty()) {
            // pop out the element least in value
            ListNode append = pq.poll();
            cur.next = new ListNode(append.val);
            cur = cur.next;
            if (append.next != null) pq.add(append.next);
        }
        return ans.next;
    }
}