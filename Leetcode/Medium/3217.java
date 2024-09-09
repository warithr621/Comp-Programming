// https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/?envType=daily-question&envId=2024-09-06

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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> del = new HashSet<>();
        for (int x : nums) del.add(x);
        ListNode start = head;
        while (del.contains(start.val)) start = start.next;
        ListNode prev = start, current = start.next;
        while (current != null) {
            if (del.contains(current.val)) {
                prev.next = current.next;
                current = prev.next;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return start;
    }
}