// https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/?envType=daily-question&envId=2025-05-08

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int[][] d = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE-1);
        }
        boolean[][] vis = new boolean[n][m];
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        d[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 0, 1});
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            int x = arr[0], y = arr[1], dist = arr[2], adding = arr[3];
            if (vis[x][y]) continue;
            vis[x][y] = true;
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k], ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int nd = Math.max(d[x][y], moveTime[nx][ny]) + adding;
                if (d[nx][ny] > nd) {
                    d[nx][ny] = nd;
                    pq.offer(new int[]{nx, ny, nd, adding == 2 ? 1 : 2});
                }
            }
        }
        return d[n-1][m-1];
    }
}