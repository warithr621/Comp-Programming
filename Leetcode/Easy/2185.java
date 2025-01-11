// https://leetcode.com/problems/counting-words-with-a-given-prefix/description/?envType=daily-question&envId=2025-01-09

class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (String s : words) {
            ans += (s.startsWith(pref) ? 1 : 0);
        }
        return ans;
    }
}