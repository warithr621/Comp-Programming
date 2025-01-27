// https://leetcode.com/problems/map-of-highest-peak/?envType=daily-question&envId=2025-01-22

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int n = isWater.length, m = isWater[0].length;
        int[][] ans = new int[n][m];
        for (int[] arr : ans) Arrays.fill(arr, -1);
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[]{i, j});
                    ans[i][j] = 0;
                }
            }
        }
        int h = 1;
        while(!q.isEmpty()) {
            int layers = q.size();
            for (int i = 0; i < layers; i++) {
                int[] cell = q.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = cell[0] + dx[k], ny = cell[1] + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && ans[nx][ny] == -1) {
                        ans[nx][ny] = h;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
            ++h;
        }
        return ans;
    }
}