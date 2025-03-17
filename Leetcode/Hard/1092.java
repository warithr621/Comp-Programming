class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        String[] dp = new String[m+1];
        for (int i = 0; i <= m; i++) {
            dp[i] = str2.substring(0, i);
        }
        for (int i = 1; i <= n; i++) {
            String[] cur = new String[m+1];
            cur[0] = str1.substring(0, i);
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    cur[j] = new StringBuilder(dp[j-1]).append(str1.charAt(i-1)).toString();
                } else {
                    String alpha = new StringBuilder(dp[j]).append(str1.charAt(i-1)).toString();
                    String beta = new StringBuilder(cur[j-1]).append(str2.charAt(j-1)).toString();
                    cur[j] = (alpha.length() < beta.length() ? alpha : beta);
                }
            }
            dp = cur;
        }
        return dp[m];
    }
}