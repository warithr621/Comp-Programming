// https://leetcode.com/problems/count-palindromic-subsequences/description/

class Solution {
    public int countPalindromes(String s) {
        int n = s.length();
        int MOD = 1_000_000_007;
        // what the edge case
        if (n < 5) return 0;
        // hm, the problem weirdly specifies length 5
        // so every string is in the form ABCBA
        // there's only 100 possible forms of AB, since it's just digits
        // if we had a way for each form to instantly find the number before/after a specific instance, this problem becomes trivial
        int[][] pfx = new int[n][100];
        int[][] sfx = new int[n][100];
        // pfx[i][JJ] is the number of times the subsequence JJ appears among the first i letters
        int[] nums = new int[10];
        for (int i = 0; i < n; i++) {
            int x = s.charAt(i) - '0';
            if (i == 0) {
                nums[x]++;
                continue;
            }
            for (int j = 0; j <= 99; j++) {
                pfx[i][j] = pfx[i-1][j];
            }
            for (int j = 0; j <= 9; j++) {
                pfx[i][j * 10 + x] = (pfx[i][j * 10 + x] + nums[j]) % MOD;
            }
            nums[x]++;
        }
        nums = new int[10];
        for (int i = n-1; i >= 0; i--) {
            int x = s.charAt(i) - '0';
            if (i == n-1) {
                nums[x]++;
                continue;
            }
            for (int j = 0; j <= 99; j++) {
                sfx[i][j] = sfx[i+1][j];
            }
            for (int j = 0; j <= 9; j++) {
                sfx[i][j * 10 + x] = (sfx[i][j * 10 + x] + nums[j]) % MOD;
            }
            nums[x]++;
        }

        long ans = 0;
        for (int i = 2; i <= n-3; i++) {
            for (int j = 0; j <= 99; j++) {
                ans = (ans + 1L * pfx[i-1][j] * sfx[i+1][j]) % MOD;
            }
        }
        return (int) ans;
    }
}