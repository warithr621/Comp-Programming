// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/?envType=daily-question&envId=2025-01-28

class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length, m = grid[0].length, c = 1;
        int dx[] = {0, 1, 0, -1}, dy[] = {1, 0, -1, 0};
        int colors[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || grid[i][j] == 0) continue;
                q.add(i * m + j);
                while (!q.isEmpty()) {
                    int v = q.poll();
                    int x = v / m, y = v % m;
                    if (vis[x][y] || grid[x][y] == 0 || colors[x][y] != 0) continue;
                    vis[x][y] = true;
                    colors[x][y] = c;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k], ny = y + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] != 0 && !vis[nx][ny] && colors[nx][ny] == 0) {
                            q.add(nx * m + ny);
                        }
                    }
                }
                ++c;
            }
        }

        int[] sums = new int[c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (colors[i][j] != 0) sums[colors[i][j]] += grid[i][j];
            }
        }
        int ans = 0;
        for (int x : sums) ans = Math.max(ans, x);
        return ans;
    }
}