// https://leetcode.com/problems/maximize-active-section-with-trade-i/description/?envType=daily-question&envId=2026-07-21

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ans = 0, ptr = 0, best = 0, prev = Integer.MIN_VALUE;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int start = ptr;
            while (ptr < n && s.charAt(ptr) == c) ++ptr;
            int len = ptr - start;
            if (c == '1') ans += len;
            else {
                best = Math.max(best, prev + len);
                prev = len;
            }
        }
        return ans + best;
    }
}