// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/editorial/?envType=daily-question&envId=2024-07-20

import java.util.*;

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[] currow = new int[n], curcol = new int[m];
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = Math.min(rowSum[i] - currow[i], colSum[j] - curcol[j]);
                currow[i] += ans[i][j];
                curcol[j] += ans[i][j];
            }
        }
        return ans;
    }
}