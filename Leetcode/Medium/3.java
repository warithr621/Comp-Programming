// https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 2ptr?
        int ans = 0, left = 0, right = 0, n = s.length();
        int[] freq = new int[128];
        while (right < n) {
            int c = s.charAt(right);
            freq[c]++;
            while (freq[c] > 1) {
                freq[s.charAt(left)]--;
                ++left;
            }
            ans = Math.max(ans, right - left + 1);
            ++right;
        }
        return ans;
    }
}