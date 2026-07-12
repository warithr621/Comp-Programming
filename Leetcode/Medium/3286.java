// https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/?envType=daily-question&envId=2026-07-02

class Solution {

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size(), m = grid.get(0).size();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1000);
        }
        dp[0][0] = grid.get(0).get(0);

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});
        while (!dq.isEmpty()) {
            int[] pt = dq.pollFirst();
            int x = pt[0], y = pt[1];
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                int w = grid.get(nx).get(ny);
                int newdist = dp[x][y] + w;
                if (newdist < dp[nx][ny]) {
                    dp[nx][ny] = newdist;
                    if (w == 0) {
                        dq.offerFirst(new int[]{nx, ny});
                    } else {
                        dq.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }
        return health > dp[n-1][m-1];
    }
}