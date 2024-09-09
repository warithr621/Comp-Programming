// https://leetcode.com/problems/split-linked-list-in-parts/?envType=daily-question&envId=2024-09-08

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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int n = 0;
        ListNode start = head;
        while (start != null) {
            ++n;
            start = start.next;
        }
        ListNode[] ans = new ListNode[k];
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode elem = new ListNode();
            ListNode ptr = elem;
            System.out.println(i < n%k ? n/k+1 : n/k);
            for (int j = 0; j < (i < n%k ? n/k+1 : n/k); j++) {
                System.out.println(cur.val + "~");
                ptr.next = new ListNode(cur.val);
                cur = cur.next;
                ptr = ptr.next;
            }
            ans[i] = elem.next;
        }
        return ans;
    }
}