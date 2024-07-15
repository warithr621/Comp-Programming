// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.*;
import java.lang.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 2ptr?
        int ans = 0, left = 0, right = 0;
        int[] freq = new int[128];
        while (right != s.length()) {
            // see if you can move right
            if (freq[s.charAt(right)] == 0) {
                // we can add this!
                freq[s.charAt(right)]++;
                ++right;
                ans = Math.max(ans, right - left);
            } else {
                // we need to shift left until we remove whatever s.charAt(right) is
                while (true) {
                    freq[s.charAt(left)]--;
                    ++left;
                    if (freq[s.charAt(right)] == 0) break;
                }
                if (right - left > ans) ans = right - left;
            }
        }
        return ans;
    }
}