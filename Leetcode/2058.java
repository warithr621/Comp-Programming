// https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/


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

    static public boolean local(int a, int b, int c) {
        return (b < a && b < c) || (b > a && b > c);
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> locals = new ArrayList<>();
        int prev = head.val, idx = 0;
        while ((head = head.next) != null) {
            ++idx;
            if (head.next == null) continue;
            if ( local(prev, head.val, head.next.val) ) {
                // this is a local maxima or minima
                locals.add(idx);
            }
            prev = head.val;
        }
        System.out.println(locals);
        int n = locals.size();
        if (n < 2) return new int[]{-1, -1};
        int[] ans = new int[]{1000000, locals.get(n-1) - locals.get(0)};
        for (int i = 1; i < n; i++) {
            ans[0] = Math.min(ans[0], locals.get(i) - locals.get(i-1));
        }
        return ans;
    }
}