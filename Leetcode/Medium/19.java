// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // after a bunch of reading I just realized this is nth from the END of the list
        int sz = 0;
        ListNode cur = head;
        while (cur != null) {
            ++sz;
            cur = cur.next;
        }
        n = sz - n;
        if (n == 0) return head.next;
        cur = head;
        int cnt = 0;
        while (cnt != n) {
            if (cnt + 1 == n) {
                // the next node needs to be removed
                cur.next = cur.next.next;
                break;
            }
            ++cnt;
            cur = cur.next;
        }
        return head;
    }
}