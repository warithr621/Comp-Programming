// https://leetcode.com/problems/rotting-oranges/

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Integer[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Integer[]{i, j, 0});
                }
            }
        }
        boolean rotten = (q.size() != 0);
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        while (!q.isEmpty()) {
            Integer[] pt = q.poll();
            int x = pt[0], y = pt[1], t = pt[2];
            if (vis[x][y] != 0) {
                vis[x][y] = Math.min(vis[x][y], t);
                continue;
            }
            vis[x][y] = t;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (grid[nx][ny] == 1) {
                    q.add(new Integer[]{nx, ny, t+1});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (vis[i][j] == 0) return -1;
                    ans = Math.max(ans, vis[i][j]);
                }
            }
        }
        if (ans == Integer.MIN_VALUE) return 0;
        return ans;
    }
}