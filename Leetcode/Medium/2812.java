// https://leetcode.com/problems/find-the-safest-path-in-a-grid/

class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 1000);
        }

        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            List<Integer> row = grid.get(i);
            for (int j = 0; j < n; j++) {
                if (row.get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            int x = coord[0], y = coord[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (dist[nx][ny] > dist[x][y] + 1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }

        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], -1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        ans[0][0] = dist[0][0];
        pq.offer(new int[]{0, 0, dist[0][0]});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], safeness = cur[2];
            if (x == n - 1 && y == n - 1) return safeness;
            if (safeness < ans[x][y]) continue;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                int nextSafe = Math.min(safeness, dist[nx][ny]);
                if (nextSafe > ans[nx][ny]) {
                    ans[nx][ny] = nextSafe;
                    pq.offer(new int[]{nx, ny, nextSafe});
                }
            }
        }
        return 0;
    }
}