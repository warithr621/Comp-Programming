// https://leetcode.com/problems/diagonal-traverse


class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean dir = false;
        int[] ans = new int[m*n];
        int cur = 0;
        ans[0] = mat[0][0]; ++cur;
        int x = -1, y = 2;
        while (cur != n * m) {
            if (dir) {
                // go top-right
                while (x >= 0 && y < n) {
                    if (0 <= x && x < m && 0 <= y && y < n) {
                        ans[cur++] = mat[x][y];
                    }
                    --x; ++y;
                }
            } else {
                // go bottom-left
                while (x < m && y >= 0) {
                    if (0 <= x && x < m && 0 <= y && y < n) {
                        ans[cur++] = mat[x][y];
                    }
                    ++x; --y;
                }

            }
            ++y;
            dir = !dir;
        }

        return ans;
    }
}