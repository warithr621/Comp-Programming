// https://leetcode.com/problems/magic-squares-in-grid/?envType=daily-question&envId=2024-08-09

class Solution {

    public static boolean magic(int[][] grid, int up, int left) {
        int[] freq = new int[15];
        for (int i = up; i < up+3; i++) {
            for (int j = left; j < left+3; j++) {
                freq[grid[i][j]]++;
            }
        }
        boolean works = true;
        for (int i = 1; i <= 9; i++) works &= (freq[i] == 1);
        if (!works) return works;
        int sum = grid[up][left] + grid[up][left+1] + grid[up][left+2];
        for (int i = up; i < up+3; i++) {
            works &= (sum == grid[i][left] + grid[i][left+1] + grid[i][left+2]);
        }
        for (int j = left; j < left+3; j++) {
            works &= (sum == grid[up][j] + grid[up+1][j] + grid[up+2][j]);
        }
        return works && (sum == grid[up][left] + grid[up+1][left+1] + grid[up+2][left+2]) &&
            (sum == grid[up+2][left] + grid[up+1][left+1] + grid[up][left+2]);
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0, n = grid.length, m = grid[0].length;
        if (n < 3 || m < 3) return 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = 0; j < m-2; j++) {
                ans += magic(grid, i, j) ? 1 : 0;
            }
        }
        return ans;
    }
}