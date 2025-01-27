// https://leetcode.com/problems/count-servers-that-communicate/?envType=daily-question&envId=2025-01-23

class Solution {
    public int countServers(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] rows = new int[m], cols = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rows[j] += grid[i][j];
                cols[i] += grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && (rows[j] > 1 || cols[i] > 1)) ++ans;
            }
        }
        return ans;
    }
}