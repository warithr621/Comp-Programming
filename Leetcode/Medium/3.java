// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

import java.util.*;
import java.lang.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 2ptr?
        int ans = 0, left = 0, right = 0;
        HashSet<Character> sub = new HashSet<>();
        while (right != s.length()) {
            // see if you can move right
            if (!sub.contains(s.charAt(right))) {
                // we can add this!
                sub.add(s.charAt(right));
                ++right;
                ans = Math.max(ans, right - left);
            } else {
                // we need to shift left until we remove whatever s.charAt(right) is
                while (true) {
                    sub.remove(s.charAt(left));
                    ++left;
                    if (!sub.contains(s.charAt(right))) break;
                }
                if (right - left > ans) ans = right - left;
            }
        }
        return ans;
    }
}