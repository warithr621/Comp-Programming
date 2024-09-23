// https://leetcode.com/problems/extra-characters-in-a-string/description/?envType=daily-question&envId=2024-09-23

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        HashSet<String> words = new HashSet<>();
        for (String str : dictionary) words.add(str);
        int[] dp = new int[n+1];
        for (int i = n-1; i >= 0; i--) {
            dp[i] = 1 + dp[i+1];
            for (int j = i; j <= n; j++) {
                String sub = s.substring(i, j);
                if (words.contains(sub)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[0];
    }
}