// https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/

class Solution {
    public int minFlips(int[][] mat) {
        int[] dx = new int[]{1, 0, -1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        int ans = Integer.MAX_VALUE, n = mat.length, m = mat[0].length;
        for (int mask = 0; mask < (1 << (m * n)); ++mask) {
            int[][] test = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    test[i][j] = mat[i][j];
                }
            }
            int temp = mask, count = 0;
            for (int i = 0; i < m * n; i++) {
                if ((temp & 1) != 0) {
                    int x = i / m, y = i % m;
                    test[x][y] ^= 1;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k], ny = y + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            test[nx][ny] ^= 1;
                        }
                    }
                    count++;
                }
                temp >>= 1;
            }
            boolean success = true;
            for (int[] arr : test) {
                for (int x : arr) {
                    success &= (x == 0);
                }
            }
            if (success) {
                ans = Math.min(ans, count);
            }
        }
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}