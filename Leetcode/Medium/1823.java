// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/

class Solution {
    public int findTheWinner(int n, int k) {
    	// simulation
        boolean[] in = new boolean[n+1];
        int out = 0;
        for (int i = 1; i <= n; i++) in[i] = true;
        int track = 0;
        for (int i = 1; out < n-1; i = i % n + 1) {
            if (!in[i]) continue;
            ++track;
            if (track == k) {
                in[i] = false;
                track = 0;
                ++out;
            }
        }
        for (int i = 1; i <= n; i++) if (in[i]) return i;
        return -1;
    }

    public int fast(int n, int k) {
    	// math
    	int ans = 0;
        for (int i = 2; i <= n; i++) ans = (ans + k) % i;
        return ++ans;
    }
}