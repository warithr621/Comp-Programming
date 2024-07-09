// https://leetcode.com/problems/merge-nodes-in-between-zeros/description/


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
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode();
        ListNode cur = ans;
        int sum = 0;
        for (ListNode x = head.next; x != null; x = x.next) {
            if (x.val != 0) {
                sum += x.val;
            } else {
                cur.next = new ListNode(sum);
                sum = 0;
                cur = cur.next;
            }
        }
        return ans.next;
    }
}