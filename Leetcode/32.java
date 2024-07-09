// https://leetcode.com/problems/longest-valid-parentheses/description/


import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = i;
                int diff = 1;
                int best = i;
                while (j + 1 < n && diff >= 0) {
                    ++j;
                    diff += (s.charAt(j) == '(' ? 1 : -1);
                    if (diff == 0) best = j;
                }
                if (diff == 0) best = j;
                if (best != i) ans = Math.max(ans, best - i + 1);
            }
        }
        return ans;
    }
}