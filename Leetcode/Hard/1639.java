// https://leetcode.com/problems/number-of-ways-to-form-a-target-string-given-a-dictionary/description/?envType=daily-question&envId=2024-12-29

class Solution {
    public int numWays(String[] words, String target) {
        int wl = words[0].length(), tl = target.length();
        final int MOD = 1_000_000_007;
        int[][] freq = new int[wl][26];
        for (String word : words) {
            for (int j = 0; j < wl; j++) {
                freq[j][word.charAt(j) - 'a']++;
            }
        }
        long[] dp = new long[tl + 1];
        long[] cur = new long[tl + 1];
        dp[0] = 1;
        for (int i = 1; i <= wl; i++) {
            System.arraycopy(dp, 0, cur, 0, cur.length);
            for (int j = 1; j <= tl; j++) {
                int pos = target.charAt(j-1) - 'a';
                cur[j] += dp[j-1] * freq[i - 1][pos] % MOD;
                cur[j] %= MOD;
            }
            System.arraycopy(cur, 0, dp, 0, dp.length);
        }
        return (int) dp[tl];
    }
}