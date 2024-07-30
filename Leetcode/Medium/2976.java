// https://leetcode.com/problems/minimum-cost-to-convert-string-i/description/?envType=daily-question&envId=2024-07-27

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length(), len = original.length;
        int[][] dist = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                dist[i][j] = Integer.MAX_VALUE >> 1;
            }
            dist[i][i] = 0;
        }
        for (int i = 0; i < len; i++) {
            if (cost[i] < dist[original[i] - 'a'][changed[i] - 'a']) {
                dist[original[i] - 'a'][changed[i] - 'a'] = cost[i];
            }
            // Note that there may exist indices i, j such that original[j] == original[i] and changed[j] == changed[i].
            // This is so silly
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int change = dist[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
            if (change == (Integer.MAX_VALUE >> 1)) return -1;
            ans += change;
        }
        System.gc();
        return ans;
    }
}