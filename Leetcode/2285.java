// https://leetcode.com/problems/maximum-total-importance-of-roads/description/


class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for (int[] arr : roads) {
            freq[arr[0]]++;
            freq[arr[1]]++;
        }
        Arrays.sort(freq);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += (long) i * freq[i-1];
        }
        return ans;
    }
}