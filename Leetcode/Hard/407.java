// https://leetcode.com/problems/trapping-rain-water-ii/description/?envType=daily-question&envId=2025-01-19

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        int n = heightMap.length, m = heightMap[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Cell> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Cell(heightMap[i][0], i, 0));
            q.offer(new Cell(heightMap[i][m-1], i, m-1));
            vis[i][0] = vis[i][m-1] = true;
        }
        for (int j = 0; j < m; j++) {
            q.offer(new Cell(heightMap[0][j], 0, j));
            q.offer(new Cell(heightMap[n-1][j], n-1, j));
            vis[0][j] = vis[n-1][j] = true;
        }
        int ans = 0;
        while (!q.isEmpty()) {
            Cell cc = q.poll();
            int row = cc.r, col = cc.c, h = cc.h;
            for (int k = 0; k < 4; k++) {
                int nrow = row + dx[k], ncol = col + dy[k];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]) {
                    int nheight = heightMap[nrow][ncol];
                    ans += Math.max(0, h - nheight);
                    q.offer(new Cell(Math.max(nheight, h), nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
        return ans;
    }
}

class Cell implements Comparable<Cell> {
    int h, r, c;
    Cell(int h, int r, int c) {
        this.h = h;
        this.r = r;
        this.c = c;
    }
    public int compareTo(Cell cc) {
        return Integer.compare(h, cc.h);
    }
}