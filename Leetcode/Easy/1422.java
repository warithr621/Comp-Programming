// https://leetcode.com/problems/maximum-score-after-splitting-a-string/description/?envType=daily-question&envId=2025-01-01

class Solution {
    public int maxScore(String s) {
        // happy new year!
        int lz = 0, rz = 0;
        int lo = 0, ro = 0;
        // I could do psums easily but ehhh extra memory (although N <= 500 so uh)
        // start with the strings being the left char and the rest
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i == 0) ++lz;
                else ++rz;
            } else {
                if (i == 0) ++lo;
                else ++ro;
            }
        }
        int ans = lz + ro;
        for (int end = 1; end < s.length()-1; end++) {
            // move 'end' from right to left
            if (s.charAt(end) == '0') {--rz; ++lz;}
            else {--ro; ++lo;}
            ans = Math.max(ans, lz + ro);
        }
        return ans;
    }
}