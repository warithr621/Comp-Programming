// https://leetcode.com/problems/spiral-matrix/?envType=study-plan-v2&envId=top-interview-150

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length, m = matrix[0].length;
        int[] dx = new int[]{0, 1, 0, -1}, dy = new int[]{1, 0, -1, 0};
        boolean[][] vis = new boolean[n][m];
        int vc = 0;
        for (int i = 0, j = 0, k = 0; vc != m * n; ) {
            ans.add(matrix[i][j]);
            vis[i][j] = true;
            ++vc;
            int nx = i + dx[k], ny = j + dy[k];
            if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny]) k = (k + 1) % 4;
            i += dx[k];
            j += dy[k];
        }
        return ans;
        // I made one that used a few extra integer vars instead of a vis matrix
        // and somehow that makes it use more memory??
    }
}