// https://leetcode.com/problems/decode-ways/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[][] dp = new int[n][2];
        // dp[i] uses the first i characters
        // dp[i][0] means cur character is start of new number
        // dp[i][1] means cur character is start of prev number
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            // take care of dp[i][0]
            if (s.charAt(i) != '0') {
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
            } else {
                dp[i][0] = 0;
            }
            // take care of dp[i][1]
            int x = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if (1 <= x && x <= 26 && s.charAt(i-1) != '0') {
                if (i == 1) dp[i][1] = 1;
                else dp[i][1] = dp[i-2][0] + dp[i-2][1];
            }
            if (s.charAt(i) == '0' &&
                !(s.charAt(i-1) == '1' || s.charAt(i-1) == '2')) {
                return 0; // impossible
            }
        }
        // for (int i = 0; i < n; i++) {
        //     System.out.println(Arrays.toString(dp[i]));
        // }
        return dp[n-1][0] + dp[n-1][1];
    }
}