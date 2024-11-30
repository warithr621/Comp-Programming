// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/description/?envType=daily-question&envId=2024-11-29

class Solution {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1)
            return -1; // cannot move
        int N = grid.length, M = grid[0].length;
        int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
        boolean[][] vis = new boolean[N][M];
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.add(new int[]{grid[0][0], 0, 0}); // time + row + col
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], row = cur[1], col = cur[2];
            if (row == N-1 && col == M-1)
                return time;
            if (vis[row][col]) continue;
            vis[row][col] = true;
            for (int k = 0; k < 4; k++) {
                int nx = row + dx[k], ny = col + dy[k];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || vis[nx][ny]) continue;
                int wait = (grid[nx][ny] - time) % 2 == 0 ? 1 : 0;
                int next = Math.max(grid[nx][ny] + wait, time + 1);
                pq.add(new int[]{next, nx, ny});
            }
        }
        return -1;
    }
}