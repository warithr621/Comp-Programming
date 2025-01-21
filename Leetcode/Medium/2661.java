// https://leetcode.com/problems/first-completely-painted-row-or-column/description/?envType=daily-question&envId=2025-01-20

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = arr.length;
        int[][] vals = new int[n+1][2];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                vals[mat[i][j]][0] = i;
                vals[mat[i][j]][1] = j;
            }
        }
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];
        Arrays.fill(row, mat[0].length);
        Arrays.fill(col, mat.length);
        for (int i = 0; i < arr.length; i++) {
            row[vals[arr[i]][0]]--;
            col[vals[arr[i]][1]]--;
            if (row[vals[arr[i]][0]] == 0 || col[vals[arr[i]][1]] == 0) {
                return i;
            }
        }
        return n-1;
    }
}