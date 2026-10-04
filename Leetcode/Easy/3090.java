// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/description/?envType=daily-question&envId=2026-08-14

class Solution {
    public int maximumLengthSubstring(String s) {
        // ehhhh just sliding window this
        int[] f = new int[26];
        int L = 0, ans = 0;
        for (int R = 0; R < s.length(); R++) {
            f[s.charAt(R) - 'a']++;
            while (f[s.charAt(R) - 'a'] > 2) {
                f[s.charAt(L++) - 'a']--;
            }
            ans = Math.max(ans, R - L + 1);
        }
        return ans;
    }
}