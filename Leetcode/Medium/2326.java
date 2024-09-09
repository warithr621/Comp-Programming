// https://leetcode.com/problems/spiral-matrix-iv/?envType=daily-question&envId=2024-09-09

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

    public static boolean bounded(int x, int y, int m, int n) {
        return (0 <= x && x < m) && (0 <= y && y < n);
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ans[i], -1);
        }
        int dir = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        for (int i = 0, j = 0; head != null; head = head.next) {
            ans[i][j] = head.val;
            if (!bounded(i + dx[dir], j + dy[dir], m, n))
                dir = (dir + 1) % 4;
            else if (ans[i + dx[dir]][j + dy[dir]] != -1)
                dir = (dir + 1) % 4;
            i += dx[dir];
            j += dy[dir];
        }
        return ans;
    }
}