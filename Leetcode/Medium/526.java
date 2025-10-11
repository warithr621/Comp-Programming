// https://leetcode.com/problems/beautiful-arrangement/description/

class Solution {

    int count = 0;

    public void backtrack(int n, int pos, boolean[] vis) {
        if (pos > n) {
            ++count;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!vis[i] && (pos % i == 0 || i % pos == 0)) {
                vis[i] = true;
                backtrack(n, pos+1, vis);
                vis[i] = false;
            }
        }
    }

    public int countArrangement(int n) {
        boolean[] vis = new boolean[n+1];
        count = 0;
        backtrack(n, 1, vis);
        return count;
    }

}