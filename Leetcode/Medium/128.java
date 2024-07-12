// https://leetcode.com/problems/longest-consecutive-sequence/description/

import java.util.*;
import java.lang.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) hs.add(x);
        int ans = 0;
        for (int x : hs) {
            if (hs.contains(x-1)) continue;
            int len = 0;
            while (hs.contains(x + len)) ++len;
            ans = Math.max(ans, len);
        }
        return ans;
    }
}