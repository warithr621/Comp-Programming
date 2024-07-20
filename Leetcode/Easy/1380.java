// https://leetcode.com/problems/lucky-numbers-in-a-matrix/?envType=daily-question&envId=2024-07-19

import java.util.*;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        Set<Integer> rowmn = new HashSet<>();
        for (int[] row : matrix) {
            int mn = Integer.MAX_VALUE;
            for (int x : row) mn = Math.min(x, mn);
            rowmn.add(mn);
        }
        for (int j = 0; j < matrix[0].length; j++) {
            int mx = -1;
            for (int i = 0; i < matrix.length; i++) {
                mx = Math.max(mx, matrix[i][j]);
            }
            if (rowmn.contains(mx)) ans.add(mx);
        }
        return ans;
    }

    public List<Integer> another (int[][] matrix) {
        // another solution that may run slightly faster, but at the cost of more memory
        // both solutions are O(N^2) in time, this one is more optimized though
        // however the other one was O(1) space I think, this one is O(M) space
        int n = matrix.length, m = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        int[] col = new int[m];
        for (int i = 0; i < n; i++) {
            int mn_idx = 0;
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] < matrix[i][mn_idx]) mn_idx = j;
            }
            if (col[mn_idx] == matrix[i][mn_idx]) ans.add(matrix[i][mn_idx]);
            else if (col[mn_idx] == 0) {
                int mx = -1;
                for (int k = 0; k < n; k++) mx = Math.max(mx, matrix[k][mn_idx]);
                col[mn_idx] = mx;
                if (col[mn_idx] == matrix[i][mn_idx]) ans.add(matrix[i][mn_idx]);
            }
        }
        return ans;
    }
}