// https://leetcode.com/problems/convert-1d-array-into-2d-array/?envType=daily-question&envId=2024-09-01

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] ans = new int[m][n];
        if (m * n != original.length) return new int[0][0];
        for (int i = 0; i < m * n; i++) {
            ans[i / n][i % n] = original[i];
        }
        return ans;
    }
}