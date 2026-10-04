// https://leetcode.com/problems/count-number-of-homogenous-substrings/description/

class Solution {
    public int countHomogenous(String s) {
        char cur = s.charAt(0);
        long run = 0;
        long ans = 0, MOD = 1_000_000_007;
        for (char c : s.toCharArray()) {
            if (cur == c) ++run;
            else {
                ans += (run * (run+1) / 2) % MOD;
                ans %= MOD;
                cur = c;
                run = 1;
            }
        }
        ans += (run * (run+1) / 2) % MOD;
        return (int) (ans % MOD);
    }
}