// https://leetcode.com/problems/count-the-number-of-consistent-strings/?envType=daily-question&envId=2024-09-12

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] yes = new boolean[26];
        for (char c : allowed.toCharArray()) {
            yes[c - 'a'] = true;
        }
        int ans = 0;
        for (String s : words) {
            boolean works = true;
            for (char c : s.toCharArray()) {
                works &= yes[c - 'a'];
            }
            if (works) {
                ++ans;
            }
        }
        return ans;
    }
}