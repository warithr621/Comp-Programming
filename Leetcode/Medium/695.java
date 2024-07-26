// https://leetcode.com/problems/max-area-of-island/

class Solution {

    // this problem is just floodfill

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] island = new int[n][m];
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        int cur = 1;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] || grid[i][j] == 0) continue;
                q.add(i * m + j);
                while (!q.isEmpty()) {
                    int v = q.poll(), x = v / m, y = v % m;
                    if (vis[x][y] || grid[x][y] == 0) continue;
                    vis[x][y] = true;
                    island[x][y] = cur;
                    for (int k = 0; k < 4; k++) {
                        int nx = x + dx[k], ny = y + dy[k];
                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (!vis[nx][ny] && grid[nx][ny] == 1) {
                                q.offer(nx * m + ny);
                            }
                        }
                    }
                }
                ++cur;
            }
        }
        int[] freq = new int[cur];
        for (int[] arr : island) {
            for (int v : arr) if (v != 0) freq[v]++;
            // if v is zero it's water
        }
        int ans = 0;
        for (int v : freq) ans = Math.max(v, ans);
        System.gc();
        return ans;
    }
}