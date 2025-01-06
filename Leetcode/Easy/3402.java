// contest

class Solution {
    public int minimumOperations(int[][] grid) {
        int ans = 0;
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length - 1; i++) {
                if (grid[i+1][j] <= grid[i][j]) {
                    ans += grid[i][j] + 1 - grid[i + 1][j];
                    grid[i + 1][j] = grid[i][j] + 1;
                }
            }
        }
        return ans;
    }
}