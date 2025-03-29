// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/?envType=daily-question&envId=2025-03-26

class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length, m = grid[0].length;
        int[] nums = new int[n*m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                nums[i*m+j] = grid[i][j];
                if (grid[i][j] % x != grid[0][0] % x) return -1;
            }
        }
        Arrays.sort(nums);
        int median = nums[n*m / 2];
        int ans = 0;
        for (int v : nums) ans += Math.abs(median - v) / x;
        return ans;
    }
}