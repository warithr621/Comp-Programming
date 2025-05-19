// https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/?envType=daily-question&envId=2025-05-13

class Solution {
    public int lengthAfterTransformations(String s, int t) {
        long[] freq = new long[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        while (t --> 0) {
            long z = freq[25];
            for (int i = 25; i > 0; i--) {
                freq[i] = freq[i-1];
            }
            freq[0] = z;
            freq[1] = (freq[1] + z) % 1_000_000_007;
        }
        long ans = 0;
        for (long x : freq) ans = (ans + x) % 1_000_000_007;
        return (int) ans;
    }
}