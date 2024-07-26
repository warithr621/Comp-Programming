// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/?envType=daily-question&envId=2024-07-26

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = 5_000_000;
            }
            dist[i][i] = 0;
        }
        for (int[] arr : edges) {
            dist[arr[0]][arr[1]] = arr[2];
            dist[arr[1]][arr[0]] = arr[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        int ans = 0, cnt = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold) ++temp;
            }
            if (temp <= cnt) {
                cnt = temp;
                ans = i;
            }
        }
        System.gc();
        return ans;
    }
}