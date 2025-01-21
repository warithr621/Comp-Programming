// https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/?envType=daily-question&envId=2025-01-18

class Solution {
    public int minCost(int[][] grid) {
        // surely dijkstra
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int n = grid.length, m = grid[0].length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // cost row col
        pq.offer(new int[]{0, 0, 0});
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        ans[0][0] = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], x = cur[1], y = cur[2];
            if (ans[x][y] != cost) continue;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int nc = cost + (k != grid[x][y] - 1 ? 1 : 0);
                if (ans[nx][ny] > nc) {
                    ans[nx][ny] = nc;
                    pq.offer(new int[]{nc, nx, ny});
                }
            }
        }
        return ans[n-1][m-1];
    }
}