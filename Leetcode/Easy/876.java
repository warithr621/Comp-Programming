// https://leetcode.com/problems/middle-of-the-linked-list/

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
    public ListNode middleNode(ListNode head) {
        int cnt = 0;
        ListNode cur = head;
        while (cur != null) {
            ++cnt;
            cur = cur.next;
        }
        cnt >>= 1;
        cur = head;
        while (cnt > 0) {
            cur = cur.next;
            --cnt;
        }
        return cur;
    }
}