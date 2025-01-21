// https://leetcode.com/problems/grid-game/description/?envType=daily-question&envId=2025-01-21

class Solution {
    public long gridGame(int[][] grid) {
        // a robot's sum will always be prefix of top + suffix of bottom
        // it's just that you're now setting some prefix and some suffix equal to zero
        long top = 0, bottom = 0;
        for (int x : grid[0]) top += x;
        long ans = Long.MAX_VALUE;
        for (int j = 0; j < grid[0].length; j++) {
            top -= grid[0][j];
            ans = Math.min(ans, Math.max(top, bottom));
            bottom += grid[1][j];
        }
        return ans;
    }
}